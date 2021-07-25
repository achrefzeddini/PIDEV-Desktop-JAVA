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
import java.util.Date;
import java.util.List;
import pidev.DataBase.DataBase;
import pidev.Entite.Commentaire;
import pidev.GUI.Annonceid;
import pidev.IService.IService;

/**
 *
 * @author elhak
 */
public class ServiceCommentaire implements IService<Commentaire> {
    
    
    private Connection con;
    private Statement ste;

    public ServiceCommentaire() {
        con = DataBase.getInstance().getConnection();
    }

    @Override
    public void add(Commentaire c) throws SQLException {
        PreparedStatement PS = con.prepareStatement("INSERT INTO `huntkingdomsymfony`.`commentaire` (`annonce_id`,`user_id`,`champCommentaire`) VALUES (?, ?, ?)   ;"); //where `annonce_id`=?
        //
        PS.setInt(1,c.getAnnonce_id());
        PS.setInt(2,c.getUser_id());
        PS.setString(3,c.getChampCommentaire());
//        PS.setInt(4,c.getAnnonce_id());
        PS.executeUpdate();
    }

    @Override
    public void delete(int id) throws SQLException {
        PreparedStatement PS = con.prepareStatement("DELETE FROM `huntkingdomsymfony`.`commentaire` WHERE `id`=?");
        PS.setInt(1,id);       
        PS.executeUpdate();
    }

    @Override
    public void update(Commentaire c, int id) throws SQLException {
        PreparedStatement PS=con.prepareStatement("UPDATE `huntkingdomsymfony`.`commentaire` SET `champCommentaire`=? WHERE `user_id`=?");
        PS.setString(1,c.getChampCommentaire());
        PS.setInt(2,id);
        PS.executeUpdate();
    }

    @Override
    public List<Commentaire> readAll() throws SQLException {
        List<Commentaire> AL = new ArrayList<>();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select * from commentaire");
        while (rs.next()) {
            int id = rs.getInt(1);
            int annonce_id = rs.getInt(2);
            int user_id = rs.getInt(3);
            String champCommentaire = rs.getString(4);
            Date dateCommentaire = rs.getDate(5);
            Commentaire c = new Commentaire(id,annonce_id,user_id,champCommentaire,dateCommentaire);
            AL.add(c);
        }
        return AL;
    }
    
    
    public List<Commentaire> readCom( int annonce_id) throws SQLException {
        List<Commentaire> AL = new ArrayList<>();
        PreparedStatement pste = con.prepareStatement("select user_id,champCommentaire,dateCommentaire from commentaire where annonce_id=?;");
        pste.setInt(1,annonce_id);
        ResultSet rs = pste.executeQuery();
        
        while (rs.next()) {
            
            int user_id = rs.getInt(1);
            String champCommentaire = rs.getString(2);
            Date dateCommentaire = rs.getDate(3);
            Commentaire c = new Commentaire(user_id,champCommentaire,dateCommentaire);
            AL.add(c);
        }
        return AL;
    }

