/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.Entite;

import java.sql.Date;

/**
 *
 * @author USER
 */
public class Event {
    int id;
    String titre;  
    String image;
    int nbrplaces ;
    String localisation ;
    float hdebut ;
    float hfin ; 
    float prix ;
    int idUser;

    public Event(int id, String titre, String image, int nbrplaces, String localisation, float hdebut, float hfin, float prix, int idUser) {
        this.id = id;
        this.titre = titre;
        this.image = image;
        this.nbrplaces = nbrplaces;
        this.localisation = localisation;
        this.hdebut = hdebut;
        this.hfin = hfin;
        this.prix = prix;
        this.idUser = idUser;
    }


    public Event(String titre, int nbrplaces, String localisation, float hdebut, float hfin,String image, float prix) {
        this.titre = titre;
        this.nbrplaces = nbrplaces;
        this.localisation = localisation;
        this.hdebut = hdebut;
        this.hfin = hfin;
        this.image = image;
        this.prix = prix;
    }

    
    public Event() {
    }

    public Event(String titre, int nbrplaces, String localisation, float hdebut, float hfin, float prix) {
     
        this.titre = titre;
        this.nbrplaces = nbrplaces;
        this.localisation = localisation;
        this.hdebut = hdebut;
        this.hfin = hfin;
        this.prix = prix;
    }

    
    public Event(int idEvent, String string, int aInt0, String string0, int aInt1, int aInt2, int aInt3) {}
    
   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    
    
    
    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public int getNbrplaces() {
        return nbrplaces;
    }

    public void setNbrplaces(int nbrplaces) {
        this.nbrplaces = nbrplaces;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public float getHdebut() {
        return hdebut;
    }

    public void setHdebut(float hdebut) {
        this.hdebut = hdebut;
    }

    public float getHfin() {
        return hfin;
    }

    public void setHfin(float hfin) {
        this.hfin = hfin;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "Event{" + "id=" + id + ", idUser=" + idUser + ", titre=" + titre + ", nbrplaces=" + nbrplaces + ", localisation=" + localisation + ", hdebut=" + hdebut + ", hfin=" + hfin + ", image=" + image + ", prix=" + prix + '}';
    }

    
    
    
    
    
}
