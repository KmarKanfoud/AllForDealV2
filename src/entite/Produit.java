/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

import GUI.AllForDealFrame;
import GUI.FrameAccueil;
import GUI.LoginForm;
import dao.CategorieDao;

import dao.ZoneDao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author esprit
 */
public class Produit {



    ZoneDao zoneDAO =new ZoneDao();
    CategorieDao catDao =new CategorieDao();
    ResultSet rsName=null;
    ResultSet rsNameCategorie=null;
    private String zoneName;
    private String categorieName;
    
    private int id;
    private int zone;
    private int user;
    private int media;
    private int categorie;
    private int quantite;
    private int ptbonus;
    private String nomP;
    private String description;
    private float prix;
    private int prix1;
    private int prix2;
    private float tva;
    private float reduction;
    private Date dateAjout;
    private int rating;
    private String photo;
    private List<Evaluation> evaluations;

    public Produit(int id, int zone, int categorie, int quantite, String nomP, String description, float prix, int prix1, int prix2, float tva, float reduction, int rating) {
        this.id = id;
        this.zone = zone;
        this.categorie = categorie;
        this.quantite = quantite;
        this.nomP = nomP;
        this.description = description;
        this.prix = prix;
        this.prix1 = prix1;
        this.prix2 = prix2;
        this.tva = tva;
        this.reduction = reduction;
        this.rating = rating;
    }

    
    public Produit(int id, int zone, int user, int media, int categorie, int quantite, int ptbonus, String nomP, String description, float prix, int prix1, int prix2, float tva, float reduction, Date dateAjout) {
        this.id = id;
        this.zone = zone;
        this.user = user;
        this.media = media;
        this.categorie = categorie;
        this.quantite = quantite;
        this.ptbonus = ptbonus;
        this.nomP = nomP;
        this.description = description;
        this.prix = prix;
        this.prix1 = prix1;
        this.prix2 = prix2;
        this.tva = tva;
        this.reduction = reduction;
        this.dateAjout = dateAjout;
        this.rating = rating;
    }

    public Produit(String zoneName, int id, int zone, int user, int media, int categorie, int quantite, int ptbonus, String nomP, String description, float prix, int prix1, int prix2, float tva, float reduction, Date dateAjout, int rating) {
        this.zoneName = zoneName;
        this.id = id;
        this.zone = zone;
        this.user = user;
        this.media = media;
        this.categorie = categorie;
        this.quantite = quantite;
        this.ptbonus = ptbonus;
        this.nomP = nomP;
        this.description = description;
        this.prix = prix;
        this.prix1 = prix1;
        this.prix2 = prix2;
        this.tva = tva;
        this.reduction = reduction;
        this.dateAjout = dateAjout;
        this.rating = rating;
    }

    public Produit(String zoneName, int id, int zone, int user, int media, int categorie, int quantite, int ptbonus, String nomP, String description, float prix, int prix1, int prix2, float tva, Date dateAjout, int rating, String photo) {
        this.zoneName = zoneName;
        this.id = id;
        this.zone = zone;
        this.user = user;
        this.media = media;
        this.categorie = categorie;
        this.quantite = quantite;
        this.ptbonus = ptbonus;
        this.nomP = nomP;
        this.description = description;
        this.prix = prix;
        this.prix1 = prix1;
        this.prix2 = prix2;
        this.tva = tva;
        this.dateAjout = dateAjout;
        this.rating = rating;
        this.photo = photo;
    }
    

    public Produit() {
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getMedia() {
        return media;
    }

    public void setMedia(int media) {
        this.media = media;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }


    public String getNomP() {
        return nomP;
    }

    public void setNomP(String nomP) {
        this.nomP = nomP;
    }

    public int getPrix1() {
        return prix1;
    }

    public void setPrix1(int prix1) {
        this.prix1 = prix1;
    }

    public int getCategorie() {
        return categorie;
    }

    public void setCategorie(int categorie) {
        this.categorie = categorie;
    }

    public int getZone() {
        return zone;
    }

    public void setZone(int Zone) {
        this.zone = Zone;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public float getTva() {
        return tva;
    }

    public void setTva(float tva) {
        this.tva = tva;
    }

    public float getReduction() {
        return reduction;
    }

    public void setReduction(float reduction) {
        this.reduction = reduction;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public int getPtbonus() {
        return ptbonus;
    }

    public void setPtbonus(int ptbonus) {
        this.ptbonus = ptbonus;
    }

    public int getPrix2() {
        return prix2;
    }

    public void setPrix2(int prix2) {
        this.prix2 = prix2;
    }

    public Date getDateAjout() {
        return dateAjout;
    }

    public void setDateAjout(Date dateAjout) {
        this.dateAjout = dateAjout;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Produit{" + "zoneDAO=" + zoneDAO + ", rsName=" + rsName + ", zoneName=" + zoneName + ", id=" + id + ", zone=" + zone + ", user=" + user + ", media=" + media + ", categorie=" + categorie + ", quantite=" + quantite + ", ptbonus=" + ptbonus + ", nomP=" + nomP + ", description=" + description + ", prix=" + prix + ", prix1=" + prix1 + ", prix2=" + prix2 + ", tva=" + tva + ", reduction=" + reduction + ", dateAjout=" + dateAjout + ", rating=" + rating + ", evaluations=" + evaluations + '}';
    }

   
    
  public String getZoneName() {
        try {
            rsName = zoneDAO.getZoneById(zone);
            while (rsName.next()) {
                zoneName = rsName.getString(1);

            }//this.setResizable(false);
        } catch (SQLException ex) {
            Logger.getLogger(AllForDealFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        return zoneName;

    }
  public String getCategorieName() {
        try {
            rsNameCategorie = catDao.getCategorieById(categorie);
            while (rsNameCategorie.next()) {
                categorieName = rsNameCategorie.getString(1);

            }
        } catch (SQLException ex) {
            Logger.getLogger(AllForDealFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        return categorieName;

    }

    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 19 * hash + this.id;
        hash = 19 * hash + Objects.hashCode(this.categorie);
        hash = 19 * hash + Objects.hashCode(this.nomP);
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
        final Produit other = (Produit) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.categorie, other.categorie)) {
            return false;
        }
        if (!Objects.equals(this.nomP, other.nomP)) {
            return false;
        }
        return true;
    }

    public List<Evaluation> getEvaluations() {
        return evaluations;
    }

    public void setEvaluations(List<Evaluation> evaluations) {
        this.evaluations = evaluations;
    }

}
