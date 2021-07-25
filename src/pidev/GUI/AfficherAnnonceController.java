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
import javafx.event.Event;
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
import javafx.scene.input.MouseDragEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import pidev.Entite.Annonce;
import pidev.Service.ServiceAnnonce;

/*---------------------------------- PDF ------------------------------------------*/
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
/*---------------------------------- fin PDF --------------------------------------*/


/**
 * FXML Controller class
 *
 * @author elhak
 */
public class AfficherAnnonceController implements Initializable {

    @FXML
    private TableView<Annonce> tableAnnonces;
    @FXML
    private TableColumn<Annonce, Integer> columnIdAnnonce;
    @FXML
    private TableColumn<Annonce, Integer> columnIdUser;
    @FXML
    private TableColumn<Annonce, String> columnNomAnnonce;
    @FXML
    private TableColumn<Annonce, String> columnDescriptionAnnonce; 
    @FXML
    private TableColumn<Annonce,Date> columnDateAnnonce;

    
    
    
    @FXML
    private Button updateAnnonce;
    @FXML
    private Button deleteAnnonce;
    @FXML
    private TextField searchAnnonce;

    ObservableList<Annonce> listA = FXCollections.observableArrayList();
    @FXML
    private Button btnref;
    @FXML
    private Button addAnnonce;
    @FXML
    private Button excel;
    @FXML
    private Button PDF;
    @FXML
    private Button Comments;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       refresh();

    }
    
    @FXML
    private void addAnnonce(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddAnnonce.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Add Announce");
        stage.setScene(new Scene(root1));
        stage.show();
    }

    @FXML
    private void updateAnnonce(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("UpdateAnnonce.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Update Announce");
        stage.setScene(new Scene(root1));
        stage.show();
       
        UpdateAnnonceController uac=fxmlLoader.getController();
        uac.setTfNomAnnonce(columnNomAnnonce.getCellData(tableAnnonces.getSelectionModel().getSelectedIndex()));
        uac.setTfDescriptionAnnonce(columnDescriptionAnnonce.getCellData(tableAnnonces.getSelectionModel().getSelectedIndex())); 
        uac.setLbidAnnonce(columnIdAnnonce.getCellData(tableAnnonces.getSelectionModel().getSelectedIndex()));
  
    }

    @FXML
    private void deleteAnnonce(ActionEvent event) throws SQLException {
        ServiceAnnonce SA = new ServiceAnnonce();
        SA.delete(columnIdAnnonce.getCellData(tableAnnonces.getSelectionModel().getSelectedIndex()));
        refresh();
        JOptionPane.showMessageDialog(null, "Announce Deleted");
    }

  
    @FXML
    void refresh(){
        ServiceAnnonce SA = new ServiceAnnonce();
         listA.clear();
        try {
            listA.addAll(SA.readAll());
        } catch (SQLException ex) {
            Logger.getLogger(AfficherAnnonceController.class.getName()).log(Level.SEVERE, null, ex);
        }

        columnIdAnnonce.setCellValueFactory(new PropertyValueFactory<>("id"));
        columnIdUser.setCellValueFactory(new PropertyValueFactory<>("user_id"));
        columnNomAnnonce.setCellValueFactory(new PropertyValueFactory<>("nomAnnonce"));
        columnDescriptionAnnonce.setCellValueFactory(new PropertyValueFactory<>("descriptionAnnonce"));
        columnDateAnnonce.setCellValueFactory(new PropertyValueFactory<>("dateAnnonce"));
        
        FilteredList<Annonce> filteredData = new FilteredList<>(listA, lu -> true);

        // 2. Set the filter Predicate whenever the filter changes.
        searchAnnonce.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate((Annonce annonce) -> {
                // If filter text is empty, display all persons.

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                // Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();

                if (String.valueOf(annonce.getId()).contains(lowerCaseFilter)) {
                    return true; // Filter matches first name.
                } else if ((String.valueOf(annonce.getUser_id()).contains(lowerCaseFilter))) {
                    return true; // Filter matches last name.
                } else if (annonce.getNomAnnonce().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches last name.
                } else if (annonce.getDescriptionAnnonce().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else {
                    return false; // Does not match.
                }
            });
        });

        // 3. Wrap the FilteredList in a SortedList. 
        SortedList<Annonce> sortedData = new SortedList<>(filteredData);

        // 4. Bind the SortedList comparator to the TableView comparator.
        // 	  Otherwise, sorting the TableView would have no effect.
        sortedData.comparatorProperty().bind(tableAnnonces.comparatorProperty());

        // 5. Add sorted (and filtered) data to the table.
        tableAnnonces.setItems(sortedData);
    }
    
    @FXML
     public void Excel() throws Exception{
       
        try {
             ServiceAnnonce ser = new ServiceAnnonce();
            ser.getDefendants("annonce"); //nom table              
        }catch (SQLException e) {
                   System.out.println("Failed to get data from database");
                 }
       
    
}

    @FXML
    private void PDF(ActionEvent event) throws SQLException {
         
                String ad="D:\\ListAnnounce.pdf";
                Document doc=new Document();
                Alert dialogC = new Alert(Alert.AlertType.INFORMATION);
                dialogC.setTitle(" Confirmation ");
                dialogC.setHeaderText(null);
                dialogC.setContentText("Are you sure to export pdf ");
                Optional<ButtonType> answer = dialogC.showAndWait();
               try {
                   PdfWriter.getInstance(doc, new FileOutputStream(ad));
               } catch (FileNotFoundException ex) {
                   Logger.getLogger(AfficherAnnonceController.class.getName()).log(Level.SEVERE, null, ex);
               } catch (DocumentException ex) {
                   Logger.getLogger(AfficherAnnonceController.class.getName()).log(Level.SEVERE, null, ex);
               }
               
               doc.open();
               try {
                    doc.add(new Paragraph("Announce"));
                    doc.add(new Paragraph("Announce List"));
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
                    LocalDateTime now = LocalDateTime.now();  
                    String d=dtf.format(now);
                    doc.add(new Paragraph("Date: "+d));
                    doc.add(new Paragraph(" "));
                    PdfPTable table = new PdfPTable(5);
                      
                    PdfPCell c1=new PdfPCell(new Phrase("Announce ID "));
                    table.addCell(c1);
                    c1=new PdfPCell(new Phrase("User ID"));
                    table.addCell(c1);
                    c1=new PdfPCell(new Phrase("Announce Name"));
                    table.addCell(c1);
                    c1=new PdfPCell(new Phrase("Announce Description"));
                    table.addCell(c1);
                    c1=new PdfPCell(new Phrase("Announce Date "));
                    table.addCell(c1);
                   
                    // table.setHeaderRows(0);
                    ServiceAnnonce s = new ServiceAnnonce();
                    ArrayList<Annonce> e =(ArrayList<Annonce>)s.readAll();
                    for(int i=0;i<e.size();i++)
                    {
                        int id=e.get(i).getId();
                        table.addCell(String.valueOf(id)); 
                        
                        int user_id=e.get(i).getUser_id();
                        table.addCell(String.valueOf(user_id));
                             
                        String nomAnnonce=e.get(i).getNomAnnonce();
                        table.addCell(nomAnnonce);
                        
                        String descriptionAnnonce=e.get(i).getDescriptionAnnonce();
                        table.addCell(descriptionAnnonce);
                        
                        Date dateAnnonce=e.get(i).getDateAnnonce();
                        table.addCell(String.valueOf(dateAnnonce));        
                    }
                    doc.add(table);
               }catch (DocumentException ex) {
                   Logger.getLogger(AfficherAnnonceController.class.getName()).log(Level.SEVERE, null, ex);
               }
               doc.close();
    }

    @FXML
    private void showCommentPage(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader;
        fxmlLoader = new FXMLLoader(getClass().getResource("AfficherCommentaire.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Comment Section");
        stage.setScene(new Scene(root1));
        stage.show();
    }
     

    
    
}


