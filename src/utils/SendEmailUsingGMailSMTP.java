/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import dao.*;
import entite.User;
import static java.lang.ProcessBuilder.Redirect.to;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SaharS
 */
public class SendEmailUsingGMailSMTP {

    public static void main(String[] args) {
       String to = null ;
        UserDao u = new UserDao();
      List  listeTo = new ArrayList();
      listeTo= u.findAllEmail();
      
//     
//      for (Object o : listeTo) {
//         to = (String)o;
//        }
//      
      
      
     

        String from = "allfordealpi@gmail.com";
        final String username = "allfordealpi@gmail.com";
        final String password = "pidev2016";

        String host = "smtp.gmail.com";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587");

        // Get the Session object.
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);

            message.setFrom(new InternetAddress(from));
            
           for (Object o : listeTo) {
                
                   to = (String)o;
                      System.out.println(to);
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to));
            
                 
          
       
           
            message.setSubject("Testing Subject");

            message.setText(" Sahar testing APImail to sent a message to all users");

            // Send message
            Transport.send(message);
           }
            System.out.println("Sent message successfully....");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

}
