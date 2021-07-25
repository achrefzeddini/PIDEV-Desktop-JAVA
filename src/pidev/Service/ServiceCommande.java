/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.Service;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import pidev.DataBase.DataBase;
import pidev.Entite.Commande;
import pidev.Entite.CurrentUser;
import pidev.IService.IService;

/**
 *
 * @author hp
 */
public class ServiceCommande implements IService<Commande> {
    
    private Connection con; 
    private Statement ste;
    CurrentUser cu = new CurrentUser();
    
    
    public ServiceCommande(){
        con = DataBase.getInstance().getConnection();
    }

    @Override
    public void ajouter(Commande t) throws SQLException {
        PreparedStatement pre=con.prepareStatement("INSERT INTO `huntkingdomsymfony`.`commande` (`produit`,  `date`, `price`, `State`, `user_id`) VALUES ( ?, ?, ?, ?, ?);");
    pre.setString(1, t.getProduit());
    pre.setDate(2, t.getDate());
    pre.setDouble(3, t.getPrice());
    pre.setInt(4, t.getState());
    pre.setInt(5, t.getUser_id());
    pre.executeUpdate();
    }
    public void ajouterpanier(Commande t) throws SQLException {
        PreparedStatement pre=con.prepareStatement("INSERT INTO `huntkingdomsymfony`.`commande` (`produit`, `price`, `user_id`, `state`) VALUES ( ?, ?, ?, 0);");
    pre.setString(1, t.getProduit());
    pre.setDouble(2, t.getPrice());

    pre.setInt(3, t.getUser_id());
    
    pre.executeUpdate();
    }

    @Override
    public void delete(int id) throws SQLException {
        PreparedStatement pre=con.prepareStatement("DELETE FROM `huntkingdomsymfony`.`commande` WHERE `id`=?;");
    pre.setInt(1, id);
    pre.executeUpdate();
    }

    @Override
    public void update(Commande t, int id) throws SQLException {
        PreparedStatement pre=con.prepareStatement("UPDATE  `huntkingdomsymfony`.`commande` SET `produit`=?, `date`=?, `user_id`=? WHERE `id`=?;");
    pre.setString(1, t.getProduit());
    pre.setDate(2, t.getDate());
    pre.setInt(3, t.getUser_id());
    pre.setInt(4, id);
    pre.executeUpdate();
    }
   
    public void updatepanier(int id) throws SQLException {
        PreparedStatement pre=con.prepareStatement("UPDATE  `huntkingdomsymfony`.`commande` SET `State`=1 WHERE `id`=?;");
    pre.setInt(1, id);
    pre.executeUpdate();
    }

    @Override
    public List<Commande> readAll() throws SQLException {
        List<Commande> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from commande WHERE `State`=1");
     while (rs.next()) {                
               int id=rs.getInt(1);
               String produit = rs.getString(2);
               Date date=rs.getDate(3);
               double price = rs.getDouble(4);
               int state=rs.getInt(5);
               int user_id=rs.getInt(6);
               Commande p=new Commande(id, produit, date, user_id, price, state);

     arr.add(p);
     }
    return arr;
    

    }

    @Override
    public List<Commande> readPanier(int id) throws SQLException {
         List<Commande> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from commande WHERE (`State`=0 And `user_id`="+cu.getUser_id()+") ");
     while (rs.next()) {                
               int idCommande=rs.getInt(1);
               String produit = rs.getString(2);
               Date date=rs.getDate(3);
               
               float price=rs.getFloat(4);
                int idUser=rs.getInt(5); 
               Commande p=new Commande(idCommande, produit, date, idUser, price);
     arr.add(p);
     }
    return arr;
    }

