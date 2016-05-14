/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import GUI.FrameAccueil;
import Idao.IDao;
import entite.Comment;
import utils.DataSource;
import entite.Produit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author esprit
 */
public class ProduitDao implements IDao<Produit> {

    private Connection connection;
    private PreparedStatement pst;

    public ProduitDao() {
        //initialiser la connection
        connection = DataSource.getInstance().getConnection();

    }


    @Override
    public void add(Produit p) {
        String req = "insert into produit (id,zone_id,categorie_id,quantite,user_id,ptbonus,nomP,description,prix,prix1,prix2,tva, reduction, dateAjout,photo) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            pst = connection.prepareStatement(req);

            pst.setString(1, p.getId() + "");
            pst.setInt(2, p.getZone());
            pst.setInt(3, p.getCategorie());
            pst.setString(4, p.getQuantite() + "");
            pst.setInt(5, p.getUser());
            pst.setString(6, p.getPtbonus() + "");
            pst.setString(7, p.getNomP());
            pst.setString(8, p.getDescription());
            pst.setString(9, p.getPrix() + "");
            pst.setString(10, p.getPrix1() + "");
            pst.setString(11, p.getPrix2() + "");
            pst.setString(12, p.getTva() + "");
            pst.setString(13, p.getReduction() + "");
            pst.setDate(14, (java.sql.Date) p.getDateAjout());
            pst.setString(15, p.getPhoto()+ "");
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProduitDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void update(Produit p) {
        String req = "update produit set  zone_id=?,categorie_id=?,quantite=? ,ptBonus=?,nomP=?,description=?,prix=?,prix1=?,prix2=?,tva=?,reduction=? where id=?";

        try {
            pst = connection.prepareStatement(req);
           
           pst.setString(1, p.getZone() + "");
            //pst.setString(2, p.getUser() + "");
           pst.setInt(2, p.getCategorie());
           pst.setString(3, p.getQuantite() + "");
           pst.setString(4, p.getPtbonus() + "");
            pst.setString(5, p.getNomP());
            pst.setString(6, p.getDescription());
            pst.setString(7, p.getPrix() + "");
            pst.setString(8, p.getPrix1() + "");
            pst.setString(9, p.getPrix2() + "");
            pst.setString(10, p.getTva() + "");
           pst.setString(11, p.getReduction() + "");
         
          pst.setInt(12, p.getId());
            
//             pst.setString(1, p.getCategorie());
//            pst.setString(2, p.getQuantite() + "");
//           pst.setString(3, p.getPtbonus() + "");
//            pst.setString(4, p.getNomP());
//            pst.setString(5, p.getDescription());
//            pst.setString(6, p.getPrix() + "");
//            pst.setString(7, p.getPrix1() + "");
//            pst.setString(8, p.getPrix2() + "");
//            pst.setString(9, p.getTva() + "");
//            pst.setString(10, p.getReduction() + "");
//            pst.setInt(11, p.getRating());
//            pst.setInt(12, p.getId());
// 

            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProduitDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void removeById(int id) {
        String req = "delete from produit where id=" + id;

        try {
            pst = connection.prepareStatement(req);

            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProduitDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Produit> findAll() {
        List<Produit> listeProduit = new ArrayList<>();

        String req = "select * from produit";

        try {
            pst = connection.prepareStatement(req);
            ResultSet resultat = pst.executeQuery(req);

            while (resultat.next()) {

                Produit p = new Produit();

                p.setId(resultat.getInt(1));
                p.setZone(resultat.getInt(2));
                 p.setCategorie(resultat.getInt(3));
                 p.setQuantite(resultat.getInt(4));
                 p.setUser(resultat.getInt(5));
                 p.setPtbonus(resultat.getInt(6));
                  p.setNomP(resultat.getString(7)); 
                 p.setDescription(resultat.getString(8));
                  p.setPrix(resultat.getInt(9));
                 p.setPrix1(resultat.getInt(10));
                p.setPrix2(resultat.getInt(11));
               p.setTva(resultat.getInt(12));
               p.setReduction(resultat.getInt(13));
               p.setDateAjout(resultat.getDate(14)); 
              p.setRating(resultat.getInt(15));
               p.setPhoto(resultat.getString(16));
               
               
                
               
                
                
               

                listeProduit.add(p);

            }
            return listeProduit;
        } catch (SQLException ex) {
            System.out.println("erreur" + ex.getMessage());
            return listeProduit;
        }

    }

    public List<Produit> DisplayById(int id) {
        List<Produit> listeProduit = new ArrayList<>();

        String requete = "select * from produit where id=" + id;

        try {
            PreparedStatement ps = connection.prepareStatement(requete);

            ResultSet resultat = ps.executeQuery(requete);
            while (resultat.next()) {

                Produit p = new Produit();

                p.setId(resultat.getInt(1));
                //p.setZone(resultat.getInt(2));
                p.setUser(resultat.getInt(3));
                p.setCategorie(resultat.getInt(5));
                p.setQuantite(resultat.getInt(6));
                p.setPtbonus(resultat.getInt(7));
                p.setNomP(resultat.getString(8));
                p.setDescription(resultat.getString(9));
                p.setPrix(resultat.getInt(10));
                p.setPrix1(resultat.getInt(11));
                p.setPrix2(resultat.getInt(12));
                p.setTva(resultat.getInt(13));
                p.setReduction(resultat.getInt(14));
                listeProduit.add(p);
            }
            return listeProduit;
        } catch (SQLException ex) {
            Logger.getLogger(ProduitDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public ResultSet getAllVille() {

        try {
            pst = connection.prepareStatement("SELECT nom FROM zone;");
            ResultSet allAdmin = pst.executeQuery();
            return allAdmin;

        } catch (SQLException ex) {
            Logger.getLogger(ProduitDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

//    public ResultSet getCategories() {
//
//        try {
//            pst = connection.prepareStatement("SELECT name FROM classification__category;");
//            ResultSet allAdmin = pst.executeQuery();
//            return allAdmin;
//
//        } catch (SQLException ex) {
//            Logger.getLogger(ProduitDao.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return null;
//    }

    @Override
    public Produit findById(int id) {
        Produit p = new Produit();
        String requete = "select * from produit where id=" + id;
        try {
            PreparedStatement ps = connection.prepareStatement(requete);

            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                p.setId(resultat.getInt(1));
                //p.setZone(resultat.getInt(2));
                p.setUser(resultat.getInt(3));
                p.setCategorie(resultat.getInt(5));
                p.setQuantite(resultat.getInt(6));
                p.setPtbonus(resultat.getInt(7));
                p.setNomP(resultat.getString(8));
                p.setDescription(resultat.getString(9));
                p.setPrix(resultat.getInt(10));
                p.setPrix1(resultat.getInt(11));
                p.setPrix2(resultat.getInt(12));
                p.setTva(resultat.getInt(13));
                //p.setReduction(resultat.getInt(14));
            }
            return p;

        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du produit " + ex.getMessage());
            return null;
        }
    }

    
     public void updateRating(Produit p) {
        String requete = "update produit set  rating=rating+?  where id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
             ps.setInt(1,1);
              ps.setInt(2, p.getId());
           
          
            ps.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la mise à jour " + ex.getMessage());
        }
//        public void Vote (int v, int u ){
//             String requete = "update produit set  rating= rating +?  where id=?";
//        try {
//            PreparedStatement ps = connection.prepareStatement(requete);
//             ps.setInt(1, p.getRating());
//              ps.setInt(2, p.getId());
//           
//          
//            ps.executeUpdate();
//            System.out.println("Mise à jour effectuée avec succès");
//        } catch (SQLException ex) {
//            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
//            System.out.println("erreur lors de la mise à jour " + ex.getMessage());
//        }
//        }
    }

 public List<Produit> findAllByUser(int user_id) {
        List<Produit> listeProduits = new ArrayList<>();

        String req = "select * from produit where user_id="+user_id;


        try {
            pst = connection.prepareStatement(req);
            ResultSet resultat = pst.executeQuery(req);

            while (resultat.next()) {

                Produit p = new Produit();
  p.setId(resultat.getInt(1));
                p.setZone(resultat.getInt(2));
                 p.setCategorie(resultat.getInt(3));
                  p.setDescription(resultat.getString(4));
                  p.setPrix(resultat.getInt(5));
                p.setUser(resultat.getInt(6));
               
                p.setQuantite(resultat.getInt(7));
                p.setPtbonus(resultat.getInt(8));
                p.setNomP(resultat.getString(9));
               
                
                p.setPrix1(resultat.getInt(10));
                p.setPrix2(resultat.getInt(11));
                p.setTva(resultat.getInt(12));
                p.setReduction(resultat.getInt(13));
                p.setDateAjout(resultat.getDate(14));
                

                listeProduits.add(p);

            }
            return listeProduits;
        } catch (SQLException ex) {
            System.out.println("erreur" + ex.getMessage());
            return listeProduits;
        }
    }
 
 
  public List<Produit> findAllByCategorie(String cat ) {
        List<Produit> ProduitByCategorieModel = new ArrayList<>();

        String req = "select * from produit where categorie_id like '%" +cat+"%'";

        try {
            pst = connection.prepareStatement(req);
            ResultSet resultat = pst.executeQuery(req);

            while (resultat.next()) {

                Produit p = new Produit();

                 p.setId(resultat.getInt(1));
                p.setZone(resultat.getInt(2));
                 p.setCategorie(resultat.getInt(3));
                  p.setDescription(resultat.getString(4));
                  p.setPrix(resultat.getInt(5));
                p.setUser(resultat.getInt(6));
               p.setQuantite(resultat.getInt(7));
                p.setPtbonus(resultat.getInt(8));
                p.setNomP(resultat.getString(9));
               p.setPrix1(resultat.getInt(10));
                p.setPrix2(resultat.getInt(11));
                p.setTva(resultat.getInt(12));
                p.setReduction(resultat.getInt(13));
               p.setDateAjout(resultat.getDate(14));
               ProduitByCategorieModel.add(p);

            }
            return ProduitByCategorieModel;
        } catch (SQLException ex) {
            System.out.println("erreur" + ex.getMessage());
            return ProduitByCategorieModel;
        }
    }
}
