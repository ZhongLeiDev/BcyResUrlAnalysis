/**
  * Copyright 2018 bejson.com 
  */
package duitang.beans;

/**
 * Auto-generated: 2018-06-25 14:31:47
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class Photo {

    private int width;
    private int height;
    private String path;
    public void setWidth(int width) {
         this.width = width;
     }
     public int getWidth() {
         return width;
     }

    public void setHeight(int height) {
         this.height = height;
     }
     public int getHeight() {
         return height;
     }

    public void setPath(String path) {
         this.path = path;
     }
     public String getPath() {
         return path;
     }

    @Override
    public String toString() {
        return "Photo{" +
                "width=" + width +
                ", height=" + height +
                ", path='" + path + '\'' +
                '}';
    }
}