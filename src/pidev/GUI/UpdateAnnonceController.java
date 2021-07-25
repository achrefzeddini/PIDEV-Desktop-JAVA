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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import pidev.Entite.Annonce;
import pidev.Service.ServiceAnnonce;

/**
 * FXML Controller class
 *
 * @author elhak
 */
public class UpdateAnnonceController implements Initializable {

    @FXML
    private Button btnAjouterAnnonce;
    @FXML
    private TextField tfNomAnnonce;
    @FXML
    private TextArea tfDescriptionAnnonce;

    private int lbidAnnonce;

    public void setLbidAnnonce(int lbidAnnonce) {
        this.lbidAnnonce = lbidAnnonce;
    }

    public void setBtnAjouterAnnonce(Button btnAjouterAnnonce) {
        this.btnAjouterAnnonce = btnAjouterAnnonce;
    }

    public void setTfNomAnnonce(String tfNomAnnonce) {
        this.tfNomAnnonce.setText(tfNomAnnonce);
    }

    public void setTfDescriptionAnnonce(String tfDescriptionAnnonce) {
        this.tfDescriptionAnnonce.setText(tfDescriptionAnnonce);
    }
//
//    public void setTfUserId(int tfUserId) {
//        this.tfUserId.setText(String.valueOf(tfUserId));
//    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void UpdateAnnonce(ActionEvent event) throws IOException, SQLException {
        
        ServiceAnnonce sa = new ServiceAnnonce();
        sa.update(new Annonce(tfNomAnnonce.getText(), tfDescriptionAnnonce.getText()),lbidAnnonce);


        JOptionPane.showMessageDialog(null, "Announce Updated");
        // close window after adding
        final Node source = (Node) event.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
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
//import java.sql.SQLException;
//import java.util.ResourceBundle;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.fxml.Initializable;
//import javafx.scene.Node;
//import javafx.scene.Parent;
//import javafx.scene.control.Button;
//import javafx.scene.control.TextArea;
//import javafx.scene.control.TextField;
//import javafx.stage.Stage;
//import javax.swing.JOptionPane;
//import pidev.Entite.Annonce;
//import pidev.Service.ServiceAnnonce;
//
///**
// * FXML Controller class
// *
// * @author elhak
// */
//public class UpdateAnnonceController implements Initializable {
//
//    @FXML
//    private Button btnAjouterAnnonce;
//    @FXML
//    private TextField tfNomAnnonce;
//    @FXML
//    private TextArea tfDescriptionAnnonce;
//    private TextField tfIdAnnonce;
//    private TextField tfUserId;
//    private int lbidAnnonce;
//
//    public void setLbidAnnonce(int lbidAnnonce) {
//        this.lbidAnnonce = lbidAnnonce;
//    }
//
//    public void setBtnAjouterAnnonce(Button btnAjouterAnnonce) {
//        this.btnAjouterAnnonce = btnAjouterAnnonce;
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
//    /**
//     * Initializes the controller class.
//     */
//    @Override
//    public void initialize(URL url, ResourceBundle rb) {
//        // TODO
//    }
//
//    @FXML
//    private void UpdateAnnonce(ActionEvent event) throws IOException, SQLException {
//        ServiceAnnonce sa = new ServiceAnnonce();
//        sa.update(new Annonce(tfNomAnnonce.getText(), tfDescriptionAnnonce.getText()), lbidAnnonce);
//
//
//        JOptionPane.showMessageDialog(null, "Announce Updated");
//        // close window after adding
//        final Node source = (Node) event.getSource();
//        final Stage stage = (Stage) source.getScene().getWindow();
//        stage.close();
//    }
//
//}
//
//
//
//
//
