///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package pidev.Service;
//
///**
// *
// * @author elhak
// */
//public class ServiceSeason {
//    
//}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.Service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import pidev.DataBase.DataBase;
import pidev.Entite.Animal;
import pidev.Entite.Season;

/**
 *
 * @author hp
 */
public class ServiceSeason {
 
     private Connection con; 
    private Statement ste;
    
    public ServiceSeason(){
        con = DataBase.getInstance().getConnection();
    
    }


    public void ajouter(Season t) throws SQLException {
        PreparedStatement pre=con.prepareStatement("INSERT INTO `huntkingdomsymfony`.`season` ( `nom`, `start`, `finish`, `description`) VALUES ( ?, ?, ?, ?);");
    
    pre.setString(1, t.getNom());
    pre.setDate(2, (Date) t.getStart());
    pre.setDate(3, (Date) t.getFinish());
    pre.setString(4, t.getDescription());
    pre.executeUpdate();
    }


   
    public void delete(int id) throws SQLException {
 
        PreparedStatement pre=con.prepareStatement("DELETE FROM `huntkingdomsymfony`.`season` WHERE `id`=?;");
    pre.setInt(1, id);
    pre.executeUpdate();
    }

//    @Override
//    public void update(Season t, int id) throws SQLException {
//
//        PreparedStatement pre=con.prepareStatement("UPDATE  `hunt`.`season` SET `idA`=?, `race`=?, `saison`=?, `place`=?, `image`=?  WHERE `idA`=?;");
//    pre.setInt(1, t.getIdA());
//    pre.setString(2, t.getRace());
//    pre.setString(3, t.getSaison());
//    pre.setString(4, t.getPlace());
//    pre.setString(5, t.getImage());
//    pre.setInt(6, id);
//    pre.executeUpdate();
//    }
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

    public List<Season> readAll() throws SQLException {
 
         List<Season> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from season");
     while (rs.next()) {    
               int id=rs.getInt(1);
               String nom =rs.getString(2);
               Date start=rs.getDate(3);
               Date finish=rs.getDate(4);  
               String description=rs.getString(5);
       
               Season p=new Season(id, nom, start, finish, description);
     arr.add(p);
     }
     return arr;
    
    }

  
    public List<Animal> readPanier(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    
    
}
