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
public class Object_list {

    private Album album;
    private Photo photo;
    private String msg;
    private long id;
    private Sender sender;
    private int buyable;
    private int reply_count;
    private String icon_url;
    private long sender_id;
    private int like_count;
    private int favorite_count;
    private String extra_type;
    private boolean is_certify_user;
    public void setAlbum(Album album) {
         this.album = album;
     }
     public Album getAlbum() {
         return album;
     }

    public void setPhoto(Photo photo) {
         this.photo = photo;
     }
     public Photo getPhoto() {
         return photo;
     }

    public void setMsg(String msg) {
         this.msg = msg;
     }
     public String getMsg() {
         return msg;
     }

    public void setId(long id) {
         this.id = id;
     }
     public long getId() {
         return id;
     }

    public void setSender(Sender sender) {
         this.sender = sender;
     }
     public Sender getSender() {
         return sender;
     }

    public void setBuyable(int buyable) {
         this.buyable = buyable;
     }
     public int getBuyable() {
         return buyable;
     }

    public void setReply_count(int reply_count) {
         this.reply_count = reply_count;
     }
     public int getReply_count() {
         return reply_count;
     }

    public void setIcon_url(String icon_url) {
         this.icon_url = icon_url;
     }
     public String getIcon_url() {
         return icon_url;
     }

    public void setSender_id(long sender_id) {
         this.sender_id = sender_id;
     }
     public long getSender_id() {
         return sender_id;
     }

    public void setLike_count(int like_count) {
         this.like_count = like_count;
     }
     public int getLike_count() {
         return like_count;
     }

    public void setFavorite_count(int favorite_count) {
         this.favorite_count = favorite_count;
     }
     public int getFavorite_count() {
         return favorite_count;
     }

    public void setExtra_type(String extra_type) {
         this.extra_type = extra_type;
     }
     public String getExtra_type() {
         return extra_type;
     }

    public void setIs_certify_user(boolean is_certify_user) {
         this.is_certify_user = is_certify_user;
     }
     public boolean getIs_certify_user() {
         return is_certify_user;
     }

    @Override
    public String toString() {
        return "Object_list{" +
                "album=" + album +
                ", photo=" + photo +
                ", msg='" + msg + '\'' +
                ", id=" + id +
                ", sender=" + sender +
                ", buyable=" + buyable +
                ", reply_count=" + reply_count +
                ", icon_url='" + icon_url + '\'' +
                ", sender_id=" + sender_id +
                ", like_count=" + like_count +
                ", favorite_count=" + favorite_count +
                ", extra_type='" + extra_type + '\'' +
                ", is_certify_user=" + is_certify_user +
                '}';
    }
}