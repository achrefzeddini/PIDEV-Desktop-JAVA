/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.GUI;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
public class AddAnnonceController implements Initializable {

    @FXML
    private Button btnAjouterAnnonce;
    @FXML
    private TextField tfNomAnnonce;
    @FXML
    private TextArea tfDescriptionAnnonce;
    @FXML
    private Button btnRetour;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    
    }    
 
    @FXML
    private void AjouterAnnonce(ActionEvent event) throws SQLException {
        if(controle_empty()==true){
        ServiceAnnonce SA=new ServiceAnnonce();
        
        int a=2;
          
        SA.add(new Annonce(a,tfNomAnnonce.getText(),tfDescriptionAnnonce.getText()));       
        JOptionPane.showMessageDialog(null, "Announce added");
        final Node source = (Node) event.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
        }
    }
    
    @FXML
    private void retour(ActionEvent event) throws IOException {
        final Node source = (Node) event.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }
  
    private boolean controle_empty() throws SQLException
    {
        
        if((tfDescriptionAnnonce.getText().isEmpty())||(tfNomAnnonce.getText().isEmpty())){
               
            JOptionPane.showMessageDialog(null, "Enter announce description ", "Attention", JOptionPane.ERROR_MESSAGE);
                return false;       
            }
        return true;
//                
//        for(int i=0;i<tfIdAnnonce.getText().length();i++){
//        
//            if(!Character.isDigit(tfIdAnnonce.getText().charAt(i))){
//               
//            JOptionPane.showMessageDialog(null, "Id must be a number", "Attention", JOptionPane.ERROR_MESSAGE);
//                return false;
//            }
//        
//            if((tfDescriptionAnnonce.getText().isEmpty())||(tfNomAnnonce.getText().isEmpty())){
//               
//            JOptionPane.showMessageDialog(null, "Enter announce description ", "Attention", JOptionPane.ERROR_MESSAGE);
//                return false;       
//            }
//            
//            ServiceAnnonce sa = new ServiceAnnonce();
//            List<Annonce> listA = sa.readAll();
//            for (Annonce listA1 : listA) {
//                if(listA1.getIdAnnonceRS()==Integer.parseInt(tfIdAnnonce.getText())){
//                    JOptionPane.showMessageDialog(null, "Id already used", "Attention", JOptionPane.ERROR_MESSAGE);
//                    return false;
//                }
//            }
//              
//    }
      
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
//import java.util.List;
//import java.util.ResourceBundle;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.fxml.Initializable;
//import javafx.scene.Node;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.control.TextArea;
//import javafx.scene.control.TextField;
//import javafx.stage.Stage;
//import javax.swing.JOptionPane;
//import pidev.Entite.Annonce;
//import pidev.Entite.CurrentUser;
//import pidev.Service.ServiceAnnonce;
//
///**
// * FXML Controller class
// *
// * @author elhak
// */
//public class AddAnnonceController implements Initializable {
//
//    @FXML
//    private Button btnAjouterAnnonce;
//    @FXML
//    private TextField tfNomAnnonce;
//    @FXML
//    private TextArea tfDescriptionAnnonce;
//    @FXML
//    private TextField tfIdAnnonce;
//    @FXML
//    private TextField tfUserId;
//    @FXML
//    private Button btnRetour;
//    
//    
//    /**
//     * Initializes the controller class.
//     */
//    @Override
//    public void initialize(URL url, ResourceBundle rb) {
//        // TODO
//    
//    }    
// 
//    
//    @FXML
//    private void AjouterAnnonce(ActionEvent event) throws SQLException {
//        if(controle_number()==true){
//        ServiceAnnonce SA=new ServiceAnnonce();
//        SA.ajouter1(new Annonce(Integer.parseInt(tfIdAnnonce.getText()),CurrentUser.getUser_id(),tfNomAnnonce.getText(),tfDescriptionAnnonce.getText()));       
//        JOptionPane.showMessageDialog(null, "Annonce added");
//        final Node source = (Node) event.getSource();
//        final Stage stage = (Stage) source.getScene().getWindow();
//        stage.close();
//        }
//    }
//    
//    @FXML
//    private void retour(ActionEvent event) throws IOException {
//        final Node source = (Node) event.getSource();
//        final Stage stage = (Stage) source.getScene().getWindow();
//        stage.close();
//    }
//  
//    private boolean controle_number() throws SQLException
//    {
//                
//        for(int i=0;i<tfIdAnnonce.getText().length();i++){
//        
//            if(!Character.isDigit(tfIdAnnonce.getText().charAt(i))){
//               
//            JOptionPane.showMessageDialog(null, "Id must be a number", "Attention", JOptionPane.ERROR_MESSAGE);
//                return false;
//            }
//        
//            if((tfDescriptionAnnonce.getText().isEmpty())||(tfNomAnnonce.getText().isEmpty())){
//               
//            JOptionPane.showMessageDialog(null, "Enter announce description ", "Attention", JOptionPane.ERROR_MESSAGE);
//                return false;       
//            }
//            
//            ServiceAnnonce sa = new ServiceAnnonce();
//            List<Annonce> listA = sa.readAll();
//            for (Annonce listA1 : listA) {
//                if(listA1.getIdAnnonceRS()==Integer.parseInt(tfIdAnnonce.getText())){
//                    JOptionPane.showMessageDialog(null, "Id already used", "Attention", JOptionPane.ERROR_MESSAGE);
//                    return false;
//                }
//            }
//              
//    }
//        return true;
//    }
//    
//    
//    
//}
