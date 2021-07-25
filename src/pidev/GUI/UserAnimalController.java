
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
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import pidev.Entite.Animal;
import pidev.Service.ServiceAnimal;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class UserAnimalController implements Initializable {

    @FXML
    private TableView<Animal> tablev;
    @FXML
    private TableColumn<Animal, Integer> coln;
    @FXML
    private TableColumn<Animal, String> colr;
    @FXML
    private TableColumn<Animal, String> cols;
    @FXML
    private TableColumn<Animal, String> colp;
    @FXML
    private TableColumn<Animal, ImageView> colpic;
    @FXML
    private TableColumn<Animal, Integer> colhunted;
    @FXML
    private TextField tfsearch;
    @FXML
    private Button btnhunted;
    @FXML
    private PieChart mypiechart;
    @FXML
    private Button btnp;
    private final ObservableList<Animal> listA = FXCollections.observableArrayList(); 
    private final ObservableList<Animal> listB = FXCollections.observableArrayList();
    ImageView im = new ImageView();

    ServiceAnimal ser = new ServiceAnimal();
    private ImageView img;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        refresh();
    }    


    @FXML
    private void ajoutermurder(ActionEvent event) throws SQLException {
                         
        ServiceAnimal sa = new ServiceAnimal();
        sa.updateh(coln.getCellData(tablev.getSelectionModel().getSelectedIndex()));
        refresh();
                
    }

    @FXML
    private void PieChartSample(ActionEvent event) throws SQLException {
        ServiceAnimal sa = new ServiceAnimal();
int count1=0,count2=0, count3=0;
count1=sa.read();
count2=sa.readd();
count3=sa.readdd();

        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                new PieChart.Data("bear", count1),
                new PieChart.Data("fish", count2),
                new PieChart.Data("deer", count3));
    mypiechart.setData(pieChartData);
    }
 
     void refresh(){
       
     
        try {
           ServiceAnimal sa = new ServiceAnimal();
       listA.clear();
                           
       listA.addAll(sa.readAll());
        } catch (SQLException ex) {
            Logger.getLogger(TableAnimalController.class.getName()).log(Level.SEVERE, null, ex);
        }

        for(int j=0 ; j<listA.size();j++){
            Animal a = listA.get(j);
            Image i = new Image(a.getImage());
            im.setImage(i);
            a.setIm(im);
            
            listB.add(j,a);
        }
        
        coln.setCellValueFactory(new PropertyValueFactory<>("idA"));
        colr.setCellValueFactory(new PropertyValueFactory<>("race"));
        cols.setCellValueFactory(new PropertyValueFactory<>("saison"));
        colp.setCellValueFactory(new PropertyValueFactory<>("place"));
        colpic.setCellValueFactory(new PropertyValueFactory<>("im"));
        colhunted.setCellValueFactory(new PropertyValueFactory<>("hunted"));
        tablev.setItems(listB);

        FilteredList<Animal> filteredData = new FilteredList<>(listA, lu -> true);

        // 2. Set the filter Predicate whenever the filter changes.
        tfsearch.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate((Animal animal) -> {
                // If filter text is empty, display all persons.

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                // Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();

                if (String.valueOf(animal.getIdA()).contains(lowerCaseFilter)) {
                    return true; // Filter matches first name.
                } else if (animal.getRace().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches last name.
                } else if (animal.getSaison().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches last name.
                } else if (animal.getPlace().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else {
                    return false; // Does not match.
                }
            });
            
        });

        // 3. Wrap the FilteredList in a SortedList. 
        SortedList<Animal> sortedData = new SortedList<>(filteredData);

        // 4. Bind the SortedList comparator to the TableView comparator.
        // 	  Otherwise, sorting the TableView would have no effect.
        sortedData.comparatorProperty().bind(tablev.comparatorProperty());

        // 5. Add sorted (and filtered) data to the table.
        tablev.setItems(sortedData);

       
       
    }

    
}




