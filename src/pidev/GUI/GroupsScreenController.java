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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import pidev.API.SendMail;
import pidev.DataBase.DataBase;
import pidev.Entite.CurrentUser;
import pidev.Entite.GroupUser;
import pidev.Entite.Groups;
import pidev.Entite.User;
import pidev.Service.GroupService;
import pidev.Service.GroupUserService;
import pidev.Service.UserService;

/**
 * FXML Controller class
 *
 * @author Testouri Mohamed
 */
public class GroupsScreenController implements Initializable {

    @FXML
    private AnchorPane GroupsPane;
    @FXML
    private TableView<Groups> TableGroups;
    @FXML
    private TableColumn<Groups, String> NameGroup;
    @FXML
    private TableColumn<Groups, String> TypeGroup;
    @FXML
    private TableColumn<Groups, Integer> IDGroup;
    @FXML
    private Button JoinGroupButton;
    @FXML
    private TextField SearchTermTextFiled;

    /**
     * Initializes the controller class.
     */
    ObservableList<Groups> listGroups = FXCollections.observableArrayList();
    GroupService GS = new GroupService();
    UserService US = new UserService();
    GroupUserService GUS = new GroupUserService();
    User U = new User();
    private final Connection connexion;
    private Statement state;

    public GroupsScreenController() {
        connexion = DataBase.getInstance().getConnection();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     System.out.println("ps"+CurrentUser.getUser_id());
        try {
            load();
        } catch (SQLException ex) {
            Logger.getLogger(ProfileUserScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void load() throws SQLException {
        listGroups.clear();
        listGroups.addAll(GS.readAll(CurrentUser.getUser_id()));
        NameGroup.setCellValueFactory(new PropertyValueFactory<>("nameGroup"));
        TypeGroup.setCellValueFactory(new PropertyValueFactory<>("typeGroup"));
        IDGroup.setCellValueFactory(new PropertyValueFactory<>("id"));
        TableGroups.setItems(listGroups);
        FilteredList<Groups> filteredData = new FilteredList<>(listGroups, lu -> true);
        SearchTermTextFiled.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate((Groups group) -> {
                // 2.1. If filter text is empty, display all persons.

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                // 2.2. Compare id name and type of every group with filter text.
                String lowerCaseFilter = newValue.toLowerCase();
                if (group.getNameGroup().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // 2.2.1. Filter matches  name.
                } else if (group.getTypeGroup().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // 2.2.2. Filter matches type.
                } else if (String.valueOf(group.getIdGroup()).contains(lowerCaseFilter)) {
                    return true; // 2.2.3. Filter matches id
                } else {
                    return false; // Does not match.
                }
            });
        });
        //3. sorted list
        // 3.1. Wrap the FilteredList in a SortedList. 
        SortedList<Groups> sortedData = new SortedList<>(filteredData);

        // 3.2. Bind the SortedList comparator to the TableView comparator.
        // 	  Otherwise, sorting the TableView would have no effect.
        sortedData.comparatorProperty().bind(TableGroups.comparatorProperty());

        // 3.3. Add sorted (and filtered) data to the table.
        TableGroups.setItems(sortedData);
    }


    @FXML
    void goMyGroupsScreen(ActionEvent event) throws IOException, SQLException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GroupUserScreen.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Hunt Kingdom | Login");
        stage.setScene(new Scene(root1));
        GS.readALL(CurrentUser.getUser_id());
        stage.show();
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

    @FXML
    void deleteAccount(ActionEvent event) throws SQLException, IOException {
        US.delete(CurrentUser.getUser_id());
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
    void joinGroup(ActionEvent event) throws SQLException {
        Integer a = IDGroup.getCellData(TableGroups.getSelectionModel().getSelectedIndex());
        //System.out.println("a:"+a);
        GUS.add(new GroupUser(CurrentUser.getUser_id(),a));
           System.out.println("id_user"+CurrentUser.getUser_id()+"a"+a);
           JOptionPane.showMessageDialog(null, "You joined this group");

           load();
    }
}
