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
import pidev.Entite.Reservation;
import pidev.IService.IService;

/**
 *
 * @author USER
 */
public class ServiceReservation implements IService<Reservation> {

    private Connection con;
    private Statement ste;

    public ServiceReservation() {
        con = DataBase.getInstance().getConnection();
    }

//ajouter
    @Override
    public void ajouter(Reservation e) throws SQLException {
        PreparedStatement PS = con.prepareStatement("INSERT INTO `reservation`(id,dateReservation,quantite,total,type,seat,payer,nomReservation,idUser,idEvent)values(?,?,?,?,?,?,?,?,?,?)");
        PS.setInt(1,e.getId());
        PS.setString(2, e.getDateReservation());
        PS.setInt(3, e.getQuantite());
        PS.setDouble(4, e.getTotal());
        PS.setString(5, e.getType());
        PS.setString(6, e.getSeat());
        PS.setInt(7, e.getPayer());
        PS.setString(8, e.getNomReservation());
        PS.setInt(9, e.getIduser());
        PS.setInt(10, e.getIdevent());
        PS.executeUpdate();
    }
    
    
    
    
    @Override
    public void update(Reservation e, int id) throws SQLException {
        PreparedStatement PS=con.prepareStatement("UPDATE `reservation` SET `dateReservation`=?,`quantite`=?,`total`=?,`type`=?,`seat`=?,`payer`=?,`nomReservation`=? WHERE `id`=?");
        PS.setString(1, e.getDateReservation());
        PS.setInt(2, e.getQuantite());
        PS.setDouble(3, e.getTotal());
        PS.setString(4, e.getType());
        PS.setString(5, e.getSeat());
        PS.setInt(6, e.getPayer());
        PS.setString(7, e.getNomReservation());
        PS.setInt(8,id);
        PS.executeUpdate();
    
    }

     @Override
    public void delete(int id) throws SQLException {       
        PreparedStatement PS = con.prepareStatement("DELETE FROM `reservation` WHERE `id`=?");
        PS.setInt(1,id);
        PS.executeUpdate();
    }
    

    @Override
    public List<Reservation> readAll() throws SQLException {
        List<Reservation> AL = new ArrayList<>();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select * from reservation");
        while (rs.next()) {
            int id = rs.getInt("id");//(1);
            String dateReservation = rs.getString("dateReservation");
            int quantite = rs.getInt("quantite");//(6);
            double total = rs.getDouble("total");//(7);
            String type = rs.getString("type");//("type");
            String seat = rs.getString("seat");//("seat");
            int payer = rs.getInt("payer");//(5);
            String nomReservation = rs.getString("nomReservation");//("nomReservation");
            int iduser = rs.getInt("iduser");//(2);
            int idevent = rs.getInt("idevent");//(3);
            Reservation r = new Reservation(id,dateReservation,quantite,total,type,seat,payer,nomReservation,iduser,idevent);
            AL.add(r);
        }
        return AL;

    }

    //Rechercher Reservation par nom
    public ArrayList<Reservation> SearchPayedReservations(int id, String searchItem) {
        ArrayList<Reservation> reservations = new ArrayList();
        try {
            PreparedStatement st = con.prepareStatement("");
            int payer = 1;
            ResultSet resultset = st.executeQuery("select * from reservation where userId =" + id + " and payer=" + payer + " and 	nomReservation LIKE '%" + searchItem + "%'  ");
            resultset.beforeFirst();
            while (resultset.next()) {
                Reservation rs = new Reservation(resultset.getInt(1), resultset.getInt(2), resultset.getInt(3), resultset.getString(4), resultset.getInt(5), resultset.getDouble(6), resultset.getString(7), resultset.getString(8));
                rs.setNomReservation(resultset.getString(10));
                reservations.add(rs);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return reservations;
    }

   

    public List<Reservation> orderByName(int orderType) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  

   
    @Override
      public ArrayList<Reservation> getAllReservations(int id){
       ArrayList<Reservation> reservations = new ArrayList();
             try {
           //getAll reservations
           PreparedStatement st = con.prepareStatement("select * from reservation where user_id ="+id+" and event_id = ANY(SELECT id from event) and dateReservation>(SELECT dateevent from event)");
           ResultSet resultset = st.executeQuery();
           resultset.beforeFirst();
           while(resultset.next()){
           Reservation rs = new Reservation(resultset.getInt(1),resultset.getInt(2),resultset.getInt(3),resultset.getString(4),resultset.getInt(5),resultset.getDouble(6),resultset.getString(7),resultset.getString(8));
           rs.setNomReservation(resultset.getString(10));
           reservations.add(rs);
           }
           
           //getAll Reservations
            
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }          
        return reservations;  
    }

   

    
      

    @Override
    public void add(Reservation t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String mail) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Reservation> readAll(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Reservation> readALL(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Reservation> readPanier(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insert(Reservation t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Reservation> searchByIDuser(int idu) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Reservation> sortByPrice() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Reservation> test(String a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Reservation> getuserprod(int id) {
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
    public Reservation getById(int idEvent) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Reservation> searchByName(String titre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
