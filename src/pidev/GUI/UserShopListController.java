/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.GUI;

import pidev.Entite.productEntity;
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
import javafx.stage.Stage;
import pidev.Entite.Commande;
import pidev.Entite.CurrentUser;
import pidev.Service.ServiceCommande;
import pidev.service.ProductService;

/**
 * FXML Controller class
 *
 * @author Dorsaf
 */
public class UserShopListController implements Initializable {

    @FXML
    private TextField searchField;
    @FXML
    private TableView<productEntity> Table;
    @FXML
    private TableColumn<productEntity, String> photo;
    @FXML
    private TableColumn<productEntity, String> name;
    @FXML
    private TableColumn<productEntity, String> descr;
    @FXML
    private TableColumn<productEntity, Float> price;
   
    @FXML
    private TableColumn<productEntity,String> nameuser;
    @FXML
    private TableColumn<productEntity, String> lastname;
    @FXML
    private Button gotocart;
    @FXML
    private TableColumn<?, ?> owner;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
         photo.setCellValueFactory(new PropertyValueFactory<productEntity, String>("Photo"));
         name.setCellValueFactory(new PropertyValueFactory<productEntity, String>("Name"));
         descr.setCellValueFactory(new PropertyValueFactory<productEntity, String>("Description"));
         price.setCellValueFactory(new PropertyValueFactory<productEntity, Float>("Price"));
         nameuser.setCellValueFactory(new PropertyValueFactory<productEntity, String>("username"));
         lastname.setCellValueFactory(new PropertyValueFactory<productEntity, String>("lastname"));
        
         
       
       
         ObservableList<productEntity> data = FXCollections.<productEntity>observableArrayList();
         ProductService ps=new ProductService();
        
        try {
            data.addAll(ps.readAll());
            System.out.println(ps.readAll());
        } catch (SQLException ex) {
            Logger.getLogger(ListProductsController.class.getName()).log(Level.SEVERE, null, ex);
        }
         Table.getItems().setAll(data);
       
        
         
         
         
         
         
         
         FilteredList<productEntity> filteredData = new FilteredList<>(data, b -> true);
         
         
         
         
         searchField.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(product -> {
				// If filter text is empty, display all persons.
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				//or else
				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (String.valueOf(product.getId()).toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; 
				} else if (product.getName().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; 
				}else if (product.getDescription().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; 
				}else if (String.valueOf(product.getPrice()).toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; 
				}
                                else if (product.getPhoto().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; 
				}
                                else if (product.getUsername().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; 
				}
                                else if (product.getLastname().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; 
				}
				
				     else  
				    	 return false; // Does not match.
			});
		});
		
		// 3. Wrap the FilteredList in a SortedList. 
		SortedList<productEntity> sortedData = new SortedList<>(filteredData);
		
		// 4. Bind the SortedList comparator to the TableView comparator.
		// 	  Otherwise, sorting the TableView would have no effect.
		sortedData.comparatorProperty().bind(Table.comparatorProperty());
		
		// 5. Add sorted (and filtered) data to the table.
		Table.setItems(sortedData);
               
         
        
    }   

    private void loadmyshop(ActionEvent event) throws IOException {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("userShop.fxml"));
        
        Parent root1 = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        stage.show();
        
        
    }

    @FXML
    private void addcart(ActionEvent event) throws IOException, SQLException {
 
        ServiceCommande sc = new ServiceCommande();
        sc.ajouterpanier(new Commande(name.getCellData(Table.getSelectionModel().getSelectedIndex()),price.getCellData(Table.getSelectionModel().getSelectedIndex()),CurrentUser.getUser_id()));
        
    }
    
   
        
    
    
}
