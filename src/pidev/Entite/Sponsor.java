/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.Entite;

/**
 *
 * @author USER
 */
public class Sponsor {

    private int id;
    private String nom;
    private int idEvent;
    private int confirmation;
    private String mailSponsor;

    public Sponsor() {
    }

    
    
    
    public Sponsor(int id, String nom, int confirmation, String mailSponsor, int idEvent) {
        this.id = id;
        this.nom = nom;
        this.confirmation = confirmation;
        this.mailSponsor = mailSponsor;
        this.idEvent = idEvent;
    }
    


    //ctr rech
    public Sponsor(String nom, int confirmation, int idEvent,  String mailSponsor) {
        this.nom = nom;
        this.confirmation = confirmation;
            this.idEvent=idEvent;
        this.mailSponsor = mailSponsor;
    

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

   

    public String getNom() {
        return nom;
    }

    public void setIdUser(String nom) {
        this.nom = nom;
    }

    public int getIdEvent() {
        return idEvent;
    }

    public void getIdEvent(int idEvent) {
        this.idEvent = idEvent;
    }

    public int getConfirmation() {
        return confirmation;
    }

    public void setConfirmation(int confirmation) {
        this.confirmation = confirmation;
    }

    public String getMailSponsor() {
        return mailSponsor;
    }

    public void getMailSponsor(String mailSponsor) {
        this.mailSponsor = mailSponsor;
    }

    @Override
    public String toString() {
        return "Sponsor{" + "id=" + id + ", nom=" + nom + ", idEvent=" + idEvent + ", confirmation=" + confirmation + ", mailSponsor=" + mailSponsor + '}';
    }

 
}
