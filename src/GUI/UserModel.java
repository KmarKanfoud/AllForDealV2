/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import dao.UserDao;
import entite.User;
import java.util.List;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author maroo
 */
public class UserModel extends AbstractTableModel{

        List<User> lp ;
  String[]colonnes ={"id","username","passowrd","email","DateCreation","Bonus","Roles","Etat"};
    
    public UserModel() {
        UserDao udao=new UserDao();
        
        lp=udao.findAll();
        
    }

    
    @Override
    public int getRowCount() {
        return lp.size();
    }

    @Override
    public int getColumnCount() {
        return colonnes.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0 :
                 return lp.get(rowIndex).getId();
            
               
              case 1:
                     return lp.get(rowIndex).getUsername();
                case 2:
                         return lp.get(rowIndex).getPassword();
                case 3:
                         return lp.get(rowIndex).getEmail();
                case 4:
                         return lp.get(rowIndex).getCreated_at();
                case 5:
                         return lp.get(rowIndex).getBonus();
                case 6:
                         return lp.get(rowIndex).getRoles();
                case 7:
                         return lp.get(rowIndex).getEnabled();
            
        }
        return null;
    }
        @Override
       public String getColumnName(int i) {
        return colonnes[i] ;//To change body of generated methods, choose Tools | Templates.
    }
    
}
