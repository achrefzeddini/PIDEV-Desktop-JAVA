/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.Entite;

import java.util.Date;


public class Annonce {
    private int id;
    private int user_id;
    private String nomAnnonce;
    private String descriptionAnnonce;
    private Date dateAnnonce;
    
    public Annonce() {
    }
    
    //add fxml
    public Annonce(int user_id, String nomAnnonce, String descriptionAnnonce) {
        this.user_id = user_id;
        this.nomAnnonce = nomAnnonce;
        this.descriptionAnnonce = descriptionAnnonce;
    }
  
  
    //update fxml
    public Annonce(String nomAnnonce, String descriptionAnnonce) {
        this.nomAnnonce = nomAnnonce;
        this.descriptionAnnonce = descriptionAnnonce;
    }
   

    //display
    public Annonce(int idAnnonce, int user_id, String nomAnnonce, String descriptionAnnonce, Date dateAnnonce) {
        this.id = idAnnonce;
        this.user_id = user_id;
        this.nomAnnonce = nomAnnonce;
        this.descriptionAnnonce = descriptionAnnonce;
        this.dateAnnonce = dateAnnonce;
    }

    @Override
    public String toString() {
        return "Annonce{" + "id=" + id + ", user_id=" + user_id + ", nomAnnonce=" + nomAnnonce + ", descriptionAnnonce=" + descriptionAnnonce + ", dateAnnonce=" + dateAnnonce + '}';
    }

        

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getNomAnnonce() {
        return nomAnnonce;
    }

    public void setNomAnnonce(String nomAnnonce) {
        this.nomAnnonce = nomAnnonce;
    }

    public String getDescriptionAnnonce() {
        return descriptionAnnonce;
    }

    public void setDescriptionAnnonce(String descriptionAnnonce) {
        this.descriptionAnnonce = descriptionAnnonce;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public Date getDateAnnonce() {
        return dateAnnonce;
    }

    public void setDateAnnonce(Date dateAnnonce) {
        this.dateAnnonce = dateAnnonce;
    }
   
    
    

    
}






///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package pidev.Entite;
//
///**
// *
// * @author Testouri Mohamed
// */
//public class Annonce {
//    private int idAnnonce;
//    private int idAnnonceRS;
//    private String nomAnnonce;
//    private String descriptionAnnonce;
//    private int idUser;
//
//    public Annonce() {
//    }
//    
//    //add fxml
//    public Annonce(String nomAnnonce, String descriptionAnnonce) {
//        this.nomAnnonce = nomAnnonce;
//        this.descriptionAnnonce = descriptionAnnonce;
//    }
//
//    //ajout fxml
//    public Annonce(int idAnnonceRS, String nomAnnonce, String descriptionAnnonce) {
//        this.idAnnonceRS = idAnnonceRS;
//        this.nomAnnonce = nomAnnonce;
//        this.descriptionAnnonce = descriptionAnnonce;
//    }
//    
//    
//
//    public Annonce(int idAnnonce, int idAnnonceRS, String nomAnnonce, String descriptionAnnonce, int idUser) {
//        this.idAnnonce = idAnnonce;
//        this.idAnnonceRS = idAnnonceRS;
//        this.nomAnnonce = nomAnnonce;
//        this.descriptionAnnonce = descriptionAnnonce;
//        this.idUser = idUser;
//    }
//
//    public Annonce(int idAnnonceRS, int idUser, String nomAnnonce, String descriptionAnnonce) {
//        this.idAnnonceRS = idAnnonceRS;
//        this.idUser = idUser;
//        this.nomAnnonce = nomAnnonce;
//        this.descriptionAnnonce = descriptionAnnonce;
//    }
//
//    public int getIdAnnonce() {
//        return idAnnonce;
//    }
//
//    public void setIdAnnonce(int idAnnonce) {
//        this.idAnnonce = idAnnonce;
//    }
//
//    public int getIdAnnonceRS() {
//        return idAnnonceRS;
//    }
//
//    public void setIdAnnonceRS(int idAnnonceRS) {
//        this.idAnnonceRS = idAnnonceRS;
//    }
//
//    public String getNomAnnonce() {
//        return nomAnnonce;
//    }
//
//    public void setNomAnnonce(String nomAnnonce) {
//        this.nomAnnonce = nomAnnonce;
//    }
//
//    public String getDescriptionAnnonce() {
//        return descriptionAnnonce;
//    }
//
//    public void setDescriptionAnnonce(String descriptionAnnonce) {
//        this.descriptionAnnonce = descriptionAnnonce;
//    }
//
//    public int getIdUser() {
//        return idUser;
//    }
//
//    public void setIdUser(int idUser) {
//        this.idUser = idUser;
//    }
//
//    @Override
//    public String toString() {
//        return "Annonce{" + "idAnnonce=" + idAnnonce + ", idAnnonceRS=" + idAnnonceRS + ", nomAnnonce=" + nomAnnonce + ", descriptionAnnonce=" + descriptionAnnonce + ", idUser=" + idUser + '}';
//    }
//    
//    
//    
//
//    
//}
