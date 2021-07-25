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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import pidev.Entite.CurrentUser;

/**
 * FXML Controller class
 *
 * @author Testouri Mohamed
 */
public class MainUController implements Initializable {

    @FXML
    private Button UserButton;
    @FXML
    private Button ProductButton;
    @FXML
    private Button EventButton;
    @FXML
    private Button AnnonceButton;
    @FXML
    private AnchorPane LoaderPane;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    ProfileUserScreenController PUSC = new ProfileUserScreenController();
    @FXML
    private Button CartButton;
    @FXML
    private Button AnimalButton;
    @FXML
    private Button SeasonButton;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        AnchorPane pane = null;

        try {
            pane = FXMLLoader.load(getClass().getResource("ProfileUserScreen.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(MainUController.class.getName()).log(Level.SEVERE, null, ex);
        }

        LoaderPane.getChildren().setAll(pane);
    }

    @FXML
    private void goUsersScreen(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("ProfileUserScreen.fxml"));
        LoaderPane.getChildren().setAll(pane);
    }


    @FXML
    private void goProductsScreen(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("userShopList.fxml"));
        LoaderPane.getChildren().setAll(pane);
    }


    @FXML
    private void goEventsScreen(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("AddReservation.fxml"));
        LoaderPane.getChildren().setAll(pane);
    }

    @FXML
    private void goAnnoncesScreen(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("AfficherAnnonceUser.fxml"));
        LoaderPane.getChildren().setAll(pane);
    }

    @FXML
    private void goCartScreen(ActionEvent event) throws IOException {
         AnchorPane pane = FXMLLoader.load(getClass().getResource("UserPanier.fxml"));
        LoaderPane.getChildren().setAll(pane);
    }

    @FXML
    private void goAnimalScreen(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("UserAnimal.fxml"));
        LoaderPane.getChildren().setAll(pane);
    }

    @FXML
    private void goSeasonScreen(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("TableSeason.fxml"));
        LoaderPane.getChildren().setAll(pane);
    }
}
