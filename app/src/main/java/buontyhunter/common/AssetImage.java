package buontyhunter.common;

public class AssetImage {
    private String path;
    private ImageType type;
    private double height;
    private double width;

    public String getPath() {
        return path;
    }

    public ImageType getType() {
        return type;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setType(ImageType type) {
        this.type = type;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setWidth(double width) {
        this.width = width;
    }
}
