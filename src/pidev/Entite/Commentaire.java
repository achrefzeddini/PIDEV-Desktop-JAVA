/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.Entite;

import java.util.Date;


public class Commentaire {
    private int id;
    private int annonce_id;
    private int user_id;
    private String champCommentaire;
    private Date dateCommentaire;

    public Commentaire() {
    }

    //add
    public Commentaire(int user_id, String champCommentaire) {
    //    this.annonce_id = annonce_id ;
        this.user_id = user_id;
        this.champCommentaire = champCommentaire;
    }
    
    
    public Commentaire(int annonce_id,int user_id, String champCommentaire) {
        this.annonce_id = annonce_id ;
        this.user_id = user_id;
        this.champCommentaire = champCommentaire;
    }
    
    
    
    
    public Commentaire(int user_id, String champCommentaire, Date dateCommentaire) {
        this.user_id = user_id;
        this.champCommentaire = champCommentaire;
        this.dateCommentaire = dateCommentaire;
    }

    //display
    public Commentaire(int id, int annonce_id, int user_id, String champCommentaire, Date dateCommentaire) {
        this.id = id;
        this.annonce_id = annonce_id;
        this.user_id = user_id;
        this.champCommentaire = champCommentaire;
        this.dateCommentaire = dateCommentaire;
    }

   

   
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAnnonce_id() {
        return annonce_id;
    }

    public void setAnnonce_id(int annonce_id) {
        this.annonce_id = annonce_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getChampCommentaire() {
        return champCommentaire;
    }

    public void setChampCommentaire(String champCommentaire) {
        this.champCommentaire = champCommentaire;
    }

    public Date getDateCommentaire() {
        return dateCommentaire;
    }

    public void setDateCommentaire(Date dateCommentaire) {
        this.dateCommentaire = dateCommentaire;
    }

    @Override
    public String toString() {
        return "Commentaire{" + "id=" + id + ", annonce_id=" + annonce_id + ", user_id=" + user_id + ", champCommentaire=" + champCommentaire + ", dateCommentaire=" + dateCommentaire + '}';
    }

    
    
    
}




///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package pidev.Entite;
//
//
//public class Commentaire {
//    private int idCommentaire;
//    private int idCommentaireRS;
//    private int idUser;
//    private int idAnnonceRS;
//    private String champCommentaire;
//    private String dateCommentaire;
//
//    public Commentaire() {
//    }
//
//    public Commentaire(int idUser, String champCommentaire, String dateCommentaire) {
//        this.idUser = idUser;
//        this.champCommentaire = champCommentaire;
//        this.dateCommentaire = dateCommentaire;
//    }
//
//    public Commentaire(int idUser,int idAnnonceRS, String champCommentaire) {
//        this.idUser = idUser;
//        this.idAnnonceRS = idAnnonceRS;
//        this.champCommentaire = champCommentaire;
//        
//    }
//           
//    
//    
//    public Commentaire(int idUser,int idAnnonceRS,int idCommentaireRS, String champCommentaire) {
//        this.idUser = idUser;
//        this.idAnnonceRS = idAnnonceRS;
//        this.idCommentaireRS = idCommentaireRS;
//        this.champCommentaire = champCommentaire;
//    }
//
//    public Commentaire(int idCommentaire, int idCommentaireRS, int idUser, int idAnnonceRS , String champCommentaire, String dateCommentaire) {
//        this.idCommentaire = idCommentaire;
//        this.idCommentaireRS = idCommentaireRS;
//        this.idUser = idUser;
//        this.idAnnonceRS = idAnnonceRS;
//        this.champCommentaire = champCommentaire;
//        this.dateCommentaire = dateCommentaire;
//    }
//
//    public int getIdCommentaire() {
//        return idCommentaire;
//    }
//
//    public void setIdCommentaire(int idCommentaire) {
//        this.idCommentaire = idCommentaire;
//    }
//
//    public int getIdCommentaireRS() {
//        return idCommentaireRS;
//    }
//
//    public void setIdCommentaireRS(int idCommentaireRS) {
//        this.idCommentaireRS = idCommentaireRS;
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
//    public int getIdAnnonceRS() {
//        return idAnnonceRS;
//    }
//
//    public void setIdAnnonceRS(int idAnnonce) {
//        this.idAnnonceRS = idAnnonce;
//    }
//
//    public String getChampCommentaire() {
//        return champCommentaire;
//    }
//
//    public void setChampCommentaire(String champCommentaire) {
//        this.champCommentaire = champCommentaire;
//    }
//
//    public String getDateCommentaire() {
//        return dateCommentaire;
//    }
//
//    public void setDateCommentaire(String dateCommentaire) {
//        this.dateCommentaire = dateCommentaire;
//    }
//
//    @Override
//    public String toString() {
//        return "Commentaire{" + "idCommentaire=" + idCommentaire + ", idCommentaireRS=" + idCommentaireRS + ", idUser=" + idUser + ", idAnnonceRS=" + idAnnonceRS + ", champCommentaire=" + champCommentaire + ", dateCommentaire=" + dateCommentaire + '}';
//    }
//
//    
//    
//    
//    
//    
//}
