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
public class Role {
    private int idRole;
    private String typeRole;

    public Role(int idRole, String typeRole) {
        this.idRole = idRole;
        this.typeRole = typeRole;
    }

    public Role(String typeRole) {
        this.typeRole = typeRole;
    }

    public Role(int idRole) {
        this.idRole = idRole;
    }

    public Role() {
    }

    public int getIdRole() {
        return idRole;
    }

    public String getTypeRole() {
        return typeRole;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }

    public void setTypeRole(String typeRole) {
        this.typeRole = typeRole;
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final Role other = (Role) obj;
        if (!Objects.equals(this.typeRole, other.typeRole)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Role{" + "idRole=" + idRole + ", typeRole=" + typeRole + '}';
    }
    
    
}
