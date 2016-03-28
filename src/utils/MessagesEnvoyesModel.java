/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import GUI.LoginForm;
import dao.MessageDao;
import entite.Message;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author SaharS
 */
public class MessagesEnvoyesModel extends AbstractTableModel {
     List<Message> msgs;
    String[] colonnes = { "De la part de", "Sujet", "Messgae","Réçu le"};

    public MessagesEnvoyesModel() {
        MessageDao mdao = new MessageDao();
        msgs= mdao.findBySender(LoginForm.getUserName());
    }
    
    

    @Override
    public int getRowCount() {
   return msgs.size();
    }

    @Override
    public int getColumnCount() {
              return colonnes.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
 switch (columnIndex) {
            case 0:
                return msgs.get(rowIndex).getFrom();
            case 1:
                return msgs.get(rowIndex).getSujet();
            case 2:
                return msgs.get(rowIndex).getTexte();
            case 3:
                return msgs.get(rowIndex).getDate_envoi();
           

            default:
                return null;
        }
    }
    
    public String getColumnName(int i) {
        return colonnes[i];
    }
    
}
