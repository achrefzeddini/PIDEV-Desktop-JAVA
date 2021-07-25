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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;
import pidev.Entite.Commentaire;
import pidev.Service.ServiceCommentaire;
import pidev.Entite.CurrentUser;

/**
 * FXML Controller class
 *
 * @author elhak
 */
public class AddCommentUserController implements Initializable {

    @FXML
    private TextField tfNomAnnonce;
    @FXML
    private TextArea tfDescriptionAnnonce;
    
   
    
    private int lbidAnnonce;
    
    public void setLbidAnnonce(int lbidAnnonce) {
        this.lbidAnnonce = lbidAnnonce;
    }
    
    
    

    @FXML
    private TableView<Commentaire> tableCommentaires;
    @FXML
    private TableColumn<Commentaire, Integer> columnIdUser;
    @FXML
    private TableColumn<Commentaire, String> columnChampCommentaire;
    @FXML
    private TableColumn<Commentaire, String> columnDate;

    @FXML
    private TextField tfUserComment;
    @FXML
    private Button btnAjouterCommentaire;
    
    public int annoncee;

    public int getAnnoncee() {
        return annoncee;
    }

    public void setAnnoncee(int annoncee) {
        this.annoncee = annoncee;
    }

    ObservableList<Commentaire> listA = FXCollections.observableArrayList();

    @FXML
    private Label idARS;
    private TextField tfCurrentUser;

    public void setIdARS(int idARS) {
        this.idARS.setText(String.valueOf(idARS));
    }


    public void setTfNomAnnonce(String tfNomAnnonce) {
        this.tfNomAnnonce.setText(tfNomAnnonce);
    }

    public void setTfDescriptionAnnonce(String tfDescriptionAnnonce) {
        this.tfDescriptionAnnonce.setText(tfDescriptionAnnonce);
    }

    public int getLbidAnnonce() {
        return lbidAnnonce;
    }

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO   
        
        System.out.println(Annonceid.getAnnonceid());
//        System.out.println(lbidAnnonce);
        
        ServiceCommentaire SA = new ServiceCommentaire();
        listA.clear();
        try {
//            listA.addAll(SA.readCom(Integer.parseInt(idARS.getText())));
            listA.addAll(SA.readCom(Annonceid.getAnnonceid()));
        } catch (SQLException ex) {
            Logger.getLogger(AfficherAnnonceController.class.getName()).log(Level.SEVERE, null, ex);
        }
        columnIdUser.setCellValueFactory(new PropertyValueFactory<>("user_id"));
        columnChampCommentaire.setCellValueFactory(new PropertyValueFactory<>("champCommentaire"));
        columnDate.setCellValueFactory(new PropertyValueFactory<>("dateCommentaire"));
        FilteredList<Commentaire> filteredData = new FilteredList<>(listA, lu -> true);

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
//                if (String.valueOf(commentaire.getIdAnnonceRS()).contains(lowerCaseFilter)) {
//                    return true; // Filter matches first name.
//                } else if ((String.valueOf(commentaire.getIdUser()).contains(lowerCaseFilter))) {
//                    return true; // Filter matches last name.
//                } else if (commentaire.getNomAnnonce().toLowerCase().contains(lowerCaseFilter)) {
//                    return true; // Filter matches last name.
//                } else if (commentaire.getDescriptionAnnonce().toLowerCase().contains(lowerCaseFilter)) {
//                    return true;
//                } else {
//                    return false; // Does not match.
//                }
//            });
//        });
        // 3. Wrap the FilteredList in a SortedList. 
        SortedList<Commentaire> sortedData = new SortedList<>(filteredData);

        // 4. Bind the SortedList comparator to the TableView comparator.
        // 	  Otherwise, sorting the TableView would have no effect.
        sortedData.comparatorProperty().bind(tableCommentaires.comparatorProperty());

        // 5. Add sorted (and filtered) data to the table.
        tableCommentaires.setItems(sortedData);

    }

//    private void UpdateAnnonce(ActionEvent event) throws IOException, SQLException {
//        ServiceAnnonce sa = new ServiceAnnonce();
//        sa.update(new Annonce(tfNomAnnonce.getText(), tfDescriptionAnnonce.getText()), lbidAnnonce);
////
////        JOptionPane.showMessageDialog(null, "Announce Updated");
//        // close window after adding
//        final Node source = (Node) event.getSource();
//        final Stage stage = (Stage) source.getScene().getWindow();
//        stage.close();
//    }

    @FXML
    private void AjouterCommentaire(ActionEvent event) throws SQLException {
           
        ServiceCommentaire sc = new ServiceCommentaire();   
        
        
        
        int a=1;    //user_id
        sc.add(new Commentaire(lbidAnnonce,CurrentUser.getUser_id(),tfUserComment.getText()));
        JOptionPane.showMessageDialog(null, "Comment Added");
    }

}


