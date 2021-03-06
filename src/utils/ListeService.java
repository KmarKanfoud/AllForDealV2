/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import dao.CollectionDao;
import dao.ServiceDao;
import dao.ZoneDao;
import entite.Service;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Super
 */
public class ListeService extends AbstractTableModel {

    List<Service> l;
    String[] colonnes = {"id", "nom Service", "Description", "Catégorie", "etat", "zone", "Ajouté le"};
    ZoneDao zoneDAO = new ZoneDao();
    CollectionDao colDao = new CollectionDao();
    public ListeService() {
        
        ServiceDao sdao = new ServiceDao();
       // l = pdao.findAllByUser(1); // userID
       l = sdao.findAll(); // ALL
    }
// test git 
    @Override
    public int getRowCount() {
        return l.size();
    }

    @Override
    public int getColumnCount() {
        return colonnes.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            
            case 0:
                return l.get(rowIndex).getId();
            case 1:
                return l.get(rowIndex).getNomService();
            case 2:
                return l.get(rowIndex).getDescription();
            case 3:
                return l.get(rowIndex).getTypeName();
            case 4:
                return l.get(rowIndex).getEtat();
            case 5:
                return l.get(rowIndex).getZoneName();
            case 6:
                return l.get(rowIndex).getDateAjout();
//             case 7:
//                return l.get(rowIndex).getUserId();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int i) {
        return colonnes[i];
    }

}
