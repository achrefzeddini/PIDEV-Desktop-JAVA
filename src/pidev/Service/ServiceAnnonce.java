/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.Service;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import pidev.Entite.Annonce;
import pidev.IService.IService;
import pidev.DataBase.DataBase;

import java.sql.SQLException;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;



/*
import java.util.logging.Level;
import java.util.logging.Logger;
*/


public class ServiceAnnonce implements IService<Annonce> {

    private Connection con;
    private Statement ste;

    public ServiceAnnonce() {
        con = DataBase.getInstance().getConnection();
    }
    
    
    
    @Override
    public void add(Annonce t) throws SQLException {
        PreparedStatement PS = con.prepareStatement("INSERT INTO `huntkingdomsymfony`.`annonce` (`user_id`,`nomAnnonce`, `descriptionAnnonce`) VALUES (?, ?, ?);");
        PS.setInt(1, t.getUser_id());
        PS.setString(2, t.getNomAnnonce());
        PS.setString(3, t.getDescriptionAnnonce());
        PS.executeUpdate();
    } 
    
//    
//    
//    public void ajouter1(Annonce a) throws SQLException {
//        PreparedStatement PS = con.prepareStatement("INSERT INTO `testannonce`.`annonce` (`idAnnonceRS`, `idUser`,`nomAnnonce`, `descriptionAnnonce`) VALUES (?, ?, ?, ?);");
//        PS.setInt(1,a.getIdAnnonceRS());
//        PS.setInt(2, a.getIdUser());
//        PS.setString(3, a.getNomAnnonce());
//        PS.setString(4, a.getDescriptionAnnonce());
//        PS.executeUpdate();
//    }

    @Override
    public void delete(int id) throws SQLException {
        PreparedStatement PS = con.prepareStatement("DELETE FROM `huntkingdomsymfony`.`annonce` WHERE `id`=?");
        PS.setInt(1,id);
        PS.executeUpdate();
    }

    @Override
    public void update(Annonce a,int id) throws SQLException {
        PreparedStatement PS=con.prepareStatement("UPDATE `huntkingdomsymfony`.`annonce` SET `nomAnnonce`=?,`descriptionAnnonce`=? WHERE `id`=?");
        PS.setString(1,a.getNomAnnonce());
        PS.setString(2,a.getDescriptionAnnonce());
        PS.setInt(3,id);
        PS.executeUpdate();
    }

    @Override
    public List<Annonce> readAll() throws SQLException {
        List<Annonce> AL = new ArrayList<>();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select * from annonce");
        while (rs.next()) {
            int id = rs.getInt(1);
            int user_id = rs.getInt(2);
            String nomAnnonce = rs.getString(3);
            String descriptionAnnonce = rs.getString(4);
            Date dateAnnonce = rs.getDate(5);
            
            Annonce a = new Annonce(id,user_id,nomAnnonce,descriptionAnnonce,dateAnnonce);
            AL.add(a);
        }
        
        return AL;
    }

    
public void getDefendants( String tab) throws Exception  { 
        
        
        @SuppressWarnings("unused")
        Workbook readWorkbook = WorkbookFactory.create(new FileInputStream("D:\\Text.xls") );
        @SuppressWarnings("resource")
        Workbook writeWorkbook = new HSSFWorkbook();
        Sheet desSheet = writeWorkbook.createSheet("new sheet");

        Statement ste = null;
        ResultSet rs = null;
        try{
            String req ="SELECT * FROM annonce";

            ste = con.createStatement();
            rs = ste.executeQuery(req);
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnsNumber = rsmd.getColumnCount();

            Row desRow1 = desSheet.createRow(0);
            for(int col=0 ;col < columnsNumber;col++) {
                Cell newpath = desRow1.createCell(col);
                newpath.setCellValue(rsmd.getColumnLabel(col+1));
            }
            while(rs.next()) {
                System.out.println("Row number" + rs.getRow() );
                Row desRow = desSheet.createRow(rs.getRow());
                for(int col=0 ;col < columnsNumber;col++) {
                    Cell newpath = desRow.createCell(col);
                    newpath.setCellValue(rs.getString(col+1));  
                }
                FileOutputStream fileOut = new FileOutputStream("D:\\Text.xls");
                writeWorkbook.write(fileOut);
                fileOut.close();
            }
        }
        catch (SQLException e) {
            System.out.println("Failed to get data from database");
        }
    }    

