/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.Entite;

/**
 *
 * @author Testouri Mohamed
 */
public class CurrentUser {

    private static int id;
    private static String mail;

    public static void setMail(String mail) {
        CurrentUser.mail = mail;
    }

    public static String getMail() {
        return mail;
    }

    public static int getUser_id() {
        return id;
    }

    public static void setUser_id(int id) {
        CurrentUser.id = id;
    }

    public static void disConnect() {
        CurrentUser.id = -1;
        CurrentUser.mail = null;

    }
}
