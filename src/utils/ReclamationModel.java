/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;


import dao.ReclamationDao;
import entite.Reclamation;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author SaharS
 */
public class ReclamationModel extends AbstractTableModel {

    List<Reclamation> rec;
    String[] colonnes = {"id réclamation", "Date réception", "Description","Sujet","Envoyé par"};

    public ReclamationModel() {
        ReclamationDao rdao = new ReclamationDao();
        rec = rdao.findAll();
    }

    @Override
    public int getRowCount() {
        return rec.size();
    }

    @Override
    public int getColumnCount() {
        return colonnes.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return rec.get(rowIndex).getId_reclamation();
            case 1:
                return rec.get(rowIndex).getDate();
            case 2:
                return rec.get(rowIndex).getDescription();
            case 3:
                return rec.get(rowIndex).getSujet();
            case 4 :
                return rec.get(rowIndex).getUsername();

            default:
                return null;
        }

    }

    public String getColumnName(int i) {
        return colonnes[i];
    }
}
