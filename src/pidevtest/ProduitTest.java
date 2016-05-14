/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidevtest;

import dao.ProduitDao;
import entite.Produit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author esprit
 */
public class ProduitTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Date date = new java.sql.Date(System.currentTimeMillis());
       // Produit p1 = new Produit(5, 2, 2, 10, "fcghbjn", 2, 20, "pontalon", "cfvgbhjnk,l;nhbugvyfct", 12000, 156, 1566 ,31  , 50  , "2016-03-08");
     //   Produit p2 = new Produit(32, 2, 2, 10, "fcghbjn", 2, 20, "pontalon", "cfvgbhjnk,l;nhbugvyfct", 12000, 156, 1566 ,31  , 50  , date);
    // Produit p3 = new Produit(7, 2, 2, 10, "fcghbjn", 2, 20, "pontalon", "cfvgbhjnk,l;nhbugvyfct", 12000, 156, 1566 ,31  , 50  , "2016-03-08");
    // Produit p4 = new Produit(17, 2, 2, 10, "fcghbjn", 2, 20, "pontalon", "cfvgbhjnk,l;nhbugvyfct", 12000, 156, 1566 ,31  , 50  , date);
        
        ProduitDao pdao = new ProduitDao();
        Produit p =new Produit();
   //   Produit p2 = new Produit(32, 2, 2, 10, "fcghbjn", 2, 20, "pontalon", "cfvgbhjnk,l;nhbugvyfct", 12000, 156, 1566 ,31  , 50  , date);
  //   pdao.add(p2);
       // pdao.add(p3);
        
//       p2.setNomP("lilya");
//      pdao.update(p2);
       
   //    pdao.removeById(1);
    List<Produit>LP = new ArrayList();
       LP = pdao.findAll();
//        System.out.println(LP);
//        

//            p2.setRating(p2.getRating() +1);
//        pdao.updateRating(p2);
//        System.out.println(p2);
    }
    
}