///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package pidev.GUI;
//
//import java.io.IOException;
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
//import javafx.fxml.FXMLLoader;
//import javafx.fxml.Initializable;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.control.TableColumn;
//import javafx.scene.control.TableView;
//import javafx.scene.control.TextField;
//import javafx.scene.control.cell.PropertyValueFactory;
//import javafx.stage.Stage;
//import javax.swing.JOptionPane;
//import pidev.Entite.Annonce;
//import pidev.Service.ServiceAnnonce;
//
///*---------------------------------- PDF ------------------------------------------*/
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import com.itextpdf.text.Document;
//import com.itextpdf.text.DocumentException;
//import com.itextpdf.text.Paragraph;
//import com.itextpdf.text.Phrase;
//import com.itextpdf.text.pdf.PdfPCell;
//import com.itextpdf.text.pdf.PdfPTable;
//import com.itextpdf.text.pdf.PdfWriter;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//import java.util.ArrayList;
//import java.util.Optional;
//import javafx.scene.control.Alert;
//import javafx.scene.control.ButtonType;
///*---------------------------------- fin PDF --------------------------------------*/
//
//
///**
// * FXML Controller class
// *
// * @author elhak
// */
//public class AfficherAnnonceController implements Initializable {
//
//    @FXML
//    private TableView<Annonce> tableAnnonces;
//    @FXML
//    private TableColumn<Annonce, Integer> columnIdAnnonce;
//    @FXML
//    private TableColumn<Annonce, Integer> columnIdAnnonceRS;
//    @FXML
//    private TableColumn<Annonce, Integer> columnIdUser;
//    @FXML
//    private TableColumn<Annonce, String> columnNomAnnonce;
//    @FXML
//    private TableColumn<Annonce, String> columnDescriptionAnnonce;
//    @FXML
//    private Button updateAnnonce;
//    @FXML
//    private TextField searchAnnonce;
//
//    ObservableList<Annonce> listA = FXCollections.observableArrayList();
//    @FXML
//    private Button btnref;
//    @FXML
//    private Button addAnnonce;
//    @FXML
//    private Button excel;
//    @FXML
//    private Button PDF;
//    @FXML
//    private Button Comments;
//    @FXML
//    private Button deleteAnnonce;
//
//    /**
//     * Initializes the controller class.
//     * @param url
//     * @param rb
//     */
//    @Override
//    public void initialize(URL url, ResourceBundle rb) {
//       refresh();
//
//    }
//    
//    @FXML
//    private void addAnnonce(ActionEvent event) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddAnnonce.fxml"));
//        Parent root1 = (Parent) fxmlLoader.load();
//        Stage stage = new Stage();
//        stage.setTitle("Add Announce");
//        stage.setScene(new Scene(root1));
//        stage.show();
//    }
//
//    @FXML
//    private void updateAnnonce(ActionEvent event) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("UpdateAnnonce.fxml"));
//        Parent root1 = (Parent) fxmlLoader.load();
//        Stage stage = new Stage();
//        stage.setTitle("Update Announce");
//        stage.setScene(new Scene(root1));
//        stage.show();
//       
//        UpdateAnnonceController uac=fxmlLoader.getController();
//        uac.setTfNomAnnonce(columnNomAnnonce.getCellData(tableAnnonces.getSelectionModel().getSelectedIndex()));
//        uac.setTfDescriptionAnnonce(columnDescriptionAnnonce.getCellData(tableAnnonces.getSelectionModel().getSelectedIndex())); 
//        uac.setLbidAnnonce(columnIdAnnonceRS.getCellData(tableAnnonces.getSelectionModel().getSelectedIndex()));
//  
//    }
//
//    @FXML
//    private void deleteAnnonce(ActionEvent event) throws SQLException {
//        ServiceAnnonce SA = new ServiceAnnonce();
//        SA.delete(columnIdAnnonceRS.getCellData(tableAnnonces.getSelectionModel().getSelectedIndex()));
//        refresh();
//        JOptionPane.showMessageDialog(null, "Announce Deleted");
//    }
//
//  
//    @FXML
//    void refresh(){
//         ServiceAnnonce SA = new ServiceAnnonce();
//         listA.clear();
//        try {
//            listA.addAll(SA.readAll());
//        } catch (SQLException ex) {
//            Logger.getLogger(AfficherAnnonceController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        columnIdAnnonce.setCellValueFactory(new PropertyValueFactory<>("idAnnonce"));
//        columnIdAnnonceRS.setCellValueFactory(new PropertyValueFactory<>("idAnnonceRS"));
//        columnIdUser.setCellValueFactory(new PropertyValueFactory<>("idUser"));
//        columnNomAnnonce.setCellValueFactory(new PropertyValueFactory<>("nomAnnonce"));
//        columnDescriptionAnnonce.setCellValueFactory(new PropertyValueFactory<>("descriptionAnnonce"));
//
//        FilteredList<Annonce> filteredData = new FilteredList<>(listA, lu -> true);
//
//        // 2. Set the filter Predicate whenever the filter changes.
//        searchAnnonce.textProperty().addListener((observable, oldValue, newValue) -> {
//            filteredData.setPredicate((Annonce annonce) -> {
//                // If filter text is empty, display all persons.
//
//                if (newValue == null || newValue.isEmpty()) {
//                    return true;
//                }
//
//                // Compare first name and last name of every person with filter text.
//                String lowerCaseFilter = newValue.toLowerCase();
//
//                if (String.valueOf(annonce.getIdAnnonceRS()).contains(lowerCaseFilter)) {
//                    return true; // Filter matches first name.
//                } else if ((String.valueOf(annonce.getIdUser()).contains(lowerCaseFilter))) {
//                    return true; // Filter matches last name.
//                } else if (annonce.getNomAnnonce().toLowerCase().contains(lowerCaseFilter)) {
//                    return true; // Filter matches last name.
//                } else if (annonce.getDescriptionAnnonce().toLowerCase().contains(lowerCaseFilter)) {
//                    return true;
//                } else {
//                    return false; // Does not match.
//                }
//            });
//        });
//
//        // 3. Wrap the FilteredList in a SortedList. 
//        SortedList<Annonce> sortedData = new SortedList<>(filteredData);
//
//        // 4. Bind the SortedList comparator to the TableView comparator.
//        // 	  Otherwise, sorting the TableView would have no effect.
//        sortedData.comparatorProperty().bind(tableAnnonces.comparatorProperty());
//
//        // 5. Add sorted (and filtered) data to the table.
//        tableAnnonces.setItems(sortedData);
//    }
//    
//    @FXML
//     public void Excel() throws Exception{
//       
//        try {
//             ServiceAnnonce ser = new ServiceAnnonce();
//            ser.getDefendants("annonce"); //nom table              
//        }catch (SQLException e) {
//                   System.out.println("Failed to get data from database");
//                 }
//       
//    
//}
//
//    @FXML
//    private void PDF(ActionEvent event) throws SQLException {
//         
//                String ad="D:\\ListAnnounce.pdf";
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
//                    doc.add(new Paragraph("Announce"));
//                    doc.add(new Paragraph("Announce List"));
//                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
//                    LocalDateTime now = LocalDateTime.now();  
//                    String d=dtf.format(now);
//                    doc.add(new Paragraph("Date: "+d));
//                    doc.add(new Paragraph(" "));
//                    PdfPTable table = new PdfPTable(6);
//                      
//                    PdfPCell c1=new PdfPCell(new Phrase("idAnnonce"));
//                    table.addCell(c1);
//                    c1=new PdfPCell(new Phrase("idAnnonceRS"));
//                    table.addCell(c1);
//                    c1=new PdfPCell(new Phrase("nomAnnonce"));
//                    table.addCell(c1);
//                    c1=new PdfPCell(new Phrase("descriptionAnnonce"));
//                    table.addCell(c1);
//                    c1=new PdfPCell(new Phrase("idUser"));
//                    table.addCell(c1);
//                   
//                    // table.setHeaderRows(0);
//                    ServiceAnnonce s = new ServiceAnnonce();
//                    ArrayList<Annonce> e =(ArrayList<Annonce>)s.readAll();
//                    for(int i=0;i<e.size();i++)
//                    {
//                        int idAnnonce=e.get(i).getIdAnnonce();
//                        table.addCell(String.valueOf(idAnnonce)); 
//                        
//                        int idAnnonceRS=e.get(i).getIdAnnonceRS();
//                        table.addCell(String.valueOf(idAnnonceRS));
//                             
//                        String nomAnnonce=e.get(i).getNomAnnonce();
//                        table.addCell(nomAnnonce);
//                        
//                        String descriptionAnnonce=e.get(i).getDescriptionAnnonce();
//                        table.addCell(descriptionAnnonce);
//                        
//                        int idUser=e.get(i).getIdUser();
//                        table.addCell(String.valueOf(idUser));        
//                    }
//                    doc.add(table);
//               }catch (DocumentException ex) {
//                   Logger.getLogger(AfficherAnnonceController.class.getName()).log(Level.SEVERE, null, ex);
//               }
//               doc.close();
//    }
//
//    @FXML
//    private void showCommentPage(ActionEvent event) throws IOException {
//        FXMLLoader fxmlLoader;
//        fxmlLoader = new FXMLLoader(getClass().getResource("AfficherCommentaire.fxml"));
//        Parent root1 = (Parent) fxmlLoader.load();
//        Stage stage = new Stage();
//        stage.setTitle("Comment Section");
//        stage.setScene(new Scene(root1));
//        stage.show();
//    }
//     
//
//    
//    
//}
