package baidutieba.beans;

/**
 * Created by ZhongLeiDev at 2018/5/24
 */
public class TiebaPicture {

    private String url;

    public TiebaPicture(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    @Override
    public String toString() {
        return "TiebaPicture{" +
                "url='" + url + '\'' +
                '}';
    }
}
