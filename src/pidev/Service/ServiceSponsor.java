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
import pidev.Entite.Sponsor;
import pidev.IService.IService;

/**
 *
 * @author USER
 */
public class ServiceSponsor implements IService<Sponsor> {

    private Connection con;
    private Statement ste;

    public ServiceSponsor() {
        con = DataBase.getInstance().getConnection();
    }

    @Override
    public void ajouter(Sponsor t) throws SQLException {
        ste = con.createStatement();
        String requeteInsert = "INSERT INTO `sponsor` (`nom`,`idEvent`,`confirmation`,`mailSponsor`)VALUES ('" + t.getNom() + "','" + t.getIdEvent() + "' ,'" + t.getConfirmation() + "','" + t.getMailSponsor() + "' );";
        ste.executeUpdate(requeteInsert);
    }

    @Override
    public void delete(int id) throws SQLException {
        PreparedStatement PS = con.prepareStatement("DELETE FROM `sponsor` WHERE `id`=?");
        PS.setInt(1, id);
        PS.executeUpdate();
    }

    @Override
    public void update(Sponsor e, int id) throws SQLException {
        PreparedStatement PS = con.prepareStatement("UPDATE `sponsor` SET `nom`=? ,confirmation`=?, `idevent`=?, `mailSponsor`=? WHERE `id`=?");
        
        PS.setString(1, e.getNom());
        PS.setInt(2, e.getConfirmation());
        PS.setInt(3, e.getIdEvent());
        PS.setString(4, e.getMailSponsor());
        PS.setInt(5,id);
       
        PS.executeUpdate();

    }

    @Override
    public List<Sponsor> readAll() throws SQLException {
        List<Sponsor> AL = new ArrayList<>();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select * from sponsor");
        while (rs.next()) {
            int ids = rs.getInt(1);
            String nom = rs.getString(2);
            int confirmation = rs.getInt(3);
            String mailSponsor = rs.getString(4);
            int idEvent = rs.getInt(5);
            Sponsor e = new Sponsor(ids, nom , confirmation , mailSponsor, idEvent);
            AL.add(e);
        }
        return AL;

    }

    public List<Sponsor> orderByName(int orderType) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    @Override
    public void add(Sponsor t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String mail) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Sponsor> readAll(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Sponsor> readALL(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Sponsor> readPanier(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insert(Sponsor t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Sponsor> searchByIDuser(int idu) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Sponsor> sortByPrice() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Sponsor> test(String a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Sponsor> getuserprod(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Sponsor> getAllReservations(int id) {
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
    public Sponsor getById(int idEvent) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Sponsor> searchByName(String titre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
