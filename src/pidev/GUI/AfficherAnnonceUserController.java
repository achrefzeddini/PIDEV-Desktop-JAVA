/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.GUI;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Date;
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
import pidev.Entite.Annonce;
import pidev.Service.ServiceAnnonce;

/**
 * FXML Controller class
 *
 * @author elhak
 */
public class AfficherAnnonceUserController implements Initializable {

    
    @FXML
    private TableView<Annonce> tableAnnonces;
    @FXML
    private TableColumn<Annonce, Integer> columnIdAnnonce;
    @FXML
    private TableColumn<Annonce, Integer> columnIdUser;
    @FXML
    private TableColumn<Annonce, String> columnNomAnnonce;
    @FXML
    private TableColumn<Annonce, String> columnDescriptionAnnonce;
    @FXML
    private TableColumn<Annonce, Date> columnDateAnnonce;
    @FXML
    private TextField searchAnnonce;
    @FXML
    private Button btnref;
    @FXML
    private Button addAnnonce;
    @FXML
    private Button addComment;
    
    ObservableList<Annonce> listA = FXCollections.observableArrayList();
    
    
    
     private int lbidAnnonce;

    public void setLbidAnnonce(int lbidAnnonce) {
        this.lbidAnnonce = lbidAnnonce;
    }
    

    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        refresh();
    }    

    @FXML
    void refresh(){
        ServiceAnnonce SA = new ServiceAnnonce();
        listA.clear();
        try {
            listA.addAll(SA.readAll());
        } catch (SQLException ex) {
            Logger.getLogger(AfficherAnnonceController.class.getName()).log(Level.SEVERE, null, ex);
        }

        columnIdAnnonce.setCellValueFactory(new PropertyValueFactory<>("id"));
        columnIdUser.setCellValueFactory(new PropertyValueFactory<>("user_id"));
        columnNomAnnonce.setCellValueFactory(new PropertyValueFactory<>("nomAnnonce"));
        columnDescriptionAnnonce.setCellValueFactory(new PropertyValueFactory<>("descriptionAnnonce"));
        columnDateAnnonce.setCellValueFactory(new PropertyValueFactory<>("dateAnnonce"));
        
        
        FilteredList<Annonce> filteredData = new FilteredList<>(listA, lu -> true);

        // 2. Set the filter Predicate whenever the filter changes.
        searchAnnonce.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate((Annonce annonce) -> {
                // If filter text is empty, display all persons.

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                // Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();

                if (String.valueOf(annonce.getId()).contains(lowerCaseFilter)) {
                    return true; // Filter matches first name.
                } else if ((String.valueOf(annonce.getUser_id()).contains(lowerCaseFilter))) {
                    return true; // Filter matches last name.
                } else if (annonce.getNomAnnonce().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches last name.
                } else if (annonce.getDescriptionAnnonce().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else {
                    return false; // Does not match.
                }
            });
        });

        // 3. Wrap the FilteredList in a SortedList. 
        SortedList<Annonce> sortedData = new SortedList<>(filteredData);

        // 4. Bind the SortedList comparator to the TableView comparator.
        // 	  Otherwise, sorting the TableView would have no effect.
        sortedData.comparatorProperty().bind(tableAnnonces.comparatorProperty());

        // 5. Add sorted (and filtered) data to the table.
        tableAnnonces.setItems(sortedData);
    }

    private void deleteAnnonce(ActionEvent event) throws SQLException {    
        ServiceAnnonce SA = new ServiceAnnonce();
        SA.delete(columnIdAnnonce.getCellData(tableAnnonces.getSelectionModel().getSelectedIndex()));
        refresh();
        JOptionPane.showMessageDialog(null, "Announce Deleted");
    }

    @FXML
    private void addAnnonce(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddAnnonce.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Add Comment");
        stage.setScene(new Scene(root1));
        stage.show();
    }

    @FXML
    private void addComment(ActionEvent event) throws IOException {
       FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddCommentUser.fxml"));
       Annonceid.setAnnonceid(columnIdAnnonce.getCellData(tableAnnonces.getSelectionModel().getSelectedIndex()));
 
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Add Comment");
        stage.setScene(new Scene(root1));
        
        AddCommentUserController uac=fxmlLoader.getController();
        uac.setTfNomAnnonce(columnNomAnnonce.getCellData(tableAnnonces.getSelectionModel().getSelectedIndex()));
        uac.setTfDescriptionAnnonce(columnDescriptionAnnonce.getCellData(tableAnnonces.getSelectionModel().getSelectedIndex())); 
//        uac.setAnnoncee(columnIdAnnonceRS.getCellData(tableAnnonces.getSelectionModel().getSelectedIndex()));
        uac.setLbidAnnonce(columnIdAnnonce.getCellData(tableAnnonces.getSelectionModel().getSelectedIndex()));
        
        
        stage.show();
        
        
        
//        uac.setIdARS(columnIdAnnonceRS.getCellData(tableAnnonces.getSelectionModel().getSelectedIndex()));
//      
               


    }
    
}




