/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.Entite;

import java.sql.Date;

/**
 *
 * @author hp
 */
public class Commande {
    private int id;
    private String produit;
    private java.sql.Date date;
    private int user_id;
    private double price;
    private int state;

    public Commande(int idCommande, String produit, Date date, int user_id, double price, int state) {
        this.id = idCommande;
        this.produit = produit;
        this.date = date;
        this.user_id = user_id;
        this.price = price;
        this.state = state;
    }

    public Commande(String produit, double price) {
        this.produit = produit;
        this.price = price;
    }

    public Commande(String produit, double price , int user_id) {
        this.produit = produit;
        this.user_id = user_id;
        this.price = price;
    }

    
    

   

    
    
    public Commande(String produit, Date date, int user_id, double price, int state) {
        this.produit = produit;
        this.date = date;
        this.user_id = user_id;
        this.price = price;
        this.state = state;
    }

    public Commande(int idCommande, String produit, Date date, int user_id, double price) {
        this.id = idCommande;
        this.produit = produit;
        this.date = date;
        this.user_id = user_id;
        this.price = price;
    }

   

    
    
    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
  

    public double getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    
    public Commande() {
    }

    public String getProduit() {
        return produit;
    }

    public void setProduit(String produit) {
        this.produit = produit;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

  

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
    

    @Override
    public String toString() {
        return "Commande{" + "idCommande=" + id + ", produit=" + produit + ", date=" + date + ", idUser=" + user_id + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    
}



///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package pidev.Entite;
//
//import java.sql.Date;
//
///**
// *
// * @author hp
// */
//public class Commande {
//    private int idCommande;
//    private String produit;
//    private java.sql.Date date;
//    private int idUser;
//    private float price;
//    private int state;
//
//    public Commande(String produit,float price,  int idUser,int state) {
//        this.produit = produit;
//        this.price = price;
//        this.idUser = idUser;
//        this.state = state;
//    }
//    
//    
//    
//    
//
//    public Commande(int idCommande, String produit, Date date, int idUser, float price, int state) {
//        this.idCommande = idCommande;
//        this.produit = produit;
//        this.date = date;
//        this.idUser = idUser;
//        this.price = price;
//        this.state = state;
//    }
//
//    
//   
//
//    
//    
//    public Commande(String produit, Date date, int idUser, float price, int state) {
//        this.produit = produit;
//        this.date = date;
//        this.idUser = idUser;
//        this.price = price;
//        this.state = state;
//    }
//
//    public Commande(int idCommande, String produit, Date date, int idUser, float price) {
//        this.idCommande = idCommande;
//        this.produit = produit;
//        this.date = date;
//        this.idUser = idUser;
//        this.price = price;
//    }
//
//   
//
//    
//    
//    public int getState() {
//        return state;
//    }
//
//    public void setState(int state) {
//        this.state = state;
//    }
//  
//
//    public float getPrice() {
//        return price;
//    }
//
//    public void setPrice(float price) {
//        this.price = price;
//    }
//    
//    public Commande() {
//    }
//
//    public String getProduit() {
//        return produit;
//    }
//
//    public void setProduit(String produit) {
//        this.produit = produit;
//    }
//
//
//    public int getIdCommande() {
//        return idCommande;
//    }
//
//
//    public int getIdUser() {
//        return idUser;
//    }
//
//    public void setIdCommande(int idCommande) {
//        this.idCommande = idCommande;
//    }
//
//    public Date getDate() {
//        return date;
//    }
//
//    public void setDate(Date date) {
//        this.date = date;
//    }
//
//  
//    
//
//    public void setIdUser(int idUser) {
//        this.idUser = idUser;
//    }
//
//
//    @Override
//    public String toString() {
//        return "Commande{" + "idCommande=" + idCommande + ", produit=" + produit + ", date=" + date + ", idUser=" + idUser + '}';
//    }
//
//    
//    
//}
