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
import javafx.collections.ObservableList;
import pidev.DataBase.DataBase;
import pidev.Entite.User;
import pidev.IService.IService;

/**
 *
 * @author Testouri Mohamed
 */
public class UserService implements IService<User> {

    private final Connection connexion;
    private Statement state;

    public UserService() {
        connexion = DataBase.getInstance().getConnection();
    }

    @Override
    public void add(User u) throws SQLException {
        PreparedStatement PrepState = connexion.prepareStatement("INSERT INTO User (fnameUser,lnameUser,phoneUser,idRole,emailUser,passwordUser) VALUES (?, ?, ?, 0, ?, ?);");
        PrepState.setString(1, u.getFnameUser());
        PrepState.setString(2, u.getLnameUser());
        PrepState.setInt(3, u.getPhoneUser());
        PrepState.setString(4, u.getEmailUser());
        PrepState.setString(5, u.getPasswordUser());
        PrepState.executeUpdate();
    }

    @Override
    public void delete(int id) throws SQLException {
        PreparedStatement PrepState = connexion.prepareStatement("DELETE FROM User WHERE id=?");
        PrepState.setInt(1, id);
        PrepState.executeUpdate();
    }

    /**
     *
     * @param emailUser
     * @throws SQLException
     */
    @Override
    public void delete(String emailUser) throws SQLException {
        PreparedStatement PrepState = connexion.prepareStatement("DELETE FROM User WHERE emailUser=?");
        PrepState.setString(1, emailUser);
        PrepState.executeUpdate();
    }

    @Override
    public List<User> readAll() throws SQLException {
        List<User> arrayUser = new ArrayList<>();
        state = connexion.createStatement();
        ResultSet rs = state.executeQuery("select id, fnameUser, lnameUser, phoneUser, emailUser, statutUser from User WHERE idRole=0");
        while (rs.next()) {
            arrayUser.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getInt(6)));
        }
        return arrayUser;
    }
//    @Override
//    public List<User> orderFname( int typeOrder) throws SQLException {
//        List<User> arrayUser = new ArrayList<>();
//        state = connexion.createStatement();
//        ResultSet rs = null;
//        
//        if (typeOrder == 0 ){
//       rs = state.executeQuery("select * from User");
//        } else if (typeOrder == 1){
//            rs = state.executeQuery("select * from User");
//        } else {
//            System.out.println("Choose Sorting Type");
//        }
//        while (rs.next()) {
//
//            arrayUser.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getString(6)));
//        }
//        return arrayUser;
//    }

    @Override
    public void update(User u, int id) throws SQLException {
        PreparedStatement PrepState = connexion.prepareStatement("UPDATE User SET fnameUser=? , lnameUser=? , phoneUser=? , emailUser=? WHERE id= ?");

        PrepState.setString(1, u.getFnameUser());
        PrepState.setString(2, u.getLnameUser());
        PrepState.setInt(3, u.getPhoneUser());
        PrepState.setString(4, u.getEmailUser());
        PrepState.setInt(5, id);
        PrepState.executeUpdate();
    }

    /**
     *
     * @param u
     * @param id
     * @param statutUser
     * @throws SQLException
     */
    public void update(int id, int statutUser) throws SQLException {
        PreparedStatement PrepState = connexion.prepareStatement("UPDATE User SET statutUser=? WHERE id=?");
        PrepState.setInt(1, statutUser);
        PrepState.setInt(2, id);
        PrepState.executeUpdate();
    }

    public void delete(ObservableList<User> User) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<User> readAll(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<User> readALL(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ajouter(User t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<User> readPanier(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insert(User t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<User> searchByIDuser(int idu) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<User> sortByPrice() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<User> test(String a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<User> getuserprod(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<User> getAllReservations(int id) {
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
    public User getById(int idEvent) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<User> searchByName(String titre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
