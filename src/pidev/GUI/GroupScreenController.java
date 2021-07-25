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
import pidev.Entite.Groups;
import pidev.Service.GroupService;

/**
 * FXML Controller class
 *
 * @author Testouri Mohamed
 */
public class GroupScreenController implements Initializable {

    @FXML
    private TableView<Groups> TableGroups;
    @FXML
    private TableColumn<Groups, String> NameGroup;
    @FXML
    private TableColumn<Groups, String> TypeGroup;
    @FXML
    private TableColumn<Groups, Integer> IDGroup;
    @FXML
    private TextField SearchTermTextFiled;
    @FXML
    private Button ShowUsersGroupButton;

    /**
     * initialises the controller class.
     *
     * @param url
     * @param rb
     */
    GroupService GS = new GroupService();

    ObservableList<Groups> listGroups = FXCollections.observableArrayList();
    @FXML
    private TextField NameGroupTextField;
    @FXML
    private TextField TypeGroupTextField;
    @FXML
    private AnchorPane GroupsAnchorPane;
    @FXML
    private Button addButton;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        refresh();
    }


    @FXML
    void ShowUsersGroup(ActionEvent event) throws IOException, SQLException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CheckGroupUserScreen.fxml"));
        Parent root2 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Hunt Kingdom | Admin | Groups | Users List");
        stage.setScene(new Scene(root2));
        stage.show();
        pidev.GUI.CheckGroupUserScreenController CUGSC = fxmlLoader.getController();
        int a = IDGroup.getCellData(TableGroups.getSelectionModel().getSelectedIndex());
//        CUGSC.insertAll(a);
//        CUGSC.setA(a);
CUGSC.refresh(a);
        System.out.println("hello"+a);
    }

    @FXML
    void addGroup(ActionEvent event) throws IOException, SQLException {
        GS.add(new Groups(NameGroupTextField.getText(), TypeGroupTextField.getText()));
        JOptionPane.showMessageDialog(null, "Group added");
        refresh();
    }

    public void refresh() {
        listGroups.clear();
        try {
            listGroups.addAll(GS.readAll());
        } catch (SQLException e) {
            Logger.getLogger(UsersScreenController.class.getName()).log(Level.SEVERE, null, e);
        }
        
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

}
