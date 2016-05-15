/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import GUI.FrameAccueil;
import Idao.IDao;
import entite.Panier;
import entite.Produit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.DataSource;

/**
 *
 * @author Toshiba
 */
public class PanierDao implements IDao<Panier> {

    private Connection connection;
    private PreparedStatement pst;

    public PanierDao() {
        connection = DataSource.getInstance().getConnection();
    }

    @Override
    public void add(Panier t) {
        String req = "insert into Panier (id,iduser,username,idprod,nomP,nbrprod,description) values (?,?,?,?,?,?,?)";
        try {
            pst = connection.prepareStatement(req);
            pst.setInt(1, t.getId());
            pst.setInt(2, FrameAccueil.getUserId());
            //récup le nom d'utlisateur connecté ?????
            pst.setString(3, t.getUsername());
            pst.setInt(4, t.getIdprod());
            pst.setString(5, t.getNomP());
            pst.setInt(6, t.getNbrprod());
            pst.setString(7, t.getDescription());
            pst.executeUpdate();

        } catch (SQLException ex) {

            Logger.getLogger(PanierDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void update(Panier t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeById(int iduser) {
        String requete = "delete from panier where iduser=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, iduser);
            ps.executeUpdate();
            System.out.println("panier supprimé");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la suppression " + ex.getMessage());
        }
    }

    public void removeProduit(int idprod, int iduser) {
        String requete = "delete from Panier where idprod=? and iduser=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, idprod);
            ps.setInt(2, iduser);
            ps.executeUpdate();
            System.out.println("produit supprimé du panier");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la suppression " + ex.getMessage());
        }
    }

    @Override
    public List<Panier> findAll() {
        List<Panier> listep = new ArrayList<>();

        String req = "select * from panier ";

        try {
            pst = connection.prepareStatement(req);
            ResultSet resultat = pst.executeQuery(req);

            while (resultat.next()) {
                Panier p = new Panier();
                p.setId(resultat.getInt(1));
                p.setIduser(resultat.getInt(2));
                p.setUsername(resultat.getString(3));
                p.setIdprod(resultat.getInt(4));
                p.setNomP(resultat.getString(5));
                p.setNbrprod(resultat.getInt(6));
                p.setDescription(resultat.getString(7));

                listep.add(p);
            }
            return listep;
        } catch (SQLException ex) {
            System.out.println("erreur Recherche all " + ex.getMessage());
            return listep;
        }
    }
    public Produit findByprodId(int id) {
        Produit p = new Produit();
        String requete = "select prix,tva,ptbonus,reduction from produit where id=" + id;
        try {
            PreparedStatement ps = connection.prepareStatement(requete);

            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                p.setPrix(resultat.getInt(1));
                p.setTva(resultat.getInt(2));
                p.setPtbonus(resultat.getInt(3));
                p.setReduction(resultat.getInt(4));
               
            }
            return p;

        } catch (SQLException ex) {
            
            System.out.println("erreur lors de la recherche du produit " + ex.getMessage());
            return null;
        }
    }

    public List<Panier> findAllByUser(int iduser) {
        List<Panier> listep = new ArrayList<>();

        String req = "select * from panier where iduser= " + iduser;

        try {
            pst = connection.prepareStatement(req);
            ResultSet resultat = pst.executeQuery(req);

            while (resultat.next()) {
                Panier p = new Panier();
                p.setId(resultat.getInt(1));
               p.setIduser(resultat.getInt(2));
                p.setUsername(resultat.getString(3));
               p.setIdprod(resultat.getInt(4));
                p.setNomP(resultat.getString(5));
                p.setNbrprod(resultat.getInt(6));
                p.setDescription(resultat.getString(7));
                listep.add(p);
            }
            return listep;
        } catch (SQLException ex) {
            System.out.println("erreur Recherche all " + ex.getMessage());
            return listep;
        }

    }
    

    /* public ResultSet getAllNom() {
     try {
     pst = connection.prepareStatement("select distinct(pr.nomP) from produit pr inner join panier p on (pr.id = p.idprod);");
     ResultSet resultset = pst.executeQuery();
     return resultset;
     } catch (SQLException ex) {
     Logger.getLogger(PanierDao.class.getName()).log(Level.SEVERE, null, ex);
     }
     return null;
     }
     */
    public ResultSet getAllIdUser() {
        try {
            pst = connection.prepareStatement("SELECT iduser FROM panier;");
            ResultSet alluser = pst.executeQuery();
            return alluser;
        } catch (SQLException ex) {
            Logger.getLogger(PanierDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Panier findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