    @Override
    public void ajouter(Annonce t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String mail) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Annonce> readAll(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Annonce> readALL(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Annonce> readPanier(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insert(Annonce t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Annonce> searchByIDuser(int idu) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Annonce> sortByPrice() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Annonce> test(String a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Annonce> getuserprod(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Annonce> getAllReservations(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int reada() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int readb() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int read() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Annonce getById(int idEvent) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Annonce> searchByName(String titre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}



///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package pidev.Service;
//
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import pidev.Entite.Annonce;
//import pidev.IService.IService;
//import pidev.DataBase.DataBase;
//
//import java.sql.SQLException;
//import java.util.List;
//import java.sql.*;
//import java.util.ArrayList;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.ss.usermodel.WorkbookFactory;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//
///**
// *
// * @author Testouri Mohamed
// */
///*
//import java.util.logging.Level;
//import java.util.logging.Logger;
// */
//public class ServiceAnnonce implements IService<Annonce> {
//
//    private Connection con;
//    private Statement ste;
//
//    public ServiceAnnonce() {
//        con = DataBase.getInstance().getConnection();
//    }
//
//    @Override
//    public void ajouter(Annonce t) throws SQLException {
//        PreparedStatement PS = con.prepareStatement("INSERT INTO `annonce` (`idAnnonceRS`,`nomAnnonce`, `descriptionAnnonce`) VALUES (?, ?, ?);");
//        PS.setInt(1, t.getIdAnnonceRS());
//        PS.setString(2, t.getNomAnnonce());
//        PS.setString(3, t.getDescriptionAnnonce());
//        PS.executeUpdate();
//    }
//
//    public void ajouter1(Annonce a) throws SQLException {
//        PreparedStatement PS = con.prepareStatement("INSERT INTO `annonce` (`idAnnonceRS`, `idUser`,`nomAnnonce`, `descriptionAnnonce`) VALUES (?, ?, ?, ?);");
//        PS.setInt(1, a.getIdAnnonceRS());
//        PS.setInt(2, a.getIdUser());
//        PS.setString(3, a.getNomAnnonce());
//        PS.setString(4, a.getDescriptionAnnonce());
//        PS.executeUpdate();
//    }
//
//    @Override
//    public void delete(int id) throws SQLException {
//        PreparedStatement PS = con.prepareStatement("DELETE FROM `annonce` WHERE `idAnnonceRS`=?");
//        PS.setInt(1, id);
//        PS.executeUpdate();
//    }
//
//    @Override
//    public void update(Annonce a, int id) throws SQLException {
//        PreparedStatement PS = con.prepareStatement("UPDATE `annonce` SET `nomAnnonce`=?,`descriptionAnnonce`=? WHERE `idAnnonceRS`=?");
//        PS.setString(1, a.getNomAnnonce());
//        PS.setString(2, a.getDescriptionAnnonce());
//        PS.setInt(3, id);
//        PS.executeUpdate();
//    }
//
//    @Override
//    public List<Annonce> readAll() throws SQLException {
//        List<Annonce> AL = new ArrayList<>();
//        ste = con.createStatement();
//        ResultSet rs = ste.executeQuery("select * from annonce");
//        while (rs.next()) {
//            int idAnnonce = rs.getInt(1);
//            int idAnnonceRS = rs.getInt(2);
//            String nomAnnonce = rs.getString("nomAnnonce");
//            String descriptionAnnonce = rs.getString("descriptionAnnonce");
//            int idUser = rs.getInt("idUser");
//            Annonce a = new Annonce(idAnnonce, idAnnonceRS, nomAnnonce, descriptionAnnonce, idUser);
//            AL.add(a);
//        }
//
//        return AL;
//    }
//
//    public void getDefendants(String tab) throws Exception {
//
//        @SuppressWarnings("unused")
//        Workbook readWorkbook = WorkbookFactory.create(new FileInputStream("D:\\Text.xls"));
//        @SuppressWarnings("resource")
//        Workbook writeWorkbook = new HSSFWorkbook();
//        Sheet desSheet = writeWorkbook.createSheet("new sheet");
//
//       
//            Statement ste = null;
//            ResultSet rs = null;
//            try {
//                String req = "SELECT * FROM annonce";
//
//                ste = con.createStatement();
//                rs = ste.executeQuery(req);
//                ResultSetMetaData rsmd = rs.getMetaData();
//                int columnsNumber = rsmd.getColumnCount();
//
//                Row desRow1 = desSheet.createRow(0);
//                for (int col = 0; col < columnsNumber; col++) {
//                    Cell newpath = desRow1.createCell(col);
//                    newpath.setCellValue(rsmd.getColumnLabel(col + 1));
//                }
//                while (rs.next()) {
//                    System.out.println("Row number" + rs.getRow());
//                    Row desRow = desSheet.createRow(rs.getRow());
//                    for (int col = 0; col < columnsNumber; col++) {
//                        Cell newpath = desRow.createCell(col);
//                        newpath.setCellValue(rs.getString(col + 1));
//                    }
//                    FileOutputStream fileOut = new FileOutputStream("D:\\Text.xls");
//                    writeWorkbook.write(fileOut);
//                    fileOut.close();
//                }
//            } catch (SQLException e) {
//                System.out.println("Failed to get data from database");
//            }
//        }
//
//    @Override
//    public void add(Annonce t) throws SQLException {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void delete(String mail) throws SQLException {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public List<Annonce> readAll(int id) throws SQLException {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public List<Annonce> readALL(int id) throws SQLException {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public List<Annonce> readPanier(int id) throws SQLException {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void insert(Annonce t) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public List<Annonce> searchByIDuser(int idu) throws SQLException {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public List<Annonce> sortByPrice() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public List<Annonce> test(String a) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public List<Annonce> getuserprod(int id) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public ArrayList<Annonce> getAllReservations(int id) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public int reada() throws SQLException {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public int readb() throws SQLException {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public int read() throws SQLException {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public Annonce getById(int idEvent) throws SQLException {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public List<Annonce> searchByName(String titre) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//
//    }
