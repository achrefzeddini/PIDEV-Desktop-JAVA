/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.GUI1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Testouri Mohamed
 */
public class UserScreenController implements Initializable {

    @FXML
    private AnchorPane Pane;
    @FXML
    private TextField SearchTermTextFiled;
    @FXML
    private TableView<?> Table;
    @FXML
    private TableColumn<?, ?> IDUser;
    @FXML
    private TableColumn<?, ?> FnameUser;
    @FXML
    private TableColumn<?, ?> LnameUser;
    @FXML
    private TableColumn<?, ?> PhoneUser;
    @FXML
    private TableColumn<?, ?> EmailUser;
    @FXML
    private Button DeleteButton;
    @FXML
    private Button UpdateButton;
    @FXML
    private Button AddButton;
    @FXML
    private Button AssignButton;
    @FXML
    private Button refreshButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void deleteUser(ActionEvent event) {
    }

    @FXML
    private void updateUser(ActionEvent event) {
    }

    @FXML
    private void addUser(ActionEvent event) {
    }

    @FXML
    private void assignUser(ActionEvent event) {
    }

    @FXML
    private void refresh(ActionEvent event) {
    }
    
}
