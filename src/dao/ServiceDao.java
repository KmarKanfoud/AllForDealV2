/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Idao.IDao;
import entite.Produit;
import entite.Service;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import utils.DataSource;

/**
 *
 * @author Super
 */
public class ServiceDao implements IDao<Service> {
     private Connection conn;
  
    ResultSet rs=null;
    
       private Connection connection;
    private PreparedStatement pst;
    
     public ServiceDao() {
        //initialiser la connection
        connection = DataSource.getInstance().getConnection();

    }

    @Override
    public void add(Service t) {
            String req = "insert into service (id,nomService,description,type,etat,dateAjout) values (?,?,?,?,?,?)";
        try {
            pst = connection.prepareStatement(req);

            pst.setInt(1, t.getId());
            //pst.setInt(2, t.getZone());
            pst.setString(2, t.getNomService());
            pst.setString(3, t.getDescription());
            pst.setString(4, t.getType());
            pst.setString(5, t.getEtat());
            pst.setDate(6, (Date) t.getDateAjout());
            //pst.setDate(7 s.DateAjout());
            
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceDao.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }

    @Override
    public void update(Service t) {
      String req = "UPDATE service SET nomService = ?,description = ? ,type = ?,etat = ?,dateAjout = ? WHERE id =?";
        System.out.println("update");
      try {
            pst = connection.prepareStatement(req);

            //pst.setInt(2, t.getZone());
            pst.setString(1, t.getNomService());
            pst.setString(2, t.getDescription());
            pst.setString(3, t.getType());
            pst.setString(4, t.getEtat());
            pst.setDate(5, (Date) t.getDateAjout());
            pst.setInt(6, t.getId());
            pst.executeUpdate();
            System.out.println(t.getId());
        } catch (SQLException ex) {
            Logger.getLogger(ServiceDao.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }

    @Override
    public void removeById(int id) {
        String requete = "delete from service where id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("service supprimé");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la suppression " + ex.getMessage());
        } 
    }
    

    @Override
    public List<Service> findAll() {
       List<Service> listeService = new ArrayList<>();

        String req = "select * from service";

        try {
            pst = connection.prepareStatement(req);
            ResultSet resultat = pst.executeQuery(req);

            while (resultat.next()) {

                Service s = new Service();

                s.setId(resultat.getInt(1));
                //p.setZone(resultat.getInt(2));
                s.setNomService(resultat.getString(4));
                s.setDescription(resultat.getString(5));
                s.setType(resultat.getString(6));
                s.setEtat(resultat.getString(7));
                s.setDateAjout(resultat.getDate(8));
     

                listeService.add(s);

            }
            return listeService;
        } catch (SQLException ex) {
            System.out.println("erreur" + ex.getMessage());
            return listeService;
        } 
    }

    @Override
    public Service findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public ResultSet getAllVille() {
       
        try {
            pst = connection.prepareStatement("SELECT nom FROM zone;");
            ResultSet allAdmin = pst.executeQuery();
            return allAdmin;
            
           
        } catch (SQLException ex) {
            Logger.getLogger(ServiceDao.class.getName()).log(Level.SEVERE, null, ex);
        }
         return null;
    }
         public ResultSet getCategorie() {
       
        try {
            pst = connection.prepareStatement("SELECT name FROM classification__category;");
            ResultSet allAdmin = pst.executeQuery();
            return allAdmin;
            
           
        } catch (SQLException ex) {
            Logger.getLogger(ServiceDao.class.getName()).log(Level.SEVERE, null, ex);
        }
         return null;
    }
 
    
}
