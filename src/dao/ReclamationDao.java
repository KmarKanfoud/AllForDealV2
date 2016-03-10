/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Idao.IDao;
import entite.Comment;
import entite.Reclamation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.DataSource;

/**
 *
 * @author SaharS
 */
public class ReclamationDao implements IDao<Reclamation> {

    private Connection connection;
    private PreparedStatement pst;

    public ReclamationDao() {
        connection = DataSource.getInstance().getConnection();
    }

    @Override
    public void add(Reclamation r) {
        String req = "insert into reclamation (date,description,sujet) values (?,?,?)";
        try {
            pst = connection.prepareStatement(req);

            //pst.setInt(1, c.getId());
            pst.setDate(1, (java.sql.Date) r.getDate());
            pst.setString(2, r.getDescription());
            pst.setString(3, r.getSujet());
            pst.executeUpdate();

        } catch (SQLException ex) {

            Logger.getLogger(ReclamationDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Reclamation r) {
         String req = "UPDATE reclamation SET description = ?,sujet = ? WHERE id_reclamation =? ";
        try {
            pst = connection.prepareStatement(req);
            pst.setString(1, r.getDescription());
            pst.setString(2, r.getSujet());
            pst.setInt(3,1);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CommentDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void removeById(int id_reclamation) {
         String requete = "delete from reclamation where id_reclamation=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id_reclamation);
            ps.executeUpdate();
            System.out.println("Réclamation supprimée");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la suppression " + ex.getMessage());
        }
    }

    @Override
    public List<Reclamation> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Reclamation findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
