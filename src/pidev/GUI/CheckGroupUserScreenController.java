/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.GUI;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import pidev.DataBase.DataBase;
import pidev.Entite.Groups;
import pidev.Entite.User;

/**
 * FXML Controller class
 *
 * @author Testouri Mohamed
 */
public class CheckGroupUserScreenController implements Initializable {

    @FXML
    private Label IDGroup;
    @FXML
    private TableColumn<User, String> FnameUser;
    @FXML
    private TableColumn<User, String> LnameUser;
    @FXML
    private TableColumn<User, Integer> PhoneUser;
    @FXML
    private TableColumn<User, Integer> IDUser;
    @FXML
    private TextField SearchTermTextFiled;
    @FXML
    private TableView<User> TableUsers;

    /**
     * Initializes the controller class.
     */
    ObservableList<Groups> listGroups = FXCollections.observableArrayList();
    ObservableList<User> listUsers = FXCollections.observableArrayList();
    List<User> arrayUsers = new ArrayList<>();
    private final Connection connexion;
    private Statement state;
    private int a;

    public CheckGroupUserScreenController() {
        connexion = DataBase.getInstance().getConnection();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            refresh(a);
//            readAll();
        } catch (SQLException ex) {
            Logger.getLogger(CheckUserGroupScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }   // TODO
    }

    public void refresh(int a) throws SQLException {
        listUsers.addAll(insertAll(a));
        IDUser.setCellValueFactory(new PropertyValueFactory<>("user_id")); //idUser
        FnameUser.setCellValueFactory(new PropertyValueFactory<>("fnameUser"));
        LnameUser.setCellValueFactory(new PropertyValueFactory<>("lnameUser"));
        PhoneUser.setCellValueFactory(new PropertyValueFactory<>("phoneUser"));
        TableUsers.setItems(listUsers);

        FilteredList<User> filteredData = new FilteredList<>(listUsers, lu -> true);
        SearchTermTextFiled.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate((User user) -> {
                // 2.1. If filter text is empty, display all persons.

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                // 2.2. Compare id name and type of every group with filter text.
                String lowerCaseFilter = newValue.toLowerCase();
                if (user.getFnameUser().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches first name.
                } else if (user.getLnameUser().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches last name.
                } else if (String.valueOf(user.getIdUser()).contains(lowerCaseFilter)) {
                    return true;
                } else if (String.valueOf(user.getPhoneUser()).contains(lowerCaseFilter)) {
                    return true;
                } else {
                    return false; // Does not match.
                }
            });
        });
        //3. sorted list
        // 3.1. Wrap the FilteredList in a SortedList. 
        SortedList<User> sortedData = new SortedList<>(filteredData);

        // 3.2. Bind the SortedList comparator to the TableView comparator.
        // 	  Otherwise, sorting the TableView would have no effect.
        sortedData.comparatorProperty().bind(TableUsers.comparatorProperty());

        // 3.3. Add sorted (and filtered) data to the table.
        TableUsers.setItems(sortedData);
    }

    private List<User> insertAll(int a) throws SQLException {
        System.out.println("idu:" + a);
        String req = "SELECT `fnameUser`,`lnameUser`,`phoneUser`,`idUser` FROM `users` WHERE `idUser` IN (SELECT `idUser` FROM `groupuser` WHERE `idGroup`=?)";
        PreparedStatement PrepState = connexion.prepareStatement(req);
        PrepState.setInt(1, a);
        ResultSet rs = PrepState.executeQuery();
        while (rs.next()) {
            arrayUsers.add(new User(rs.getString(1),rs.getString(2),rs.getInt(3), rs.getInt(4)));
        }

        return arrayUsers;
    }

}
