/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.GUI;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import pidev.Entite.Reservation;
import pidev.Entite.Sponsor;
import pidev.Service.ServiceReservation;
import pidev.Service.ServiceSponsor;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class AfficherSponsorController implements Initializable {
    @FXML
    private TableColumn<Sponsor, String> nom;
    @FXML
    private TableColumn<Sponsor, Integer> idevent;
    @FXML
    private TableColumn<Sponsor, Integer> confirmation;
    @FXML
    private TableColumn<Sponsor, String> mail;
    ObservableList<Sponsor> listA = FXCollections.observableArrayList();
    @FXML
    private TextField searchSponsor;
    @FXML
    private Button btnref;
    @FXML
    private Button deletesponsor;
    @FXML
    private Button updatesponsor;
    @FXML
    private TableView<Sponsor> tableSponsor;
    @FXML
    private Button addsponsor;
    @FXML
    private TableColumn<Sponsor, Integer> tcsponsor;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        refresh();
    }

    @FXML
     void refresh() {
        ServiceSponsor SA = new ServiceSponsor();
        listA.clear();
        try {
            listA.addAll(SA.readAll());
        } catch (SQLException ex) {
            Logger.getLogger(AfficherSponsorController.class.getName()).log(Level.SEVERE, null, ex);
        }

        tcsponsor.setCellValueFactory(new PropertyValueFactory<>("id"));
        nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        idevent.setCellValueFactory(new PropertyValueFactory<>("idEvent"));
        confirmation.setCellValueFactory(new PropertyValueFactory<>("confirmation"));
        mail.setCellValueFactory(new PropertyValueFactory<>("mailSponsor"));

        FilteredList<Sponsor> filteredData = new FilteredList<>(listA, lu -> true);

        // 2. Set the filter Predicate whenever the filter changes.
        searchSponsor.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate((Sponsor sponsor) -> {
                // If filter text is empty, display all persons.

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                // Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();
                if (String.valueOf(sponsor.getId()).contains(lowerCaseFilter)) {
                    return true; // Filter matches first name.
                } else if (sponsor.getNom().contains(lowerCaseFilter)) {
                    return true; // Filter matches last name.
                } else if (String.valueOf(sponsor.getIdEvent()).contains(lowerCaseFilter)) {
                    return true; // Filter matches last name.
                } else if (sponsor.getMailSponsor().contains(lowerCaseFilter)) {
                    return true;
                } else {
                    return false; // Does not match.
                }

            });
        });

        // 3. Wrap the FilteredList in a SortedList. 
        SortedList<Sponsor> sortedData = new SortedList<>(filteredData);

        // 4. Bind the SortedList comparator to the TableView comparator.
        // 	  Otherwise, sorting the TableView would have no effect.
        sortedData.comparatorProperty().bind(tableSponsor.comparatorProperty());

        // 5. Add sorted (and filtered) data to the table.
        tableSponsor.setItems(sortedData);
    }

//    private void deletesponsor(ActionEvent event) throws SQLException {
//        ServiceSponsor SA = new ServiceSponsor();
//        SA.delete(idsponsor.getCellData(tableSponsor.getSelectionModel().getSelectedIndex()));
//        //refresh();
//        JOptionPane.showMessageDialog(null, "Sponsor Deleted");
//    }

    @FXML
    private void updatesponsor(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("UpdateSponsor.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Update Sponsor");
        stage.setScene(new Scene(root1));
        stage.show();
         
        UpdateSponsorController uac = fxmlLoader.getController();
        uac.setN(tcsponsor.getCellData(tableSponsor.getSelectionModel().getSelectedIndex()));
        uac.setTfnom(nom.getCellData(tableSponsor.getSelectionModel().getSelectedIndex()));
        uac.setTfconfirmation(confirmation.getCellData(tableSponsor.getSelectionModel().getSelectedIndex()));
        uac.setTfmail(mail.getCellData(tableSponsor.getSelectionModel().getSelectedIndex()));
        uac.setTfidevent(idevent.getCellData(tableSponsor.getSelectionModel().getSelectedIndex()));
    }

    @FXML
    private void Addsponsor(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddSponsor.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Add Sponsor");
        stage.setScene(new Scene(root1));
        stage.show();

    }

    @FXML
    private void deleteSponsor(ActionEvent event) throws SQLException {
        ServiceSponsor SA = new ServiceSponsor();
        SA.delete(tcsponsor.getCellData(tableSponsor.getSelectionModel().getSelectedIndex()));
        //refresh();
        JOptionPane.showMessageDialog(null, "Sponsor Deleted");
    }

}
