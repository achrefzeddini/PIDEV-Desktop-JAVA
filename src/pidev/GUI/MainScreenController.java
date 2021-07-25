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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import pidev.Entite.CurrentUser;

/**
 * FXML Controller class
 *
 * @author Testouri Mohamed
 */
public class MainScreenController implements Initializable {

    @FXML
    private AnchorPane LoaderAnchorPane;
    @FXML
    private Button HomeButton;
    @FXML
    private Button UserButton;
    @FXML
    private Button GroupButton;
    @FXML
    private Button ProductButton;
    @FXML
    private Button OrderButton;
    @FXML
    private Button EventButton;
    @FXML
    private Button AnnonceButton;
    @FXML
    private Button SignOutButton;
    @FXML
    private Button AnimalButton;
    @FXML
    private Button SponsorButton;
    @FXML
    private Button ReservationButton;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        AnchorPane paneI = null;
        try {
            paneI = FXMLLoader.load(getClass().getResource("HomeScreen.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(MainScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
        LoaderAnchorPane.getChildren().setAll(paneI);

    }

    @FXML
    void goHomeScreen(ActionEvent event) {
        AnchorPane pane = null;
        try {
            pane = FXMLLoader.load(getClass().getResource("HomeScreen.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(MainScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
        LoaderAnchorPane.getChildren().setAll(pane);
    }

    @FXML
    void goUsersScreen(ActionEvent event) throws IOException {
      AnchorPane pane = null;
        try {
            pane = FXMLLoader.load(getClass().getResource("UsersScreen.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(MainScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
        LoaderAnchorPane.getChildren().setAll(pane);
        
    }

    @FXML
    void goGroupsScreen(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("GroupScreen.fxml"));
                LoaderAnchorPane.getChildren().setAll(pane);
    }

    @FXML
void goProductsScreen(ActionEvent event) {
        AnchorPane pane = null;
        try {
            pane = FXMLLoader.load(getClass().getResource("ListProducts.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(MainScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
        LoaderAnchorPane.getChildren().setAll(pane);
    }

    @FXML
  void goOrdersScreen(ActionEvent event) {
        AnchorPane pane = null;
        try {
            pane = FXMLLoader.load(getClass().getResource("TableCommande.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(MainScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
        LoaderAnchorPane.getChildren().setAll(pane);
    }

    @FXML
    void goEventsScreen(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("AfficherEvent.fxml"));
                LoaderAnchorPane.getChildren().setAll(pane);
    }

    @FXML
    void goAnnoncesScreen(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("AfficherAnnonce.fxml"));
                LoaderAnchorPane.getChildren().setAll(pane);
        
    }

    @FXML
    void signOut(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("LoginScreen.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Hunt Kingdom | Login");
        stage.setScene(new Scene(root1));
        stage.show();
        final Node source = (Node) event.getSource();
        final Stage stages = (Stage) source.getScene().getWindow();
        stages.close();
        CurrentUser.disConnect();
    }

    @FXML
    private void goAnimalScreen(ActionEvent event) {
        AnchorPane pane = null;
        try {
            pane = FXMLLoader.load(getClass().getResource("TableAnimal.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(MainScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
        LoaderAnchorPane.getChildren().setAll(pane);
    }

    @FXML
    private void goSponsorsScreen(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("AfficherSponsor.fxml"));
                LoaderAnchorPane.getChildren().setAll(pane);
    }

    @FXML
    private void goReservationScreen(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("AfficherReservation.fxml"));
                LoaderAnchorPane.getChildren().setAll(pane);
    }

}
