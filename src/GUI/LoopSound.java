/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
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
public class LoopSound {
    public static Mixer mixer ;
    public static Clip clip ;
    
      public static void main(String[] args) {
          Mixer.Info[] mixInfo = AudioSystem.getMixerInfo(); 
          mixer = AudioSystem.getMixer(mixInfo[0]);
          DataLine.Info dataLine = new DataLine.Info(Clip.class, null);
  try{
      clip = (Clip)mixer.getLine(dataLine);}
      catch(LineUnavailableException ex){
          ex.printStackTrace();
      }
 try
 {
     URL soundURL = Main.class.getResource("/dao/The_Eagles-Hotel_California_acoustic_live_www.wav");
     AudioInputStream audioImput = AudioSystem.getAudioInputStream(soundURL);
     clip.open(audioImput);
     
 }catch(LineUnavailableException ex){
          ex.printStackTrace();
      }
 catch(UnsupportedAudioFileException exp){exp.printStackTrace(); }
  catch(IOException io){io.printStackTrace(); }

      clip.start();
     
      do{
          try {
              Thread.sleep(50);
          }
          catch(InterruptedException ie){ie.printStackTrace(); 
      }
      
      }while(clip.isActive());
      }
}