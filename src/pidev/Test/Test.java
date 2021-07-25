/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.Test;

import java.sql.SQLException;
import java.util.List;
import pidev.Entite.Groups;
import pidev.Entite.User;
import pidev.GUI.CheckUserGroupScreenController;
import pidev.Service.GroupService;
import pidev.Service.UserService;
import pidev.Entite.Annonce;
import pidev.Entite.Commentaire;
import pidev.Service.ServiceAnnonce;
import pidev.Service.ServiceCommentaire;

/**
 *
 * @author Testouri Mohamed
 */
public class Test {

    public static void main(String[] args) throws SQLException {
        CheckUserGroupScreenController CUGC = new CheckUserGroupScreenController();
        List<Groups> arraytest = CUGC.insertAll(55);
        System.out.println(arraytest);
//        SendMail.sendMail("m.testoury@outlook.fr", "ll ", "test");
//        SendMail.sendMail("amel.khelifa@esprit.tn", "ll ", "test");
//        ServiceAnnonce SA = new ServiceAnnonce();
//        UserService US = new UserService();
//        GroupService GS = new GroupService();
//        ServiceAnimal sera = new ServiceAnimal();
//        ServiceCommande ser = new ServiceCommande();

//        Annonce a1 = new Annonce(123, "Cication du jour", " Pour être appréciée à sa juste valeur une randonnée pédestre devrait être entreprise seul. La marche à plusieurs, ou même à deux, n’a plus de randonnée que le nom ; c’est quelque chose d’autre, qui ressemble à un pique-nique. Une randonnée pédestre devrait être entreprise seul, parce que la liberté en est l’essence.", 456);
//        Annonce a2 = new Annonce(789, "Bon plan !! ", " voici une liste de bon plans qu'on a voulu partager avec vous ! ", 1011);
//
//        Annonce a4 = new Annonce(12, "updated ", "yeaaaaaas ! ", 1314);
//        List<Groups> listGroup = GS.readAll();
//        List<Users> listUser = US.readAll();
//        Animal p1 = new Animal(1, "fish", "all", "bizerte");
//        Commande p2 = new Commande(2, "09-02-2020", 2);
//
//        User u1 = new User("test100", "test100", 22222860, 1, "mohamed.testouri@esprit.tn", "HelloJava");
//        User u2 = new User("3a", "3a", 0, "3a2@esprit.tn", "Hello Java");
//        Groups g1 = new Groups("Test 100", "test 100");
//        Groups g2 = new Groups("TEst", "teST");
        //US.add(u2);
        //US.add(u1);
        //US.update(u2, 37);
        //GS.add(g1);
        //GS.add(g2);
        //GS.update(g2, 10);
        //GS.add(g2);
//        US.delete(37);
//GS.delete(10);
//        System.out.println(listUser);
//        System.out.println(listGroup);
//      sera.add(p1);
        //      ser.add(p2);
        //US.delete("mohamed.testouri@esprit.tn");
        ServiceAnnonce SA = new ServiceAnnonce();
        ServiceCommentaire SC = new ServiceCommentaire();
        
        System.out.println(SC.readCom(428));
        
//
//        Annonce a1 = new Annonce(428,2,"Bon Plan ", "Annonce bon plan modifiéé ");
//               
//        
//        
//        
//
//        Commentaire c1 = new Commentaire(2,428,25,"commentaire modifiéé");
//        Commentaire c2 = new Commentaire(2,428,25,"commentaire jdiiiiddd");
//
//        try {
//            
//            
//            //SA.ajouter1(a1);      //(`idAnnonce`,`nomAnnonce`,`descriptionAnnonce`,`idUser`)
//
//            //SA.update(a1,428);        
//            //SA.delete(428);
//            
//            
//            //SC.ajouter(c2);       //(`idUser`,`idAnnonce`,`idCommentaireRS`,`champCommentaire`)
//            //SC.update(c1, 1);
//            //SC.delete(25);
//            
//            List<Annonce> list = SA.readAll();
//            System.out.println(list);
//
//            List<Commentaire> listC = SC.readAll();
//            System.out.println(listC);  
//
//
//        } catch (SQLException ex) {
//            System.out.println(ex);
//        }
//    }

}}
