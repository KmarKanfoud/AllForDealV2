/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import dao.ReclamationDao;
import dao.UserDao;
import entite.Reclamation;
import entite.User;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.Set;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.Mixer;
import javax.sound.sampled.UnsupportedAudioFileException;
import sun.applet.Main;

/**
 *
 * @author SaharS
 */
public class FrameAccueil extends javax.swing.JFrame {

    /**
     * Creates new form FrameAccueil
     */

    
    public static Mixer mixer;
    public static Clip clip;

    private static int user_id;


    public static int getUserId() {
        return user_id;
    }

    public static void setUserId(int user_id) {
        FrameAccueil.user_id = user_id;
    }

    public FrameAccueil(int user_id) {
        initComponents();
        this.user_id = user_id;
        System.out.println(user_id);
        User u = new User();
        UserDao udao = new UserDao();
        u = udao.findById(user_id);

    }

    public FrameAccueil() {
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

        jPanel4 = new javax.swing.JPanel();
        Service = new javax.swing.JTabbedPane();
        ProduitLabel = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        AcheterBtn = new javax.swing.JButton();
        ProposerPBtn = new javax.swing.JButton();
        ServicePanel = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        ConsulterBtn = new javax.swing.JButton();
        ProposerServiceBtn = new javax.swing.JButton();
        ReclamationPanel = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        TFSujet = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        TFDescription = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        EnvoyerReclamationBtn = new javax.swing.JButton();
        erreur1 = new javax.swing.JLabel();
        erreur2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lUserName = new javax.swing.JLabel();
        lEmail = new javax.swing.JLabel();
        lGender = new javax.swing.JLabel();
        lAdress = new javax.swing.JLabel();
        lBunus = new javax.swing.JLabel();
        lNom = new javax.swing.JLabel();
        lPrenom = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lcreation = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 365, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 250, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        AcheterBtn.setText("Acheter");
        AcheterBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AcheterBtnActionPerformed(evt);
            }
        });

        ProposerPBtn.setText("Proposer");
        ProposerPBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProposerPBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap(62, Short.MAX_VALUE)
                .addComponent(AcheterBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(ProposerPBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AcheterBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ProposerPBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout ProduitLabelLayout = new javax.swing.GroupLayout(ProduitLabel);
        ProduitLabel.setLayout(ProduitLabelLayout);
        ProduitLabelLayout.setHorizontalGroup(
            ProduitLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProduitLabelLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(151, Short.MAX_VALUE))
        );
        ProduitLabelLayout.setVerticalGroup(
            ProduitLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProduitLabelLayout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(183, Short.MAX_VALUE))
        );

        Service.addTab("Produit", ProduitLabel);

        ConsulterBtn.setText("Consulter");
        ConsulterBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsulterBtnActionPerformed(evt);
            }
        });

        ProposerServiceBtn.setText("Proposer");
        ProposerServiceBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProposerServiceBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap(70, Short.MAX_VALUE)
                .addComponent(ConsulterBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(ProposerServiceBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ConsulterBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ProposerServiceBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout ServicePanelLayout = new javax.swing.GroupLayout(ServicePanel);
        ServicePanel.setLayout(ServicePanelLayout);
        ServicePanelLayout.setHorizontalGroup(
            ServicePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ServicePanelLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(147, Short.MAX_VALUE))
        );
        ServicePanelLayout.setVerticalGroup(
            ServicePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ServicePanelLayout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(192, Short.MAX_VALUE))
        );

        Service.addTab("Service", ServicePanel);

        TFSujet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TFSujetActionPerformed(evt);
            }
        });

        jLabel3.setText("Sujet");

        jLabel4.setText("Description");

        EnvoyerReclamationBtn.setText("Envoyer");
        EnvoyerReclamationBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EnvoyerReclamationBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGap(0, 18, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(EnvoyerReclamationBtn)
                                .addGap(19, 19, 19))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(TFSujet, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(TFDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(TFSujet, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(5, 5, 5)
                .addComponent(TFDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(EnvoyerReclamationBtn)
                .addContainerGap(56, Short.MAX_VALUE))
        );

        erreur1.setForeground(new java.awt.Color(255, 0, 0));

        erreur2.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout ReclamationPanelLayout = new javax.swing.GroupLayout(ReclamationPanel);
        ReclamationPanel.setLayout(ReclamationPanelLayout);
        ReclamationPanelLayout.setHorizontalGroup(
            ReclamationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ReclamationPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ReclamationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(erreur1)
                    .addComponent(erreur2))
                .addContainerGap(200, Short.MAX_VALUE))
        );
        ReclamationPanelLayout.setVerticalGroup(
            ReclamationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ReclamationPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
            .addGroup(ReclamationPanelLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(erreur1)
                .addGap(98, 98, 98)
                .addComponent(erreur2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Service.addTab("Réclamation", ReclamationPanel);

        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });

        lUserName.setText("-");

        lEmail.setText("-");

        lGender.setText("-");

        lAdress.setText("-");

        lBunus.setText("-");

        lNom.setText("-");

        lPrenom.setText("-");

        jLabel1.setText("UserName :");

        jLabel2.setText("Email :");

        jLabel5.setText("Genre");

        jLabel6.setText("Addresse :");

        jLabel7.setText("Bonus :");

        jLabel8.setText("Nom :");

        jLabel9.setText("Prenom :");

        lcreation.setText("-");

        jLabel10.setText("Création de Compte :");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lcreation))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lPrenom))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lNom))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lBunus))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lAdress))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lGender))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 150, Short.MAX_VALUE)
                        .addComponent(lEmail))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lUserName)))
                .addContainerGap(374, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lUserName)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lEmail)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lGender)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lAdress)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lBunus)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lNom)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lPrenom)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lcreation)
                    .addComponent(jLabel10))
                .addContainerGap(132, Short.MAX_VALUE))
        );

        Service.addTab("Profile", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Service)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Service)
                .addContainerGap())
        );

        setBounds(0, 0, 629, 486);
    }// </editor-fold>//GEN-END:initComponents

    private void EnvoyerReclamationBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EnvoyerReclamationBtnActionPerformed
        Reclamation r = new Reclamation();
        erreur1.setText(" ");
        // erreur2.setText(" ");
        if (!TFSujet.getText().equals("") || TFDescription.getText().equals(" ")) {
            r.setSujet(TFSujet.getText());
            r.setDescription(TFDescription.getText());
            Date date = new java.sql.Date(System.currentTimeMillis());
            r.setDate(date);
            ReclamationDao pdao = new ReclamationDao();
            pdao.add(r);
            TFSujet.setText("");
            TFDescription.setText("");
        } else {
            erreur1.setText("Veuiller introduire votre sujet");
            //  erreur2.setText("Veuiller introduire votre description de réclamation");
        }


    }//GEN-LAST:event_EnvoyerReclamationBtnActionPerformed

    private void TFSujetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TFSujetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TFSujetActionPerformed

    private void ProposerPBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProposerPBtnActionPerformed
       FrameAjouterProduit faP= new FrameAjouterProduit();
       faP.setVisible(true);
    }//GEN-LAST:event_ProposerPBtnActionPerformed

    private void AcheterBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AcheterBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AcheterBtnActionPerformed

    private void ConsulterBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsulterBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ConsulterBtnActionPerformed

    private void ProposerServiceBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProposerServiceBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ProposerServiceBtnActionPerformed

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        User u = new User();
        UserDao udao = new UserDao();
        u = udao.findById(user_id);
        lUserName.setText(u.getUsername());
        lEmail.setText(u.getEmail());
        lGender.setText(u.getGender());
        lAdress.setText(u.getAdress());
        lBunus.setText("" + u.getBonus());
        lNom.setText(u.getLastname());
        lPrenom.setText(u.getFirstname());
        lcreation.setText("" + u.getCreated_at());

    }//GEN-LAST:event_jPanel1MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screenSize = tk.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        Mixer.Info[] mixInfo = AudioSystem.getMixerInfo();
        mixer = AudioSystem.getMixer(mixInfo[0]);
        DataLine.Info dataLine = new DataLine.Info(Clip.class, null);
        try {
            clip = (Clip) mixer.getLine(dataLine);
        } catch (LineUnavailableException ex) {
            ex.printStackTrace();
        }
        try {
            URL soundURL = Main.class.getResource("/images/The_Eagles-Hotel_California_acoustic_live_www.wav");
            AudioInputStream audioImput = AudioSystem.getAudioInputStream(soundURL);
            clip.open(audioImput);

        } catch (LineUnavailableException ex) {
            ex.printStackTrace();
        } catch (UnsupportedAudioFileException exp) {
            exp.printStackTrace();
        } catch (IOException io) {
            io.printStackTrace();
        }

     


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
            java.util.logging.Logger.getLogger(FrameAccueil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameAccueil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameAccueil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameAccueil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrameAccueil fa = new FrameAccueil();
                fa.setVisible(true);
                fa.setResizable(false);

                fa.setSize(screenWidth / 2, screenHeight / 2);
                fa.setLocation(screenWidth / 4, screenHeight / 4);
            }
        });
        
           clip.start();

        do {
            try {
                Thread.sleep(50);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }

        } while (clip.isActive());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AcheterBtn;
    private javax.swing.JButton ConsulterBtn;
    private javax.swing.JButton EnvoyerReclamationBtn;
    private javax.swing.JPanel ProduitLabel;
    private javax.swing.JButton ProposerPBtn;
    private javax.swing.JButton ProposerServiceBtn;
    private javax.swing.JPanel ReclamationPanel;
    private javax.swing.JTabbedPane Service;
    private javax.swing.JPanel ServicePanel;
    private javax.swing.JTextField TFDescription;
    private javax.swing.JTextField TFSujet;
    private javax.swing.JLabel erreur1;
    private javax.swing.JLabel erreur2;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel lAdress;
    private javax.swing.JLabel lBunus;
    private javax.swing.JLabel lEmail;
    private javax.swing.JLabel lGender;
    private javax.swing.JLabel lNom;
    private javax.swing.JLabel lPrenom;
    private javax.swing.JLabel lUserName;
    private javax.swing.JLabel lcreation;
    // End of variables declaration//GEN-END:variables
}
