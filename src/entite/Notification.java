/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

/**
 *
 * @author SaharS
 */
public class Notification {

    private  int id;
    private  int id_user;
    private  int id_produit;
    private  int id_service;
    private String userNom;
    private String serviceNom;

    public Notification() {
    }

    public Notification(int id, int id_user,int id_produit,int id_service) {
            this.id = id;
        this.id_user=id_user;
        this.id_produit=id_produit;
        this.id_service=id_service;
        
       
    }

    public Notification(int id, int id_user, int id_produit) {
        this.id = id;
        this.id_user = id_user;
        this.id_produit = id_produit;
    }

    public Notification( int id_user, int id_service) {
   
        this.id_user = id_user;
        this.id_service = id_service;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_produit() {
        return id_produit;
    }

    public void setId_produit(int id_produit) {
        this.id_produit = id_produit;
    }

    public int getId_service() {
        return id_service;
    }

    public void setId_service(int id_service) {
        this.id_service = id_service;
    }

    public String getUserNom() {
        return userNom;
    }

    public void setUserNom(String userNom) {
        this.userNom = userNom;
    }

    public String getServiceNom() {
        return serviceNom;
    }

    public void setServiceNom(String serviceNom) {
        this.serviceNom = serviceNom;
    }
    

   

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.id;
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
        final Notification other = (Notification) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Notification{" + "id=" + id + ", id_user=" + id_user + ", id_produit=" + id_produit + ", id_service=" + id_service + ", userNom=" + userNom + ", serviceNom=" + serviceNom + '}';
    }

    

   
   

 
   
    
    

}
