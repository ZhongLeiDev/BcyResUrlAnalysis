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
public class Data {

    private int total;
    private int next_start;
    private List<Object_list> object_list;
    private int more;
    public void setTotal(int total) {
         this.total = total;
     }
     public int getTotal() {
         return total;
     }

    public void setNext_start(int next_start) {
         this.next_start = next_start;
     }
     public int getNext_start() {
         return next_start;
     }

    public void setObject_list(List<Object_list> object_list) {
         this.object_list = object_list;
     }
     public List<Object_list> getObject_list() {
         return object_list;
     }

    public void setMore(int more) {
         this.more = more;
     }
     public int getMore() {
         return more;
     }

    @Override
    public String toString() {
        return "Data{" +
                "total=" + total +
                ", next_start=" + next_start +
                ", object_list=" + object_list +
                ", more=" + more +
                '}';
    }
}