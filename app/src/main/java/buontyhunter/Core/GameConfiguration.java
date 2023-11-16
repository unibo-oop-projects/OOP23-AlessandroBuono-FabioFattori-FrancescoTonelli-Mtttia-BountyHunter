package buontyhunter.Core;

/* this class should have only the settings of the game like fps  */
public class GameConfiguration {
    private final int fps;
    private final int tileSize;

    public GameConfiguration(){
        this(60,32);
    }

    public GameConfiguration(final int fps, final int tileSize){
        if(fps >= 0) {
            this.fps = fps;
        }else{
            throw new IllegalArgumentException("FPS Can't Be under 0");
        }

        

        if(tileSize > 0){
            this.tileSize = tileSize;
        }else{
            throw new IllegalArgumentException("Tile Size Can't Be under 0");
        }
    }

    public int getFPS(){
        return fps;
    }

    public int getTileSize(){
        return tileSize;
    }

    
}
