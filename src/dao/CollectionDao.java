/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Idao.IDao;
import dao.ProduitDao;
import dao.ServiceDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.DataSource;

/**
 *
 * @author Super Moon
 */
public class CollectionDao implements IDao<Collection> {
    
    
     private Connection connection;
    private PreparedStatement pst;

    public CollectionDao() {
        connection = DataSource.getInstance().getConnection();
    }
    
    
    
    
    
     public ResultSet getAllCollection() {

        try {
            pst = connection.prepareStatement("SELECT name FROM classification__collection;");
            ResultSet allAdmin = pst.executeQuery();
            return allAdmin;

        } catch (SQLException ex) {
            Logger.getLogger(ProduitDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ResultSet getCollectionByName(String name) {

        try {
            pst = connection.prepareStatement("SELECT id FROM classification__collection where name='" + name + "';");
            ResultSet allAdmin = pst.executeQuery();

            return allAdmin;

        } catch (SQLException ex) {
            Logger.getLogger(CollectionDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public ResultSet getCollectionById(int id) {

        try {
            pst = connection.prepareStatement("SELECT name FROM classification__collection where id=" + id + ";");
            ResultSet allAdmin = pst.executeQuery();

            return allAdmin;

        } catch (SQLException ex) {
            Logger.getLogger(CollectionDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
     public ResultSet getCollection() {

        try {
            pst = connection.prepareStatement("SELECT name FROM classification__collection;");
            ResultSet allAdmin = pst.executeQuery();
            return allAdmin;

        } catch (SQLException ex) {
            Logger.getLogger(CollectionDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void add(Collection t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Collection t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Collection> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
