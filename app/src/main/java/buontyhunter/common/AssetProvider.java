package buontyhunter.common;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.imageio.ImageIO;

public class AssetProvider {

    public String assetPath;
    private Map<String, BufferedImage> imageAssetMap;

    /**
     * Create a new AssetProvider with the default asset path "/"
     */
    public AssetProvider() {
        this.assetPath = "/";
        this.imageAssetMap = new HashMap<>();
    }

    /**
     * get the path to the passed resource
     * @param assetPath the path to the assets folder
     */
    public String fullPath(String resourceName) {
        return assetPath + resourceName;
    }

    /**
     * Load an image from the assets folder and cache it in a HashMap to optimize the loading
     * @param path the path to the image
     * @return true if the image was loaded successfully, false otherwise
     * @see #fullPath(String)
     */
    public boolean loadImage(String path) {
        try {
            BufferedImage image = ImageIO.read(getClass().getResource(fullPath(path)));
            imageAssetMap.put(path, image);
            return true;
        } catch (Exception e) {
            System.out.println("Failed to load image: " + path + " error Message => " + e);
            return false;
        }
    }

    /**
     * Check if an image is loaded
     * @param path the path to the image
     * @return true if the image is loaded, false otherwise
     */
    public boolean imageLoaded(String path) {
        return imageAssetMap.containsKey(path);
    }

    /**
     * Get an image from the assets folder
     * @param path the path to the image
     * @return the image if it was loaded successfully, null otherwise
     * @see #fullPath(String)
     * @see #loadImage(String)
     */
    public BufferedImage getImage(String path) {
        if (imageLoaded(path)) {
            return imageAssetMap.get(path);
        } else {
            if (loadImage(path)) {
                return imageAssetMap.get(path);
            } else {
                return null;
            }
        }
    }

    /**
     * Load a text file from the assets folder
     * @param path the path to the text file
     * @return the text file content if it was loaded successfully, Optional.empty() otherwise
     * @see #fullPath(String)
     */
    public Optional<String> getText(String path) {
        try (InputStream is = getClass().getResourceAsStream(fullPath(path));
                BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            return Optional.of(reader.lines().collect(Collectors.joining("\n")));
        } catch (Exception e) {

            System.out.println("Failed to load text: " + path + " error Message => " + e);
            // e.printStackTrace();
            return Optional.empty();
        }
    }
}
