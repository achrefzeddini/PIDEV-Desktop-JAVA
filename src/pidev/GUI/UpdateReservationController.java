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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import pidev.Entite.Reservation;
import pidev.Entite.Sponsor;
import pidev.Service.ServiceReservation;
import pidev.Service.ServiceSponsor;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class UpdateReservationController implements Initializable {

    @FXML
    private TextField tfdatereservation;
    @FXML
    private TextField tfnomreservation;
    @FXML
    private TextField tfpayer;
    @FXML
    private TextField tfseat;
    @FXML
    private TextField tftype;
    @FXML
    private TextField tfquantite;
    @FXML
    private TextField tftotal;
    @FXML
    private Button btnUPdate;
    @FXML
    private Label n;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
     public void setTfdatereservation(String tfdatereservation) {
        this.tfdatereservation.setText(tfdatereservation);
    }
   public void setTfquantite(int tfquantite) {
        this.tfquantite.setText(String.valueOf(tfquantite));
    }
    public void setTfnbrplaces(double tftotal) {
        this.tftotal.setText(String.valueOf(tftotal));
    }
    public void setTftype(String tftype) {
        this.tftype.setText(tftype);
    }

    public void setTfnomreservation(String tfnomreservation) {
        this.tfnomreservation.setText(tfnomreservation);
    }

    public void setTfpayer(int tfpayer) {
        this.tfpayer.setText(String.valueOf(tfpayer));
    }

    public void setTfseat(String tfseat) {
        this.tfseat.setText(tfseat);
    }

    public void setTftotal(Double tftotal) {
        this.tftotal.setText(String.valueOf(tftotal));
    }
    

    @FXML
    private void UpdateReservation(ActionEvent event) throws SQLException {
         ServiceReservation sc=new ServiceReservation();
        Reservation r = new Reservation(tfdatereservation.getText(),Integer.parseInt(tfquantite.getText()),Double.parseDouble(tftotal.getText()),tftype.getText(),tfseat.getText(),Integer.parseInt(tfpayer.getText()));
        
        sc.update(r,Integer.parseInt(tfnomreservation.getText()));
        JOptionPane.showMessageDialog(null, "Sponsor Updated");
                final Node source = (Node) event.getSource();
                final Stage stage = (Stage) source.getScene().getWindow();
                stage.close();
    }
    
}
