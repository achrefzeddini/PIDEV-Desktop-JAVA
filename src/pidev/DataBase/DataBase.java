package pidev.DataBase;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class DataBase {
    String url = "jdbc:mysql://localhost/huntkingdomsymfony";
    String login = "root";
    String password = "";
    
    public static DataBase database;
    public Connection connexion;
    
    private DataBase() {
         try {
             connexion=DriverManager.getConnection(url, login, password);
             System.out.println("connexion etablie");
         } catch (SQLException ex) {
             System.out.println(ex);
         }
    }
    
    public Connection  getConnection(){
    return connexion;
    }     
    
    public static DataBase getInstance(){
        if(database==null)
        database=new DataBase();
    return database;
    }         
}