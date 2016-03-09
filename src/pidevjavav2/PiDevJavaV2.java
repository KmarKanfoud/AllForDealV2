/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidevjavav2;

import dao.ServiceDao;
import entite.Service;
import java.util.Date;

/**
 *
 * @author Super
 */
public class PiDevJavaV2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    
        Date date = new java.sql.Date(System.currentTimeMillis());
       Service s1 = new Service(6, "dcdv", "sfvs", "cscd", "vdsfc", date);

        ServiceDao pdao = new ServiceDao();
        pdao.add(s1);
        
}}