    @Override
    public void ajouter(Commentaire t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String mail) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Commentaire> readAll(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Commentaire> readALL(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Commentaire> readPanier(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insert(Commentaire t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Commentaire> searchByIDuser(int idu) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Commentaire> sortByPrice() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Commentaire> test(String a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Commentaire> getuserprod(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Commentaire> getAllReservations(int id) {
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
    public Commentaire getById(int idEvent) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Commentaire> searchByName(String titre) {
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
//import pidev.Entite.Commentaire;
//import pidev.GUI.Annonceid;
//import pidev.IService.IService;
//
///**
// *
// * @author elhak
// */
//public class ServiceCommentaire implements IService<Commentaire> {
//    
//    
//    private Connection con;
//    private Statement ste;
//
//    public ServiceCommentaire() {
//        con = DataBase.getInstance().getConnection();
//    }
//
//    @Override
//    public void ajouter(Commentaire c) throws SQLException {
//        PreparedStatement PS = con.prepareStatement("INSERT INTO `commentaire` (`idUser`,`idAnnonceRS`,`idCommentaireRS`,`champCommentaire`) VALUES (?, ?, ?, ?);");
//        PS.setInt(1,c.getIdUser());
//        PS.setInt(2,c.getIdAnnonceRS());
//        PS.setInt(3,c.getIdCommentaireRS());
//        PS.setString(4,c.getChampCommentaire());
//        PS.executeUpdate();
//    }
//    
//    public void ajouterCom(Commentaire c) throws SQLException {
//        PreparedStatement PS = con.prepareStatement("INSERT INTO `commentaire` (`idUser`,`idAnnonceRS`,`champCommentaire`) VALUES (?, ?, ?);");
//        PS.setInt(1,c.getIdUser());
//        PS.setInt(2,c.getIdAnnonceRS());
//        PS.setString(3,c.getChampCommentaire());
//        PS.executeUpdate();
//    }
//    
//
//    @Override
//    public void delete(int id) throws SQLException {
//        PreparedStatement PS = con.prepareStatement("DELETE FROM `commentaire` WHERE `idCommentaire`=?");
//        PS.setInt(1,id);       
//        PS.executeUpdate();
//    }
//
//    @Override
//    public void update(Commentaire c, int id) throws SQLException {
//        PreparedStatement PS=con.prepareStatement("UPDATE `commentaire` SET `champCommentaire`=? WHERE `idUser`=?");
//        PS.setString(1,c.getChampCommentaire());
//        PS.setInt(2,id);
//        PS.executeUpdate();
//    }
//
//    @Override
//    public List<Commentaire> readAll() throws SQLException {
//        List<Commentaire> AL = new ArrayList<>();
//        ste = con.createStatement();
//        ResultSet rs = ste.executeQuery("select * from commentaire");
//        while (rs.next()) {
//            int idCommentaire = rs.getInt(1);
//            int idCommentaireRS = rs.getInt(2);
//            int idUser = rs.getInt(3);
//            int idAnnonceRS = rs.getInt(4);
//            String champCommentaire = rs.getString(5);
//            String dateCommentaire = rs.getString(6);
//            Commentaire c = new Commentaire(idCommentaire,idCommentaireRS,idUser,idAnnonceRS,champCommentaire,dateCommentaire);
//            AL.add(c);
//        }
//        return AL;
//    }
//    
//    
//    public List<Commentaire> readCom( int idAnnonce) throws SQLException {
//        List<Commentaire> AL = new ArrayList<>();
//        PreparedStatement pste = con.prepareStatement("select idUser,champCommentaire,dateCommentaire from commentaire where idAnnonceRS=?;");
//        pste.setInt(1, idAnnonce);
//        ResultSet rs = pste.executeQuery();
//        
//        while (rs.next()) {
////            int idCommentaire = rs.getInt(1);
////            int idCommentaireRS = rs.getInt(2);
//            int idUser = rs.getInt(1);
////            int idAnnonceRS = rs.getInt(4);
//            String champCommentaire = rs.getString(2);
//            String dateCommentaire = rs.getString(3);
//            Commentaire c = new Commentaire(idUser,champCommentaire,dateCommentaire);
//            AL.add(c);
//        }
//        return AL;
//    }
//
//    @Override
//    public void add(Commentaire t) throws SQLException {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void delete(String mail) throws SQLException {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public List<Commentaire> readAll(int id) throws SQLException {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public List<Commentaire> readALL(int id) throws SQLException {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public List<Commentaire> readPanier(int id) throws SQLException {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void insert(Commentaire t) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public List<Commentaire> searchByIDuser(int idu) throws SQLException {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public List<Commentaire> sortByPrice() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public List<Commentaire> test(String a) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public List<Commentaire> getuserprod(int id) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public ArrayList<Commentaire> getAllReservations(int id) {
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
//    public Commentaire getById(int idEvent) throws SQLException {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public List<Commentaire> searchByName(String titre) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//    
//}
