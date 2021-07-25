/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import pidev.DataBase.DataBase;
import pidev.Entite.Animal;
import pidev.Entite.Commande;
import pidev.IService.IService;

/**
 *
 * @author hp
 */
public class ServiceAnimal implements IService<Animal>{
    private Connection con; 
    private Statement ste;
    
    public ServiceAnimal(){
        con = DataBase.getInstance().getConnection();
    
    }

    @Override
    public void ajouter(Animal t) throws SQLException {
        PreparedStatement pre=con.prepareStatement("INSERT INTO `huntkingdomsymfony`.`animal` ( `idA`, `race`, `saison`, `place`, `image`) VALUES ( ?, ?, ?, ?, ?);");
    pre.setInt(1, t.getIdA());
    pre.setString(2, t.getRace());
    pre.setString(3, t.getSaison());
    pre.setString(4, t.getPlace());
    pre.setString(5, t.getImage());
    pre.executeUpdate();
    }
    
    public void ajouters(Animal t) throws SQLException {
        PreparedStatement pre=con.prepareStatement("INSERT INTO `huntkingdomsymfony`.`animal` ( idA, race, saison, place, image, hunted, season_id) VALUES ( ?, ?, ?, ?, ?,0, 1);");
    pre.setInt(1, t.getIdA());
    pre.setString(2, t.getRace());
    pre.setString(3, t.getSaison());
    pre.setString(4, t.getPlace());
    pre.setString(5, t.getImage());
 
    pre.executeUpdate();
    }
    
    
    @Override
    public void delete(int id) throws SQLException {
 
        PreparedStatement pre=con.prepareStatement("DELETE FROM `huntkingdomsymfony`.`animal` WHERE `idA`=?;");
    pre.setInt(1, id);
    pre.executeUpdate();
    }

    @Override
    public void update(Animal t, int id) throws SQLException {

        PreparedStatement pre=con.prepareStatement("UPDATE  `huntkingdomsymfony`.`animal` SET `idA`=?, `race`=?, `saison`=?, `place`=?, `image`=?  WHERE `idA`=?;");
    pre.setInt(1, t.getIdA());
    pre.setString(2, t.getRace());
    pre.setString(3, t.getSaison());
    pre.setString(4, t.getPlace());
    pre.setString(5, t.getImage());
    pre.setInt(6, id);
    pre.executeUpdate();
    }
    public void updates(Animal t, int id) throws SQLException {

        PreparedStatement pre=con.prepareStatement("UPDATE  `huntkingdomsymfony`.`animal` SET `idA`=?, `race`=?, `saison`=?, `place`=?, `image`=?  WHERE `idA`=?;");
    pre.setInt(1, t.getIdA());
    pre.setString(2, t.getRace());
    pre.setString(3, t.getSaison());
    pre.setString(4, t.getPlace());
    pre.setString(5, t.getImage());
    pre.setInt(6, id);
    pre.executeUpdate();
    }

    @Override
    public List<Animal> readAll() throws SQLException {
 
         List<Animal> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from animal");
     while (rs.next()) {    
               int id=rs.getInt(1);
               int idA=rs.getInt(2);
               String race=rs.getString(3);
               String saison=rs.getString(4);  
               String place=rs.getString(5);
               String image=rs.getString(6);
               int hunted=rs.getInt(7);
               Animal p=new Animal(id, idA, race, saison, place, image, hunted);
     arr.add(p);
     }
     return arr;
    
    }

