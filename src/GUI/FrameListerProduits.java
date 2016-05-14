/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import dao.CommentDao;
import dao.ProduitDao;
import dao.ZoneDao;
import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import utils.CommentModel;
import utils.ProduitModel;

/**
 *
 * @author esprit
 */
public class FrameListerProduits extends javax.swing.JFrame {
ProduitDao pdao = new ProduitDao();
    ZoneDao zdao = new ZoneDao();
    /**
     * Creates new form FrameListerProduits
     */
    public FrameListerProduits() {
        initComponents();
         loadAllVille();
//        loadAllCollection();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbProduits = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        tfNomProduit = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tfPrix = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cbCategorie = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        tfTVA = new javax.swing.JTextField();
        tfReduction = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tfQuantite = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cbZone = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        tfPointBonus = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        taDescription = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        btnSupprimer = new javax.swing.JButton();
        bntModifier = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tbProduits.setModel(new ProduitModel());
        tbProduits.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbProduitsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbProduits);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tfNomProduit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNomProduitActionPerformed(evt);
            }
        });

        jLabel2.setText("Nom du Produit");

        tfPrix.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfPrixActionPerformed(evt);
            }
        });
        tfPrix.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfPrixKeyTyped(evt);
            }
        });

        jLabel3.setText("Catégorie");

        jLabel4.setText("Prix");

        jLabel5.setText("TVA");

        tfTVA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfTVAActionPerformed(evt);
            }
        });
        tfTVA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfTVAKeyTyped(evt);
            }
        });

        tfReduction.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfReductionKeyTyped(evt);
            }
        });

        jLabel6.setText("Réduction");

        tfQuantite.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfQuantiteKeyTyped(evt);
            }
        });

        jLabel7.setText("Quantité");

        jLabel8.setText("Gouvernorat");

        jLabel9.setText("Point Bonus");

        tfPointBonus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfPointBonusActionPerformed(evt);
            }
        });
        tfPointBonus.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfPointBonusKeyTyped(evt);
            }
        });

        taDescription.setColumns(20);
        taDescription.setRows(5);
        jScrollPane3.setViewportView(taDescription);

        jLabel10.setText("Description");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(jLabel10))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfPrix, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbZone, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cbCategorie, javax.swing.GroupLayout.Alignment.TRAILING, 0, 84, Short.MAX_VALUE)
                                    .addComponent(tfNomProduit, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addGap(47, 47, 47)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(tfTVA, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tfReduction, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tfQuantite, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tfPointBonus, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfNomProduit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbCategorie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfPrix, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbZone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tfTVA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfReduction, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfQuantite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfPointBonus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        btnSupprimer.setText("Supprimer");
        btnSupprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSupprimerActionPerformed(evt);
            }
        });

        bntModifier.setText("Modifier");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 636, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(18, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bntModifier)
                        .addGap(104, 104, 104)
                        .addComponent(btnSupprimer)
                        .addGap(243, 243, 243))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSupprimer)
                    .addComponent(bntModifier))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfNomProduitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNomProduitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNomProduitActionPerformed

    private void tfPrixActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfPrixActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfPrixActionPerformed

    private void tfPrixKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfPrixKeyTyped

    }//GEN-LAST:event_tfPrixKeyTyped

    private void tfTVAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfTVAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfTVAActionPerformed

    private void tfTVAKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfTVAKeyTyped

    }//GEN-LAST:event_tfTVAKeyTyped

    private void tfReductionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfReductionKeyTyped

    }//GEN-LAST:event_tfReductionKeyTyped

    private void tfQuantiteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfQuantiteKeyTyped

    }//GEN-LAST:event_tfQuantiteKeyTyped

    private void tfPointBonusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfPointBonusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfPointBonusActionPerformed

    private void tfPointBonusKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfPointBonusKeyTyped

    }//GEN-LAST:event_tfPointBonusKeyTyped

    private void tbProduitsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbProduitsMouseClicked
        int i = tbProduits.getSelectedRow();
        TableModel model =tbProduits.getModel();
        tfNomProduit.setText(model.getValueAt(i,1).toString());
       cbCategorie.setSelectedItem(model.getValueAt(i,2));
        tfQuantite.setText(model.getValueAt(i,3).toString());
        taDescription.setText(model.getValueAt(i,4).toString());
        tfPrix.setText(model.getValueAt(i,5).toString());
        tfPointBonus.setText(model.getValueAt(i,6).toString());
        cbZone.setSelectedItem(model.getValueAt(i,7));
        tfTVA.setText(model.getValueAt(i,9).toString());
        tfReduction.setText(model.getValueAt(i,10).toString());
        
    }//GEN-LAST:event_tbProduitsMouseClicked

    private void btnSupprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSupprimerActionPerformed
        FrameListerProduits frameListeProduits = new FrameListerProduits(); 
        int i = tbProduits.getSelectedRow();
         Object l=tbProduits.getValueAt(i, 0);
         

        ProduitDao pdao=new ProduitDao();
        
        int j =JOptionPane.showConfirmDialog(null, "la suppression est irréversible. Etes-vous sur de vouloir continuer?", "Veuillez confirmer votre choix", JOptionPane.YES_NO_OPTION);
      
        if (j==0){
            pdao.removeById((int)l);
        
        tbProduits.setModel(new ProduitModel() );

        jScrollPane2.setViewportView(tbProduits);
       
        
       }
    }//GEN-LAST:event_btnSupprimerActionPerformed

    /**
     * @param args the command line argument
     */
    public static void main(String args[]) {
          Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screenSize = tk.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrameListerProduits.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameListerProduits.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameListerProduits.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameListerProduits.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
//                
//                 FrameListerProduits flp = new FrameListerProduits();
//                flp.setVisible(true);
//                flp.setResizable(false);
//
//                flp.setSize(screenWidth / 2, screenHeight / 2);
//                flp.setLocation(screenWidth / 4, screenHeight / 4);
//                
//                
//                
                new FrameListerProduits().setVisible(true);
            }
        });
    }
private void loadAllVille() {
        try {
            ResultSet res = zdao.getAllVille();

            while (res.next()) {

                cbZone.addItem(res.getString(1));
              // System.out.println(res.getString(1));

            }
        } catch (SQLException ex) {
//            Logger.getLogger(FrameAjouterProduit.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//    private void loadAllCollection() {
//        try {
//         //   ResultSet res = pdao.getCategories();
//
//            while (res.next()) {
//
//                cbCategorie.addItem(res.getString(1));
//              // System.out.println(res.getString(1));
//
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(FrameAjouterProduit.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntModifier;
    private javax.swing.JButton btnSupprimer;
    private javax.swing.JComboBox cbCategorie;
    private javax.swing.JComboBox cbZone;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea taDescription;
    private javax.swing.JTable tbProduits;
    private javax.swing.JTextField tfNomProduit;
    private javax.swing.JTextField tfPointBonus;
    private javax.swing.JTextField tfPrix;
    private javax.swing.JTextField tfQuantite;
    private javax.swing.JTextField tfReduction;
    private javax.swing.JTextField tfTVA;
    // End of variables declaration//GEN-END:variables
}
