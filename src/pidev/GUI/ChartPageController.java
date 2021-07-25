/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.GUI;


import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import pidev.Entite.productEntity;
import pidev.service.ProductService;

/**
 *
 * @author Dorsaf
 */
public class ChartPageController implements Initializable{

    @FXML
    private BarChart<String, Integer> barchart1;
    @FXML
    private NumberAxis yaxis;
    @FXML
    private CategoryAxis xaxis;
    @FXML
    private AreaChart<String, Float> areachart1;
    @FXML
    private NumberAxis yaxis1;
    @FXML
    private CategoryAxis xaxis1;
    
        
    ProductService ps=new ProductService();

    List<productEntity> products = new ArrayList<>();
    
    private ObservableList<String> idusers = FXCollections.observableArrayList();
    private ObservableList<Integer> productnumber = FXCollections.observableArrayList();
    
    private ObservableList<String> productname = FXCollections.observableArrayList();
    private ObservableList<Float> price = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            afficher();
        } catch (SQLException ex) {
            Logger.getLogger(ChartPageController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }    
    
    public void afficher() throws SQLException{
        idusers.clear();
        productname.clear();
        price.clear();
        
        
        
        products = ps.readAll();
        List<Integer> ids= new ArrayList<>();
        
        
        for(productEntity product: products){
//            idusers.add(product.getUsername());
//            ids.add(product.getOwner().getIdUser());
            productname.add(product.getName());
            price.add(product.getPrice());
        }
        //idusers.addAll(ps.readAll());
        LinkedHashSet<String> hashset = new LinkedHashSet<>(idusers);
        ArrayList<String> newList = new ArrayList<>(hashset);
        idusers.clear();
        idusers.addAll(newList);
        
       
      
        xaxis.setCategories(idusers);
        
        
         LinkedHashSet<Integer> hashset2 = new LinkedHashSet<>(ids);
         ArrayList<Integer> newList2 = new ArrayList<>(hashset2);
         ids.clear();
         ids.addAll(newList2);
         
         
         XYChart.Series<String, Integer> series = new XYChart.Series<>();
    
    for (int i = 0; i < ids.size(); i++) {
        //something to add
            series.getData().add(new XYChart.Data<>(idusers.get(i), ids.get(i) ));
        }
        
        barchart1.getData().add(series);
    
         
         //2nd chart
        
        LinkedHashSet<String> hashset3 = new LinkedHashSet<>(productname);
        ArrayList<String> newList3 = new ArrayList<>(hashset3);
        productname.clear();
        productname.addAll(newList3);
        
       
      
        xaxis1.setCategories(productname);
        
         LinkedHashSet<Float> hashset4 = new LinkedHashSet<>(price);
        ArrayList<Float> newList4 = new ArrayList<>(hashset4);
        price.clear();
        price.addAll(newList4);
        
        XYChart.Series<String, Float> series2 = new XYChart.Series<>();
    
    for (int i = 0; i < productname.size(); i++) {
        //something to add
            series2.getData().add(new XYChart.Data<>(productname.get(i), price.get(i) ));
        }
        
       areachart1.getData().add(series2);
    }

    private void goback(ActionEvent event) throws IOException {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("listProducts.fxml"));
        
        Parent root = loader.load();
        
        areachart1.getScene().setRoot(root);
    }

}
