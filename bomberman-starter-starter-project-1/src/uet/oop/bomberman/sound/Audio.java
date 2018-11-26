package uet.oop.bomberman.sound;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class Audio {

    static Clip _bombExplode, _mainMusic , _walk, _eatItem, _musicOpen, _gameOver,_victory ;


    public static void playMenuSelect(){
        try{
            AudioInputStream in = AudioSystem.getAudioInputStream(new File("sound/MenuSelect.wav"));
            Clip clip = AudioSystem.getClip();
            clip.open(in);
            clip.start();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void playEatItem(){
        try{
            AudioInputStream in = AudioSystem.getAudioInputStream(new File("sound\\eatItem.wav"));
            _eatItem = AudioSystem.getClip();
            _eatItem.open(in);
            _eatItem.start();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void playMusicOpen(){
        try{
            AudioInputStream in = AudioSystem.getAudioInputStream(new File("sound\\musicOpenTile.wav"));
            _musicOpen= AudioSystem.getClip();
            _musicOpen.open(in);
            _musicOpen.start();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void playBombExplode(){
        try{
            AudioInputStream in = AudioSystem.getAudioInputStream(new File("sound\\explosion.wav"));
            _bombExplode = AudioSystem.getClip();
            _bombExplode.open(in);
            _bombExplode.start();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void playVictory(){
        try{
            AudioInputStream in = AudioSystem.getAudioInputStream(new File("sound\\victory.wav"));
            _victory = AudioSystem.getClip();
            _victory.open(in);
            _victory.start();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void playLoopGameSong(){
        try{
            AudioInputStream in = AudioSystem.getAudioInputStream(new File("sound\\main.wav"));
            _mainMusic = AudioSystem.getClip();
            _mainMusic.open(in);
            _mainMusic.setFramePosition(0);
            _mainMusic.loop(Clip.LOOP_CONTINUOUSLY);
//            _mainMusic.start();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public static  void stopGameSong(){
        _mainMusic.stop();
    }
    
    public static void gameOver(){
        try{
            AudioInputStream in = AudioSystem.getAudioInputStream(new File("sound\\gameOver.wav"));
            _gameOver = AudioSystem.getClip();
            _gameOver.open(in);
            _gameOver.start();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static void bomberWalk(){
        try{
            AudioInputStream in = AudioSystem.getAudioInputStream(new File("D:/bomberman-starter/res/sound/walk.wav"));
            Clip clip = AudioSystem.getClip();
            clip.open(in);
            clip.start();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

}