    @Override
    public List<Animal> readPanier(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public void updateh(int id) throws SQLException {

        PreparedStatement pre=con.prepareStatement("UPDATE  `huntkingdomsymfony`.`animal` SET `hunted`=hunted+1  WHERE `idA`=?;");

    pre.setInt(1, id);

    pre.executeUpdate();
    }
     public int read() throws SQLException {
 
         
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select hunted from animal where `race`='bear'");
     while (rs.next()) {    

               int hunted=rs.getInt(1);
               rs.close();
               return hunted;
  
     }
   return 0;
     }
      public int readd() throws SQLException {
 
         
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select hunted from animal where `race`='fish'");
     while (rs.next()) {    

               int hunted=rs.getInt(1);
               rs.close();
               return hunted;
  
     }
   return 0;
     }
            public int readdd() throws SQLException {
 
         
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select hunted from animal where `race`='deer'");
     while (rs.next()) {    

               int hunted=rs.getInt(1);
               rs.close();
               return hunted;
  
     }
   return 0;
     }

    @Override
    public void add(Animal t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String mail) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Animal> readAll(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Animal> readALL(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insert(Animal t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Animal> searchByIDuser(int idu) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Animal> sortByPrice() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Animal> test(String a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Animal> getuserprod(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Animal> getAllReservations(int id) {
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
    public Animal getById(int idEvent) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Animal> searchByName(String titre) {
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
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
//import pidev.DataBase.DataBase;
//import pidev.Entite.Animal;
//import pidev.Entite.Commande;
//import pidev.IService.IService;
//
///**
// *
// * @author hp
// */
//public class ServiceAnimal implements IService<Animal>{
//    private Connection con; 
//    private Statement ste;
//    
//    public ServiceAnimal(){
//        con = DataBase.getInstance().getConnection();
//    
//    }
//
//    @Override
//    public void ajouter(Animal t) throws SQLException {
//        PreparedStatement pre=con.prepareStatement("INSERT INTO `animal` ( `idA`, `race`, `saison`, `place`, `image`) VALUES ( ?, ?, ?, ?, ?);");
//    pre.setInt(1, t.getIdA());
//    pre.setString(2, t.getRace());
//    pre.setString(3, t.getSaison());
//    pre.setString(4, t.getPlace());
//    pre.setString(5, t.getImage());
//    pre.executeUpdate();
//    }
//
//    @Override
//    public void delete(int id) throws SQLException {
// 
//        PreparedStatement pre=con.prepareStatement("DELETE FROM `animal` WHERE `idA`=?;");
//    pre.setInt(1, id);
//    pre.executeUpdate();
//    }
//
//    @Override
//    public void update(Animal t, int id) throws SQLException {
//
//        PreparedStatement pre=con.prepareStatement("UPDATE `animal` SET `idA`=?, `race`=?, `saison`=?, `place`=?, `image`=?  WHERE `idA`=?;");
//    pre.setInt(1, t.getIdA());
//    pre.setString(2, t.getRace());
//    pre.setString(3, t.getSaison());
//    pre.setString(4, t.getPlace());
//    pre.setString(5, t.getImage());
//    pre.setInt(6, id);
//    pre.executeUpdate();
//    }
//
//    @Override
//    public List<Animal> readAll() throws SQLException {
// 
//         List<Animal> arr=new ArrayList<>();
//    ste=con.createStatement();
//    ResultSet rs=ste.executeQuery("select * from animal");
//     while (rs.next()) {    
//               int idAnimal=rs.getInt(1);
//               int idA=rs.getInt(2);
//               String race=rs.getString(3);
//               String saison=rs.getString(4);  
//               String place=rs.getString(5);
//               String image=rs.getString(6);
//               int hunted=rs.getInt(7);
//               Animal p=new Animal(idAnimal, idA, race, saison, place, image, hunted);
//     arr.add(p);
//     }
//     return arr;
//    
//    }
//
//    @Override
//    public List<Animal> readPanier(int id) throws SQLException {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    
//    public void updateh(int id) throws SQLException {
//
//        PreparedStatement pre=con.prepareStatement("UPDATE `animal` SET `hunted`=hunted+1  WHERE `idA`=?;");
//
//    pre.setInt(1, id);
//
//    pre.executeUpdate();
//    }
//     public int read() throws SQLException {
// 
//         
//    ste=con.createStatement();
//    ResultSet rs=ste.executeQuery("select hunted from animal where `race`='bear'");
//     while (rs.next()) {    
//
//               int hunted=rs.getInt(1);
//               rs.close();
//               return hunted;
//  
//     }
//   return 0;
//     }
//      public int readd() throws SQLException {
// 
//         
//    ste=con.createStatement();
//    ResultSet rs=ste.executeQuery("select hunted from animal where `race`='fish'");
//     while (rs.next()) {    
//
//               int hunted=rs.getInt(1);
//               rs.close();
//               return hunted;
//  
//     }
//   return 0;
//     }
//            public int readdd() throws SQLException {
// 
//         
//    ste=con.createStatement();
//    ResultSet rs=ste.executeQuery("select hunted from animal where `race`='deer'");
//     while (rs.next()) {    
//
//               int hunted=rs.getInt(1);
//               rs.close();
//               return hunted;
//  
//     }
//   return 0;
//     }
//
//    @Override
//    public void insert(Animal t) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public List<Animal> searchByIDuser(int idu) throws SQLException {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public List<Animal> sortByPrice() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public List<Animal> test(String a) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public List<Animal> getuserprod(int id) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void add(Animal t) throws SQLException {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void delete(String mail) throws SQLException {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public List<Animal> readAll(int id) throws SQLException {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public List<Animal> readALL(int id) throws SQLException {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public ArrayList<Animal> getAllReservations(int id) {
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
//    public Animal getById(int idEvent) throws SQLException {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public List<Animal> searchByName(String titre) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//    
//}
