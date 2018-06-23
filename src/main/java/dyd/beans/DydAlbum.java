package dyd.beans;

import java.util.List;

/**
 * Created by ZhongLeiDev at 2018/6/23
 * DydAlbum 持久化单元
 */
public class DydAlbum {

    private int albumId;
    private String author;
    private String title;
    private String description;
    private String tags;
    private List<DydPicture> picList;

    public DydAlbum(int albumId, String author, String title, String description, String tags, List<DydPicture> picList) {
        this.albumId = albumId;
        this.author = author;
        this.title = title;
        this.description = description;
        this.tags = tags;
        this.picList = picList;
    }


    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public List<DydPicture> getPicList() {
        return picList;
    }

    public void setPicList(List<DydPicture> picList) {
        this.picList = picList;
    }

    @Override
    public String toString() {
        return "DydAlbum{" +
                "albumId=" + albumId +
                ", author='" + author + '\'' +
                ", description='" + description + '\'' +
                ", tags='" + tags + '\'' +
                ", picList=" + picList +
                '}';
    }
}
