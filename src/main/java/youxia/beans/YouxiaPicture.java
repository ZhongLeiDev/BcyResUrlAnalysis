package youxia.beans;

/**
 * Created by ZhongLeiDev at 2018/5/24
 */
public class YouxiaPicture {

    private String albumname;
    private String url;
    private String originurl;

    /**
     * YouxiaPictures构造器
     * @param albumname     相册名称
     * @param url   图片链接
     * @param originurl     原始图片链接
     */
    public YouxiaPicture(String albumname, String url, String originurl) {
        this.albumname = albumname;
        this.url = url;
        this.originurl = originurl;
    }

    public String getAlbumname() {
        return albumname;
    }

    public void setAlbumname(String albumname) {
        this.albumname = albumname;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getOriginurl() {
        return originurl;
    }

    public void setOriginurl(String originurl) {
        this.originurl = originurl;
    }


    @Override
    public String toString() {
        return "YouxiaPicture{" +
                "albumname='" + albumname + '\'' +
                ", url='" + url + '\'' +
                ", originurl='" + originurl + '\'' +
                '}';
    }
}
