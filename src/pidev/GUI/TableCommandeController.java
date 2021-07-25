/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.GUI;

import java.io.File;
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
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import pidev.Entite.Animal;
import pidev.Entite.Commande;
import pidev.Entite.Commande;
import pidev.Service.ServiceAnimal;
import pidev.Service.ServiceCommande;
import pidev.Service.ServiceCommande;

/**
 *
 * @author hp
 */
public class TableCommandeController implements Initializable{

    @FXML
    private TableView<Commande> tablevc;
    @FXML
    private TableColumn<Commande, Integer> colnumber;
    @FXML
    private TableColumn<Commande, String> colproduit;
    @FXML
    private TableColumn<Commande, String> coldate;
    @FXML
    private TableColumn<Commande, Integer> colclient;
    @FXML
    private Button btndc;
    @FXML
    private TextField searchc;
    ObservableList<Commande> listC = FXCollections.observableArrayList();
    private ImageView imgcommande;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//              File file = new File("images/he.jpg");
//        Image image = new Image(file.toURI().toString());
//        imgcommande.setImage(image);
        refresh();
 
    }
   
    ServiceCommande ser=new ServiceCommande();
    
    
    void refresh(){
       
        ServiceCommande sc = new ServiceCommande();
       listC.clear();
       
        try {
            listC.addAll(sc.readAll());
        } catch (SQLException ex) {
            Logger.getLogger(TableCommandeController.class.getName()).log(Level.SEVERE, null, ex);
        }
       

        colnumber.setCellValueFactory(new PropertyValueFactory<>("id"));
        colproduit.setCellValueFactory(new PropertyValueFactory<>("produit"));
        coldate.setCellValueFactory(new PropertyValueFactory<>("date"));
        colclient.setCellValueFactory(new PropertyValueFactory<>("price"));
        tablevc.setItems(listC);

        FilteredList<Commande> filteredData = new FilteredList<>(listC, lu -> true);

        // 2. Set the filter Predicate whenever the filter changes.
        searchc.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate((Commande commande) -> {
                // If filter text is empty, display all persons.

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                // Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();

                if (String.valueOf(commande.getId()).contains(lowerCaseFilter)) {
                    return true; // Filter matches first name.
                } else if (commande.getProduit().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches last name.
                } else if (String.valueOf(commande.getUser_id()).contains(lowerCaseFilter)) {
                    return true;
                } else {
                    return false; // Does not match.
                }
            });
        });

        // 3. Wrap the FilteredList in a SortedList. 
        SortedList<Commande> sortedData = new SortedList<>(filteredData);

        // 4. Bind the SortedList comparator to the tablevciew comparator.
        // 	  Otherwise, sorting the tablevciew would have no effect.
        sortedData.comparatorProperty().bind(tablevc.comparatorProperty());

        // 5. Add sorted (and filtered) data to the table.
        tablevc.setItems(sortedData);
    }
       
       
//    }
//    @FXML
//    private void ajoutCommande(ActionEvent event) throws IOException, SQLException {
//        ServiceCommande sc = new ServiceCommande();
//        sc.ajouter(new Commande(tfproduit.getText(), tfdate.getText(), Integer.parseInt(tfclient.getText())));
//        JOptionPane.showMessageDialog(null, "Commande Added");
//        refresh();
//        
//    }
//
//    @FXML
//     private void updateProduit(TableColumn.CellEditEvent bb) throws SQLException {
//                Commande commandeselected = tablevc.getSelectionModel().getSelectedItem();
//                commandeselected.setProduit(bb.getNewValue().toString());
//                ser.update(commandeselected, commandeselected.getIdCommande());
//                
//    }
//     @FXML
//     private void updateDate(TableColumn.CellEditEvent bb) throws SQLException {
//                Commande commandeselected = tablevc.getSelectionModel().getSelectedItem();
//                commandeselected.setProduit(bb.getNewValue().toString());
//                ser.update(commandeselected, commandeselected.getIdCommande());
//                
//    }
//     @FXML
//     private void updateClient(TableColumn.CellEditEvent bb) throws SQLException {
//                Commande commandeselected = tablevc.getSelectionModel().getSelectedItem();
//                commandeselected.setProduit(bb.getNewValue().toString());
//                ser.update(commandeselected, commandeselected.getIdCommande());
//                
//    }
//
//    @FXML
//    private void deleteCommande(ActionEvent event) throws SQLException {
//        ServiceCommande sa = new ServiceCommande();
//        sa.delete(colnumber.getCellData(tablevc.getSelectionModel().getSelectedIndex()));
//        refresh();
//             JOptionPane.showMessageDialog(null, "Commande Deleted");
//    }

    @FXML
    private void Imprimer(ActionEvent event) {
    }

    
}




