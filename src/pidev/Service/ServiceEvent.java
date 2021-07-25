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
import pidev.Entite.Event;
import pidev.IService.IService;
import java.util.logging.*;
import java.util.logging.Level;

/**
 *
 * @author USER
 */
public class ServiceEvent implements IService<Event>{
    private Connection con;
    private Statement ste ;
    
    public ServiceEvent(){
        con =DataBase.getInstance().getConnection();
    }

    @Override
    /*public void ajouter(Event t) throws SQLException {
      ste= con.createStatement();
      String requeteInsert="INSERT INTO `testevent`.`event` (`idEvent`,`idUser`,`titre`,`nbrplaces`,`localisation`,`hdebut`,`hfin`,`prix`)VALUES ('" +t.getIdEvent() + "' ,'" +t.getIdUser() + "','" +t.getTitre() +"' ,'" +t.getNbrplaces() +"' ,'" +t.getLocalisation() + "' ,'" +t.getHdebut()+ "' ,'" +t.getHfin()+ "' ,'" +t.getPrix()+ "' );";   
      ste.executeUpdate(requeteInsert);
    }*/
     public void ajouter(Event e) throws SQLException {
        PreparedStatement PS = con.prepareStatement("INSERT INTO `event` (`titre`,`image`,`nbrplaces`, `localisation`,`hdebut`,`hfin`,`prix`,`idUser`) VALUES (?, ?, ?, ?, ?, ?, ?, 1);");

        PS.setString(1,e.getTitre());
        PS.setString(2,e.getImage());
        PS.setInt(3,e.getNbrplaces());
        PS.setString(4, e.getLocalisation());
        PS.setFloat(5,e.getHdebut());
        PS.setFloat(6,e.getHfin());
        PS.setFloat(7,e.getPrix());
        PS.executeUpdate();
    }
     
      
    @Override
    public void delete(int id) throws SQLException {
        PreparedStatement PS = con.prepareStatement("DELETE FROM `event` WHERE `id`=?");
        PS.setInt(1,id);
        PS.executeUpdate();
    }

   

    @Override
    public void update(Event e, int id) throws SQLException {
        PreparedStatement PS=con.prepareStatement("UPDATE `event` SET `titre`=?,`nbrplaces`=?,`localisation`=?,`hdebut`=?,`hfin`=?,`prix`=? WHERE `id`=?");
        PS.setString(1,e.getTitre());
        PS.setInt(2,e.getNbrplaces());
        PS.setString(3,e.getLocalisation());
        PS.setFloat(4,e.getHdebut());
        PS.setFloat(5,e.getHfin());
        PS.setFloat(6,e.getPrix());
        PS.setInt(7,id);
        PS.executeUpdate();
    }

    @Override
    public List<Event> readAll() throws SQLException {
              List<Event> AL = new ArrayList<>();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select * from event");
        while (rs.next()) {
            int id = rs.getInt(1);
            String titre = rs.getString(2);
            String image = rs.getString(3);
            int nbrplaces = rs.getInt(4);
            String localisation = rs.getString(6);
            float hdebut =rs.getFloat(6);
            float hfin =rs.getFloat(7);
            float prix =rs.getFloat(8);
            int idUser = rs.getInt(9);
            
            
            
            Event e = new Event(id, titre, image, nbrplaces , localisation, hdebut, hfin, prix, idUser );
            AL.add(e);
        }
        return AL;
    
    }

    public List<Event> orderByName(int orderType) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     @Override
    public List<Event> searchByName(String titre) {
        
         List<Event> list= new ArrayList<>();
       
         try {
            
            ste=con.createStatement();
            String query="select * from menu where titre="+titre+"";
            ResultSet rs=ste.executeQuery(query);
            while(rs.next()){
//                String titre, int nbrplaces, String localisation, float hdebut, float hfin,String image, float prix
               // list.add(new productEntity(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getFloat(5) , rs.getObject(6) ));
                list.add(new Event(rs.getString(1),rs.getInt(2),rs.getString(3),rs.getFloat(4),rs.getFloat(5),rs.getString(6),rs.getFloat(7)));
            }
            
            
                    } catch (SQLException ex) {
            Logger.getLogger(Event.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    @Override
    public Event getById(int idEvent) throws SQLException {
        
        ste=con.createStatement();
        String query="select * from menu where id="+idEvent;
        ResultSet rs=ste.executeQuery(query);
        while(rs.next())
        {
            Event e;
            e = new Event(rs.getInt("id"),rs.getString("titre"),rs.getInt("nbrplaces"),rs.getString("localisation"),rs.getInt("hdebut"),rs.getInt("hfin"),rs.getInt("prix"));
            return e;
        }
        return null;
    } 

   

    @Override
    public ArrayList<Event> getAllReservations(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public int read() throws SQLException {
 
         
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select nbrplaces from event where `localisation`='ain drahem'");
     while (rs.next()) {    

               int nbrplaces=rs.getInt(1);
               rs.close();
               return nbrplaces;
  
     }
   return 0;
     }

    @Override
    public int reada() throws SQLException {
         ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select nbrplaces from event where `localisation`='testour'");
     while (rs.next()) {    

               int nbrplaces=rs.getInt(1);
               rs.close();
               return nbrplaces;
  
     }
   return 0;
     
    }

    @Override
    public int readb() throws SQLException {
       ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select nbrplaces from event where `localisation`='tunis'");
     while (rs.next()) {    

               int nbrplaces=rs.getInt(1);
               rs.close();
               return nbrplaces;
  
     }
   return 0;
    }

    @Override
    public void add(Event t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String mail) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Event> readAll(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Event> readALL(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Event> readPanier(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insert(Event t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Event> searchByIDuser(int idu) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Event> sortByPrice() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Event> test(String a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Event> getuserprod(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}



    
    
