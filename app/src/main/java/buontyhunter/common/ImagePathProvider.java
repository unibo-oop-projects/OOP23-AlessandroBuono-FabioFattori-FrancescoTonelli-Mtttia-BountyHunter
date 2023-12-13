package buontyhunter.common;

import java.util.HashMap;
import java.util.Map;

import buontyhunter.core.GameEngine;

public class ImagePathProvider {
    public static Map<ImageType, AssetImage> imagePaths = new HashMap<>() {
        {
            put(ImageType.EARTH, new AssetImage() {
                {
                    setPath("earth.png");
                    setType(ImageType.EARTH);
                    setHeight(GameEngine.RATIO_HEIGHT);
                    setWidth(GameEngine.RATIO_WIDTH);
                }
            });
            put(ImageType.WATER, new AssetImage() {
                {
                    setPath("water.png");
                    setType(ImageType.WATER);
                    setHeight(GameEngine.RATIO_HEIGHT);
                    setWidth(GameEngine.RATIO_WIDTH);
                }
            });
            put(ImageType.GRASS, new AssetImage() {
                {
                    setPath("grass.png");
                    setType(ImageType.GRASS);
                    setHeight(GameEngine.RATIO_HEIGHT);
                    setWidth(GameEngine.RATIO_WIDTH);
                }
            });
            put(ImageType.SAND, new AssetImage() {
                {
                    setPath("sand.png");
                    setType(ImageType.SAND);
                    setHeight(GameEngine.RATIO_HEIGHT);
                    setWidth(GameEngine.RATIO_WIDTH);
                }
            });
            put(ImageType.TREE, new AssetImage() {
                {
                    setPath("tree.png");
                    setType(ImageType.TREE);
                    setHeight(GameEngine.RATIO_HEIGHT);
                    setWidth(GameEngine.RATIO_WIDTH);
                }
            });
            put(ImageType.WALL, new AssetImage() {
                {
                    setPath("wall.png");
                    setType(ImageType.WALL);
                    setHeight(GameEngine.RATIO_HEIGHT);
                    setWidth(GameEngine.RATIO_WIDTH);
                }
            });
            put(ImageType.MAPBG, new AssetImage() {
                {
                    setPath("mapBG.png");
                    setType(ImageType.MAPBG);
                    setHeight(GameEngine.WINDOW_HEIGHT);
                    setWidth(GameEngine.WINDOW_HEIGHT);
                }
            });
        }
    };
}
