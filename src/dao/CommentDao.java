/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Idao.IDao;
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
public class CommentDao implements IDao<Comment>{
     private Connection connection;
    private PreparedStatement pst;

    public CommentDao() {
        connection = DataSource.getInstance().getConnection();
    }

    @Override
    public void add(Comment c) {
        
         String req = "insert into comment (body,created_at) values (?,?)";
        try {
            pst = connection.prepareStatement(req);
           
             //pst.setInt(1, c.getId());
             pst.setString(1, c.getBody());
             pst.setDate(2, (Date) c.getCreated_at());
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
            pst.setInt(2,2);
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
                c.setCreated_at((Date)resultat.getDate(6));
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     public List<Comment> DisplayAllCommentaireByProduit(int num) {

        List<Comment> commentaires = new ArrayList<>();

        String requete = "select * from comment where produit_id=" + num;
        try {
            
             PreparedStatement ps = connection.prepareStatement(requete);
            
            ResultSet resultat = ps.executeQuery(requete);

            while (resultat.next()) {
                Comment c = new Comment();
                  c.setId(resultat.getInt(1));
                c.setBody(resultat.getString(3));
                c.setCreated_at((Date) resultat.getDate(6));
                commentaires.add(c);
            }
            return commentaires;
        } catch (SQLException ex) {
            
            System.out.println("erreur lors du chargement des commentaires " + ex.getMessage());
            return null;
        }
    }
    
}
