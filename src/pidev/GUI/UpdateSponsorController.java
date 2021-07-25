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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import pidev.Entite.Sponsor;
import pidev.Service.ServiceEvent;
import pidev.Service.ServiceSponsor;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class UpdateSponsorController implements Initializable {

    @FXML
    private Button btnUPdate;
    @FXML
    private TextField tfnom;
    @FXML
    private TextField tfmail;
    @FXML
    private TextField tfconfirmation;
    private TextField tfidsponsor;
    @FXML
    private TextField tfidevent;
    @FXML
    private Label n;
    
    
    private int lbidSponsors;

    public void setLbidSponsors(int lbidSponsors) {
        this.lbidSponsors = lbidSponsors;
    }
    
    
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
     public void setTfidsponsor(int tfidsponsor) {
        this.tfidsponsor.setText(String.valueOf(tfidsponsor));
    }
    public void setTfnom(String tfnom) {
        this.tfnom.setText(tfnom);
    }
 public void setTfidevent(int tfidevent) {
        this.tfidevent.setText(String.valueOf(tfidevent));
    }
 public void setTfconfirmation(int  tfconfirmation) {
        this.tfconfirmation.setText(String.valueOf(tfconfirmation));
    }
 public void setTfmail(String  tfmail) {
        this.tfmail.setText( tfmail);
    }
 public void setN(int n) {
        this.n.setText(String.valueOf(n));
    }
 

    @FXML
    private void UpdateSponsor(ActionEvent event) throws SQLException {
        
        
        ServiceSponsor sc=new ServiceSponsor();
        
        sc.update(new Sponsor(tfnom.getText(),Integer.parseInt(tfconfirmation.getText()), Integer.parseInt(tfidevent.getText()),tfmail.getText()), lbidSponsors);
        
        JOptionPane.showMessageDialog(null, "Sponsor Updated");
                final Node source = (Node) event.getSource();
                final Stage stage = (Stage) source.getScene().getWindow();
                stage.close();
    }
    
}
