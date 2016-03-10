/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidevtest;

import dao.ServiceDao;

import entite.Service;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Super
 */
public class ServiceTest {

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        Date date = new java.sql.Date(System.currentTimeMillis());
        //Service s1 = new Service(6, "dcdv", "sfvs", "cscd", "vdsfc", date);
        Service s2 = new Service(7, "testGIt", "git", "git", "git", date);
        ServiceDao pdao = new ServiceDao();
        //pdao.add(s1);
        //pdao.add(s2);
       // s2.setNomService("Maison");
       // pdao.update(s2);
        pdao.removeById(6);

    }
}
