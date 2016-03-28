/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import GUI.FrameAccueil;
import dao.CommentDao;
import entite.Comment;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author SaharS
 */
public class CommentUserModel  extends AbstractTableModel {
    
    List<Comment> com;
    String[] colonnes = { "Commentaire", "Ajouté le", "Réference produit", "Nom produit"};

    public CommentUserModel() {
        CommentDao pdao = new CommentDao();
            //com = pdao.DisplayAllCommentaireByUser(FrameAccueil.getUserId());
        com = pdao.DisplayAllCommentaireByUser(10);
    }

    @Override
    public int getRowCount() {
        return com.size();
    }

    @Override
    public int getColumnCount() {
        return colonnes.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
//            case 0:
//                return com.get(rowIndex).getId();
            case 0:
                return com.get(rowIndex).getBody();
            case 1:
                return com.get(rowIndex).getCreated_at();
            case 2:
                return com.get(rowIndex).getProduit_id();
            case 3:
                return com.get(rowIndex).getNomP();

            default:
                return null;
        }

    }

    public String getColumnName(int i) {
        return colonnes[i];
    }
    
}
