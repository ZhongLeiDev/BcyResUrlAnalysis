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
public class Album {

    private long id;
    private String name;
    private int count;
    private int category;
    private List<String> covers;
    private int status;
    private int like_count;
    private int actived_at;
    private int favorite_count;
    private int favorite_id;
    private int visit_count;
    public void setId(long id) {
         this.id = id;
     }
     public long getId() {
         return id;
     }

    public void setName(String name) {
         this.name = name;
     }
     public String getName() {
         return name;
     }

    public void setCount(int count) {
         this.count = count;
     }
     public int getCount() {
         return count;
     }

    public void setCategory(int category) {
         this.category = category;
     }
     public int getCategory() {
         return category;
     }

    public void setCovers(List<String> covers) {
         this.covers = covers;
     }
     public List<String> getCovers() {
         return covers;
     }

    public void setStatus(int status) {
         this.status = status;
     }
     public int getStatus() {
         return status;
     }

    public void setLike_count(int like_count) {
         this.like_count = like_count;
     }
     public int getLike_count() {
         return like_count;
     }

    public void setActived_at(int actived_at) {
         this.actived_at = actived_at;
     }
     public int getActived_at() {
         return actived_at;
     }

    public void setFavorite_count(int favorite_count) {
         this.favorite_count = favorite_count;
     }
     public int getFavorite_count() {
         return favorite_count;
     }

    public void setFavorite_id(int favorite_id) {
         this.favorite_id = favorite_id;
     }
     public int getFavorite_id() {
         return favorite_id;
     }

    public void setVisit_count(int visit_count) {
         this.visit_count = visit_count;
     }
     public int getVisit_count() {
         return visit_count;
     }

    @Override
    public String toString() {
        return "Album{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", count=" + count +
                ", category=" + category +
                ", covers=" + covers +
                ", status=" + status +
                ", like_count=" + like_count +
                ", actived_at=" + actived_at +
                ", favorite_count=" + favorite_count +
                ", favorite_id=" + favorite_id +
                ", visit_count=" + visit_count +
                '}';
    }
}