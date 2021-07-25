/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.GUI;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
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
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import pidev.DataBase.DataBase;
import pidev.Entite.Animal;
import pidev.Entite.Commande;
import pidev.Service.ServiceAnimal;

/**
 *
 * @author hp
 */
public class TableAnimalController implements Initializable{
    
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
    private Button btnadd;
    @FXML
    private Button btndel;
    @FXML
    private TextField tfsearch;
    private final ObservableList<Animal> listA = FXCollections.observableArrayList();
    private final ObservableList<Animal> listB = FXCollections.observableArrayList();

    @FXML
    private TextField tfnumber;
    @FXML
    private TextField tfrace;
    @FXML
    private TextField tfplace;
    @FXML
    private TextField tfseason;
    ImageView im = new ImageView();

    ServiceAnimal ser = new ServiceAnimal();
    private ImageView img;
    @FXML
    private TextField tfimg;
    @FXML
    private Button btnhunted;
    @FXML
    private TableColumn<Animal, Integer> colhunted;
    @FXML
    private PieChart mypiechart;
    @FXML
    private Button btnp;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        /*
        File file = new File("images/bow.jpg");
        Image image = new Image(file.toURI().toString());
        imga.setImage(image);
        */
        refresh();
        tablev.setEditable(true);
        colr.setCellFactory(TextFieldTableCell.forTableColumn());
        cols.setCellFactory(TextFieldTableCell.forTableColumn());
        colp.setCellFactory(TextFieldTableCell.forTableColumn());  
        
    }
    
    void refresh(){
       
        tfnumber.setText("");
        tfrace.setText("");
        tfseason.setText("");
        tfplace.setText("");
        tfimg.setText("");
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
    
    @FXML
    void addanimal(ActionEvent event) throws IOException, SQLException {
        if(controle_number()==true && controle_empty()==true && controle_emptys()==true && controle_emptyp()==true){
        ServiceAnimal sa = new ServiceAnimal();
        sa.ajouters(new Animal(Integer.parseInt(tfnumber.getText()), tfrace.getText(), tfseason.getText(), tfplace.getText(), tfimg.getText()));
        JOptionPane.showMessageDialog(null, "Animal Added");
        refresh();
        
         }
//         else{
//     
//        refresh();
//        
//        }
    }
    @FXML
    private void updateRace(TableColumn.CellEditEvent bb) throws SQLException {
                Animal animselected = tablev.getSelectionModel().getSelectedItem();
                animselected.setRace(bb.getNewValue().toString());
                ser.update(animselected, animselected.getIdA());
                
    }
    @FXML
    private void updateSeason(TableColumn.CellEditEvent bb) throws SQLException {
                Animal animselected = tablev.getSelectionModel().getSelectedItem();
                animselected.setSaison(bb.getNewValue().toString());
                ser.update(animselected, animselected.getIdA());
                
    }
    @FXML
    private void updatePlace(TableColumn.CellEditEvent bb) throws SQLException {
                Animal animselected = tablev.getSelectionModel().getSelectedItem();
                animselected.setPlace(bb.getNewValue().toString());
                ser.update(animselected, animselected.getIdA());
                
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
     

@FXML
    void deleteAnimal(ActionEvent e) throws SQLException {
        ServiceAnimal sa = new ServiceAnimal();
        sa.delete(coln.getCellData(tablev.getSelectionModel().getSelectedIndex()));
        refresh();
        JOptionPane.showMessageDialog(null, "Animal Deleted");
    }
    

    private void addimage(ActionEvent event) throws MalformedURLException, IOException {
       
//       URL url = new URL("https://drive.google.com/open?id=1Ngw-M_W2fouNyoIKLp6zQT5m3jC4UEG0");
       Image image = new Image("https://drive.google.com/open?id=1Ngw-M_W2fouNyoIKLp6zQT5m3jC4UEG0");
       img.setImage(image);
       refresh();
      
    }
    @FXML
    private void ajoutermurder(ActionEvent event ) throws SQLException {
                        ServiceAnimal sa = new ServiceAnimal();
                        sa.updateh(coln.getCellData(tablev.getSelectionModel().getSelectedIndex()));
                        refresh();
                
    }

   
     //LES controles
    private boolean controle_number() throws SQLException
    {
                
        for(int i=0;i<tfnumber.getText().length();i++){
        
            if(!Character.isDigit(tfnumber.getText().charAt(i))){
               
            JOptionPane.showMessageDialog(null, "Reference must be a number", "Attention", JOptionPane.ERROR_MESSAGE);
                return false;
            }
             ServiceAnimal sa = new ServiceAnimal();
      List<Animal> listA = sa.readAll();
            for (Animal listA1 : listA) {
                if(listA1.getIdA()==Integer.parseInt(tfnumber.getText())){
                    JOptionPane.showMessageDialog(null, "Reference already used", "Attention", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            }
              
    }
        return true;
    }
    
    private boolean controle_empty() throws SQLException
    {
                
       if(tfrace.getText().length()==0){
           JOptionPane.showMessageDialog(null, "Race empty", "Attention", JOptionPane.ERROR_MESSAGE);
           return false;
              
    }
        return true;
    }
    private boolean controle_emptys() throws SQLException
    {
                
       if(tfseason.getText().length()==0){
           JOptionPane.showMessageDialog(null, "Season empty", "Attention", JOptionPane.ERROR_MESSAGE);
           return false;
              
    }
        return true;
    }
    
    private boolean controle_emptyp() throws SQLException
    {
                
       if(tfplace.getText().length()==0){
           JOptionPane.showMessageDialog(null, "Place empty", "Attention", JOptionPane.ERROR_MESSAGE);
           return false;
              
    }
        return true;
    }
    
    
    
    }


    






//*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package pidev.GUI;
//
//import java.awt.image.BufferedImage;
//import java.io.File;
//import java.io.IOException;
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.sql.Connection;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.List;
//import java.util.ResourceBundle;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.collections.transformation.FilteredList;
//import javafx.collections.transformation.SortedList;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.fxml.Initializable;
//import javafx.scene.Node;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.scene.chart.PieChart;
//import javafx.scene.control.Button;
//import javafx.scene.control.TableColumn;
//import javafx.scene.control.TableView;
//import javafx.scene.control.TextField;
//import javafx.scene.control.cell.PropertyValueFactory;
//import javafx.scene.control.cell.TextFieldTableCell;
//import javafx.scene.image.Image;
//import javafx.scene.image.ImageView;
//import javafx.scene.input.MouseEvent;
//import javafx.stage.FileChooser;
//import javafx.stage.Stage;
//import javax.imageio.ImageIO;
//import javax.swing.ImageIcon;
//import javax.swing.JOptionPane;
//import pidev.DataBase.DataBase;
//import pidev.Entite.Animal;
//import pidev.Entite.Commande;
//import pidev.Service.ServiceAnimal;
//
///**
// *
// * @author hp
// */
//public class TableAnimalController implements Initializable{
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
//    private Button btnadd;
//    @FXML
//    private Button btndel;
//    @FXML
//    private TextField tfsearch;
//    private final ObservableList<Animal> listA = FXCollections.observableArrayList();
//    private final ObservableList<Animal> listB = FXCollections.observableArrayList();
//
//    @FXML
//    private TextField tfnumber;
//    @FXML
//    private TextField tfrace;
//    @FXML
//    private TextField tfplace;
//    @FXML
//    private TextField tfseason;
//    @FXML
//    private TextField tfimg;
//    ImageView im = new ImageView();
//
//    ServiceAnimal ser = new ServiceAnimal();
//    private ImageView img;
//    @FXML
//    private Button btnhunted;
//    @FXML
//    private TableColumn<Animal, Integer> colhunted;
//    @FXML
//    private PieChart mypiechart;
//    @FXML
//    private Button btnp;
//    @Override
//    public void initialize(URL location, ResourceBundle resources) {
//        /*
//        File file = new File("images/bow.jpg");
//        Image image = new Image(file.toURI().toString());
//        imga.setImage(image);
//        */
//        refresh();
//        tablev.setEditable(true);
//        colr.setCellFactory(TextFieldTableCell.forTableColumn());
//        cols.setCellFactory(TextFieldTableCell.forTableColumn());
//        colp.setCellFactory(TextFieldTableCell.forTableColumn());  
//        
//    }
//    
//    void refresh(){
//       
//        tfnumber.setText("");
//        tfrace.setText("");
//        tfseason.setText("");
//        tfplace.setText("");
//        tfimg.setText("");
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
//    @FXML
//    void addanimal(ActionEvent event) throws IOException, SQLException {
//        if(controle_number()==true && controle_empty()==true && controle_emptys()==true && controle_emptyp()==true){
//        ServiceAnimal sa = new ServiceAnimal();
//        sa.ajouter(new Animal(Integer.parseInt(tfnumber.getText()), tfrace.getText(), tfseason.getText(), tfplace.getText(),tfimg.getText()));
//        JOptionPane.showMessageDialog(null, "Animal Added");
//        refresh();
//        
//         }
////         else{
////     
////        refresh();
////        
////        }
//    }
//    @FXML
//    private void updateRace(TableColumn.CellEditEvent bb) throws SQLException {
//                Animal animselected = tablev.getSelectionModel().getSelectedItem();
//                animselected.setRace(bb.getNewValue().toString());
//                ser.update(animselected, animselected.getIdA());
//                
//    }
//    @FXML
//    private void updateSeason(TableColumn.CellEditEvent bb) throws SQLException {
//                Animal animselected = tablev.getSelectionModel().getSelectedItem();
//                animselected.setSaison(bb.getNewValue().toString());
//                ser.update(animselected, animselected.getIdA());
//                
//    }
//    @FXML
//    private void updatePlace(TableColumn.CellEditEvent bb) throws SQLException {
//                Animal animselected = tablev.getSelectionModel().getSelectedItem();
//                animselected.setPlace(bb.getNewValue().toString());
//                ser.update(animselected, animselected.getIdA());
//                
//    }
//
//    
//  @FXML
//    private void PieChartSample(ActionEvent event) throws SQLException {
//         ServiceAnimal sa = new ServiceAnimal();
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
//
//@FXML
//    void deleteAnimal(ActionEvent e) throws SQLException {
//        ServiceAnimal sa = new ServiceAnimal();
//        sa.delete(coln.getCellData(tablev.getSelectionModel().getSelectedIndex()));
//        refresh();
//        JOptionPane.showMessageDialog(null, "Animal Deleted");
//    }
//    
//
//    private void addimage(ActionEvent event) throws MalformedURLException, IOException {
//       
////       URL url = new URL("https://drive.google.com/open?id=1Ngw-M_W2fouNyoIKLp6zQT5m3jC4UEG0");
//       Image image = new Image("https://drive.google.com/open?id=1Ngw-M_W2fouNyoIKLp6zQT5m3jC4UEG0");
//       img.setImage(image);
//       refresh();
//      
//    }
//    @FXML
//    private void ajoutermurder(ActionEvent event ) throws SQLException {
//                        ServiceAnimal sa = new ServiceAnimal();
//                        sa.updateh(coln.getCellData(tablev.getSelectionModel().getSelectedIndex()));
//                        refresh();
//                
//    }
//
//   
//     //LES controles
//    private boolean controle_number() throws SQLException
//    {
//                
//        for(int i=0;i<tfnumber.getText().length();i++){
//        
//            if(!Character.isDigit(tfnumber.getText().charAt(i))){
//               
//            JOptionPane.showMessageDialog(null, "Reference must be a number", "Attention", JOptionPane.ERROR_MESSAGE);
//                return false;
//            }
//             ServiceAnimal sa = new ServiceAnimal();
//      List<Animal> listA = sa.readAll();
//            for (Animal listA1 : listA) {
//                if(listA1.getIdA()==Integer.parseInt(tfnumber.getText())){
//                    JOptionPane.showMessageDialog(null, "Reference already used", "Attention", JOptionPane.ERROR_MESSAGE);
//                    return false;
//                }
//            }
//              
//    }
//        return true;
//    }
//    
//    private boolean controle_empty() throws SQLException
//    {
//                
//       if(tfrace.getText().length()==0){
//           JOptionPane.showMessageDialog(null, "Race empty", "Attention", JOptionPane.ERROR_MESSAGE);
//           return false;
//              
//    }
//        return true;
//    }
//    private boolean controle_emptys() throws SQLException
//    {
//                
//       if(tfseason.getText().length()==0){
//           JOptionPane.showMessageDialog(null, "Season empty", "Attention", JOptionPane.ERROR_MESSAGE);
//           return false;
//              
//    }
//        return true;
//    }
//    
//    private boolean controle_emptyp() throws SQLException
//    {
//                
//       if(tfplace.getText().length()==0){
//           JOptionPane.showMessageDialog(null, "Place empty", "Attention", JOptionPane.ERROR_MESSAGE);
//           return false;
//              
//    }
//        return true;
//    }
//    
//    
//    
//    }
//
//
//    
//
//
