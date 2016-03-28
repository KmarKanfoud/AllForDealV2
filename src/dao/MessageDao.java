/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import GUI.FrameAccueil;
import GUI.FrameGestionProduitAdmin;
import GUI.LoginForm;
import Idao.IDao;
import entite.Message;
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
public class MessageDao implements IDao<Message> {
    
    private Connection connection;
    private PreparedStatement pst;
    
    public MessageDao() {
        connection = DataSource.getInstance().getConnection();
    }
    
    @Override
    public void add(Message m) {
        String req = "INSERT INTO message( fromu, tou, sujet, texte,date_envoi) values (?,?,?,?,?)";
        try {
            pst = connection.prepareStatement(req);
            
            pst.setString(1, LoginForm.getUserName());
            //pst.setString(1, m.getFrom());
            pst.setString(2, m.getTo());
            pst.setString(3, m.getSujet());
            pst.setString(4, m.getTexte());
            pst.setDate(5, (Date) m.getDate_envoi());
            
            pst.executeUpdate();
            
        } catch (SQLException ex) {
            
            Logger.getLogger(CommentDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void update(Message t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void removeById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public List<Message> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 
    @Override
    public Message findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
       /////////AFFICHER LES MESSAGES RECUS
    
    public List<Message> findByReceiver(String s) {
        List<Message> listmsgs = new ArrayList ();
        String requete = "select * from message where toU = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setString(1, s);
            ResultSet resultat = ps.executeQuery();
            
            while (resultat.next()) {
                  Message msg = new Message();
                msg.setId_message(resultat.getInt(1));
                msg.setFrom(resultat.getString(2));
                msg.setTo(resultat.getString(3));
                msg.setSujet(resultat.getString(4));
                msg.setTexte(resultat.getString(5));                
                msg.setDate_envoi((Date) resultat.getDate(6));
                
                listmsgs.add(msg);
            }
            return listmsgs;
            
        } catch (SQLException ex) {
           Logger.getLogger(MessageDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
    
    //////Afficher lesmessages envoyés
    public List<Message> findBySender(String s) {
        List<Message> listmsgs = new ArrayList ();
        String requete = "select * from message where fromU= ?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setString(1, s);
            ResultSet resultat = ps.executeQuery();
            
            while (resultat.next()) {
                  Message msg = new Message();
                msg.setId_message(resultat.getInt(1));
                msg.setFrom(resultat.getString(2));
                msg.setTo(resultat.getString(3));
                msg.setSujet(resultat.getString(4));
                msg.setTexte(resultat.getString(5));                
                msg.setDate_envoi((Date) resultat.getDate(6));
                
                listmsgs.add(msg);
            }
            return listmsgs;
            
        } catch (SQLException ex) {
           Logger.getLogger(MessageDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
    
}
