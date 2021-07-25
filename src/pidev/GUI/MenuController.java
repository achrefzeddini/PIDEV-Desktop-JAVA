/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author elhak
 */
public class MenuController implements Initializable {

    @FXML
    private Button HomeButton;
    @FXML
    private Button UserButton;
    @FXML
    private Button GroupButton;
    @FXML
    private Button AnimalButton;
    @FXML
    private Button ProductButton;
    @FXML
    private Button OrderButton;
    @FXML
    private Button EventButton;
    @FXML
    private Button AnnonceButton;
    @FXML
    private Button CommentsButton;
    @FXML
    private Button SignOutButton;
    @FXML
    private AnchorPane AnchorMain;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void goHomeScreen(ActionEvent event) {
    }

    @FXML
    private void goUsersScreen(ActionEvent event) {
    }

    @FXML
    private void goGroupsScreen(ActionEvent event) {
    }

    @FXML
    private void goAnimalScreen(ActionEvent event) {
    }

    @FXML
    private void goProductsScreen(ActionEvent event) {
    }

    @FXML
    private void goOrdersScreen(ActionEvent event) {
    }

    @FXML
    private void goEventsScreen(ActionEvent event) {
    }

    @FXML
    private void goAnnoncesScreen(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("AfficherAnnonce.fxml"));
        AnchorMain.getChildren().setAll(pane); 
    }

    @FXML
    private void goCommentsScreen(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("AfficherCommentaire.fxml"));
        AnchorMain.getChildren().setAll(pane); 
    }

    @FXML
    private void signOut(ActionEvent event) {
    }

    @FXML
    private void goAnimalScreen(MouseDragEvent event) {
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
//import java.util.ResourceBundle;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.fxml.Initializable;
//import javafx.scene.control.Button;
//import javafx.scene.input.MouseDragEvent;
//import javafx.scene.layout.AnchorPane;
//
///**
// * FXML Controller class
// *
// * @author elhak
// */
//public class MenuController implements Initializable {
//
//    @FXML
//    private Button HomeButton;
//    @FXML
//    private Button UserButton;
//    @FXML
//    private Button GroupButton;
//    @FXML
//    private Button AnimalButton;
//    @FXML
//    private Button ProductButton;
//    @FXML
//    private Button OrderButton;
//    @FXML
//    private Button EventButton;
//    @FXML
//    private Button AnnonceButton;
//    @FXML
//    private Button CommentsButton;
//    @FXML
//    private Button SignOutButton;
//    @FXML
//    private AnchorPane AnchorMain;
//
//    /**
//     * Initializes the controller class.
//     */
//    @Override
//    public void initialize(URL url, ResourceBundle rb) {
//        // TODO
//    }    
//
//    @FXML
//    private void goHomeScreen(ActionEvent event) {
//    }
//
//    @FXML
//    private void goUsersScreen(ActionEvent event) {
//    }
//
//    @FXML
//    private void goGroupsScreen(ActionEvent event) {
//    }
//
//    @FXML
//    private void goAnimalScreen(ActionEvent event) {
//    }
//
//    @FXML
//    private void goProductsScreen(ActionEvent event) {
//    }
//
//    @FXML
//    private void goOrdersScreen(ActionEvent event) {
//    }
//
//    @FXML
//    private void goEventsScreen(ActionEvent event) {
//    }
//
//    @FXML
//    private void goAnnoncesScreen(ActionEvent event) throws IOException {
//        AnchorPane pane = FXMLLoader.load(getClass().getResource("AfficherAnnonce.fxml"));
//        AnchorMain.getChildren().setAll(pane); 
//    }
//
//    @FXML
//    private void goCommentsScreen(ActionEvent event) throws IOException {
//        AnchorPane pane = FXMLLoader.load(getClass().getResource("AfficherCommentaire.fxml"));
//        AnchorMain.getChildren().setAll(pane); 
//    }
//
//    @FXML
//    private void signOut(ActionEvent event) {
//    }
//
//    @FXML
//    private void goAnimalScreen(MouseDragEvent event) {
//    }
//    
//}
