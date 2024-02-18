package buontyhunter.model;

import java.io.File;
import javax.sound.sampled.*;

public class MusicPlayerImpl implements MusicPlayer{

    @Override
    public void playTrack(Track toPlay) {
        try{
            File trackFile = new File(toPlay.getPath());
            if(trackFile.exists()){
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(trackFile);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();

                Thread.sleep(10);
                while(clip.isRunning()){
                    Thread.sleep(10);
                }
                clip.close();
                audioInput.close();
            }
            else{
                System.out.println("File non trovato");
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
}
