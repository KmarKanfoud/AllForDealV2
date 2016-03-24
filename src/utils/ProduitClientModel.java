/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import GUI.*;
import dao.ProduitDao;
import entite.Produit;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Lilya Thebti
 */
public class ProduitClientModel extends AbstractTableModel{
    List<Produit> l;

String [] colonnes={"id","nom","Categorie","Quantité","Description","prix","point Bonus","Zone","Ajouté le","TVA","Réduction"};
    public ProduitClientModel() {
       ProduitDao pdao = new ProduitDao();
       l = pdao.findAllByUser(FrameAccueil.getUserId());
    }

    @Override
    public int getRowCount() {
return l.size();    }

    @Override
    public int getColumnCount() {
 return colonnes.length;  
    }
@Override
    public Object getValueAt(int rowIndex, int columnIndex) {
switch (columnIndex){
    case 0: return l.get(rowIndex).getId();
    case 1: return l.get(rowIndex).getNomP();
    case 2: return l.get(rowIndex).getCategorie();
    case 3: return l.get(rowIndex).getQuantite();
    case 4: return l.get(rowIndex).getDescription();
    case 5: return l.get(rowIndex).getPrix();
    case 6: return l.get(rowIndex).getPtbonus();
    case 7: return l.get(rowIndex).getZoneName();
    case 8: return l.get(rowIndex).getDateAjout();
    case 9: return l.get(rowIndex).getTva();
    case 10: return l.get(rowIndex).getReduction();
    default: return null;
    }
    }
    @Override
    public String getColumnName(int i) {
      return colonnes[i];
    }
    
    
}
