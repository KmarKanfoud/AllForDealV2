/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidevtest;

import dao.UserDao;
import entite.User;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author maroo
 */
public class UserTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        java.sql.Date d = java.sql.Date.valueOf(LocalDate.now());

      // User u1  = new User("User1", "User1", "user1@user.com", "user1@user.com", 1, "user1", "m", 5859687 , "Mirou1", "alli1", "ROLE_ADMIN",d,123,"tunis");
        //  User u2  = new User(2, "Ahmed", "Tounsi");
        UserDao udao = new UserDao();
//        p1.setNom("Sahar");
//        pdao.update(p1);

       //udao.removeById(13);
        //System.out.println(udao.findAllEmail());
        String to;
        UserDao u = new UserDao();
        List listeTo = new ArrayList();
        listeTo = u.findAllEmail();

        for (Object o : listeTo) {
            to = (String) o;
            System.out.println(to);
        }
    }
}
