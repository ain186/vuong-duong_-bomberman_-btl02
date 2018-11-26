package uet.oop.bomberman.sound;

import javax.sound.sampled.*;
import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class testSound extends JFrame{

    Clip clip;

    public testSound() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Test Sound Clip");
        this.setSize(100, 100);
        this.setVisible(false);
        try {
            // Open an audio input stream.
            File soundFile = new File("C:\\Users\\zeroa\\IdeaProjects\\bomberman-starter-starter-project-1\\sound\\MusicOpen.wav"); //you could also get the sound file with an URL
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
            // Get a sound clip resource.
            clip = AudioSystem.getClip();
            // Open audio clip and load samples from the audio input stream.
            clip.open(audioIn);

        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch ( IOException e) {
            e.printStackTrace();
        } catch ( LineUnavailableException e ) {
            e.printStackTrace();
        }
    }

    public void play(){
//        clip.setFramePosition(0);  // Must always rewind!
        clip.start();
    }
    public void loop(){
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    public void stop(){
        clip.stop();
    }

    public static void main(String[] args) {
        testSound t = new testSound();
        t.play();
    }

}
