/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import dao.CommentDao;
import entite.Comment;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.swing.JOptionPane;
import utils.CommentModel;

/**
 *
 * @author SaharS
 */
public class FrameListCommentaire extends javax.swing.JFrame {

    Toolkit tk = Toolkit.getDefaultToolkit();
    Dimension screenSize = tk.getScreenSize();
    int screenHeight = screenSize.height;
    int screenWidth = screenSize.width;

    /**
     * Creates new form ListComment
     */
    public FrameListCommentaire() {
        initComponents();

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
        ListComment = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        BtnSupprimer = new javax.swing.JButton();
        BtnModifier = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ListComment.setModel(new CommentModel());
        jScrollPane1.setViewportView(ListComment);

        BtnSupprimer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete.jpg"))); // NOI18N
        BtnSupprimer.setText("Supprimer");
        BtnSupprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSupprimerActionPerformed(evt);
            }
        });

        BtnModifier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit.jpg"))); // NOI18N
        BtnModifier.setText("Modifier");
        BtnModifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnModifierActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(156, 156, 156)
                .addComponent(BtnModifier)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addComponent(BtnSupprimer)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnSupprimer)
                    .addComponent(BtnModifier))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 604, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 141, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnSupprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSupprimerActionPerformed
        int ligneSelectionne = ListComment.getSelectedRow();
        Object l = ListComment.getValueAt(ligneSelectionne, 0);
        System.out.println(l);
        CommentDao comm = new CommentDao();
        int i = JOptionPane.showConfirmDialog(null, "La suppression est irréversible. Êtes-vous sûr de vouloir continuer?",
                "Veuillez confirmer votre choix",
                JOptionPane.YES_NO_OPTION);

        if (i == 0) {
           // Object o = ListComment.getValueAt(ligneSelectionne, 3);
           // System.out.println(o);
            comm.removeById((int) l);
            ListComment.setModel(new CommentModel());
            jScrollPane1.setViewportView(ListComment);
        }
    }//GEN-LAST:event_BtnSupprimerActionPerformed

    private void BtnModifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnModifierActionPerformed
        int ligneSelectionne = ListComment.getSelectedRow();
        Object l = ListComment.getValueAt(ligneSelectionne, 0);
        FrameModifierCommentaire frameModifier = new FrameModifierCommentaire();
        CommentDao dao = new CommentDao();
        Comment c = new Comment();
       // c.setId(ligneSelectionne);
         //c.setBody((String)ListComment.getValueAt(ligneSelectionne,1));
         c.setId((int)ListComment.getValueAt(ligneSelectionne,0));
     FrameModifierCommentaire frame=new FrameModifierCommentaire();
                     frame.setVisible(true);
                     frame.setC(c);
                     frame.getTFComment().setText((String)ListComment.getValueAt(ligneSelectionne,1));                  
                     System.out.println(c);

        //frame.setVisible(true);
        frame.setResizable(false);
        frame.setSize(screenWidth / 2, screenHeight / 2);
        frame.setLocation(screenWidth / 4, screenHeight / 4);
    }//GEN-LAST:event_BtnModifierActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(FrameListCommentaire.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameListCommentaire.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameListCommentaire.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameListCommentaire.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            Toolkit tk = Toolkit.getDefaultToolkit();
            Dimension screenSize = tk.getScreenSize();
            int screenHeight = screenSize.height;
            int screenWidth = screenSize.width;

            public void run() {

                FrameListCommentaire fl = new FrameListCommentaire();
                fl.setVisible(true);
                fl.setResizable(false);

                fl.setSize(screenWidth / 2, screenHeight / 2);
                fl.setLocation(screenWidth / 4, screenHeight / 4);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnModifier;
    private javax.swing.JButton BtnSupprimer;
    public static javax.swing.JTable ListComment;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
