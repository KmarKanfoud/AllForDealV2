/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Idao.IDao;
import entite.Zone;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.DataSource;

/**
 *
 * @author esprit
 */
public class ZoneDao implements IDao<Zone>{
    
 private Connection connection;
    private PreparedStatement pst;
    
    
    public ZoneDao() {
        //initialiser la connection
        connection = DataSource.getInstance().getConnection();

    }
    
    @Override
    public void add(Zone t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Zone t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Zone> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Zone findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    
      public ResultSet getZoneByName(String name) {

        try {
            pst = connection.prepareStatement("SELECT id FROM zone where nom='" + name + "';");
            ResultSet allAdmin = pst.executeQuery();
           
            return allAdmin;
            

        } catch (SQLException ex) {
            Logger.getLogger(ProduitDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public ResultSet getZoneById(int id) {

        try {
            pst = connection.prepareStatement("SELECT nom FROM zone where id=" + id + ";");
            ResultSet allAdmin = pst.executeQuery();

            return allAdmin;

        } catch (SQLException ex) {
            Logger.getLogger(ProduitDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
      
}
