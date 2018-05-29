package yande.beans;

/**
 * Created by ZhongLeiDev at 2018/5/24
 */
public class YandePicture {

    private String tags;
    private Integer file_size;
    private String file_url;
    private String preview_url;
    private Integer preview_width;
    private Integer preview_height;
    private String sample_url;
    private Integer sample_width;
    private Integer sample_height;
    private Integer sample_file_size;
    private String jpeg_url;
    private Integer jpeg_width;
    private Integer jpeg_height;
    private Integer jpeg_file_size;

    /**
     * Yande类型的Picture存储类构造器
     * @param tags  标签
     * @param file_size 文件大小
     * @param file_url  文件链接
     * @param preview_url   预览文件链接
     * @param preview_width   预览文件宽度
     * @param preview_height    预览文件高度
     * @param sample_url    示例链接
     * @param sample_width  示例宽度
     * @param sample_height   示例高度
     * @param sample_file_size  示例文件大小
     * @param jpeg_url  JPEG文件链接（源文件)
     * @param jpeg_width    JPEG文件宽度
     * @param jpeg_height   JPEG文件高度
     * @param jpeg_file_size    JPEG文件大小
     */
    public YandePicture(String tags, Integer file_size, String file_url, String preview_url, Integer preview_width, Integer preview_height, String sample_url, Integer sample_width, Integer sample_height, Integer sample_file_size, String jpeg_url, Integer jpeg_width, Integer jpeg_height, Integer jpeg_file_size) {
        this.tags = tags;
        this.file_size = file_size;
        this.file_url = file_url;
        this.preview_url = preview_url;
        this.preview_width = preview_width;
        this.preview_height = preview_height;
        this.sample_url = sample_url;
        this.sample_width = sample_width;
        this.sample_height = sample_height;
        this.sample_file_size = sample_file_size;
        this.jpeg_url = jpeg_url;
        this.jpeg_width = jpeg_width;
        this.jpeg_height = jpeg_height;
        this.jpeg_file_size = jpeg_file_size;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public Integer getFile_size() {
        return file_size;
    }

    public void setFile_size(Integer file_size) {
        this.file_size = file_size;
    }

    public String getFile_url() {
        return file_url;
    }

    public void setFile_url(String file_url) {
        this.file_url = file_url;
    }

    public String getPreview_url() {
        return preview_url;
    }

    public void setPreview_url(String preview_url) {
        this.preview_url = preview_url;
    }

    public Integer getPreview_width() {
        return preview_width;
    }

    public void setPreview_width(Integer preview_width) {
        this.preview_width = preview_width;
    }

    public Integer getPreview_height() {
        return preview_height;
    }

    public void setPreview_height(Integer preview_height) {
        this.preview_height = preview_height;
    }

    public String getSample_url() {
        return sample_url;
    }

    public void setSample_url(String sample_url) {
        this.sample_url = sample_url;
    }

    public Integer getSample_width() {
        return sample_width;
    }

    public void setSample_width(Integer sample_width) {
        this.sample_width = sample_width;
    }

    public Integer getSample_height() {
        return sample_height;
    }

    public void setSample_height(Integer sample_height) {
        this.sample_height = sample_height;
    }

    public Integer getSample_file_size() {
        return sample_file_size;
    }

    public void setSample_file_size(Integer sample_file_size) {
        this.sample_file_size = sample_file_size;
    }

    public String getJpeg_url() {
        return jpeg_url;
    }

    public void setJpeg_url(String jpeg_url) {
        this.jpeg_url = jpeg_url;
    }

    public Integer getJpeg_width() {
        return jpeg_width;
    }

    public void setJpeg_width(Integer jpeg_width) {
        this.jpeg_width = jpeg_width;
    }

    public Integer getJpeg_height() {
        return jpeg_height;
    }

    public void setJpeg_height(Integer jpeg_height) {
        this.jpeg_height = jpeg_height;
    }

    public Integer getJpeg_file_size() {
        return jpeg_file_size;
    }

    public void setJpeg_file_size(Integer jpeg_file_size) {
        this.jpeg_file_size = jpeg_file_size;
    }

    @Override
    public String toString() {
        return "YandePicture{" +
                "tags='" + tags + '\'' +
                ", file_size=" + file_size +
                ", file_url='" + file_url + '\'' +
                ", preview_url='" + preview_url + '\'' +
                ", preview_width=" + preview_width +
                ", preview_height=" + preview_height +
                ", sample_url='" + sample_url + '\'' +
                ", sample_width=" + sample_width +
                ", sample_height=" + sample_height +
                ", sample_file_size=" + sample_file_size +
                ", jpeg_url='" + jpeg_url + '\'' +
                ", jpeg_width=" + jpeg_width +
                ", jpeg_height=" + jpeg_height +
                ", jpeg_file_size=" + jpeg_file_size +
                '}';
    }
}
