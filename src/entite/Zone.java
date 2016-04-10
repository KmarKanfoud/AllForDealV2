/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

/**
 *
 * @author esprit
 */
public class Zone {
    private int id;
    private String nom;
    private double lat;
    private double lon;

    public Zone(String nom, double lat, double lon) {
        this.nom = nom;
        this.lat = lat;
        this.lon = lon;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public Zone() {
    }

    public Zone(int id, String nom, double lat, double lon) {
        this.id = id;
        this.nom = nom;
        this.lat = lat;
        this.lon = lon;
    }
    

   

    @Override
    public int hashCode() {
        int hash = 3;
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
        final Zone other = (Zone) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Zone{" + "id=" + id + ", nom=" + nom + ", lat=" + lat + ", lon=" + lon + '}';
    }
    
    
   
}
