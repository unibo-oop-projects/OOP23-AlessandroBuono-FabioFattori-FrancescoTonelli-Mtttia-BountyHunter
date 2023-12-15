package buontyhunter.graphics;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.imageio.ImageIO;

import buontyhunter.common.AssetImage;
import buontyhunter.common.ImagePathProvider;
import buontyhunter.common.ImageType;

public class SwingAssetProvider {

    public String assetPath;
    private Map<ImageType, Image> imageAssetMap;
    private Map<ImageType, AssetImage> imageAssetClassMap;

    /**
     * Create a new AssetProvider with the default asset path "/"
     */
    public SwingAssetProvider() {
        this.assetPath = "/";
        this.imageAssetMap = new HashMap<>();
        this.imageAssetClassMap = new HashMap<>();
        loadAllAssets();
    }

    public void loadAllAssets() {
        ImagePathProvider.imagePaths.entrySet().forEach(entry -> {
            loadImage(entry.getKey(), entry.getValue());
        });
    }

    /**
     * get the path to the passed resource
     * 
     * @param assetPath the path to the assets folder
     */
    public String fullPath(String resourceName) {
        return assetPath + resourceName;
    }

    /**
     * Load an image from the assets folder and cache it in a HashMap to optimize
     * the loading
     * 
     * @param path the path to the image
     * @return true if the image was loaded successfully, false otherwise
     * @see #fullPath(String)
     */
    private boolean loadImage(ImageType type, AssetImage image) {
        try {
            BufferedImage buffImage = ImageIO.read(getClass().getResource(fullPath(image.getPath())));
            Image awtImage = buffImage.getScaledInstance((int) image.getWidth(), (int) image.getHeight(),
                    Image.SCALE_DEFAULT);
            imageAssetMap.put(type, awtImage);
            imageAssetClassMap.put(type, image);
            return true;
        } catch (Exception e) {
            System.out.println("Failed to load image: " + image.getPath() + " error Message => " + e.getMessage() + " "
                    + e.getStackTrace());
            return false;
        }
    }

    /**
     * Check if an image is loaded
     * 
     * @param path the path to the image
     * @return true if the image is loaded, false otherwise
     */
    private boolean imageLoaded(ImageType type) {
        return imageAssetMap.containsKey(type);
    }

    /**
     * Get an image from the assets folder
     * 
     * @param path the path to the image
     * @return the image if it was loaded successfully, null otherwise
     * @see #fullPath(String)
     * @see #loadImage(String)
     */
    public Image getImage(ImageType type) {
        if (imageLoaded(type)) {
            return imageAssetMap.get(type);
        } else {
            return null;
        }
    }
    
    public AssetImage getImageClass(ImageType type) {
        if (imageAssetClassMap.containsKey(type)) {
            return imageAssetClassMap.get(type);
        } else {
            return null;
        }
    }
    
}
