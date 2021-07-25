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
import pidev.Entite.GroupUser;
import pidev.IService.IService;

/**
 *
 * @author Testouri Mohamed
 */
public class GroupUserService implements IService<GroupUser>{
    private final Connection connexion;
    private Statement state;

    public GroupUserService() {
        connexion = DataBase.getInstance().getConnection();
    }

    @Override
    public void add(GroupUser gu) throws SQLException {
        PreparedStatement PrepState = connexion.prepareStatement("INSERT INTO groups_user (user_id,groups_id) VALUES (?, ?);");
        PrepState.setInt(1, gu.getUser_id());
        PrepState.setInt(2, gu.getGroups_id());
        PrepState.executeUpdate();
    }

//    @Override
//    public void delete(int idGroupUser) throws SQLException {
//        PreparedStatement PrepState = connexion.prepareStatement("DELETE FROM groups_user WHERE idGroupUser=?");
//        PrepState.setInt(1, idGroupUser);
//        PrepState.executeUpdate();
//    }
    public void delete(int user_id, int idGroup) throws SQLException{
        PreparedStatement PrepState = connexion.prepareStatement("DELETE FROM groups_user WHERE user_id=? AND idGroup=? ");
        PrepState.setInt(1, user_id);
        PrepState.setInt(2, idGroup);
        PrepState.executeUpdate();
    }

    @Override
    public void update(GroupUser gu, int idGroupUser) throws SQLException {
    PreparedStatement PrepState = connexion.prepareStatement("UPDATE groups_user SET user_id=? , idGroup=? WHERE idGroupUser=? ");
        PrepState.setInt(1, gu.getUser_id());
        PrepState.setInt(2, gu.getGroups_id());
        PrepState.executeUpdate();    
    }

    @Override
    public List<GroupUser> readAll(int id) throws SQLException {
     List<GroupUser> arrayGroupUser = new ArrayList<>();
            state = connexion.createStatement();
        ResultSet rs = state.executeQuery("SELECT * FROM groups_user WHERE groups_is="+String.valueOf(id));
        while (rs.next()) {
            arrayGroupUser.add(new GroupUser(rs.getInt(1), rs.getInt(2)));
            System.out.println(arrayGroupUser);
        }
        return arrayGroupUser;    
    }
    
    @Override
    public void delete(String email) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<GroupUser> readAll() throws SQLException {
    List<GroupUser> arrayGroupUser = new ArrayList<>();
            state = connexion.createStatement();
        ResultSet rs = state.executeQuery("SELECT * FROM groups_user");
        while (rs.next()) {
            arrayGroupUser.add(new GroupUser(rs.getInt(1), rs.getInt(2)));
            System.out.println(arrayGroupUser);
        }
        return arrayGroupUser;        
    }

    @Override
    public List<GroupUser> readALL(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ajouter(GroupUser t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<GroupUser> readPanier(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insert(GroupUser t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<GroupUser> searchByIDuser(int idu) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<GroupUser> sortByPrice() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<GroupUser> test(String a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<GroupUser> getuserprod(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<GroupUser> getAllReservations(int id) {
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
    public GroupUser getById(int idEvent) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<GroupUser> searchByName(String titre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
