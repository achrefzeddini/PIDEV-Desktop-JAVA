/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.GUI;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
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
import pidev.Service.ServiceReservation;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class AfficherReservationController implements Initializable {

    @FXML
    private TableView<Reservation> tablereservation;
    @FXML
    private TableColumn<Reservation, Integer> id;
    @FXML
    private TableColumn<Reservation, String> datereservation;
    @FXML
    private TableColumn<Reservation, Integer> quantite;
    @FXML
    private TableColumn<Reservation, Double> total;
    @FXML
    private TableColumn<Reservation, String> type;
    @FXML
    private TableColumn<Reservation, String> seat;
    @FXML
    private TableColumn<Reservation, Integer> payer;
    @FXML
    private TableColumn<Reservation, String> nomreservation;
    @FXML
    private TableColumn<Reservation, Integer> iduser;
    @FXML
    private TableColumn<Reservation, Integer> idevent;
    @FXML
    private TextField searchReservation;
    @FXML
    private Button btnref;
    @FXML
    private Button btnDeletereservation;
    @FXML
    private Button btnUpdateReservation;
    @FXML
    private Button btnhistorique;

   //private final Connection con ;
ObservableList<Reservation> listA = FXCollections.observableArrayList();
       ArrayList<Reservation> reservations = new ArrayList();

//public AfficherReservationController(){
//    con = DataBase.getInstance().getConnection();
//}
//    
       /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      refresh();
    }    

    @FXML
    void refresh() {
        ServiceReservation SA = new ServiceReservation();
         listA.clear();
        try {
            listA.addAll(SA.readAll());
        } catch (SQLException ex) {
            Logger.getLogger(AfficherReservationController.class.getName()).log(Level.SEVERE, null, ex);
        }

        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        datereservation.setCellValueFactory(new PropertyValueFactory<>("dateReservation"));
        quantite.setCellValueFactory(new PropertyValueFactory<>("quantite"));
        total.setCellValueFactory(new PropertyValueFactory<>("total"));
        type.setCellValueFactory(new PropertyValueFactory<>("type"));
        seat.setCellValueFactory(new PropertyValueFactory<>("seat"));
        payer.setCellValueFactory(new PropertyValueFactory<>("payer"));
        nomreservation.setCellValueFactory(new PropertyValueFactory<>("nomReservation"));
        iduser.setCellValueFactory(new PropertyValueFactory<>("iduser"));
        idevent.setCellValueFactory(new PropertyValueFactory<>("idevent"));

        FilteredList<Reservation> filteredData = new FilteredList<>(listA, lu -> true);

        // 2. Set the filter Predicate whenever the filter changes.
        searchReservation.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate((Reservation reservation) -> {
                // If filter text is empty, display all persons.

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                // Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();

                if (String.valueOf(reservation.getId()).contains(lowerCaseFilter)) {
                    return true; // Filter matches first name.
                } else if ((String.valueOf(reservation.getDateReservation()).contains(lowerCaseFilter))) {
                    return true; // Filter matches last name.
                } else if (String.valueOf(reservation.getQuantite()).contains(lowerCaseFilter)) {
                    return true; // Filter matches last name.
                } else if (reservation.getSeat().contains(lowerCaseFilter)) {
                    return true;
                } else {
                    return false; // Does not match.
                }
            });
        });

        // 3. Wrap the FilteredList in a SortedList. 
        SortedList<Reservation> sortedData = new SortedList<>(filteredData);

        // 4. Bind the SortedList comparator to the TableView comparator.
        // 	  Otherwise, sorting the TableView would have no effect.
        sortedData.comparatorProperty().bind(tablereservation.comparatorProperty());

        // 5. Add sorted (and filtered) data to the table.
        tablereservation.setItems(sortedData);
    }

    @FXML
    private void deleteReservation(ActionEvent reservation) throws SQLException {
         ServiceReservation SA = new ServiceReservation();
        SA.delete(id.getCellData(tablereservation.getSelectionModel().getSelectedIndex()));
        //refresh();
        JOptionPane.showMessageDialog(null, "Reservation Deleted");
    }

    private void addreservation(ActionEvent reservation) throws IOException {
         FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddReservation.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Add Reservation");
        stage.setScene(new Scene(root1));
        stage.show();
    }

    @FXML
    private void updateReservation(ActionEvent reservation) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("UpdateReservation.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Update Reservation");
        stage.setScene(new Scene(root1));
        stage.show();
         UpdateReservationController uac=fxmlLoader.getController();
        uac.setTfdatereservation(datereservation.getCellData(tablereservation.getSelectionModel().getSelectedIndex()));
        uac.setTfquantite(quantite.getCellData(tablereservation.getSelectionModel().getSelectedIndex())); 
        uac.setTftotal(total.getCellData(tablereservation.getSelectionModel().getSelectedIndex()));
        uac.setTftype(type.getCellData(tablereservation.getSelectionModel().getSelectedIndex()));
        uac.setTfseat(seat.getCellData(tablereservation.getSelectionModel().getSelectedIndex()));
        uac.setTfpayer(payer.getCellData(tablereservation.getSelectionModel().getSelectedIndex()));
        uac.setTfnomreservation(nomreservation.getCellData(tablereservation.getSelectionModel().getSelectedIndex()));
    
    }

//    @FXML
//    private ArrayList<Reservation> historique(ActionEvent event) {
//             try {
//           //getAll reservations
//           PreparedStatement st = con.prepareStatement("select * from reservation where user_id ="+id+" and event_id = ANY(SELECT id from event) and dateReservation>(SELECT dateevent from event)");
//           ResultSet resultset = st.executeQuery();
//           resultset.beforeFirst();
//           while(resultset.next()){
//           Reservation rs = new Reservation(resultset.getInt(1),resultset.getInt(2),resultset.getInt(3),resultset.getString(4),resultset.getInt(5),resultset.getDouble(6),resultset.getString(7),resultset.getString(8));
//           rs.setNomReservation(resultset.getString(10));
//           reservations.add(rs);
//           }
//           
//           //getAll Reservations
//            
//        } catch (SQLException ex) {
//             System.out.println(ex.getMessage());
//        }          
//        return reservations;  
//    }

    @FXML
    private void historique(ActionEvent event) {
    }
}
