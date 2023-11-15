package buontyhunter.Core;

/* this class should have only the settings of the game like fps  */
public class GameConfiguration {
    private int fps;

    public GameConfiguration(){
        this(60);
    }

    public GameConfiguration(int fps){
        setFPS(fps);
    }

    public int getFPS(){
        return fps;
    }

    private void setFPS(int fps){
        if(fps >= 0) {
            this.fps = fps;
            return;
        }

        throw new IllegalArgumentException("FPS Can't Be under 0");
    }
}
