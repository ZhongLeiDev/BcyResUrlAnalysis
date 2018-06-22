package dyd.beans;

/**
 * Created by ZhongLeiDev at 2018/6/22
 */
public class DydText {

    private String content;

    public DydText(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "DydText{" +
                "content='" + content + '\'' +
                '}';
    }
}
