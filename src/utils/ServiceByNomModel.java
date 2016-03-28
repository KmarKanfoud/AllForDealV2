
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import GUI.FrameAfficherServiceAll;
import dao.ServiceDao;
import dao.ZoneDao;
import entite.Service;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Super
 */
public class ServiceByNomModel extends AbstractTableModel{

    List<Service> l;
    String[] colonnes = {"id", "nom Service", "Description", "Catégorie", "etat", "zone", "Ajouté le"};
    ZoneDao zoneDAO = new ZoneDao();
    public ServiceByNomModel() {
        
        ServiceDao pdao = new ServiceDao();
       l = pdao.findByName(FrameAfficherServiceAll.getNomS());
   
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
                return l.get(rowIndex).getType();
            case 4:
                return l.get(rowIndex).getEtat();
            case 5:
                return l.get(rowIndex).getZoneName();
            case 6:
                return l.get(rowIndex).getDateAjout();

            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int i) {
        return colonnes[i];
    }

}


