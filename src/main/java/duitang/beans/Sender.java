/**
  * Copyright 2018 bejson.com 
  */
package duitang.beans;
import java.util.List;

/**
 * Auto-generated: 2018-06-25 14:31:47
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class Sender {

    private long id;
    private String username;
    private String avatar;
    private List<String> identity;
    private boolean is_certify_user;
    public void setId(long id) {
         this.id = id;
     }
     public long getId() {
         return id;
     }

    public void setUsername(String username) {
         this.username = username;
     }
     public String getUsername() {
         return username;
     }

    public void setAvatar(String avatar) {
         this.avatar = avatar;
     }
     public String getAvatar() {
         return avatar;
     }

    public void setIdentity(List<String> identity) {
         this.identity = identity;
     }
     public List<String> getIdentity() {
         return identity;
     }

    public void setIs_certify_user(boolean is_certify_user) {
         this.is_certify_user = is_certify_user;
     }
     public boolean getIs_certify_user() {
         return is_certify_user;
     }

    @Override
    public String toString() {
        return "Sender{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", avatar='" + avatar + '\'' +
                ", identity=" + identity +
                ", is_certify_user=" + is_certify_user +
                '}';
    }
}