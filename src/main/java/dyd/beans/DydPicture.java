package dyd.beans;

/**
 * Created by ZhongLeiDev at 2018/5/24
 */
public class DydPicture {

    private String image;
    private int imageHeight;
    private int imageWidth;

    public DydPicture(String image, int imageHeight, int imageWidth) {
        this.image = image;
        this.imageHeight = imageHeight;
        this.imageWidth = imageWidth;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getImageHeight() {
        return imageHeight;
    }

    public void setImageHeight(int imageHeight) {
        this.imageHeight = imageHeight;
    }

    public int getImageWidth() {
        return imageWidth;
    }

    public void setImageWidth(int imageWidth) {
        this.imageWidth = imageWidth;
    }

    @Override
    public String toString() {
        return "DydPicture{" +
                "image='" + image + '\'' +
                ", imageHeight=" + imageHeight +
                ", imageWidth=" + imageWidth +
                '}';
    }
}
