/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidevtest;

import GUI.FrameAccueil;
import GUI.FrameGestionProduitAdmin;
import dao.CommentDao;
import entite.Comment;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author SaharS
 */
public class CommentTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //DateFormat dateFormat = new SimpleDateFormat("yyy/MM/dd HH:mm:ss");
        //Date date = new Date();
        //System.out.println(dateFormat.format(date));
        Date date = new java.sql.Date(System.currentTimeMillis());
       // Comment c1 = new Comment("Bonjour", date);
        // Comment c2=  new Comment("AllForDeal", date);
        CommentDao pdao = new CommentDao();
        //pdao.add(c1);
        //pdao.add(c2);
        // c2.setBody("sahar");
        // pdao.update(c2);
        //pdao.removeById(12);
       List<Comment> com = new ArrayList();
      //com = pdao.DisplayCommentaireByUserProduit(10,21);
        com = pdao.DisplayCommentService(12);
        System.out.println(com);
    }

}