///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package pidev.GUI;
//
//import com.itextpdf.text.Document;
//import com.itextpdf.text.DocumentException;
//import com.itextpdf.text.Paragraph;
//import com.itextpdf.text.Phrase;
//import com.itextpdf.text.pdf.PdfPCell;
//import com.itextpdf.text.pdf.PdfPTable;
//import com.itextpdf.text.pdf.PdfWriter;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.net.URL;
//import java.sql.Date;
//import java.sql.SQLException;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//import java.util.ArrayList;
//import java.util.Optional;
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
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.scene.control.Alert;
//import javafx.scene.control.Button;
//import javafx.scene.control.ButtonType;
//import javafx.scene.control.TableColumn;
//import javafx.scene.control.TableView;
//import javafx.scene.control.TextField;
//import javafx.scene.control.cell.PropertyValueFactory;
//import javafx.scene.control.cell.TextFieldTableCell;
//import javafx.scene.image.Image;
//import javafx.scene.image.ImageView;
//import javafx.stage.Stage;
//import javax.swing.JOptionPane;
//import pidev.Entite.Animal;
//import pidev.Entite.Annonce;
//import pidev.Entite.Commande;
//import pidev.Entite.Commande;
//import pidev.Service.ServiceAnimal;
//import pidev.Service.ServiceAnnonce;
//import pidev.Service.ServiceCommande;
//import pidev.Service.ServiceCommande;
//
///**
// *
// * @author hp
// */
//public class TableCommandeController implements Initializable{
//
//    @FXML
//    private TableView<Commande> tablevc;
//    @FXML
//    private TableColumn<Commande, Integer> colnumber;
//    @FXML
//    private TableColumn<Commande, String> colproduit;
//    @FXML
//    private TableColumn<Commande, String> coldate;
//    @FXML
//    private TableColumn<Commande, Integer> colclient;
//    @FXML
//    private Button btndc;
//    @FXML
//    private TextField searchc;
//    ObservableList<Commande> listC = FXCollections.observableArrayList();
//    private ImageView imgcommande;
//
//    @Override
//    public void initialize(URL location, ResourceBundle resources) {
////              File file = new File("images/he.jpg");
////        Image image = new Image(file.toURI().toString());
////        imgcommande.setImage(image);
//        refresh();
// 
//    }
//   
//    ServiceCommande ser=new ServiceCommande();
//    
//    
//    void refresh(){
//       
//        ServiceCommande sc = new ServiceCommande();
//       listC.clear();
//       
//        try {
//            listC.addAll(sc.readAll());
//        } catch (SQLException ex) {
//            Logger.getLogger(TableCommandeController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//       
//
//        colnumber.setCellValueFactory(new PropertyValueFactory<>("idCommande"));
//        colproduit.setCellValueFactory(new PropertyValueFactory<>("produit"));
//        coldate.setCellValueFactory(new PropertyValueFactory<>("date"));
//        colclient.setCellValueFactory(new PropertyValueFactory<>("idUser"));
//        tablevc.setItems(listC);
//
//        FilteredList<Commande> filteredData = new FilteredList<>(listC, lu -> true);
//
//        // 2. Set the filter Predicate whenever the filter changes.
//        searchc.textProperty().addListener((observable, oldValue, newValue) -> {
//            filteredData.setPredicate((Commande commande) -> {
//                // If filter text is empty, display all persons.
//
//                if (newValue == null || newValue.isEmpty()) {
//                    return true;
//                }
//
//                // Compare first name and last name of every person with filter text.
//                String lowerCaseFilter = newValue.toLowerCase();
//
//                if (String.valueOf(commande.getIdCommande()).contains(lowerCaseFilter)) {
//                    return true; // Filter matches first name.
//                } else if (commande.getProduit().toLowerCase().contains(lowerCaseFilter)) {
//                    return true; // Filter matches last name.
//                } else if (String.valueOf(commande.getIdUser()).contains(lowerCaseFilter)) {
//                    return true;
//                } else {
//                    return false; // Does not match.
//                }
//            });
//        });
//
//        // 3. Wrap the FilteredList in a SortedList. 
//        SortedList<Commande> sortedData = new SortedList<>(filteredData);
//
//        // 4. Bind the SortedList comparator to the tablevciew comparator.
//        // 	  Otherwise, sorting the tablevciew would have no effect.
//        sortedData.comparatorProperty().bind(tablevc.comparatorProperty());
//
//        // 5. Add sorted (and filtered) data to the table.
//        tablevc.setItems(sortedData);
//    }
//       
//       
////    }
////    @FXML
////    private void ajoutCommande(ActionEvent event) throws IOException, SQLException {
////        ServiceCommande sc = new ServiceCommande();
////        sc.ajouter(new Commande(tfproduit.getText(), tfdate.getText(), Integer.parseInt(tfclient.getText())));
////        JOptionPane.showMessageDialog(null, "Commande Added");
////        refresh();
////        
////    }
////
////    @FXML
////     private void updateProduit(TableColumn.CellEditEvent bb) throws SQLException {
////                Commande commandeselected = tablevc.getSelectionModel().getSelectedItem();
////                commandeselected.setProduit(bb.getNewValue().toString());
////                ser.update(commandeselected, commandeselected.getIdCommande());
////                
////    }
////     @FXML
////     private void updateDate(TableColumn.CellEditEvent bb) throws SQLException {
////                Commande commandeselected = tablevc.getSelectionModel().getSelectedItem();
////                commandeselected.setProduit(bb.getNewValue().toString());
////                ser.update(commandeselected, commandeselected.getIdCommande());
////                
////    }
////     @FXML
////     private void updateClient(TableColumn.CellEditEvent bb) throws SQLException {
////                Commande commandeselected = tablevc.getSelectionModel().getSelectedItem();
////                commandeselected.setProduit(bb.getNewValue().toString());
////                ser.update(commandeselected, commandeselected.getIdCommande());
////                
////    }
////
////    @FXML
////    private void deleteCommande(ActionEvent event) throws SQLException {
////        ServiceCommande sa = new ServiceCommande();
////        sa.delete(colnumber.getCellData(tablevc.getSelectionModel().getSelectedIndex()));
////        refresh();
////             JOptionPane.showMessageDialog(null, "Commande Deleted");
////    }
//
//    @FXML
//    private void pdf(ActionEvent event) throws SQLException {
//        String ad="D:\\ListCommande.pdf";
//                Document doc=new Document();
//                Alert dialogC = new Alert(Alert.AlertType.INFORMATION);
//                dialogC.setTitle(" Confirmation ");
//                dialogC.setHeaderText(null);
//                dialogC.setContentText("Are you sure to export pdf ");
//                Optional<ButtonType> answer = dialogC.showAndWait();
//               try {
//                   PdfWriter.getInstance(doc, new FileOutputStream(ad));
//               } catch (FileNotFoundException ex) {
//                   Logger.getLogger(AfficherAnnonceController.class.getName()).log(Level.SEVERE, null, ex);
//               } catch (DocumentException ex) {
//                   Logger.getLogger(AfficherAnnonceController.class.getName()).log(Level.SEVERE, null, ex);
//               }
//               
//               doc.open();
//               try {
//                    doc.add(new Paragraph("Commande"));
//                    doc.add(new Paragraph("Commande List"));
//                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
//                    LocalDateTime now = LocalDateTime.now();  
//                    String d=dtf.format(now);
//                    doc.add(new Paragraph("Date: "+d));
//                    doc.add(new Paragraph(" "));
//                    PdfPTable table = new PdfPTable(6);
//                      
//                    
//                    PdfPCell c1=new PdfPCell(new Phrase("colnumber"));
//                    table.addCell(c1);
//                    c1=new PdfPCell(new Phrase("colproduit"));
//                    table.addCell(c1);
//                    c1=new PdfPCell(new Phrase("coldate"));
//                    table.addCell(c1);
//                    c1=new PdfPCell(new Phrase("colclient"));
//                    table.addCell(c1);
//                   
//                    // table.setHeaderRows(0);
//                    ServiceCommande s = new ServiceCommande();
//                    ArrayList<Commande> e =(ArrayList<Commande>)s.readAll();
//                    for(int i=0;i<e.size();i++)
//                    {
//                        int colnumber =e.get(i).getIdCommande();
//                        table.addCell(String.valueOf(colnumber)); 
//                        
//                        String colproduit=e.get(i).getProduit();
//                        table.addCell(colproduit);
//                             
//                        Date coldate=e.get(i).getDate();
//                        table.addCell(String.valueOf(coldate));
//                        
//                        int colclient=e.get(i).getIdUser();
//                        table.addCell(String.valueOf(colclient));
//                             
//                    }
//                    doc.add(table);
//               }catch (DocumentException ex) {
//                   Logger.getLogger(AfficherAnnonceController.class.getName()).log(Level.SEVERE, null, ex);
//               }
//               doc.close();
//    }
//
//    
//}
