/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Idao;

import entite.Evaluation;
import java.util.List;

/**
 *
 * @author SaharS
 */
public interface IEvaluationDao {
        
    void addEvaluation(Evaluation evaluation);
    List<Evaluation> findAllEvaluations();
    
}
