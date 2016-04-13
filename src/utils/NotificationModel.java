/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import GUI.FrameAccueil;
import dao.NotificationDao;
import entite.Notification;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author SaharS
 */
public class NotificationModel extends AbstractTableModel {
      List<Notification> note;
    String[] colonnes = {"Nom du service", "Nom d'utilisateur"};
    
    public  NotificationModel(){
        NotificationDao ndao = new NotificationDao();
        note = ndao.findNotificationService(FrameAccueil.getUserId());
    }
    @Override
    public int getRowCount() {
  return note.size();
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
                return note.get(rowIndex).getServiceNom();
            case 1:
                return note.get(rowIndex).getUserNom();
            default:
                return null;
        }
    }
    
    public String getColumnName(int i) {
        return colonnes[i];
    }
    
}