//
//
//
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
//import javafx.scene.control.Label;
//import javafx.scene.control.TableColumn;
//import javafx.scene.control.TableView;
//import javafx.scene.control.TextArea;
//import javafx.scene.control.TextField;
//import javafx.scene.control.cell.PropertyValueFactory;
//import javax.swing.JOptionPane;
//import pidev.Entite.Commentaire;
//import pidev.Entite.CurrentUser;
//import pidev.Service.ServiceCommentaire;
//
///**
// * FXML Controller class
// *
// * @author elhak
// */
//public class AddCommentUserController implements Initializable {
//
//    @FXML
//    private TextField tfNomAnnonce;
//    @FXML
//    private TextArea tfDescriptionAnnonce;
//    
//    private TextField tfIdAnnonce;
//    private TextField tfUserId;
//    private int lbidAnnonce;
//
//    @FXML
//    private TableView<Commentaire> tableCommentaires;
//    @FXML
//    private TableColumn<Commentaire, Integer> columnIdUser;
//    @FXML
//    private TableColumn<Commentaire, String> columnChampCommentaire;
//    @FXML
//    private TableColumn<Commentaire, String> columnDate;
//
//    @FXML
//    private TextField tfUserComment;
//    @FXML
//    private Button btnAjouterCommentaire;
//    
//    public int annoncee;
//
//    public int getAnnoncee() {
//        return annoncee;
//    }
//
//    public void setAnnoncee(int annoncee) {
//        this.annoncee = annoncee;
//    }
//
//    ObservableList<Commentaire> listA = FXCollections.observableArrayList();
//
//    @FXML
//    private Label idARS;
//
//    public void setIdARS(int idARS) {
//        this.idARS.setText(String.valueOf(idARS));
//    }
//
//    public void setLbidAnnonce(int lbidAnnonce) {
//        this.lbidAnnonce = lbidAnnonce;
//    }
//
//    public void setTfNomAnnonce(String tfNomAnnonce) {
//        this.tfNomAnnonce.setText(tfNomAnnonce);
//    }
//
//    public void setTfDescriptionAnnonce(String tfDescriptionAnnonce) {
//        this.tfDescriptionAnnonce.setText(tfDescriptionAnnonce);
//    }
//
//    public void setTfIdAnnonce(int tfIdAnnonce) {
//        this.tfIdAnnonce.setText(String.valueOf(tfIdAnnonce));
//    }
//
//    public void setTfUserId(int tfUserId) {
//        this.tfUserId.setText(String.valueOf(tfUserId));
//    }
//
//    public int getLbidAnnonce() {
//        return lbidAnnonce;
//    }
//
//    /**
//     * Initializes the controller class.
//     * @param url
//     * @param rb
//     */
//    @Override
//    public void initialize(URL url, ResourceBundle rb) {
//        // TODO   
//        
//        System.out.println(Annonceid.getAnnonceid());
////        System.out.println(lbidAnnonce);
//        
//        ServiceCommentaire SA = new ServiceCommentaire();
//        listA.clear();
//        try {
////            listA.addAll(SA.readCom(Integer.parseInt(idARS.getText())));
//            listA.addAll(SA.readCom(Annonceid.getAnnonceid()));
//        } catch (SQLException ex) {
//            Logger.getLogger(AfficherAnnonceController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        columnIdUser.setCellValueFactory(new PropertyValueFactory<>("idUser"));
//        columnChampCommentaire.setCellValueFactory(new PropertyValueFactory<>("champCommentaire"));
//        columnDate.setCellValueFactory(new PropertyValueFactory<>("dateCommentaire"));
//        FilteredList<Commentaire> filteredData = new FilteredList<>(listA, lu -> true);
//
////        
////        // 2. Set the filter Predicate whenever the filter changes.
////        searchCommentaire.textProperty().addListener((observable, oldValue, newValue) -> {
////            filteredData.setPredicate((Commentaire commentaire) -> {
////                // If filter text is empty, display all persons.
////
////                if (newValue == null || newValue.isEmpty()) {
////                    return true;
////                }
////
////                // Compare first name and last name of every person with filter text.
////                String lowerCaseFilter = newValue.toLowerCase();
////
////                if (String.valueOf(commentaire.getIdAnnonceRS()).contains(lowerCaseFilter)) {
////                    return true; // Filter matches first name.
////                } else if ((String.valueOf(commentaire.getIdUser()).contains(lowerCaseFilter))) {
////                    return true; // Filter matches last name.
////                } else if (commentaire.getNomAnnonce().toLowerCase().contains(lowerCaseFilter)) {
////                    return true; // Filter matches last name.
////                } else if (commentaire.getDescriptionAnnonce().toLowerCase().contains(lowerCaseFilter)) {
////                    return true;
////                } else {
////                    return false; // Does not match.
////                }
////            });
////        });
//        // 3. Wrap the FilteredList in a SortedList. 
//        SortedList<Commentaire> sortedData = new SortedList<>(filteredData);
//
//        // 4. Bind the SortedList comparator to the TableView comparator.
//        // 	  Otherwise, sorting the TableView would have no effect.
//        sortedData.comparatorProperty().bind(tableCommentaires.comparatorProperty());
//
//        // 5. Add sorted (and filtered) data to the table.
//        tableCommentaires.setItems(sortedData);
//
//    }
//
////    private void UpdateAnnonce(ActionEvent event) throws IOException, SQLException {
////        ServiceAnnonce sa = new ServiceAnnonce();
////        sa.update(new Annonce(tfNomAnnonce.getText(), tfDescriptionAnnonce.getText()), lbidAnnonce);
//////
//////        JOptionPane.showMessageDialog(null, "Announce Updated");
////        // close window after adding
////        final Node source = (Node) event.getSource();
////        final Stage stage = (Stage) source.getScene().getWindow();
////        stage.close();
////    }
//
//    @FXML
//    private void AjouterCommentaire(ActionEvent event) throws SQLException {
//        ServiceCommentaire sc = new ServiceCommentaire();
//        //idUser`,`idAnnonceRS`,`idCommentaireRS`,`champCommentaire`
//        sc.ajouterCom(new Commentaire(CurrentUser.getUser_id(),lbidAnnonce,tfUserComment.getText()));
//        JOptionPane.showMessageDialog(null, "Comment Added");
//    }
//
//}
