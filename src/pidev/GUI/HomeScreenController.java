/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Testouri Mohamed
 */
public class HomeScreenController implements Initializable {

    @FXML
    private Button UsersButton;
    @FXML
    private Button GroupsButton;
    @FXML
    private Button ProductsButton;
    @FXML
    private Button OrdersButton;
    @FXML
    private Button EventsButton;
    @FXML
    private Button AnnoncesButton;
    @FXML
    private AnchorPane HomeAnchorPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
            }    

    void goHomeScreen(ActionEvent event) {
    }

    @FXML
    void goUsersScreen(ActionEvent event) throws IOException {
                AnchorPane pane = null;
        try {
            pane = FXMLLoader.load(getClass().getResource("UsersScreen.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(MainScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
        HomeAnchorPane.getChildren().setAll(pane);
    }

    @FXML
    void goGroupsScreen(ActionEvent event) throws IOException {
        AnchorPane pane = null;
        try {
            pane = FXMLLoader.load(getClass().getResource("GroupScreen.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(MainScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
        HomeAnchorPane.getChildren().setAll(pane);
    }

    @FXML
    private void goProductsScreen(ActionEvent event) {
        AnchorPane pane = null;
        try {
            pane = FXMLLoader.load(getClass().getResource("ListProducts.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(MainScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
        HomeAnchorPane.getChildren().setAll(pane);
    }

    @FXML
    private void goOrdersScreen(ActionEvent event) {
        AnchorPane pane = null;
        try {
            pane = FXMLLoader.load(getClass().getResource("TableCommande.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(MainScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
        HomeAnchorPane.getChildren().setAll(pane);
    }

    @FXML
    private void goEventsScreen(ActionEvent event) {
        AnchorPane pane = null;
        try {
            pane = FXMLLoader.load(getClass().getResource("AfficherEvent.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(MainScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
        HomeAnchorPane.getChildren().setAll(pane);
    }

    @FXML
    private void goAnnoncesScreen(ActionEvent event) {
        AnchorPane pane = null;
        try {
            pane = FXMLLoader.load(getClass().getResource("TableSeason.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(MainScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
        HomeAnchorPane.getChildren().setAll(pane);
    }

    
}
