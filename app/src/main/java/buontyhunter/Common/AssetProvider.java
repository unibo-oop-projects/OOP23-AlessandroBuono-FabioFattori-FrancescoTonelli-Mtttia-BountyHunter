package buontyhunter.common;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
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

    public AssetProvider() {
        this.assetPath = "/";
        this.imageAssetMap = new HashMap<>();
    }

    public String fullPath(String resourceName) {
        return assetPath + resourceName;
    }

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

    public boolean imageLoaded(String path) {
        return imageAssetMap.containsKey(path);
    }

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
