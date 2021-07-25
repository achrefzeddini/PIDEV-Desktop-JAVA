/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.Entite;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author hp
 */
public class Animal {
    
    private int id ;
    private int idA ;
    private String race ;
    private String saison ;
    private String place ;
    private String image;
    private ImageView im;
    private int hunted;
    private int season_id;

    public Animal(int id, int idA, String race, String saison, String place, String image, int hunted) {
        this.id = id;
        this.idA = idA;
        this.race = race;
        this.saison = saison;
        this.place = place;
        this.image = image;
        this.hunted = hunted;
    }

    public Animal(int id, int idA, String race, String saison, String place, String image, ImageView im, int hunted, int season_id) {
        this.id = id;
        this.idA = idA;
        this.race = race;
        this.saison = saison;
        this.place = place;
        this.image = image;
        this.im = im;
        this.hunted = hunted;
        this.season_id = season_id;
    }

    public Animal(int idA, String race, String saison, String place, String image, ImageView im, int hunted, int season_id) {
        this.idA = idA;
        this.race = race;
        this.saison = saison;
        this.place = place;
        this.image = image;
        this.im = im;
        this.hunted = hunted;
        this.season_id = season_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSeason_id() {
        return season_id;
    }

    public void setSeason_id(int season_id) {
        this.season_id = season_id;
    }

    
    
    
    public int getHunted() {
        return hunted;
    }

    public Animal(int hunted) {
        this.hunted = hunted;
    }

    
    
    public void setHunted(int hunted) {
        this.hunted = hunted;
    }
    
    

    public ImageView getIm() {
        return im;
    }

    public void setIm(ImageView im) {
        this.im = im;
    }
    

    public Animal(int id, int idA, String race, String saison, String place, ImageView im) {
        this.id = id;
        this.idA = idA;
        this.race = race;
        this.saison = saison;
        this.place = place;
        this.im = im;
    }

    
    public Animal(int idA, String race, String saison, String place, String image) {
        this.idA = idA;
        this.race = race;
        this.saison = saison;
        this.place = place;
        this.image = image;
    }

    public Animal(int id, int idA, String race, String saison, String place, String image) {
        this.id = id;
        this.idA = idA;
        this.race = race;
        this.saison = saison;
        this.place = place;
        this.image = image;
    }

    public Animal(int id, int idA, String race, String saison, String place) {
        this.id = id;
        this.idA = idA;
        this.race = race;
        this.saison = saison;
        this.place = place;
    }
    
    

    public Animal(int idA, String race, String saison, String place) {
        this.idA = idA;
        this.race = race;
        this.saison = saison;
        this.place = place;
    }


    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getSaison() {
        return saison;
    }

    public void setSaison(String saison) {
        this.saison = saison;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public int getIdA() {
        return idA;
    }

    public void setIdA(int idA) {
        this.idA = idA;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    
    
    @Override
    public String toString() {
        return "Animal{" + "idAnimal=" + id + ", idA=" + idA + ", race=" + race + ", saison=" + saison + ", place=" + place + '}';
    }

    
    
    
    
}



///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package pidev.Entite;
//
//import javafx.scene.image.Image;
//import javafx.scene.image.ImageView;
//
///**
// *
// * @author hp
// */
//public class Animal {
//    
//    private int idAnimal ;
//    private int idA ;
//    private String race ;
//    private String saison ;
//    private String place ;
//    private String image;
//    private ImageView im;
//    private int hunted;
//
//    public Animal(int idAnimal, int idA, String race, String saison, String place, String image, int hunted) {
//        this.idAnimal = idAnimal;
//        this.idA = idA;
//        this.race = race;
//        this.saison = saison;
//        this.place = place;
//        this.image = image;
//        this.hunted = hunted;
//    }
//
//    
//    
//    
//    public int getHunted() {
//        return hunted;
//    }
//
//    public Animal(int hunted) {
//        this.hunted = hunted;
//    }
//
//    
//    
//    public void setHunted(int hunted) {
//        this.hunted = hunted;
//    }
//    
//    
//
//    public ImageView getIm() {
//        return im;
//    }
//
//    public void setIm(ImageView im) {
//        this.im = im;
//    }
//    
//
//    public Animal(int idAnimal, int idA, String race, String saison, String place, ImageView im) {
//        this.idAnimal = idAnimal;
//        this.idA = idA;
//        this.race = race;
//        this.saison = saison;
//        this.place = place;
//        this.im = im;
//    }
//
//    
//    public Animal(int idA, String race, String saison, String place, String image) {
//        this.idA = idA;
//        this.race = race;
//        this.saison = saison;
//        this.place = place;
//        this.image = image;
//    }
//
//    public Animal(int idAnimal, int idA, String race, String saison, String place, String image) {
//        this.idAnimal = idAnimal;
//        this.idA = idA;
//        this.race = race;
//        this.saison = saison;
//        this.place = place;
//        this.image = image;
//    }
//
//    public Animal(int idAnimal, int idA, String race, String saison, String place) {
//        this.idAnimal = idAnimal;
//        this.idA = idA;
//        this.race = race;
//        this.saison = saison;
//        this.place = place;
//    }
//    
//    
//
//    public Animal(int idA, String race, String saison, String place) {
//        this.idA = idA;
//        this.race = race;
//        this.saison = saison;
//        this.place = place;
//    }
//
//    public int getIdAnimal() {
//        return idAnimal;
//    }
//
//    public void setIdAnimal(int idAnimal) {
//        this.idAnimal = idAnimal;
//    }
//
//    public String getRace() {
//        return race;
//    }
//
//    public void setRace(String race) {
//        this.race = race;
//    }
//
//    public String getSaison() {
//        return saison;
//    }
//
//    public void setSaison(String saison) {
//        this.saison = saison;
//    }
//
//    public String getPlace() {
//        return place;
//    }
//
//    public void setPlace(String place) {
//        this.place = place;
//    }
//
//    public int getIdA() {
//        return idA;
//    }
//
//    public void setIdA(int idA) {
//        this.idA = idA;
//    }
//
//    public void setImage(String image) {
//        this.image = image;
//    }
//
//    public String getImage() {
//        return image;
//    }
//
//    
//    
//    @Override
//    public String toString() {
//        return "Animal{" + "idAnimal=" + idAnimal + ", idA=" + idA + ", race=" + race + ", saison=" + saison + ", place=" + place + '}';
//    }
//
//    
//    
//    
//    
//}
