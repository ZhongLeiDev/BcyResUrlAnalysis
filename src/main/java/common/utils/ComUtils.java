package common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ZhongLeiDev at 2018/5/30
 */
public class ComUtils {

    /**
     * consume whether item is contained by the list
     * @param list
     * @param item
     * @return
     */
    public static boolean isItemExistInList(List<String> list, String item) {
        boolean re = false;
        for (String str : list) {
            if (item.equals(str)) {
                re = true;
            }
        }
        return re;
    }

    /**
     * List<String>-->Map<String,String>
     * @param urllist
     * @return
     */
    public static Map<String, String> buildMapfromList(List<String> urllist) {
        Map<String,String> result = new HashMap<String,String>();
        String name = "fail";
        for (String url : urllist) {
            name = url.substring(url.lastIndexOf("/")+1, url.length());
            result.put(url, name);
            System.out.println("Name->" + name);
        }
        return result;
    }

    /**
     * 根据当前时间生成文件名称前半部分
     * @return ("yyyyMMddHHmmss")
     */
    public static String getCurrentFileNamePart1() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        Date d = new Date();
        String dateNowStr = sdf.format(d);
        return dateNowStr;
    }


}
