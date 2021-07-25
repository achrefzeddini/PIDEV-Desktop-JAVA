/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.Entite;

import java.util.Objects;

/**
 *
 * @author Testouri Mohamed
 */
public class User {

    private int id;
    private String fnameUser;

    public User(int id, String fnameUser, String lnameUser) {
        this.id = id;
        this.fnameUser = fnameUser;
        this.lnameUser = lnameUser;
    }
    private String lnameUser;
    private int phoneUser;
    private String emailUser;
    private String passwordUser;
    private int idRole;
    private int statusUser;

    public int idProperty() {
        return id;
    }

    public User() {
    }

    public User(String fnameUser, String lnameUser, int phoneUser, int id) {
        this.fnameUser = fnameUser;
        this.lnameUser = lnameUser;
        this.phoneUser = phoneUser;
        this.id= id;
    }

    public User(String fnameUser, String lnameUser, int phoneUser, int idRole, String emailUser) {
        this.fnameUser = fnameUser;
        this.lnameUser = lnameUser;
        this.phoneUser = phoneUser;
        this.emailUser = emailUser;
        this.idRole = idRole;
    }

    public User(String fnameUser, String lnameUser, int phoneUser, String emailUser, String passwordUser) {
        this.fnameUser = fnameUser;
        this.lnameUser = lnameUser;
        this.phoneUser = phoneUser;
        this.emailUser = emailUser;
        this.passwordUser = passwordUser;
    }

    public User(int id, String fnameUser, String lnameUser, int phoneUser, String emailUser, int statusUser) {
        this.id = id;
        this.fnameUser = fnameUser;
        this.lnameUser = lnameUser;
        this.phoneUser = phoneUser;
        this.emailUser = emailUser;
        this.statusUser = statusUser;
    }

    public User(int id, String fnameUser, String lnameUser, int phoneUser, int idRole, String emailUser, String passwordUser) {
        this.id = id;
        this.fnameUser = fnameUser;
        this.lnameUser = lnameUser;
        this.phoneUser = phoneUser;
        this.idRole = idRole;
        this.emailUser = emailUser;
        this.passwordUser = passwordUser;

    }

    public User(String fnameUser, String lnameUser, int phoneUser, String emailUser, int statusUser) {
        this.fnameUser = fnameUser;
        this.lnameUser = lnameUser;
        this.phoneUser = phoneUser;
        this.emailUser = emailUser;
        this.statusUser = statusUser;
    }

    public User(String fnameUser, String lnameUser, int phoneUser, int idRole, String emailUser, String passwordUser) {
        this.fnameUser = fnameUser;
        this.lnameUser = lnameUser;
        this.phoneUser = phoneUser;
        this.idRole = idRole;
        this.emailUser = emailUser;
        this.passwordUser = passwordUser;
    }

    public User(int id, String fnameUser, String lnameUser, int phoneUser, int idRole, String emailUser) {
        this.id = id;
        this.fnameUser = fnameUser;
        this.lnameUser = lnameUser;
        this.phoneUser = phoneUser;
        this.idRole = idRole;
        this.emailUser = emailUser;
    }

    public User(int id, String fnameUser, String lnameUser, int phoneUser, String emailUser) {
        this.id = id;
        this.fnameUser = fnameUser;
        this.lnameUser = lnameUser;
        this.phoneUser = phoneUser;
        this.emailUser = emailUser;
    }

    public User(String fnameUser, String lnameUser) {
        this.fnameUser = fnameUser;
        this.lnameUser = lnameUser;
    }

    public int getIdUser() {
        return id;
    }

    public String getFnameUser() {
        return fnameUser;
    }

    public String getLnameUser() {
        return lnameUser;
    }

    public int getPhoneUser() {
        return phoneUser;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public String getPasswordUser() {
        return passwordUser;
    }

    public int getidRole() {
        return idRole;
    }

    public int getIdRole() {
        return idRole;
    }

    public int getStatutUser() {
        return statusUser;
    }

    public void setStatutUser(int statusUser) {
        this.statusUser = statusUser;
    }

    public void setIdUser(int id) {
        this.id = id;
    }

    public void setFnameUser(String fnameUser) {
        this.fnameUser = fnameUser;
    }

    public void setLnameUser(String lnameUser) {
        this.lnameUser = lnameUser;
    }

    public void setPhoneUser(int phoneUser) {
        this.phoneUser = phoneUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    public void setPasswordUser(String passwordUser) {
        this.passwordUser = passwordUser;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }

    @Override
    public String toString() {
        return "Users{" + "id=" + id + ", fnameUser=" + fnameUser + ", lnameUser=" + lnameUser + ", phoneUser=" + phoneUser + ", emailUser=" + emailUser + ", idRole=" + idRole + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (!Objects.equals(this.fnameUser, other.fnameUser)) {
            return false;
        }
        if (!Objects.equals(this.lnameUser, other.lnameUser)) {
            return false;
        }
        if (!Objects.equals(this.emailUser, other.emailUser)) {
            return false;
        }
        if (!Objects.equals(this.passwordUser, other.passwordUser)) {
            return false;
        }
        return true;
    }

}
