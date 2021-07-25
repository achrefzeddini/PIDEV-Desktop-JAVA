/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.GUI;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.ZoneId;
import static java.time.temporal.TemporalQueries.localDate;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;
import pidev.Entite.Animal;
import pidev.Entite.Commande;
import pidev.Entite.Season;
import pidev.Service.ServiceAnimal;
import pidev.Service.ServiceCommande;
import pidev.Service.ServiceSeason;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class TableSeasonController implements Initializable {
    @FXML 
    private TableColumn<Season, Integer> tbn;
    @FXML
    private TableColumn<Season, String> tbnom;
    @FXML
    private TableColumn<Season, String> tbstart;
    @FXML
    private TableColumn<Season, String> tbfinish;
    @FXML
    private TableColumn<Season, String> tbdescription;
    @FXML
    private TableView<Season> tvseason;
@FXML
    private TextField searchc;
    @FXML
    private Button btndel;
    @FXML
    private TextField tfnom;
    @FXML
    private DatePicker tfstart;
   
    @FXML
    private DatePicker tffinish;
    @FXML
    private TextField tfdesc;
    @FXML
    private Button btnadd;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        refresh();
    }    
    
      ObservableList<Season> listC = FXCollections.observableArrayList();
    void refresh(){
       
        ServiceSeason sc = new ServiceSeason();
       listC.clear();
       
        try {
            listC.addAll(sc.readAll());
        } catch (SQLException ex) {
            Logger.getLogger(TableCommandeController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        tbn.setCellValueFactory(new PropertyValueFactory<>("id"));
        tbnom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        tbstart.setCellValueFactory(new PropertyValueFactory<>("start"));
        tbfinish.setCellValueFactory(new PropertyValueFactory<>("finish"));
        tbdescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        tvseason.setItems(listC);

        FilteredList<Season> filteredData = new FilteredList<>(listC, lu -> true);

        // 2. Set the filter Predicate whenever the filter changes.
        searchc.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate((Season commande) -> {
                // If filter text is empty, display all persons.

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                // Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();

                if (commande.getDescription().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches first name.
                } else if (commande.getNom().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches last name.
                
                } else {
                    return false; // Does not match.
                }
            });
        });

        // 3. Wrap the FilteredList in a SortedList. 
        SortedList<Season> sortedData = new SortedList<>(filteredData);

        // 4. Bind the SortedList comparator to the tablevciew comparator.
        // 	  Otherwise, sorting the tablevciew would have no effect.
        sortedData.comparatorProperty().bind(tvseason.comparatorProperty());

        // 5. Add sorted (and filtered) data to the table.
        tvseason.setItems(sortedData);
    }
    
    @FXML
    void deleteSeason(ActionEvent e) throws SQLException {
        ServiceSeason sa = new ServiceSeason();
        sa.delete(tbn.getCellData(tvseason.getSelectionModel().getSelectedIndex()));
        refresh();
        JOptionPane.showMessageDialog(null, "Season Deleted");
    }
    
     void addseason(ActionEvent event) throws IOException, SQLException {
       // if(controle_number()==true && controle_empty()==true && controle_emptys()==true && controle_emptyp()==true){
        ServiceSeason sa = new ServiceSeason();

      // sa.ajouter(new Season(tfnom.getText(), (java.sql.Date) tfstart.getValue(), tffinish.getValue(), tfdesc.getText()));
        JOptionPane.showMessageDialog(null, "Animal Added");
        refresh();
        
         }
    
}
