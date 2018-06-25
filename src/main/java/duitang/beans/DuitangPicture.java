package duitang.beans;

/**
 * Created by ZhongLeiDev at 2018/6/25
 */
public class DuitangPicture {

    private int status;
    private Data data;
    public void setStatus(int status) {
        this.status = status;
    }
    public int getStatus() {
        return status;
    }

    public void setData(Data data) {
        this.data = data;
    }
    public Data getData() {
        return data;
    }

    @Override
    public String toString() {
        return "DuitangPicture{" +
                "status=" + status +
                ", data=" + data +
                '}';
    }
}
