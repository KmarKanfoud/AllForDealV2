/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import GUI.AllForDealFrame;
import Idao.IDao;
import entite.Categorie;
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
 * @author Lilya Thebti
 */
public class CategorieDao implements IDao<Categorie>{

    
    private Connection connection;
    private PreparedStatement pst;

    public CategorieDao() {
      connection = DataSource.getInstance().getConnection();
    }

    
    
    
    @Override
    public void add(Categorie t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Categorie t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Categorie> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Categorie findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
public ResultSet getCategories() {

        try {
            pst = connection.prepareStatement("SELECT name FROM classification__category;");
            ResultSet allAdmin = pst.executeQuery();
            return allAdmin;

        } catch (SQLException ex) {
            Logger.getLogger(ProduitDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ResultSet getCategorieByName(String name) {

        try {
            pst = connection.prepareStatement("SELECT id FROM classification__category where name='" + name + "';");
            ResultSet allAdmin = pst.executeQuery();

            return allAdmin;

        } catch (SQLException ex) {
            Logger.getLogger(ProduitDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public ResultSet getCategorieById(int id) {

        try {
            pst = connection.prepareStatement("SELECT name FROM classification__category where id=" + id + ";");
            ResultSet allAdmin = pst.executeQuery();

            return allAdmin;

        } catch (SQLException ex) {
            Logger.getLogger(ProduitDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
 
}
