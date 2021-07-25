/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.GUI;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
public class UpdateEventController implements Initializable {

    @FXML
    private Button btnAjouterAnnonce;
    @FXML
    private TextField tftitre;
    @FXML
    private TextField tfprix;
    @FXML
    private TextField tfhfin;
    @FXML
    private TextField tfhdebut;
    @FXML
    private TextField tflocalisation;
    @FXML
    private TextField tfnbrplaces;
    @FXML
    private Label n;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
     public void setTftitre(String tftitre) {
        this.tftitre.setText(tftitre);
    }
 public void setTfnbrplaces(int tfnbrplaces) {
        this.tfnbrplaces.setText(String.valueOf(tfnbrplaces));
    }
   public void setTflocalisation(String tflocalisation) {
        this.tflocalisation.setText(tflocalisation);
    }
   public void setTfhdebut(Float tfhdebut) {
        this.tfhdebut.setText(String.valueOf(tfhdebut));
    }
    public void setTfhfin (Float tfhfin) {
        this.tfhfin.setText(String.valueOf(tfhfin));
    }
     public void setTfprix(Float tfprix) {
        this.tfprix.setText(String.valueOf(tfprix));
    }

    public void setN(int n) {
        this.n.setText(String.valueOf(n));
    }
     
    @FXML
    private void UpdateAnnonce(ActionEvent event) throws SQLException {
       
        ServiceEvent sa = new ServiceEvent();
        sa.update(new Event(tftitre.getText(),Integer.parseInt(tfnbrplaces.getText()),tflocalisation.getText(),Float.parseFloat(tfhdebut.getText()),Float.parseFloat(tfhfin.getText()),Float.parseFloat(tfprix.getText())),Integer.parseInt(n.getText()));

        JOptionPane.showMessageDialog(null, "Event Updated");
        // close window after adding
        final Node source = (Node) event.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }
    
}
