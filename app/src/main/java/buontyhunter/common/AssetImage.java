package buontyhunter.common;

public class AssetImage {
    private String path;
    private ImageType type;
    private double height;
    private double width;
    

    
    /**
     * @return the path to the image
     */
    public String getPath() {
        return path;
    }

    /**
     * @return the type of the image
     */
    public ImageType getType() {
        return type;
    }

    /**
     * @return the height of the image
     */
    public double getHeight() {
        return height;
    }

    /**
     * @return the width of the image
     */
    public double getWidth() {
        return width;
    }

    /**
     * Set the path to the image
     * @param path the new path to the image
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * Set the type of the image
     * @param type the new type of the image
     */
    public void setType(ImageType type) {
        this.type = type;
    }

    /**
     * Set the height of the image
     * @param height the new height of the image
     */
    public void setHeight(double height) {
        this.height = height;
    }

    /**
     * Set the width of the image
     * @param width the new width of the image
     */
    public void setWidth(double width) {
        this.width = width;
    }
}
