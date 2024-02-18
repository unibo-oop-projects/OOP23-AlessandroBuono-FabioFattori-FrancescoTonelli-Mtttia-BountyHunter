package buontyhunter.graphics;

public interface MusicPlayer {
    enum Track{
        hubTrack("C:\\Users\\wfaff\\Documents\\GitHub\\BountyHunter\\app\\src\\main\\resources\\tracks\\hub.wav"),
        worldTrack("tracks/adventure.wav"),
        bossTrack("tracks/boss.wav");

        private String path;
        Track(String path){
            this.path = path;
        }

        public String getPath(){
            return this.path;
        }
    }

    void playTrack(Track toPlay);
}
