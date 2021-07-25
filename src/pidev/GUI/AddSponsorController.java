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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import pidev.Entite.Sponsor;
import pidev.Service.ServiceSponsor;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class AddSponsorController implements Initializable {

    @FXML
    private Label labelLastNameCurrentUser;
    @FXML
    private Label labelNameCurrentUser;
    @FXML
    private TextField tfnom;
    @FXML
    private TextField tfmail;
    @FXML
    private TextField tfconfirmation;
    @FXML
    private TextField tfIdSponsor;
    @FXML
    private TextField tfUserId;
    @FXML
    private Button deleteSponsor;
    @FXML
    private Button addSponsor;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void deleteSponsor(ActionEvent event) throws SQLException {
        ServiceSponsor SC = new ServiceSponsor();
        SC.delete(Integer.parseInt(tfIdSponsor.getText()));
        JOptionPane.showMessageDialog(null, "Sponsor Deleted");
    }

    @FXML
    private void addSponsor(ActionEvent event) throws SQLException {
        ServiceSponsor SA=new ServiceSponsor();
        SA.ajouter(new Sponsor(tfnom.getText(),Integer.parseInt(tfUserId.getText()),Integer.parseInt(tfconfirmation.getText()),tfmail.getText()));       
        JOptionPane.showMessageDialog(null, "Sponsor added");
    }
    
}
