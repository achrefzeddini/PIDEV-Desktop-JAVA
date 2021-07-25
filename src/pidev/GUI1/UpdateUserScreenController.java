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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import pidev.API.SendMail;
import pidev.Entite.User;
import pidev.Service.UserService;

/**
 * FXML Controller class
 *
 * @author Testouri Mohamed
 */
public class UpdateUserScreenController implements Initializable {

    @FXML
    private TextField FnameUser;
    @FXML
    private TextField LnameUser;
    @FXML
    private TextField PhoneUser;
    @FXML
    private TextField EmailUser;
    @FXML
    private TextField RoleUser;
    @FXML
    private Button UpdateUserButton;
    @FXML
    private Label IDUser;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void setFnameUser(String FnameUser) {
        this.FnameUser.setText(FnameUser);
    }

    public void setLnameUser(String LnameUser) {
        this.LnameUser.setText(LnameUser);
    }

    public void setPhoneUser(int PhoneUser) {
        this.PhoneUser.setText(String.valueOf(PhoneUser));
    }

    public void setEmailUser(String EmailUser) {
        this.EmailUser.setText(EmailUser);
    }

    public void setIDUser(int IDUser) {
        this.IDUser.setText(String.valueOf(IDUser));
    }

    public void setRoleUser(int RoleUser) {
        this.RoleUser.setText(String.valueOf(RoleUser));
    }

    @FXML
    void updateUser(ActionEvent event) throws SQLException {
        UserService US = new UserService();
        US.update(new User(FnameUser.getText(), LnameUser.getText(), Integer.parseInt(PhoneUser.getText()), Integer.parseInt(RoleUser.getText()), EmailUser.getText()), Integer.parseInt(IDUser.getText()));
        System.out.println(IDUser);
        // API SMS
        
        //sending mail
        String mailReciver = EmailUser.getText();
        SendMail.sendMail(mailReciver, "Updated", "your information has been updated");
        // close window after adding a user (it works dont ask because i dont know how 
        final Node source = (Node) event.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        JOptionPane.showMessageDialog(null, "User Updated");
        stage.close();
    }

}
