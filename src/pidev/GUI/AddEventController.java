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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import pidev.Entite.Event;
import pidev.Service.ServiceEvent;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class AddEventController implements Initializable {

    @FXML
    private Button btnRetour;
    @FXML
    private TextField tftitre;
    @FXML
    private Button btnAjouterEvent;
    @FXML
    private TextField tflocalisation;
    @FXML
    private TextField tfnbrplaces;
    @FXML
    private TextField tfhdebut;
    @FXML
    private TextField tfhfin;
    @FXML
    private TextField tfprix;
    @FXML
    private TextField tfimage;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void retour(ActionEvent event) throws IOException {
        final Node source = (Node) event.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void AjouterEvent(ActionEvent event) throws IOException, SQLException{
          ServiceEvent SA = new ServiceEvent();
        SA.ajouter(new Event(
                                tftitre.getText(),
                                Integer.parseInt(tfnbrplaces.getText()),
                                tflocalisation.getText(),
                                Float.parseFloat(tfhdebut.getText()),
                                Float.parseFloat(tfhfin.getText()),
                                tfimage.getText(),
                                Float.parseFloat(tfprix.getText())));

        JOptionPane.showMessageDialog(null, "Annonce added");
    }
    
}
