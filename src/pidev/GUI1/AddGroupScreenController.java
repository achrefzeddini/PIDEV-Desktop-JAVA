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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pidev.Entite.Groups;
import pidev.Service.GroupService;

/**
 * FXML Controller class
 *
 * @author Testouri Mohamed
 */
public class AddGroupScreenController implements Initializable {

    @FXML
    private TextField NameGroup;
    @FXML
    private TextField TypeGroup;
    @FXML
    private Button AddGroupUser;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    void addGroup(ActionEvent event) throws SQLException {
        GroupScreenController GSC = new GroupScreenController();
        GroupService GS = new GroupService();
        GS.add(new Groups(NameGroup.getText(), TypeGroup.getText()));
        final Node source = (Node) event.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
        //GSC.refresh();

    }

}