///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package pidev.GUI;
//
//import java.io.IOException;
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
//import javafx.fxml.FXMLLoader;
//import javafx.fxml.Initializable;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.control.TableColumn;
//import javafx.scene.control.TableView;
//import javafx.scene.control.TextField;
//import javafx.scene.control.cell.PropertyValueFactory;
//import javafx.stage.Stage;
//import javax.swing.JOptionPane;
//import pidev.Entite.Annonce;
//import pidev.Service.ServiceAnnonce;
//
///**
// * FXML Controller class
// *
// * @author elhak
// */
//public class AfficherAnnonceUserController implements Initializable {
//
//    
//    @FXML
//    private TableView<Annonce> tableAnnonces;
//    @FXML
//    private TableColumn<Annonce, Integer> columnIdAnnonce;
//    @FXML
//    private TableColumn<Annonce, Integer> columnIdAnnonceRS;
//    @FXML
//    private TableColumn<Annonce, Integer> columnIdUser;
//    @FXML
//    private TableColumn<Annonce, String> columnNomAnnonce;
//    @FXML
//    private TableColumn<Annonce, String> columnDescriptionAnnonce;
//    @FXML
//    private Button deleteAnnonce;
//    @FXML
//    private TextField searchAnnonce;
//    @FXML
//    private Button btnref;
//    @FXML
//    private Button addAnnonce;
//    @FXML
//    private Button addComment;
//    
//    ObservableList<Annonce> listA = FXCollections.observableArrayList();
//    
//
//    /**
//     * Initializes the controller class.
//     */
//    
//    @Override
//    public void initialize(URL url, ResourceBundle rb) {
//        // TODO
//        refresh();
//    }    
//
//    @FXML
//    void refresh(){
//        ServiceAnnonce SA = new ServiceAnnonce();
//        listA.clear();
//        try {
//            listA.addAll(SA.readAll());
//        } catch (SQLException ex) {
//            Logger.getLogger(AfficherAnnonceController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        columnIdAnnonce.setCellValueFactory(new PropertyValueFactory<>("idAnnonce"));
//        columnIdAnnonceRS.setCellValueFactory(new PropertyValueFactory<>("idAnnonceRS"));
//        columnIdUser.setCellValueFactory(new PropertyValueFactory<>("idUser"));
//        columnNomAnnonce.setCellValueFactory(new PropertyValueFactory<>("nomAnnonce"));
//        columnDescriptionAnnonce.setCellValueFactory(new PropertyValueFactory<>("descriptionAnnonce"));
//
//        FilteredList<Annonce> filteredData = new FilteredList<>(listA, lu -> true);
//
//        // 2. Set the filter Predicate whenever the filter changes.
//        searchAnnonce.textProperty().addListener((observable, oldValue, newValue) -> {
//            filteredData.setPredicate((Annonce annonce) -> {
//                // If filter text is empty, display all persons.
//
//                if (newValue == null || newValue.isEmpty()) {
//                    return true;
//                }
//
//                // Compare first name and last name of every person with filter text.
//                String lowerCaseFilter = newValue.toLowerCase();
//
//                if (String.valueOf(annonce.getIdAnnonceRS()).contains(lowerCaseFilter)) {
//                    return true; // Filter matches first name.
//                } else if ((String.valueOf(annonce.getIdUser()).contains(lowerCaseFilter))) {
//                    return true; // Filter matches last name.
//                } else if (annonce.getNomAnnonce().toLowerCase().contains(lowerCaseFilter)) {
//                    return true; // Filter matches last name.
//                } else if (annonce.getDescriptionAnnonce().toLowerCase().contains(lowerCaseFilter)) {
//                    return true;
//                } else {
//                    return false; // Does not match.
//                }
//            });
//        });
//
//        // 3. Wrap the FilteredList in a SortedList. 
//        SortedList<Annonce> sortedData = new SortedList<>(filteredData);
//
//        // 4. Bind the SortedList comparator to the TableView comparator.
//        // 	  Otherwise, sorting the TableView would have no effect.
//        sortedData.comparatorProperty().bind(tableAnnonces.comparatorProperty());
//
//        // 5. Add sorted (and filtered) data to the table.
//        tableAnnonces.setItems(sortedData);
//    }
//
//    @FXML
//    private void deleteAnnonce(ActionEvent event) throws SQLException {    
//        ServiceAnnonce SA = new ServiceAnnonce();
//        SA.delete(columnIdAnnonceRS.getCellData(tableAnnonces.getSelectionModel().getSelectedIndex()));
//        refresh();
//        JOptionPane.showMessageDialog(null, "Announce Deleted");
//    }
//
//    @FXML
//    private void addAnnonce(ActionEvent event) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddAnnonce.fxml"));
//        Parent root1 = (Parent) fxmlLoader.load();
//        Stage stage = new Stage();
//        stage.setTitle("Add Comment");
//        stage.setScene(new Scene(root1));
//        stage.show();
//    }
//
//    @FXML
//    private void addComment(ActionEvent event) throws IOException {
//       FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddCommentUser.fxml"));
//       Annonceid.setAnnonceid(columnIdAnnonceRS.getCellData(tableAnnonces.getSelectionModel().getSelectedIndex()));
// 
//        Parent root1 = (Parent) fxmlLoader.load();
//        Stage stage = new Stage();
//        stage.setTitle("Add Comment");
//        stage.setScene(new Scene(root1));
//        
//        AddCommentUserController uac=fxmlLoader.getController();
//        uac.setTfNomAnnonce(columnNomAnnonce.getCellData(tableAnnonces.getSelectionModel().getSelectedIndex()));
//        uac.setTfDescriptionAnnonce(columnDescriptionAnnonce.getCellData(tableAnnonces.getSelectionModel().getSelectedIndex())); 
////        uac.setAnnoncee(columnIdAnnonceRS.getCellData(tableAnnonces.getSelectionModel().getSelectedIndex()));
//        uac.setLbidAnnonce(columnIdAnnonceRS.getCellData(tableAnnonces.getSelectionModel().getSelectedIndex()));
//        
//        
//        stage.show();
//        
//        
//        
////        uac.setIdARS(columnIdAnnonceRS.getCellData(tableAnnonces.getSelectionModel().getSelectedIndex()));
////      
//               
//
//
//    }
//    
//}
