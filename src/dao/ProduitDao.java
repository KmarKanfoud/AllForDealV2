/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import GUI.FrameAjouterProduit;
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
        String req = "insert into produit (id,categorie,quantite,ptbonus,nomP,description,prix,prix1,prix2,tva, reduction, dateAjout) values (?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            pst = connection.prepareStatement(req);

            pst.setString(1, p.getId() + "");
          //  pst.setString(2, p.getZone() + "");
          //  pst.setString(2, p.getUser() + "");
            pst.setString(2, p.getCategorie());
            pst.setString(3, p.getQuantite() + "");
            pst.setString(4, p.getPtbonus() + "");
            pst.setString(5, p.getNomP());
            pst.setString(6, p.getDescription());
            pst.setString(7, p.getPrix() + "");
            pst.setString(8, p.getPrix1() + "");
            pst.setString(9, p.getPrix2() + "");
            pst.setString(10, p.getTva() + "");
            pst.setString(11, p.getReduction() + "");
            // pst.setString(14, p.getDateAjout() + "");
            pst.setDate(12, (java.sql.Date) p.getDateAjout());

            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProduitDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void update(Produit p) {
        String req = "update produit set  zone_id=? , user_id=?, categorie=?,quantite=? ,ptbonus=?,nomP=?,description=?,prix=?,prix1=?,prix2=?,tva=?,reduction=? where id=?";

        try {
            pst = connection.prepareStatement(req);
            pst.setString(1, p.getZone() + "");
            pst.setString(2, p.getUser() + "");
            pst.setString(3, p.getCategorie());
            pst.setString(4, p.getQuantite() + "");
            pst.setString(5, p.getPtbonus() + "");
            pst.setString(6, p.getNomP());
            pst.setString(7, p.getDescription());
            pst.setString(8, p.getPrix() + "");
            pst.setString(9, p.getPrix1() + "");
            pst.setString(10, p.getPrix2() + "");
            pst.setString(11, p.getTva() + "");
            pst.setString(12, p.getReduction() + "");
            pst.setString(13, p.getDateAjout() + "");
            pst.setInt(14, p.getId());
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
                //p.setZone(resultat.getInt(2));
                p.setUser(resultat.getInt(3));
                p.setCategorie(resultat.getString(5));
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
            System.out.println("erreur" + ex.getMessage());
            return listeProduit;
        }

    }

    
    public List<Produit> DisplayById(int id) {
      List<Produit> listeProduit = new ArrayList<>();
       
     
       String requete ="select * from produit where id="+id;
       
        
        try {
           PreparedStatement ps = connection.prepareStatement(requete);
          
            ResultSet resultat =ps.executeQuery(requete);
            while (resultat.next()){
                
                  Produit p = new Produit();

                p.setId(resultat.getInt(1));
                //p.setZone(resultat.getInt(2));
                p.setUser(resultat.getInt(3));
                p.setCategorie(resultat.getString(5));
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
     public ResultSet getCollections() {
       
        try {
            pst = connection.prepareStatement("SELECT name FROM classification__collection;");
            ResultSet allAdmin = pst.executeQuery();
            return allAdmin;
            
           
        } catch (SQLException ex) {
            Logger.getLogger(ProduitDao.class.getName()).log(Level.SEVERE, null, ex);
        }
         return null;
    }

    @Override
    public Produit findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  

}