    @Override
    public void add(Commande t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String mail) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Commande> readAll(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Commande> readALL(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insert(Commande t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Commande> searchByIDuser(int idu) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Commande> sortByPrice() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Commande> test(String a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Commande> getuserprod(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Commande> getAllReservations(int id) {
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
    public Commande getById(int idEvent) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Commande> searchByName(String titre) {
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
//import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
//import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
//import java.sql.Connection;
//import java.sql.Date;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
//import pidev.DataBase.DataBase;
//import pidev.Entite.Commande;
//import pidev.Entite.CurrentUser;
//import pidev.IService.IService;
//
///**
// *
// * @author hp
// */
//public class ServiceCommande implements IService<Commande> {
//    
//    private Connection con; 
//    private Statement ste;
//    
//    public ServiceCommande(){
//        con = DataBase.getInstance().getConnection();
//    }
//
//    @Override
//    public void ajouter(Commande t) throws SQLException {
//        PreparedStatement pre=con.prepareStatement("INSERT INTO `commande` (`produit`,  `date`, `idUser`, `price`, `State`) VALUES ( ?, ?, ?, ?, ?);");
//    pre.setString(1, t.getProduit());
//    pre.setDate(2, t.getDate());
//    pre.setInt(3, t.getIdUser());
//    pre.setDouble(4, t.getPrice());
//    pre.setInt(5, t.getState());
//    pre.executeUpdate();
//    }
//    public void ajouterpanier(Commande t) throws SQLException {
//        PreparedStatement pre=con.prepareStatement("INSERT INTO `commande` (`produit`, `price`, `idUser`, `State`) VALUES ( ?, ?, ?, ?);");
//    pre.setString(1, t.getProduit());
//    pre.setDouble(2, t.getPrice());
//    pre.setInt(3, CurrentUser.getUser_id());
//    pre.setInt(4, t.getState());
//    pre.executeUpdate();
//    }
//
//    @Override
//    public void delete(int id) throws SQLException {
//        PreparedStatement pre=con.prepareStatement("DELETE FROM `commande` WHERE `idCommande`=?;");
//    pre.setInt(1, id);
//    pre.executeUpdate();
//    }
//
//    @Override
//    public void update(Commande t, int id) throws SQLException {
//        PreparedStatement pre=con.prepareStatement("UPDATE `commande` SET `produit`=?, `date`=?, `idUser`=? WHERE `idCommande`=?;");
//    pre.setString(1, t.getProduit());
//    pre.setDate(2, t.getDate());
//    pre.setInt(3, t.getIdUser());
//    pre.setInt(4, id);
//    pre.executeUpdate();
//    }
//   
//    public void updatepanier(int id) throws SQLException {
//        PreparedStatement pre=con.prepareStatement("UPDATE `commande` SET `State`=1 WHERE `idCommande`=?;");
//    pre.setInt(1, id);
//    pre.executeUpdate();
//    }
//
//    @Override
//    public List<Commande> readAll() throws SQLException {
//        List<Commande> arr=new ArrayList<>();
//    ste=con.createStatement();
//    ResultSet rs=ste.executeQuery("select * from commande WHERE `State`=1");
//     while (rs.next()) {                
//               int idCommande=rs.getInt(1);
//               String produit = rs.getString(2);
//               Date date=rs.getDate(3);
//               int idUser=rs.getInt(4);
//               float price = rs.getFloat(5);
//               int state=rs.getInt(6);
//               Commande p=new Commande(idCommande, produit, date, idUser, price, state);
//
//     arr.add(p);
//     }
//    return arr;
//    
//
//    }
//
//    @Override
//    public List<Commande> readPanier(int id) throws SQLException {
//        id = CurrentUser.getUser_id();
//         List<Commande> arr=new ArrayList<>();
//    PreparedStatement PrepState = con.prepareStatement("select * from commande WHERE (`State`=0 And `idUser`=?) ");
//    PrepState.setInt(1, id);
//    ResultSet rs=PrepState.executeQuery();
//     while (rs.next()) {      
//               Commande p=new Commande(rs.getInt(1), rs.getString(2), rs.getDate(3),rs.getInt(4), rs.getFloat(5));
//     arr.add(p);
//     }
//    return arr;
//    }
//    
//
//    @Override
//    public void insert(Commande t) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public List<Commande> searchByIDuser(int idu) throws SQLException {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public List<Commande> sortByPrice() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public List<Commande> test(String a) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public List<Commande> getuserprod(int id) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void add(Commande t) throws SQLException {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void delete(String mail) throws SQLException {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public List<Commande> readAll(int id) throws SQLException {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public List<Commande> readALL(int id) throws SQLException {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public ArrayList<Commande> getAllReservations(int id) {
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
//    public Commande getById(int idEvent) throws SQLException {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public List<Commande> searchByName(String titre) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//    
//   
//   
//    }
//    
//
