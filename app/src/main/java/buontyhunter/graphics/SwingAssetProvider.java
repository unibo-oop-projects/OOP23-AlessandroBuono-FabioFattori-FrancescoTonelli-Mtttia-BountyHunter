package buontyhunter.graphics;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;

import buontyhunter.common.AssetImage;
import buontyhunter.common.ImagePathProvider;
import buontyhunter.common.ImageType;

public class SwingAssetProvider {

    public String assetPath;
    private Map<ImageType, Image> imageAssetMap;

    /**
     * Create a new AssetProvider with the default asset path "/"
     */
    public SwingAssetProvider() {
        this.assetPath = "/";
        this.imageAssetMap = new HashMap<>();
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
     * @param resourceName the path to the assets folder
     * @return the full path to the resource
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
     * @param type the type of the image to get
     * @return the image if it was loaded successfully, null otherwise
     * @see #fullPath(String)
     */
    public Image getImage(ImageType type) {
        if (imageLoaded(type)) {
            return imageAssetMap.get(type);
        } else {
            return null;
        }
    }
}
