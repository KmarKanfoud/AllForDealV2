/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;



import GUI.*;
import Idao.IDao;
import com.sun.xml.internal.ws.util.Constants;
import entite.Comment;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.DataSource;

/**
 *
 * @author SaharS
 */
public class CommentDao implements IDao<Comment> {

    private Connection connection;
    private PreparedStatement pst;

    public CommentDao() {
        connection = DataSource.getInstance().getConnection();
    }

    @Override
    public void add(Comment c) {

        String req = "insert into comment (body,created_at,produit_id,user_id) values (?,?,?,?)";
        try {
            pst = connection.prepareStatement(req);

            //pst.setInt(1, c.getId());
            pst.setString(1, c.getBody());
            pst.setDate(2, (Date) c.getCreated_at());
            pst.setInt(3, AllForDealFrame.getProduit_id());
            pst.setInt(4, LoginForm.getUser_id());

            pst.executeUpdate();

        } catch (SQLException ex) {

            Logger.getLogger(CommentDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public void addS(Comment c) {

        String req = "insert into comment (body,created_at,service_id,user_id) values (?,?,?,?)";
        try {
            pst = connection.prepareStatement(req);

            pst.setString(1, c.getBody());
            pst.setDate(2, (Date) c.getCreated_at());
            pst.setInt(3, AllForDealFrame.getService_id());
            pst.setInt(4, LoginForm.getUser_id());

            pst.executeUpdate();

        } catch (SQLException ex) {

            Logger.getLogger(CommentDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Comment c) {
        String req = "UPDATE comment SET body = ? WHERE id =? ";
        try {
            pst = connection.prepareStatement(req);
            pst.setString(1, c.getBody());
            pst.setInt(2, c.getId());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CommentDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void removeById(int id) {
        String requete = "delete from comment where id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Commentaire supprimé");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la suppression " + ex.getMessage());
        }
    }

    @Override
    public List<Comment> findAll() {
        List<Comment> listeCommentaire = new ArrayList<>();

        String req = "select * from comment";
        try {
            pst = connection.prepareStatement(req);
            ResultSet resultat = pst.executeQuery(req);

            while (resultat.next()) {
                Comment c = new Comment();
                c.setId(resultat.getInt(1));
                c.setBody(resultat.getString(3));
                c.setCreated_at((Date) resultat.getDate(6));
                c.setProduit_id(resultat.getInt(9));
                c.setUser_id(resultat.getInt(11));

                listeCommentaire.add(c);
            }
            return listeCommentaire;
        } catch (SQLException ex) {
            System.out.println("erreur Recherche all " + ex.getMessage());
            return listeCommentaire;
        }
    }

    @Override
    public Comment findById(int id) {
         Comment  c = new Comment();
        String requete = "select * from comment where id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                c.setId(resultat.getInt(1));
                c.setBody(resultat.getString(3));
               c.setCreated_at((Date) resultat.getDate(4));
               c.setUser_id(resultat.getInt(11));
            }
            return c;

        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche d'une Personne " + ex.getMessage());
            return null;
        }
    }
        
    

    
    
    
  ///////////////// AFFICHAGE DES COMMENTAIRES D'UN SEUL UTILISATEUR

    public List<Comment> DisplayAllCommentaireByUser(int num) {

        List<Comment> commentaires = new ArrayList<>();

        String requete = "SELECT c.produit_id,p.nomP,c.body,c.created_at FROM produit p inner join comment c on (c.produit_id = p.id) and c.user_id=" + num;
        try {

            PreparedStatement ps = connection.prepareStatement(requete);

            ResultSet resultat = ps.executeQuery(requete);

            while (resultat.next()) {
                Comment c = new Comment();
                //c.setId(resultat.getInt(1));
                 c.setProduit_id(resultat.getInt(1));
                 c.setNomP(resultat.getString(2));
                c.setBody(resultat.getString(3));
                c.setCreated_at((Date) resultat.getDate(4));
               

                commentaires.add(c);
            }
            return commentaires;
        } catch (SQLException ex) {

            System.out.println("erreur lors du chargement des commentaires " + ex.getMessage());
            return null;
        }
    }
 
    ///////////////// AFFICHAGE DES COMMENTAIRES D'UN SEUL PRODUIT
    
         public   List<Comment> DisplayCommentProduit(int num) {
        List<Comment> commentaires = new ArrayList<>();
        String req = "SELECT c.id,u.username,c.body,c.created_at,c.produit_id FROM fos_user_user u inner join comment c on (c.user_id = u.id) and c.produit_id=" + num;
        try {
           
            PreparedStatement ps = connection.prepareStatement(req);

            ResultSet resultat = ps.executeQuery(req);

            while (resultat.next()) {
                Comment c = new Comment();
                c.setId(resultat.getInt(1));
                c.setUsername(resultat.getString(2));
                c.setBody(resultat.getString(3));
                c.setCreated_at((Date) resultat.getDate(4));
                c.setProduit_id(resultat.getInt(5));

                commentaires.add(c);
            }return commentaires;

        } catch (SQLException ex) {
            Logger.getLogger(ProduitDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
       
         
     public List<Comment> DisplayCommentaireByUserProduit(int user_id, int produit_id) {

        List<Comment> commentaires = new ArrayList<>();

        String requete = "select * from comment where user_id like " + user_id + " and produit_id like " + produit_id;
        try {

            PreparedStatement ps = connection.prepareStatement(requete);

            ResultSet resultat = ps.executeQuery(requete);

            while (resultat.next()) {
                Comment c = new Comment();
                //c.setId(resultat.getInt(1));
                c.setBody(resultat.getString(3));
                c.setCreated_at((Date) resultat.getDate(6));
                c.setUser_id(resultat.getInt(11));

                commentaires.add(c);
            }
            return commentaires;
        } catch (SQLException ex) {

            System.out.println("erreur lors du chargement des commentaires " + ex.getMessage());
            return null;
        }
    }
         
//             public List<Comment> DisplayAllCommentaireByProduit(int num) {
//
//        List<Comment> commentaires = new ArrayList<>();
//
//        String requete = "select * from comment where produit_id=" + num;
//        try {
//
//            PreparedStatement ps = connection.prepareStatement(requete);
//
//            ResultSet resultat = ps.executeQuery(requete);
//
//            while (resultat.next()) {
//                Comment c = new Comment();
//                //c.setId(resultat.getInt(1));
//                c.setBody(resultat.getString(3));
//                c.setCreated_at((Date) resultat.getDate(6));
//
//                commentaires.add(c);
//            }
//            return commentaires;
//        } catch (SQLException ex) {
//
//            System.out.println("erreur lors du chargement des commentaires " + ex.getMessage());
//            return null;
//        }
//    }
     
     
     
     //////////////////// AFFICHER LES COMMENTAIRES D'UN SEUL SERVICE
     
      public   List<Comment> DisplayCommentService(int num) {
        List<Comment> commentaires = new ArrayList<>();
        String req = "SELECT c.id,u.username,c.body,c.created_at,c.service_id FROM fos_user_user u inner join comment c on (c.user_id = u.id) and c.service_id=" + num;
        try {
           
            PreparedStatement ps = connection.prepareStatement(req);
            ResultSet resultat = ps.executeQuery(req);

            while (resultat.next()) {
                Comment c = new Comment();
                c.setId(resultat.getInt(1));
                c.setUsername(resultat.getString(2));
                c.setBody(resultat.getString(3));
                c.setCreated_at((Date) resultat.getDate(4));
                c.setService_id(resultat.getInt(5));

                commentaires.add(c);
            }return commentaires;

        } catch (SQLException ex) {
            Logger.getLogger(ProduitDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
     
     
     //////////////////////AFFICHER LES COMMENTAIRES DE MES SERVICES
     
     
      public List<Comment> DisplayCommentaireByUserService(int user_id, int service_id) {

        List<Comment> commentaires = new ArrayList<>();

        String requete = "select * from comment where user_id like " + user_id + " and service_id like " + service_id;
        try {

            PreparedStatement ps = connection.prepareStatement(requete);

            ResultSet resultat = ps.executeQuery(requete);

            while (resultat.next()) {
                Comment c = new Comment();
                //c.setId(resultat.getInt(1));
                c.setBody(resultat.getString(3));
                c.setCreated_at((Date) resultat.getDate(6));
                c.setUser_id(resultat.getInt(11));

                commentaires.add(c);
            }
            return commentaires;
        } catch (SQLException ex) {

            System.out.println("erreur lors du chargement des commentaires " + ex.getMessage());
            return null;
        }
    }
      
      ///////////////// AFFICHAGE DES COMMENTAIRES D'UN SEUL UTILISATEUR D'UN SERVICE

    public List<Comment> DisplayCommentaireSByUser(int num) {

        List<Comment> commentaires = new ArrayList<>();

        String requete = "SELECT c.service_id,p.nomP,c.body,c.created_at FROM produit p inner join comment c on (c.produit_id = p.id) and c.user_id=" + num;
        try {

            PreparedStatement ps = connection.prepareStatement(requete);

            ResultSet resultat = ps.executeQuery(requete);

            while (resultat.next()) {
                Comment c = new Comment();
                //c.setId(resultat.getInt(1));
                 c.setProduit_id(resultat.getInt(1));
                 c.setNomP(resultat.getString(2));
                c.setBody(resultat.getString(3));
                c.setCreated_at((Date) resultat.getDate(4));
               

                commentaires.add(c);
            }
            return commentaires;
        } catch (SQLException ex) {

            System.out.println("erreur lors du chargement des commentaires " + ex.getMessage());
            return null;
        }
    }
     
     
     
     
     
     
     
     
     
     
    }
