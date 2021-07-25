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
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import pidev.Entite.Event;
import pidev.Entite.Reservation;
import pidev.Service.ServiceEvent;
import pidev.Service.ServiceReservation;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class AddReservationController implements Initializable {

    @FXML
    private TextField tfid;
    @FXML
    private Button btnAjouterReservation;
    @FXML
    private TextField tfseat;
    @FXML
    private TextField tftype;
    @FXML
    private TextField tftotal;
    @FXML
    private TextField tfquantite;
    @FXML
    private TextField tfDatereservation;
    @FXML
    private TextField tfiduser;
    @FXML
    private TextField tfnomreservation;
    @FXML
    private TextField tfpayer;
    @FXML
    private TextField tfidevent;
    @FXML
    private TableView<Event> table;
    @FXML
    private TableColumn<Event, Integer> idevent;
    @FXML
    private TableColumn<Event,Integer> iduser;
    @FXML
    private TableColumn<Event,String> titre;
    @FXML
    private TableColumn<Event, Integer> nbrplaces;
    @FXML
    private TableColumn<Event,String> localisation;
    @FXML
    private TableColumn<Event,Float> hdebut;
    @FXML
    private TableColumn<Event, Float> hfin;
    @FXML
    private TableColumn<Event, Float> prix;
    ObservableList<Event> listA = FXCollections.observableArrayList();
    @FXML
    private TextField searchEvent;

    /**
     * Initializes the controller class.
     */
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
       ServiceEvent SA = new ServiceEvent();
         listA.clear();
        try {
            listA.addAll(SA.readAll());
        } catch (SQLException ex) {
            Logger.getLogger(AfficherEventController.class.getName()).log(Level.SEVERE, null, ex);
        }

        idevent.setCellValueFactory(new PropertyValueFactory<>("id"));
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
        JOptionPane.showMessageDialog(null, "Event Deleted");
    }
    

    @FXML
    private void AjouterReservation(ActionEvent event) throws SQLException {
        ServiceReservation SA=new ServiceReservation();
        SA.ajouter(new Reservation(Integer.parseInt(tfid.getText()),tfDatereservation.getText(),Integer.parseInt(tfquantite.getText()),Integer.parseInt(tftotal.getText()),tftype.getText(),tfseat.getText(),Integer.parseInt(tfpayer.getText()),tfnomreservation.getText(),Integer.parseInt(tfiduser.getText()),Integer.parseInt(tfidevent.getText())));       
        JOptionPane.showMessageDialog(null, "Reservation added");
         final Node source = (Node) event.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }
   
    
    /*
    private boolean controle_number() throws SQLException
    {
                
        for(int i=0;i<tfIdAnnonce.getText().length();i++){
        
            if(!Character.isDigit(tf.getText().charAt(i))){
               
            JOptionPane.showMessageDialog(null, "Id must be a number", "Attention", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        
            if((tfDescriptionAnnonce.getText().isEmpty())||(tfNomAnnonce.getText().isEmpty())){
               
            JOptionPane.showMessageDialog(null, "Enter announce description ", "Attention", JOptionPane.ERROR_MESSAGE);
                return false;       
            }
            
            ServiceAnnonce sa = new ServiceAnnonce();
            List<Annonce> listA = sa.readAll();
            for (Annonce listA1 : listA) {
                if(listA1.getIdAnnonceRS()==Integer.parseInt(tfIdAnnonce.getText())){
                    JOptionPane.showMessageDialog(null, "Id already used", "Attention", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            }
              
    }
        return true;
    }
    
    
    
}
    
    */
    
    
    private void retour(ActionEvent event) throws IOException {
        final Node source = (Node) event.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }
    
    
}
