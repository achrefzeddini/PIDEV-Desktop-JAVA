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
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import pidev.Entite.Event;
import pidev.Service.ServiceEvent;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class AfficherEventController implements Initializable {

    @FXML
    private TableColumn<Event, Integer> idevent;
    @FXML
    private TableColumn<Event, Integer> iduser;
    @FXML
    private TableColumn<Event, String> titre;
    @FXML
    private TableColumn<Event,Integer> nbrplaces;
    @FXML
    private TableColumn<Event,String> localisation;
    @FXML
    private TableColumn<Event, Float> hdebut;
    @FXML
    private TableColumn<Event, Float> hfin;
    @FXML
    private TableColumn<Event, Float> prix;
    ObservableList<Event> listA = FXCollections.observableArrayList();
    @FXML
    private TextField searchEvent;
    @FXML
    private Button btnref;
    @FXML
    private TableView<Event> table;
    @FXML
    private Button deleteEvent;
    @FXML
    private Button addEvent;
    @FXML
    private Button updateEvent;
    @FXML
    private Button btnreservation;
    @FXML
    private Button btnpiechart;
    @FXML
    private PieChart mypiechart;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       refresh();
    }    

    @FXML
   void refresh() {
       ServiceEvent SA = new ServiceEvent();
         listA.clear();
        try {
            listA.addAll(SA.readAll());
        } catch (SQLException ex) {
            Logger.getLogger(AfficherEventController.class.getName()).log(Level.SEVERE, null, ex);
        }

        idevent.setCellValueFactory(new PropertyValueFactory<>("idEvent"));
        iduser.setCellValueFactory(new PropertyValueFactory<>("idUser"));
        titre.setCellValueFactory(new PropertyValueFactory<>("titre"));
        nbrplaces.setCellValueFactory(new PropertyValueFactory<>("nbrplaces"));
        localisation.setCellValueFactory(new PropertyValueFactory<>("localisation"));
        hdebut.setCellValueFactory(new PropertyValueFactory<>("hdebut"));
        hfin.setCellValueFactory(new PropertyValueFactory<>("hfin"));
        prix.setCellValueFactory(new PropertyValueFactory<>("prix"));

        FilteredList<Event> filteredData = new FilteredList<>(listA, lu -> true);

        // 2. Set the filter Predicate whenever the filter changes.
        searchEvent.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate((Event evente) -> {
                // If filter text is empty, display all persons.

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                // Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();

                if (String.valueOf(evente.getId()).contains(lowerCaseFilter)) {
                    return true; // Filter matches first name.
                } else if (String.valueOf(evente.getIdUser()).contains(lowerCaseFilter)) {
                    return true; // Filter matches last name.
                } else if (evente.getTitre().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches last name.
                } else if (evente.getLocalisation().contains(lowerCaseFilter)) {
                    return true;
                } else {
                    return false; // Does not match.
                }
            });
        });

        // 3. Wrap the FilteredList in a SortedList. 
        SortedList<Event> sortedData = new SortedList<>(filteredData);

        // 4. Bind the SortedList comparator to the TableView comparator.
        // 	  Otherwise, sorting the TableView would have no effect.
        sortedData.comparatorProperty().bind(table.comparatorProperty());

        // 5. Add sorted (and filtered) data to the table.
        table.setItems(sortedData);
    }

    @FXML
    private void deleteEvent(ActionEvent event) throws SQLException {
         ServiceEvent SA = new ServiceEvent();
        SA.delete(idevent.getCellData(table.getSelectionModel().getSelectedIndex()));
        //refresh();
        JOptionPane.showMessageDialog(null, "Announce Deleted");
    }

    @FXML
    private void addEvent(ActionEvent event) throws IOException {
         FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddEvent.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Add Event");
        stage.setScene(new Scene(root1));
        stage.show();
    }

    @FXML
    private void updateEvent(ActionEvent event) throws IOException {
          FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("UpdateEvent.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Update Event");
        stage.setScene(new Scene(root1));
        stage.show();
         UpdateEventController uac=fxmlLoader.getController();
        uac.setTftitre(titre.getCellData(table.getSelectionModel().getSelectedIndex()));
        uac.setTfnbrplaces(nbrplaces.getCellData(table.getSelectionModel().getSelectedIndex())); 
        uac.setTflocalisation(localisation.getCellData(table.getSelectionModel().getSelectedIndex()));
        uac.setTfhdebut(hdebut.getCellData(table.getSelectionModel().getSelectedIndex()));
        uac.setTfhfin(hfin.getCellData(table.getSelectionModel().getSelectedIndex()));
        uac.setTfprix(prix.getCellData(table.getSelectionModel().getSelectedIndex()));
        uac.setN(idevent.getCellData(table.getSelectionModel().getSelectedIndex()));
    }

    @FXML
    private void partiereservation(ActionEvent event) throws IOException {
         FXMLLoader fxmlLoader;
        fxmlLoader = new FXMLLoader(getClass().getResource("AfficherReservation.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Add reservation");
        stage.setScene(new Scene(root1));
        stage.show();
    }

    @FXML
    private void piechart(ActionEvent event) throws SQLException {
        
         ServiceEvent sa = new ServiceEvent();
int count1=0,count2=0, count3=0;
count1=sa.read();
count2=sa.reada();
count3=sa.readb();

        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                new PieChart.Data("ain drahem", count1),
                new PieChart.Data("testour", count2),
                new PieChart.Data("tunis", count3));
    mypiechart.setData(pieChartData);
    }
        
    

    
}
