
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import dao.UserDao;
import entite.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author maroo
 */
public class Statestique  {

    private Connection connection;
    private PreparedStatement pst;

    public Statestique() {
        //initialiser la connection
        connection = DataSource.getInstance().getConnection();
    } 

   public int nbfemme(){
        String req="select count(*) from fos_user_user where gender='f'";
       int f=0;
          try {
            PreparedStatement ps = connection.prepareStatement(req);
            
            ResultSet resultat = ps.executeQuery();
           while(resultat.next()){
               f=Integer.parseInt(resultat.getString(1));
               
           }
           return f;
          }
         catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
            return f;
        }
   }
    public int nbUser()  {
        String req="select count(*) from fos_user_user";
       int f=0;
          try {
            PreparedStatement ps = connection.prepareStatement(req);
            
            ResultSet resultat = ps.executeQuery();
           while(resultat.next()){
               f=Integer.parseInt(resultat.getString(1));
               
           }
           return f;
          }
         catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
            return f;
        }
    }
    public int nbProduit()  {
        String req="select count(*) from produit";
       int f=0;
          try {
            PreparedStatement ps = connection.prepareStatement(req);
            
            ResultSet resultat = ps.executeQuery();
           while(resultat.next()){
               f=Integer.parseInt(resultat.getString(1));
               
           }
           return f;
          }
         catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
            return f;
        }
    }
    public int nbService()  {
        String req="select count(*) from service";
       int f=0;
          try {
            PreparedStatement ps = connection.prepareStatement(req);
            
            ResultSet resultat = ps.executeQuery();
           while(resultat.next()){
               f=Integer.parseInt(resultat.getString(1));
               
           }
           return f;
          }
         catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
            return f;
        }
    }
    public int nbComment()  {
        String req="select count(*) from comment";
       int f=0;
          try {
            PreparedStatement ps = connection.prepareStatement(req);
            
            ResultSet resultat = ps.executeQuery();
           while(resultat.next()){
               f=Integer.parseInt(resultat.getString(1));
               
           }
           return f;
          }
         catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
            return f;
        }
    }
    public int nbPauP()  {
        String req="select count(*) from panier";
       int f=0;
          try {
            PreparedStatement ps = connection.prepareStatement(req);
            
            ResultSet resultat = ps.executeQuery();
           while(resultat.next()){
               f=Integer.parseInt(resultat.getString(1));
               
           }
           return f;
          }
         catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
            return f;
        }
    }
    
}
