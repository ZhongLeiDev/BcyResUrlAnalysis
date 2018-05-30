package huaban.beans;

public class HuabanPicture
{
  private String pinId;
  private String key;
  private String type;

  public String getPinId()
  {
    return this.pinId; }

  public void setPinId(String pinId) {
    this.pinId = pinId;
  }

  public String getType() {
    return this.type; }

  public void setType(String type) {
    this.type = type; }

  public String getKey() {
    return this.key; }

  public void setKey(String key) {
    this.key = key;
  }

  public String getImgUrl() {
    return "http://img.hb.aicdn.com/" + this.key + "_fw658";
  }

  @Override
  public String toString() {
    return "HuabanPicture{" +
            "pinId='" + pinId + '\'' +
            ", key='" + key + '\'' +
            ", type='" + type + '\'' +
            '}';
  }
}
