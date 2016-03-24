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
public class Evaluation {
    private int note;
    private int id_user;
    private int id_produit;
    private int id_service;

    public Evaluation() {
    }

    public Evaluation(int note) {
        this.note = note;
    }

    public Evaluation(int note, int id_produit) {
        this.note = note;
        this.id_produit = id_produit;
    }

    public Evaluation(int note, int id_user, int id_produit, int id_service) {
        this.note = note;
        this.id_user = id_user;
        this.id_produit = id_produit;
        this.id_service = id_service;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + this.note;
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
        final Evaluation other = (Evaluation) obj;
        if (this.note != other.note) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Evaluation{" + "note=" + note + ", id_user=" + id_user + ", id_produit=" + id_produit + ", id_service=" + id_service + '}';
    }
    
     public int getevaluation() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setEvaluation(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
