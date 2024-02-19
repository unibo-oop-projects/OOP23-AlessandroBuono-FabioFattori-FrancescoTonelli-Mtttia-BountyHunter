package buontyhunter.model;

import java.net.URL;

import javax.sound.sampled.*;

public class MusicPlayerImpl implements MusicPlayer{

    private Clip clip;
    private AudioInputStream audioInput;

    @Override
    public void playTrack(Track toPlay) {
        try{
            URL trackFile = getClass().getClassLoader().getResource(toPlay.getPath());
            this.audioInput = AudioSystem.getAudioInputStream(trackFile);
            this.clip = AudioSystem.getClip();
            this.clip.open(audioInput);
            this.clip.loop(Clip.LOOP_CONTINUOUSLY);
            this.clip.start();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void closeTrack() {
        if(this.clip.isOpen()){
            this.clip.close();
        }
    }

    
    
}
