/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import dao.CommentDao;
import entite.Comment;
import java.util.List;
import GUI.*;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author SaharS
 */
public class CommentPModel extends AbstractTableModel {

    List<Comment> com;
    String[] colonnes = { "Commentaire", "Ajouté le"};

    public CommentPModel() {
        CommentDao pdao = new CommentDao();
        //com = pdao.DisplayAllCommentaireByProduit(1);
        com = pdao.DisplayAllCommentaireByProduit(FrameGestionProduitAdmin.getProd_id());
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

            default:
                return null;
        }

    }

    public String  getColumnName(int i) {
        return colonnes[i];
    }
}
