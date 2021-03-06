/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import GUI.AllForDealFrame;
import GUI.DashbordAdminFrame;
import GUI.FrameGestionProduitAdmin;
import dao.CommentDao;
import entite.Comment;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author SaharS
 */
public class CommentDPModel extends AbstractTableModel {

  List<Comment> com;
    String[] colonnes = {"id","Commentaire", "Ajouté le", "ajouté par"};

    public CommentDPModel() {
        CommentDao pdao = new CommentDao();
        //com = pdao.DisplayAllCommentaireByProduit(1);
        //com = pdao.DisplayCommentaireByUserProduit(FrameAccueil.getUserId(), FrameGestionProduitAdmin.getProd_id());
        com = pdao.DisplayCommentProduit(DashbordAdminFrame.getProduit_id());
      
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
            case 0:
                return com.get(rowIndex).getId();
            case 1:
                return com.get(rowIndex).getBody();
            case 2:
                return com.get(rowIndex).getCreated_at();
            case 3:
                return com.get(rowIndex).getUsername();
            default:
                return null;
        }

    }

    public String getColumnName(int i) {
        return colonnes[i];
    }
}
