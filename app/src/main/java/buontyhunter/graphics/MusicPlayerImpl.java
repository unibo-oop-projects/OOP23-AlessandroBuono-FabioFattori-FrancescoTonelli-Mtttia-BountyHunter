package buontyhunter.graphics;

import java.io.File;
import javax.sound.sampled.*;

public class MusicPlayerImpl implements MusicPlayer{

    private Clip clip;

    public MusicPlayerImpl(){
        try{
            clip = AudioSystem.getClip();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void playTrack(Track toPlay) {
        try{
            File trackFile = new File(toPlay.getPath());
            if(trackFile.exists()){
                clip.close();
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(trackFile);
                clip.open(audioInput);
                clip.start();
            }
            else{
                System.out.println("File non trovato");
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
}
