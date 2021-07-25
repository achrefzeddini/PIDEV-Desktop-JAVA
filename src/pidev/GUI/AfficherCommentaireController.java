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
import javafx.scene.SubScene;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.ContextMenuEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import pidev.Entite.Commentaire;
import pidev.Service.ServiceCommentaire;

/**
 * FXML Controller class
 *
 * @author elhak
 */
public class AfficherCommentaireController implements Initializable {

    @FXML
    private TableView<Commentaire> tableCommentaire;
    @FXML
    private Button btnDeleteCommentaire;
    @FXML
    private TableColumn<Commentaire, Integer> columnIdCommentaire;
    private TableColumn<Commentaire, Integer> columnIdCommentaireRS;
    @FXML
    private TableColumn<Commentaire, Integer> columnIdUser;
    @FXML
    private TableColumn<Commentaire, Integer> columnIdAnnonceRS;
    @FXML
    private TableColumn<Commentaire, String> columnChampCommentaire;
    @FXML
    private TableColumn<Commentaire, String> columnDateCommentaire;
    @FXML
    private TextField searchCommentaire;

    ObservableList<Commentaire> listC = FXCollections.observableArrayList();

    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            refresh();
    }

    private void addCommentaire(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader;
        fxmlLoader = new FXMLLoader(getClass().getResource("AddCommentaire.fxml"));
        Parent root = (Parent)fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Add Comment");
        stage.setScene(new Scene(root));
        stage.show();
        
    }

    private void updateCommentaire(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("UpdateCommentaire.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Update Comment");
        stage.setScene(new Scene(root));
        stage.show();

    }

    @FXML
    private void deleteCommentaire(ActionEvent event) throws SQLException {
        ServiceCommentaire SC = new ServiceCommentaire();
        SC.delete(columnIdCommentaire.getCellData(tableCommentaire.getSelectionModel().getSelectedIndex()));
        JOptionPane.showMessageDialog(null, "Comment Deleted");
        refresh();
    }

    private void refresh() {
        
        ServiceCommentaire SC = new ServiceCommentaire();
        listC.clear();
        try {
            listC.addAll(SC.readAll());
        } catch (SQLException ex) {
            Logger.getLogger(AfficherCommentaireController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        columnIdCommentaire.setCellValueFactory(new PropertyValueFactory<>("id"));
        columnIdUser.setCellValueFactory(new PropertyValueFactory<>("user_id"));
        columnIdAnnonceRS.setCellValueFactory(new PropertyValueFactory<>("annonce_id"));
        columnChampCommentaire.setCellValueFactory(new PropertyValueFactory<>("champCommentaire"));
        columnDateCommentaire.setCellValueFactory(new PropertyValueFactory<>("dateCommentaire"));
        tableCommentaire.setItems(listC);
        FilteredList<Commentaire> filteredData = new FilteredList<>(listC, lu -> true);

        // 2. Set the filter Predicate whenever the filter changes.
        searchCommentaire.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate((Commentaire commentaire) -> {
                // If filter text is empty, display all persons.

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                // Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();

                if (String.valueOf(commentaire.getId()).contains(lowerCaseFilter)) {
                    return true; // Filter matches id
                } else if ((String.valueOf(commentaire.getAnnonce_id()).contains(lowerCaseFilter))) {
                    return true;
                } else if ((String.valueOf(commentaire.getUser_id()).contains(lowerCaseFilter))) {
                    return true;
                } else if (commentaire.getChampCommentaire().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else {
                    return false;
                }
            });
        });
        

        // 3. Wrap the FilteredList in a SortedList. 
        SortedList<Commentaire> sortedData = new SortedList<>(filteredData);

        // 4. Bind the SortedList comparator to the TableView comparator.
        // 	  Otherwise, sorting the TableView would have no effect.
        sortedData.comparatorProperty().bind(tableCommentaire.comparatorProperty());

        // 5. Add sorted (and filtered) data to the table.
        tableCommentaire.setItems(sortedData);

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
//import javafx.scene.SubScene;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.control.TableColumn;
//import javafx.scene.control.TableView;
//import javafx.scene.control.TextField;
//import javafx.scene.control.cell.PropertyValueFactory;
//import javafx.scene.input.ContextMenuEvent;
//import javafx.stage.Stage;
//import javax.swing.JOptionPane;
//import pidev.Entite.Commentaire;
//import pidev.Service.ServiceCommentaire;
//
///**
// * FXML Controller class
// *
// * @author elhak
// */
//public class AfficherCommentaireController implements Initializable {
//
//    @FXML
//    private TableView<Commentaire> tableCommentaire;
//    @FXML
//    private Button btnDeleteCommentaire;
//    @FXML
//    private TableColumn<Commentaire, Integer> columnIdCommentaire;
//    @FXML
//    private TableColumn<Commentaire, Integer> columnIdCommentaireRS;
//    @FXML
//    private TableColumn<Commentaire, Integer> columnIdUser;
//    @FXML
//    private TableColumn<Commentaire, Integer> columnIdAnnonceRS;
//    @FXML
//    private TableColumn<Commentaire, String> columnChampCommentaire;
//    @FXML
//    private TableColumn<Commentaire, String> columnDateCommentaire;
//    @FXML
//    private TextField searchCommentaire;
//
//    ObservableList<Commentaire> listC = FXCollections.observableArrayList();
//
//    
//
//    /**
//     * Initializes the controller class.
//     */
//    @Override
//    public void initialize(URL url, ResourceBundle rb) {
//            refresh();
//    }
//
//    private void addCommentaire(ActionEvent event) throws IOException {
//        FXMLLoader fxmlLoader;
//        fxmlLoader = new FXMLLoader(getClass().getResource("AddCommentaire.fxml"));
//        Parent root = (Parent)fxmlLoader.load();
//        Stage stage = new Stage();
//        stage.setTitle("Add Comment");
//        stage.setScene(new Scene(root));
//        stage.show();
//        
//    }
//
//    private void updateCommentaire(ActionEvent event) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("UpdateCommentaire.fxml"));
//        Parent root = (Parent) fxmlLoader.load();
//        Stage stage = new Stage();
//        stage.setTitle("Update Comment");
//        stage.setScene(new Scene(root));
//        stage.show();
//
//    }
//
//    @FXML
//    private void deleteCommentaire(ActionEvent event) throws SQLException {
//        ServiceCommentaire SC = new ServiceCommentaire();
//        SC.delete(columnIdCommentaire.getCellData(tableCommentaire.getSelectionModel().getSelectedIndex()));
//        JOptionPane.showMessageDialog(null, "Comment Deleted");
//        refresh();
//    }
//
//    private void refresh() {
//        
//        ServiceCommentaire SC = new ServiceCommentaire();
//        listC.clear();
//        try {
//            listC.addAll(SC.readAll());
//        } catch (SQLException ex) {
//            Logger.getLogger(AfficherCommentaireController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        
//        columnIdCommentaire.setCellValueFactory(new PropertyValueFactory<>("idCommentaire"));
//        columnIdCommentaireRS.setCellValueFactory(new PropertyValueFactory<>("idCommentaireRS"));
//        columnIdUser.setCellValueFactory(new PropertyValueFactory<>("idUser"));
//        columnIdAnnonceRS.setCellValueFactory(new PropertyValueFactory<>("idAnnonceRS"));
//        columnChampCommentaire.setCellValueFactory(new PropertyValueFactory<>("champCommentaire"));
//        columnDateCommentaire.setCellValueFactory(new PropertyValueFactory<>("dateCommentaire"));
//        tableCommentaire.setItems(listC);
//        FilteredList<Commentaire> filteredData = new FilteredList<>(listC, lu -> true);
//
//        // 2. Set the filter Predicate whenever the filter changes.
//        searchCommentaire.textProperty().addListener((observable, oldValue, newValue) -> {
//            filteredData.setPredicate((Commentaire commentaire) -> {
//                // If filter text is empty, display all persons.
//
//                if (newValue == null || newValue.isEmpty()) {
//                    return true;
//                }
//
//                // Compare first name and last name of every person with filter text.
//                String lowerCaseFilter = newValue.toLowerCase();
//
//                if (String.valueOf(commentaire.getIdCommentaire()).contains(lowerCaseFilter)) {
//                    return true; // Filter matches first name.
//                } else if ((String.valueOf(commentaire.getIdCommentaireRS()).contains(lowerCaseFilter))) {
//                    return true; // Filter matches last name.
//                } else if ((String.valueOf(commentaire.getIdUser()).contains(lowerCaseFilter))) {
//                    return true;
//                } else if ((String.valueOf(commentaire.getIdAnnonceRS()).contains(lowerCaseFilter))) {
//                    return true;
//                } else if (commentaire.getChampCommentaire().toLowerCase().contains(lowerCaseFilter)) {
//                    return true;
//                } else if (commentaire.getDateCommentaire().toLowerCase().contains(lowerCaseFilter)){
//                    return true;
//                } else {
//                    return false;
//                }
//            });
//        });
//        
//
//        // 3. Wrap the FilteredList in a SortedList. 
//        SortedList<Commentaire> sortedData = new SortedList<>(filteredData);
//
//        // 4. Bind the SortedList comparator to the TableView comparator.
//        // 	  Otherwise, sorting the TableView would have no effect.
//        sortedData.comparatorProperty().bind(tableCommentaire.comparatorProperty());
//
//        // 5. Add sorted (and filtered) data to the table.
//        tableCommentaire.setItems(sortedData);
//
//    }
//
//
//}
