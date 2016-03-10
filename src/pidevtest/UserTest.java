/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidevtest;

import dao.UserDao;
import entite.User;
import java.time.LocalDate;
import java.util.Date;


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
        
       User u1  = new User("User1", "User1", "user1@user.com", "user1@user.com", 1, "user1", "m", 5859687 , "Mirou1", "alli1", "ROLE_ADMIN",d);
      //  User u2  = new User(2, "Ahmed", "Tounsi");
        UserDao udao = new UserDao();
//        p1.setNom("Sahar");
//        pdao.update(p1);
     
        udao.add(u1);
    }
    
}
