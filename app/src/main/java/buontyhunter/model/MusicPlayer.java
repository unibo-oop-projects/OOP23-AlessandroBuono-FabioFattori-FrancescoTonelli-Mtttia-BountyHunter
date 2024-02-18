package buontyhunter.model;

public interface MusicPlayer {
    enum Track{
        HUB_TRACK("tracks/hub.wav"),
        ADVENTURE_TRACK("tracks/adventure.wav"),
        BOSS_TRACK("tracks/the_sorcerer.wav");

        private String path;
        Track(String path){
            this.path = path;
        }

        public String getPath(){
            return this.path;
        }
    }

    void playTrack(Track toPlay);

    void closeTrack();
}
