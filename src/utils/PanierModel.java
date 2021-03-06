/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import dao.PanierDao;
import entite.Panier;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Toshiba
 */
public class PanierModel extends AbstractTableModel {

    List<Panier> lp;
    //List<Produit> lpr ;
    String[] colonnes = {"id", "id-User", "Username", "id-Produit", "Nom-Produit", "Nombre des produits", "Description"};

    public PanierModel() {

        PanierDao pdao = new PanierDao();
        lp = pdao.findAll();
         // int x;

       //for( Panier p : lp){
        // x= ((Panier)p).getIdprod();
        // lpr.add(prdao.findById(x));
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
        switch (columnIndex) {

            case 0:
                return lp.get(rowIndex).getId();
            case 1:
                return lp.get(rowIndex).getIduser();
            case 2:
                return lp.get(rowIndex).getUsername();
            case 3:
                return lp.get(rowIndex).getIdprod();
            case 4:
                return lp.get(rowIndex).getNomP();
            case 5:
                return lp.get(rowIndex).getNbrprod();
            case 6:
                return lp.get(rowIndex).getDescription();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int i) {
        return colonnes[i];
    }

}
