/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidevtest;

import dao.EvaluationDao;
import entite.Evaluation;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SaharS
 */
public class EvaluationTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EvaluationDao pdao = new EvaluationDao();
//        Evaluation e1 = new Evaluation(21, 12);
//        pdao.add(e1);
   
        List<Evaluation> ev = new ArrayList();
        ev = pdao.findAllEvaluations();
        System.out.println(ev);
    }
}
