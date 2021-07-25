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
import pidev.Entite.Groups;
import pidev.Service.GroupService;

/**
 * FXML Controller class
 *
 * @author Testouri Mohamed
 */
public class UpdateGroupScreenController implements Initializable {

    @FXML
    private TextField NameGroup;
    @FXML
    private TextField TypeGroup;
    @FXML
    private Label IDGroup;
    @FXML
    private Button UpdateGroupUser;

    /**
     * initialises the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void setIDGroup(int IDGroup) {
        this.IDGroup.setText(String.valueOf(IDGroup));
    }

    public void setNameGroup(String NameGroup) {
        this.NameGroup.setText(NameGroup);
    }

    public void setTypeGroup(String TypeGroup) {
        this.TypeGroup.setText(TypeGroup);
    }

    @FXML
    void UpdateGroup(ActionEvent event) throws SQLException {
        JOptionPane.showMessageDialog(null, "User Updated");
        GroupService GS = new GroupService();
        GS.update(new Groups(NameGroup.getText(), TypeGroup.getText()), Integer.parseInt(IDGroup.getText()));
        System.out.println(IDGroup);
// mazzel el code mtaa update eli lezmni naadi les parametre selectionné men table view o nhothom fi textfiled 

        // API SMS
        //sending mail
//        String mailReciver = EmailUser.getText();
//        SendMail.sendMail(mailReciver, "Updated", "your information has been updated");
        // close window after adding a user (it works dont ask because i dont know how 
        final Node source = (Node) event.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

}
