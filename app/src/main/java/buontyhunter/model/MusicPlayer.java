package buontyhunter.model;

import java.io.InputStream;

public interface MusicPlayer {
    enum Track{
        HUB_TRACK("tracks/hub.wav");

        private String path;
        Track(String path){
            this.path = path;
        }

        public String getPath(){
            return this.path;
        }
    }

    default InputStream getTrackInputStream(Track track) {
        return getClass().getClassLoader().getResourceAsStream(track.getPath());
    }

    void playTrack(Track toPlay);
}
