/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.GUI;

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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;
import pidev.Entite.Commande;
import pidev.Service.ServiceCommande;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class UserPanierController implements Initializable {

    @FXML
    private TableColumn<Commande, String> colproduit;
    @FXML
    private Button btndel;
    @FXML
    private TextField tfsearchP;
    @FXML
    private TableView<Commande> tablecom;
    @FXML
    private TableColumn<Commande, Integer> colnumber;
    @FXML
    private Button btnorder;
    ObservableList<Commande> listC = FXCollections.observableArrayList();
    @FXML
    private TableColumn<Commande, Float> colprice;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        refresh();
    }    

    @FXML
    private void deletecommande(ActionEvent event) throws SQLException {
    
        ServiceCommande sa = new ServiceCommande();
        sa.delete(colnumber.getCellData(tablecom.getSelectionModel().getSelectedIndex()));
        refresh();
             JOptionPane.showMessageDialog(null, "Commande Deleted");
    }

    @FXML
    private void orderpanier(ActionEvent event) throws SQLException {
        ServiceCommande sa = new ServiceCommande();
        sa.updatepanier(colnumber.getCellData(tablecom.getSelectionModel().getSelectedIndex()));
        refresh();
             JOptionPane.showMessageDialog(null, "Ordered");
        
    }
    
    void refresh(){
       
        ServiceCommande sc = new ServiceCommande();
       listC.clear();
       
       
        try {
            listC.addAll(sc.readPanier(1));
        } catch (SQLException ex) {
            Logger.getLogger(UserPanierController.class.getName()).log(Level.SEVERE, null, ex);
        }
      

        colnumber.setCellValueFactory(new PropertyValueFactory<>("id"));
        colproduit.setCellValueFactory(new PropertyValueFactory<>("produit"));
        colprice.setCellValueFactory(new PropertyValueFactory<>("price"));
       
        tablecom.setItems(listC);

        FilteredList<Commande> filteredData = new FilteredList<>(listC, lu -> true);

        // 2. Set the filter Predicate whenever the filter changes.
        tfsearchP.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate((Commande commande) -> {
                // If filter text is empty, display all persons.

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                // Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();

                if (String.valueOf(commande.getId()).contains(lowerCaseFilter)) {
                    return true; // Filter matches first name.
                } else if (commande.getProduit().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches last name.
                } else if (String.valueOf(commande.getUser_id()).contains(lowerCaseFilter)) {
                    return true;
                } else {
                    return false; // Does not match.
                }
            });
        });

        // 3. Wrap the FilteredList in a SortedList. 
        SortedList<Commande> sortedData = new SortedList<>(filteredData);

        // 4. Bind the SortedList comparator to the tablevciew comparator.
        // 	  Otherwise, sorting the tablevciew would have no effect.
        sortedData.comparatorProperty().bind(tablecom.comparatorProperty());

        // 5. Add sorted (and filtered) data to the table.
        tablecom.setItems(sortedData);
    }


  
    
}



///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package pidev.GUI;
//
//import java.net.URL;
//import java.sql.SQLException;
//import java.util.ResourceBundle;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.collections.transformation.FilteredList;
//import javafx.collections.transformation.SortedList;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.Initializable;
//import javafx.scene.control.Button;
//import javafx.scene.control.TableColumn;
//import javafx.scene.control.TableView;
//import javafx.scene.control.TextField;
//import javafx.scene.control.cell.PropertyValueFactory;
//import javax.swing.JOptionPane;
//import pidev.Entite.Commande;
//import pidev.Service.ServiceCommande;
//
///**
// * FXML Controller class
// *
// * @author hp
// */
//public class UserPanierController implements Initializable {
//
//    @FXML
//    private TableColumn<Commande, String> colproduit;
//    @FXML
//    private TableColumn<Commande, Integer> colreference;
//    @FXML
//    private Button btndel;
//    @FXML
//    private TextField tfsearchP;
//    @FXML
//    private TableView<Commande> tablecom;
//    @FXML
//    private TableColumn<Commande, Integer> colnumber;
//    @FXML
//    private Button btnorder;
//    ObservableList<Commande> listC = FXCollections.observableArrayList();
//    @FXML
//    private TableColumn<Commande, Float> colprice;
//
//    /**
//     * Initializes the controller class.
//     */
//    @Override
//    public void initialize(URL url, ResourceBundle rb) {
//        refresh();
//    }    
//
//    @FXML
//    private void deletecommande(ActionEvent event) throws SQLException {
//    
//        ServiceCommande sa = new ServiceCommande();
//        sa.delete(colnumber.getCellData(tablecom.getSelectionModel().getSelectedIndex()));
//        refresh();
//             JOptionPane.showMessageDialog(null, "Commande Deleted");
//    }
//
//    @FXML
//    private void orderpanier(ActionEvent event) throws SQLException {
//        ServiceCommande sa = new ServiceCommande();
//        sa.updatepanier(colnumber.getCellData(tablecom.getSelectionModel().getSelectedIndex()));
//        refresh();
//             JOptionPane.showMessageDialog(null, "Ordered");
//        
//    }
//    
//    void refresh(){
//       
//        ServiceCommande sc = new ServiceCommande();
//       listC.clear();
//       
//       
//        try {
//            listC.addAll(sc.readPanier(1));
//        } catch (SQLException ex) {
//            Logger.getLogger(UserPanierController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//      
//
//        colnumber.setCellValueFactory(new PropertyValueFactory<>("idCommande"));
//        colproduit.setCellValueFactory(new PropertyValueFactory<>("produit"));
//        colprice.setCellValueFactory(new PropertyValueFactory<>("price"));
//        colreference.setCellValueFactory(new PropertyValueFactory<>("idUser"));
//        tablecom.setItems(listC);
//
//        FilteredList<Commande> filteredData = new FilteredList<>(listC, lu -> true);
//
//        // 2. Set the filter Predicate whenever the filter changes.
//        tfsearchP.textProperty().addListener((observable, oldValue, newValue) -> {
//            filteredData.setPredicate((Commande commande) -> {
//                // If filter text is empty, display all persons.
//
//                if (newValue == null || newValue.isEmpty()) {
//                    return true;
//                }
//
//                // Compare first name and last name of every person with filter text.
//                String lowerCaseFilter = newValue.toLowerCase();
//
//                if (String.valueOf(commande.getIdCommande()).contains(lowerCaseFilter)) {
//                    return true; // Filter matches first name.
//                } else if (commande.getProduit().toLowerCase().contains(lowerCaseFilter)) {
//                    return true; // Filter matches last name.
//                } else if (String.valueOf(commande.getIdUser()).contains(lowerCaseFilter)) {
//                    return true;
//                } else {
//                    return false; // Does not match.
//                }
//            });
//        });
//
//        // 3. Wrap the FilteredList in a SortedList. 
//        SortedList<Commande> sortedData = new SortedList<>(filteredData);
//
//        // 4. Bind the SortedList comparator to the tablevciew comparator.
//        // 	  Otherwise, sorting the tablevciew would have no effect.
//        sortedData.comparatorProperty().bind(tablecom.comparatorProperty());
//
//        // 5. Add sorted (and filtered) data to the table.
//        tablecom.setItems(sortedData);
//    }
//
//
//  
//    
//}
