/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author SaharS
 */
public class Comment {

    private int id;
    private String body;
    private Date created_at;
    private int produit_id;
    private int service_id;
    private int user_id;
    private String username;
    private String nomP;

    public Comment() {
    }


    public Comment(int id, String body, Date created_at) {
        this.id = id;
        this.body = body;
        this.created_at = created_at;
    }

    public Comment( String username,String body, Date created_at, int produit_id,int user_id) {
        this.username = username;
        this.body = body;
        this.created_at = created_at;
        this.produit_id = produit_id;
        this.user_id = user_id;
        
    }

    public Comment(int id, String body, Date created_at, int produit_id, int service_id, int user_id) {
        this.id = id;
        this.body = body;
        this.created_at = created_at;
        this.produit_id = produit_id;
        this.service_id = service_id;
        this.user_id = user_id;
    }

 
    
    
    

    public Comment(int id, String body, Date created_at, int produit_id, int user_id) {
        this.id = id;
        this.body = body;
        this.created_at = created_at;
        this.produit_id = produit_id;
        this.user_id = user_id;
    }

  

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public int getProduit_id() {
        return produit_id;
    }

    public void setProduit_id(int produit_id) {
        this.produit_id = produit_id;
    }

    public int getService_id() {
        return service_id;
    }

    public void setService_id(int service_id) {
        this.service_id = service_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + this.id;
        hash = 13 * hash + Objects.hashCode(this.body);
        hash = 13 * hash + Objects.hashCode(this.created_at);
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
        final Comment other = (Comment) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.body, other.body)) {
            return false;
        }
        if (!Objects.equals(this.created_at, other.created_at)) {
            return false;
        }
        return true;
    }

    public String getNomP() {
        return nomP;
    }

    public void setNomP(String nomP) {
        this.nomP = nomP;
    }

    @Override
    public String toString() {
        return "Comment{" + "body=" + body + ", created_at=" + created_at + ", produit_id=" + produit_id + ", service_id=" + service_id +  ", username=" + username + ", nomP=" + nomP + '}';
    }

  

    
   

}
