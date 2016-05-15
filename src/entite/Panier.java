/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

import java.util.Objects;

/**
 *
 * @author Toshiba
 */
public class Panier {

    int id;
    int iduser;
    String username;
    int idprod;
    String nomP;
    int nbrprod;
    String description;

    public Panier() {
    }

    public Panier(int id, String username, String nomP, int nbrprod, String description) {
        this.id = id;
        this.username = username;
        this.nomP = nomP;
        this.nbrprod = nbrprod;
        this.description = description;
    }

    
    
    public Panier(int id, int iduser, String username, int idprod, String nomP, int nbrprod, String description) {
        this.id = id;
        this.iduser = iduser;
        this.username = username;
        this.idprod = idprod;
        this.nomP = nomP;
        this.nbrprod = nbrprod;
        this.description = description;
    }

  

    public int getId() {
        return id;
    }

    public int getIduser() {
        return iduser;
    }

    public String getUsername() {
        return username;
    }

    public int getIdprod() {
        return idprod;
    }

    public String getNomP() {
        return nomP;
    }

    public int getNbrprod() {
        return nbrprod;
    }

    public String getDescription() {
        return description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setIdprod(int idprod) {
        this.idprod = idprod;
    }

    public void setNomP(String nomP) {
        this.nomP = nomP;
    }

    public void setNbrprod(int nbrprod) {
        this.nbrprod = nbrprod;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + this.id;
        hash = 31 * hash + this.iduser;
        hash = 31 * hash + Objects.hashCode(this.username);
        hash = 31 * hash + this.idprod;
        hash = 31 * hash + Objects.hashCode(this.nomP);
        hash = 31 * hash + this.nbrprod;
        hash = 31 * hash + Objects.hashCode(this.description);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Panier other = (Panier) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.iduser != other.iduser) {
            return false;
        }
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (this.idprod != other.idprod) {
            return false;
        }
        if (!Objects.equals(this.nomP, other.nomP)) {
            return false;
        }
        if (this.nbrprod != other.nbrprod) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Panier{" + "id=" + id + ", iduser=" + iduser + ", username=" + username + ", idprod=" + idprod + ", nomP=" + nomP + ", nbrprod=" + nbrprod + ", description=" + description + '}';
    }


}