///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package pidev.GUI;
//
//import java.net.URL;
//import java.sql.SQLException;
//import java.util.ResourceBundle;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.collections.transformation.FilteredList;
//import javafx.collections.transformation.SortedList;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.Initializable;
//import javafx.scene.chart.PieChart;
//import javafx.scene.control.Button;
//import javafx.scene.control.TableColumn;
//import javafx.scene.control.TableView;
//import javafx.scene.control.TextField;
//import javafx.scene.control.cell.PropertyValueFactory;
//import javafx.scene.image.Image;
//import javafx.scene.image.ImageView;
//import pidev.Entite.Animal;
//import pidev.Service.ServiceAnimal;
//
///**
// * FXML Controller class
// *
// * @author hp
// */
//public class UserAnimalController implements Initializable {
//
//    @FXML
//    private TableView<Animal> tablev;
//    @FXML
//    private TableColumn<Animal, Integer> coln;
//    @FXML
//    private TableColumn<Animal, String> colr;
//    @FXML
//    private TableColumn<Animal, String> cols;
//    @FXML
//    private TableColumn<Animal, String> colp;
//    @FXML
//    private TableColumn<Animal, ImageView> colpic;
//    @FXML
//    private TableColumn<Animal, Integer> colhunted;
//    @FXML
//    private TextField tfsearch;
//    @FXML
//    private Button btnhunted;
//    @FXML
//    private PieChart mypiechart;
//    @FXML
//    private Button btnp;
//    private final ObservableList<Animal> listA = FXCollections.observableArrayList(); 
//    private final ObservableList<Animal> listB = FXCollections.observableArrayList();
//    ImageView im = new ImageView();
//
//    ServiceAnimal ser = new ServiceAnimal();
//    private ImageView img;
//    /**
//     * Initializes the controller class.
//     */
//    @Override
//    public void initialize(URL url, ResourceBundle rb) {
//        refresh();
//    }    
//
//
//    @FXML
//    private void ajoutermurder(ActionEvent event) throws SQLException {
//                         
//        ServiceAnimal sa = new ServiceAnimal();
//        sa.updateh(coln.getCellData(tablev.getSelectionModel().getSelectedIndex()));
//        refresh();
//                
//    }
//
//    @FXML
//    private void PieChartSample(ActionEvent event) throws SQLException {
//        ServiceAnimal sa = new ServiceAnimal();
//int count1=0,count2=0, count3=0;
//count1=sa.read();
//count2=sa.readd();
//count3=sa.readdd();
//
//        ObservableList<PieChart.Data> pieChartData =
//                FXCollections.observableArrayList(
//                new PieChart.Data("bear", count1),
//                new PieChart.Data("fish", count2),
//                new PieChart.Data("deer", count3));
//    mypiechart.setData(pieChartData);
//    }
// 
//     void refresh(){
//       
//     
//        try {
//           ServiceAnimal sa = new ServiceAnimal();
//       listA.clear();
//                           
//       listA.addAll(sa.readAll());
//        } catch (SQLException ex) {
//            Logger.getLogger(TableAnimalController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        for(int j=0 ; j<listA.size();j++){
//            Animal a = listA.get(j);
//            Image i = new Image(a.getImage());
//            im.setImage(i);
//            a.setIm(im);
//            
//            listB.add(j,a);
//        }
//        
//        coln.setCellValueFactory(new PropertyValueFactory<>("idA"));
//        colr.setCellValueFactory(new PropertyValueFactory<>("race"));
//        cols.setCellValueFactory(new PropertyValueFactory<>("saison"));
//        colp.setCellValueFactory(new PropertyValueFactory<>("place"));
//        colpic.setCellValueFactory(new PropertyValueFactory<>("im"));
//        colhunted.setCellValueFactory(new PropertyValueFactory<>("hunted"));
//        tablev.setItems(listB);
//
//        FilteredList<Animal> filteredData = new FilteredList<>(listA, lu -> true);
//
//        // 2. Set the filter Predicate whenever the filter changes.
//        tfsearch.textProperty().addListener((observable, oldValue, newValue) -> {
//            filteredData.setPredicate((Animal animal) -> {
//                // If filter text is empty, display all persons.
//
//                if (newValue == null || newValue.isEmpty()) {
//                    return true;
//                }
//
//                // Compare first name and last name of every person with filter text.
//                String lowerCaseFilter = newValue.toLowerCase();
//
//                if (String.valueOf(animal.getIdA()).contains(lowerCaseFilter)) {
//                    return true; // Filter matches first name.
//                } else if (animal.getRace().toLowerCase().contains(lowerCaseFilter)) {
//                    return true; // Filter matches last name.
//                } else if (animal.getSaison().toLowerCase().contains(lowerCaseFilter)) {
//                    return true; // Filter matches last name.
//                } else if (animal.getPlace().toLowerCase().contains(lowerCaseFilter)) {
//                    return true;
//                } else {
//                    return false; // Does not match.
//                }
//            });
//            
//        });
//
//        // 3. Wrap the FilteredList in a SortedList. 
//        SortedList<Animal> sortedData = new SortedList<>(filteredData);
//
//        // 4. Bind the SortedList comparator to the TableView comparator.
//        // 	  Otherwise, sorting the TableView would have no effect.
//        sortedData.comparatorProperty().bind(tablev.comparatorProperty());
//
//        // 5. Add sorted (and filtered) data to the table.
//        tablev.setItems(sortedData);
//
//       
//       
//    }
//
//    
//}
