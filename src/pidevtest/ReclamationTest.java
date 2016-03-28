/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidevtest;

import dao.CommentDao;
import dao.ReclamationDao;
import entite.Reclamation;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author SaharS
 */
public class ReclamationTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Date date = java.sql.Date.valueOf(LocalDate.now());
        //Reclamation r1 = new Reclamation(date, "obj1", "reclamation");

        ReclamationDao pdao = new ReclamationDao();
        // pdao.add(r1);
        //r1.setDescription("sahar");
        // r1.setSujet("sahar");
        //pdao.update(r1);
          // pdao.removeById(2);
        List<Reclamation> rec= new ArrayList();
        //com = pdao.DisplayCommentaireByUserProduit(10,21);
     rec = pdao.findAll();
     System.out.println(rec);
    }
}
