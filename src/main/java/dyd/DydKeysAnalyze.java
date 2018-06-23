package dyd;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import common.utils.ComUtils;
import dyd.beans.DydObject;
import dyd.beans.DydPicture;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ZhongLeiDev at 2018/5/24
 */
public class DydKeysAnalyze {

    /**
     * 获取图片链接（已变更，暂时不再使用2018-06-23）
     * @param src
     * @return
     */
    public static List<String> getRealImgUrl(String src) {
        List<String> result = new ArrayList<String>();
        String temp;
        Pattern pattern= Pattern.compile("//image.diyidan.net/post/.{3,5}/.{1,3}/.{1,3}/.{10,25}(.jpg|jpeg|png|bmp)");
        Matcher matcher = pattern.matcher(src);
        while(matcher.find()) {
            temp = "http:" + matcher.group();
            if(!ComUtils.isItemExistInList(result, temp)) {
                result.add(temp);
            }
        }
        return result;
    }

    /**
     * 获取图片 JSON 字符串
     * @param src
     * @return
     */
    public static String getPictureJSONStr(String src) {
        Pattern pattern= Pattern.compile("translatePostJsonToHtml\\(\\[[\\s\\S]*?]\\)");
        Matcher matcher = pattern.matcher(src);
        while(matcher.find()) {
            return "[" + matcher.group().split("\\[")[1].split("]")[0] + "]";
        }
        return null;
    }

    /**
     * 获取图片元素列表
     * @param jsonStr 图片 JSON 字符串
     * @return
     */
    public static List<DydPicture> getDydPictureList(String jsonStr) {
        List<DydPicture> pictureList = new ArrayList<>();
        JSONArray jsonArray = JSONArray.parseArray(jsonStr);
        if (jsonArray != null) {
            for (Object obj : jsonArray) {
                JSONObject jsonObject = (JSONObject) obj;
                String type = jsonObject.getString("type");
                if (type.equals("image")) {
                    String imgobj = jsonObject.getString("image");
                    DydPicture pic = JSONObject.parseObject(imgobj, DydPicture.class);
                    pic.setImage("https://image.diyidan.net" + pic.getImage());
                    pictureList.add(pic);
                }
            }
        }
        return pictureList;
    }

    /**
     * 获取描述
     * @param src
     * @return
     */
    public static String getDesc(String src) {
        String desc = "";
        Pattern pattern= Pattern.compile("<div id=\"bdDesc\"[\\s\\S]*?</div>");
        Matcher matcher = pattern.matcher(src);
        while(matcher.find()) {
            desc += matcher.group().split(">")[1].split("<")[0] + "." ;
        }
        Pattern pattern1= Pattern.compile("<div id=\"bdText\"[\\s\\S]*?</div>");
        Matcher matcher1 = pattern.matcher(src);
        while(matcher.find()) {
            desc += matcher1.group().split(">")[1].split("<")[0] + "." ;
        }
        return desc;
    }

    /**
     * 获取Tags
     * @param src
     * @return
     */
    public static String getTags(String src) {
        String tags = "";
        Pattern pattern= Pattern.compile("javascript:searchWithTag[\\s\\S]*?</span>");
        Matcher matcher = pattern.matcher(src);
        while(matcher.find()) {
            tags += matcher.group().split(">")[1].split("<")[0] + ";" ;
        }
        return tags;
    }

    /**
     * 获取总页数
     * @param src
     * @return
     */
    public static int getAllPageCount(String src) {
        int pageCount = 0;
        Pattern pattern= Pattern.compile("共[\\S]{1,4}页");
        Matcher matcher = pattern.matcher(src);
        while(matcher.find()) {
            pageCount = Integer.parseInt(matcher.group().replace("共","").replace("页",""));
        }
        return pageCount;
    }

    /**
     * 获取作者名称
     * @param src
     * @return
     */
    public static String getAuthor(String src) {
        String author = "";
        Pattern pattern= Pattern.compile("class=\"user_name\"[\\s\\S]*?</span>");
        Matcher matcher = pattern.matcher(src);
        while(matcher.find()) {
            author = matcher.group().split(">")[2].split("<")[0];
            break;
        }
        return author;
    }

    /**
     * 获取作品标题
     * @param src
     * @return
     */
    public static String getTitle(String src) {
        String title = "";
        Pattern pattern= Pattern.compile("<title>[\\s\\S]*?</title>");
        Matcher matcher = pattern.matcher(src);
        while(matcher.find()) {
            title = matcher.group().substring(7,matcher.group().length()-8);
        }
        return title;
    }

}
