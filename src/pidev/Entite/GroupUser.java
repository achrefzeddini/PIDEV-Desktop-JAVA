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
public class GroupUser {
    private int user_id;
    private int groups_id;

    public GroupUser() {
    }

    public GroupUser(int user_id, int groups_id) {
        this.user_id = user_id;
        this.groups_id = groups_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getGroups_id() {
        return groups_id;
    }

    public void setGroups_id(int groups_id) {
        this.groups_id = groups_id;
    }

    @Override
    public String toString() {
        return "GroupUser{" + "user_id=" + user_id + ", groups_id=" + groups_id + '}';
    }

       
}
