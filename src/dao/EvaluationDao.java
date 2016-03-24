/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Idao.IEvaluationDao;
import entite.Evaluation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
public class EvaluationDao implements IEvaluationDao {

    private Connection connection;
    private PreparedStatement pst;

    public EvaluationDao() {
        connection = DataSource.getInstance().getConnection();
    }
    private static IEvaluationDao iEvaluationDAO;

    public static IEvaluationDao getInstance() {
        if (iEvaluationDAO == null) {
            iEvaluationDAO = new EvaluationDao();
        }
        return iEvaluationDAO;
    }

    @Override
    public void addEvaluation(Evaluation e) {
        String req = "insert into evaluation (note,id_produit) values (?,?)";
        try {
            pst = connection.prepareStatement(req);
            pst.setInt(1, e.getNote());
            //pst.setInt(2, e.getId_produit());
            pst.executeUpdate();

        } catch (SQLException ex) {

            Logger.getLogger(CommentDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Evaluation> findAllEvaluations() {

        List<Evaluation> listeevaluations = new ArrayList<>();
        String requete = "select * from evaluation";
        try {
            Statement statement = connection
                    .createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            while (resultat.next()) {
                Evaluation e = new Evaluation();
                e.setNote(resultat.getInt(2));
               // e.setId_produit(resultat.getInt(3));
                listeevaluations.add(e);
            }
            return listeevaluations;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur  " + ex.getMessage());
            return null;
        }
    }

//   
//    public Evaluation findById(int num) {
//         Evaluation ev= new Evaluation();
//        
//        String req = "select * from evaluation where id_produit="+num;
//        try {
//            pst = connection.prepareStatement(req);
//          
//            ResultSet resultat = pst.executeQuery(req);
//
//            while (resultat.next()) {
//                Evaluation e = new Evaluation();
//                e.setNote(resultat.getInt(2));    
//            }
//            return ev;
//        } catch (SQLException ex) {
//            System.out.println("erreur Recherche all " + ex.getMessage());
//            return ev;
//        }
//    }
}
