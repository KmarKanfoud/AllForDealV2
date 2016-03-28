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
public class Message {

    private int id_message;
    private String from;
    private String to;
    private String sujet;
    private String texte;
    private Date date_envoi;

    public Message() {
    }

    public Message(int id_message, String from, String to, String sujet, String texte, Date date_envoi) {
        this.id_message = id_message;
        this.from = from;
        this.to = to;
        this.sujet = sujet;
        this.texte = texte;
        this.date_envoi = date_envoi;
    }
    

    public Message(String from, String to, String sujet, String texte) {
        this.from = from;
        this.to = to;
        this.sujet = sujet;
        this.texte = texte;
    }

    public Message(String from, String to, String sujet, String texte, Date date_envoi) {
        this.from = from;
        this.to = to;
        this.sujet = sujet;
        this.texte = texte;
        this.date_envoi = date_envoi;
    }

    public int getId_message() {
        return id_message;
    }

    public void setId_message(int id_message) {
        this.id_message = id_message;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }

    public Date getDate_envoi() {
        return date_envoi;
    }

    public void setDate_envoi(Date date_envoi) {
        this.date_envoi = date_envoi;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + this.id_message;
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
        final Message other = (Message) obj;
        if (this.id_message != other.id_message) {
            return false;
        }
        return true;
    }


 

    @Override
    public String toString() {
        return "Message{" + "id_message=" + id_message + ", from=" + from + ", to=" + to + ", sujet=" + sujet + ", texte=" + texte + ", date_envoi=" + date_envoi + '}';
    }
    
    

}
