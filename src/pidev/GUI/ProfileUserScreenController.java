/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.GUI;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import pidev.API.SendMail;
import pidev.DataBase.DataBase;
import pidev.Entite.Groups;
import pidev.Entite.User;
import pidev.Entite.CurrentUser;
import pidev.Entite.GroupUser;
import pidev.Service.GroupService;
import pidev.Service.GroupUserService;
import pidev.Service.UserService;

/**
 * FXML Controller class
 *
 * @author Testouri Mohamed
 */
public class ProfileUserScreenController implements Initializable {

    @FXML
    private AnchorPane LoaderAnchorPane;
    @FXML
    private Label FirstName;
    @FXML
    private Label LastName;
    @FXML
    private Label Email;
    @FXML
    private Label Phone;
    @FXML
    private Button GroupButton;
    @FXML
    private Button AnnonceButton;
    @FXML
    private Button SignOutButton;
//    int id_user = CurrentUser.getUser_id();
    ObservableList<Groups> listGroups = FXCollections.observableArrayList();
    GroupService GS = new GroupService();
    UserService US = new UserService();
    GroupUserService GUS = new GroupUserService();
    User U = new User();
    private final Connection connexion;
    private Statement state;

    public ProfileUserScreenController() {
        connexion = DataBase.getInstance().getConnection();
    }
    @FXML
    private Label ID;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            show();
        } catch (SQLException | IOException ex) {
            Logger.getLogger(ProfileUserScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
 }

    public void show() throws SQLException, IOException{
    String req = "SELECT `fnameUser`, `lnameUser`, `phoneUser`, `emailUser` FROM user WHERE `id` = ?"; //"+this.IDUser.getText()+"
        PreparedStatement PrepState = connexion.prepareStatement(req);
        PrepState.setInt(1, CurrentUser.getUser_id());
        ResultSet rs = PrepState.executeQuery();
        while (rs.next()) {
            setFirstName(rs.getString(1));
            setLastName(rs.getString(2));
            setPhone(rs.getInt(3));
            setEmail(rs.getString(4));
             AnchorPane pane; 
            pane = FXMLLoader.load(getClass().getResource("GroupsScreen.fxml"));
            LoaderAnchorPane.getChildren().setAll(pane);
            
        }
}
    public void setFirstName(String FirstName) {
        this.FirstName.setText(FirstName);
    }

    public void setLastName(String LastName) {
        this.LastName.setText(LastName);
    }

    public void setEmail(String Email) {
        this.Email.setText(Email);
    }

    public void setPhone(int Phone) {
        this.Phone.setText(String.valueOf(Phone));
    }

    @FXML
    void goMyGroupsScreen(ActionEvent event) throws IOException {
 
             AnchorPane pane; 
            pane = FXMLLoader.load(getClass().getResource("GroupUserScreen.fxml"));
            LoaderAnchorPane.getChildren().setAll(pane);
    }

    @FXML
    void deleteAccount(ActionEvent event) throws SQLException, IOException {
        int idDelete = CurrentUser.getUser_id();         
        US.delete(idDelete);
        JOptionPane.showMessageDialog(null, "Account deleted");
                
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("LoginScreen.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Hunt Kingdom | Login");
        stage.setScene(new Scene(root1));
        stage.show();
        final Node source = (Node) event.getSource();
        final Stage stages = (Stage) source.getScene().getWindow();
                stages.close();
    CurrentUser.disConnect();
        SendMail.sendMail(CurrentUser.getMail(), "Deleted", "you deleted your account from HUNT Kingdom Community");
    
    }

    @FXML
    void signOut(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("LoginScreen.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Hunt Kingdom | Login");
        stage.setScene(new Scene(root1));
        stage.show();
        final Node source = (Node) event.getSource();
        final Stage stages = (Stage) source.getScene().getWindow();
        stages.close();
        CurrentUser.disConnect();
    }

}
