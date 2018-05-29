package yande;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import yande.beans.YandePicture;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ZhongLeiDev at 2018/5/24
 */
public class YandeKeysAnalyze {

    /**
     * 根据源数据解析获取 YandePicture 列表
     * @param src
     * @return
     */
    public static List<YandePicture> getPicturesWithTag(String src) {
        List<YandePicture> list = new ArrayList<>();
        Pattern pattern= Pattern.compile("Post.register\\(\\{[\\s\\S]*?}\\)");
        Matcher matcher = pattern.matcher(src);
        String str = "";
        while(matcher.find()) {
            str = matcher.group();
//            System.out.print(str);
            JSONObject obj = JSON.parseObject(str.substring(14,str.length()-1));
            list.add(new YandePicture(
                    obj.getString("tags"),  //tag
                    obj.getInteger("file_size"),    //file_size
                    obj.getString("file_url"),  //file_url
                    obj.getString("preview_url"),   //preview_url
                    obj.getInteger("preview_width"),    //preview_width
                    obj.getInteger("preview_height"),   //preview_height
                    obj.getString("sample_url"),    //sample_url
                    obj.getInteger("sample_width"),     //sample_width
                    obj.getInteger("sample_height"),    //sample_height
                    obj.getInteger("sample_file_size"),     //sample_file_size
                    obj.getString("jpeg_url"),   //jpeg_url
                    obj.getInteger("jpeg_width"),   //jpeg_width
                    obj.getInteger("jpeg_height"),  //jpeg_height
                    obj.getInteger("jpeg_file_size")    //jpeg_file_size
                     )
            );
        }
        return list;
    }

    /**
     * 获取全部的页面数量，只针对由Tag搜索得到的结果，页面轮询可以使用翻页并
     * 判断访问页面的Item数量是否大于0来判断是否是最后一页
     * @param src
     * @return
     */
    public static Integer getAllPageCount(String src) {
        int count = 0;
        Pattern pattern= Pattern.compile("<a href=\"/post\\?commit=Search[\\s\\S]*?</a>");
        Matcher matcher = pattern.matcher(src);
        while(matcher.find()) {
//            System.out.println(matcher.group());
            int getcount = Integer.parseInt(matcher.group().split(">")[1].split("<")[0]);
            if (count<getcount) {
                count = getcount;
            }
        }
        return count;
    }

}
