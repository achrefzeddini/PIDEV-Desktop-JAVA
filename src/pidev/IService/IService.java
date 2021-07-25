/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.IService;

/**
 *
 * @author Testouri Mohamed
 */

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
//import pidev.Entite.Event;

/**
 *
 * @author House
 */
public interface IService<T> {
    void ajouter(T t) throws SQLException;
    void add(T t) throws SQLException;
    void delete(int id) throws SQLException;
    void delete (String mail) throws SQLException;
    void update(T t, int id) throws SQLException;
    List<T> readAll() throws SQLException;
List<T> readAll(int id) throws SQLException;
    /**
     *
     * @param id
     * @return
     * @throws SQLException
     */
    List<T> readALL(int id) throws SQLException;

    List<T> readPanier(int id) throws SQLException;
    void insert(T t);
    List<T> searchByIDuser(int idu) throws SQLException;
    List<T> sortByPrice();
    List<T> test(String a);
    List<T> getuserprod(int id);
    ArrayList<T> getAllReservations(int id);
    int reada() throws SQLException;
    int readb() throws SQLException;
    int read() throws SQLException;
    T getById(int idEvent) throws SQLException;
     List<T> searchByName(String titre);
}

