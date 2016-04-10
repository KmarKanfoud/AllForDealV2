package GUI;


import java.awt.BorderLayout;
import javax.swing.JFrame;
import utils.PlayerPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


class VideoPlayer extends JFrame {

     public VideoPlayer() {
          PanelVideo player = new PanelVideo();
          this.setTitle("Swing Video Player");
          this.setDefaultCloseOperation(HIDE_ON_CLOSE);
          this.setLayout(new BorderLayout());
          this.setSize(640, 480);
          this.setLocationRelativeTo(null);
          this.add(player, BorderLayout.CENTER);
          this.validate();
          this.setVisible(true);

         player.play("C:\\Users\\SaharS\\Desktop\\JAVA.MP4");
     }

   

    
}