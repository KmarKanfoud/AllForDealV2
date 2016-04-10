package utils;


import com.sun.jna.NativeLibrary;
import java.awt.BorderLayout;
import java.io.File;
import javax.swing.JPanel;
import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author majdletaief
 */
public class PlayerPanel extends JPanel {

     private File vlcInstallPath = new File("C:\\Program Files\\VideoLAN\\VLC");
     private EmbeddedMediaPlayer player;

     public PlayerPanel() {
         NativeLibrary.addSearchPath("libvlc", vlcInstallPath.getAbsolutePath());
         EmbeddedMediaPlayerComponent videoCanvas = new EmbeddedMediaPlayerComponent();
         this.setLayout(new BorderLayout());
         this.add(videoCanvas, BorderLayout.CENTER);
         this.player = videoCanvas.getMediaPlayer();
     }

     public void play(String media) {
         player.prepareMedia(media);
         player.parseMedia();
         player.play();
     }
 }
