/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import GUI.FrameAccueil;
import GUI.FrameGestionProduitAdmin;
import Idao.IDao;
import entite.Comment;
import entite.Notification;
import java.sql.Connection;
import java.sql.Date;
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
 * @author SaharS
 */
public class NotificationDao implements IDao<Notification>  {
    
     private Connection connection;
    private PreparedStatement pst;

    public NotificationDao() {
        connection = DataSource.getInstance().getConnection();
    }
    
  
     @Override
  public void add(Notification n) {

        String req = "insert into notification (id_produit,id_service,id_user) values (?,?,?)";
        try {
            pst = connection.prepareStatement(req);

            //pst.setInt(1, c.getId());
            pst.setInt(1, n.getId_produit());
            pst.setInt(2,n.getId_service());
            pst.setInt(3,n.getId_user());

            pst.executeUpdate();

        } catch (SQLException ex) {

            Logger.getLogger(CommentDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }



    @Override
    public void update(Notification t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    public List<Notification> findNotificationService(int num) {
 List<Notification> listeCommentaire = new ArrayList<>();

        String req = "select s.nomService,u.username from notification n inner join service s on (n.id_service = s.id) inner join fos_user_user u on (n.id_user=u.id) where s.user_id="+num;
        try {
            pst = connection.prepareStatement(req);
            ResultSet resultat = pst.executeQuery(req);

            while (resultat.next()) {
            Notification n = new Notification();
              n.setServiceNom(resultat.getString(1));
                n.setUserNom(resultat.getString(2));
              
           

                listeCommentaire.add(n);
            }
            return listeCommentaire;
        } catch (SQLException ex) {
            System.out.println("erreur Recherche all " + ex.getMessage());
            return listeCommentaire;
        }    }

    @Override
    public void removeById(int id) {
 String requete = "delete from notification where id_user=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("notifications supprimées");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la suppression " + ex.getMessage());
        }
    }

    @Override
    public Notification findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Notification> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
