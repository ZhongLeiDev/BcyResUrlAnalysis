package dyd.beans;

/**
 * Created by ZhongLeiDev at 2018/6/22
 */
public class DydObject {

    private Object object;
    private String type;
    private String description;

    public DydObject(Object object, String type, String description) {
        this.object = object;
        this.type = type;
        this.description = description;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "DydObject{" +
                "object=" + object +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
