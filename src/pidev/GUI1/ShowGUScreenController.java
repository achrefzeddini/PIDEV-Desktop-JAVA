/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.GUI;

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
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;
import pidev.Entite.GroupUser;
import pidev.Service.GroupUserService;

/**
 * FXML Controller class
 *
 * @author Testouri Mohamed
 */
public class ShowGUScreenController implements Initializable {

    @FXML
    private TextField SearchTermTextFiled;
    @FXML
    private Button refreshButton;
    @FXML
    private Button DeleteButton;
    @FXML
    private Button UpdateButton;
    @FXML
    private TableView<GroupUser> Table;
    @FXML
    private Label IDGroup;
    @FXML
    private TableColumn<GroupUser, Integer> IdGU;
    @FXML
    private TableColumn<GroupUser, Integer> IdUser;
    @FXML
    private TableColumn<GroupUser, Integer> IdGroup;

    /**
     * initialises the controller class.
     */
    ObservableList<GroupUser> listGU = FXCollections.observableArrayList();

    public void setIDGroup(int IDGroup) {
        this.IDGroup.setText(String.valueOf(IDGroup));
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            refresh();
        } catch (SQLException ex) {
            Logger.getLogger(ShowGUScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    void refresh() throws SQLException {
        GroupUserService GUS = new GroupUserService();
        listGU.clear();
        listGU.addAll(GUS.readAll(Integer.parseInt(this.IDGroup.getText())));
        IdGU.setCellValueFactory(new PropertyValueFactory<>("idGroupUser"));
        IdUser.setCellValueFactory(new PropertyValueFactory<>("idUser"));
        IdGroup.setCellValueFactory(new PropertyValueFactory<>("idGroup"));
        Table.setItems(listGU);
        FilteredList<GroupUser> filteredData = new FilteredList<>(listGU, lu -> true);
        SearchTermTextFiled.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate((GroupUser gu) -> {
                // 2.1. If filter text is empty, display all persons.

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                // 2.2. Compare id name and type of every group with filter text.
                String lowerCaseFilter = newValue.toLowerCase();
                if (String.valueOf(gu.getIdGroupUser()).contains(lowerCaseFilter)) {
                    return true; // 2.2.1. Filter matches  name.
                } else if (String.valueOf(gu.getIdUser()).contains(lowerCaseFilter)) {
                    return true; // 2.2.2. Filter matches type.
                } else if (String.valueOf(gu.getIdGroup()).contains(lowerCaseFilter)) {
                    return true; // 2.2.3. Filter matches id
                } else {
                    return false; // Does not match.
                }
            });
        });
        //3. sorted list
        // 3.1. Wrap the FilteredList in a SortedList. 
        SortedList<GroupUser> sortedData = new SortedList<>(filteredData);

        // 3.2. Bind the SortedList comparator to the TableView comparator.
        // 	  Otherwise, sorting the TableView would have no effect.
        sortedData.comparatorProperty().bind(Table.comparatorProperty());

        // 3.3. Add sorted (and filtered) data to the table.
        Table.setItems(sortedData);
    }

    @FXML
    void deleteGroup(ActionEvent event) throws SQLException {
        GroupUserService GUS = new GroupUserService();
        GUS.delete(IdGU.getCellData(Table.getSelectionModel().getSelectedIndex()));
        //System.out.println(IDGroup.getCellData(Table.getSelectionModel().getSelectedIndex()));
        JOptionPane.showMessageDialog(null, "Group Deleted");
        refresh();
    }

    @FXML
    void updateGroup(ActionEvent event) {
    }

}
