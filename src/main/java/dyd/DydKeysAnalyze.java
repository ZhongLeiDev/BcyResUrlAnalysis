package dyd;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import common.linkshandle.WebLinksCatcher;
import common.utils.ComUtils;
import dyd.beans.DydAlbum;
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
     * 网页链接预处理，去掉后缀
     * @param url
     * @return
     */
    public static String preLoadUrl(String url) {
        String result = "";
        if (url.endsWith("#anchor_comment_floor")) {
            result = url.replace("#anchor_comment_floor","");
        } else {
            result = url;
        }
        return result;
    }

    /**
     * 重定向到只看楼主
     * @param preLoadUrl
     * @return
     */
    public static String loadLouZhuUrl(String preLoadUrl) {
        return preLoadUrl + "?louzhu=true";
    }

    /**
     * 获取图片链接（方式1，针对未进行点击权限限制的页面）
     * @param src
     * @return
     */
    public static List<DydPicture> getRealImgUrl(String src) {
        List<DydPicture> result = new ArrayList<>();
        String temp;
        Pattern pattern= Pattern.compile("//image.diyidan.net/post/.{3,5}/.{1,3}/.{1,3}/.{10,25}(.jpg|jpeg|png|bmp)!weblarge");
        Matcher matcher = pattern.matcher(src);
        while(matcher.find()) {
            temp = "https:" + matcher.group();
            result.add(new DydPicture(temp.replace("!weblarge",""),0,0));
        }
        return result;
    }

    /**
     * 获取图片 JSON 字符串（方式2，针对进行了图片点击权限限制的页面）
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
    public static String getAllPageCount(String src) {
        String pageCount = "";
        Pattern pattern= Pattern.compile("共[\\S]{1,4}页");
        Matcher matcher = pattern.matcher(src);
        while(matcher.find()) {
            pageCount = matcher.group().replace("共","").replace("页","");
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

    /**
     * 根据链接获取全部的图片单元，生成相册信息
     * @param srcUrl
     * @return
     */
    public static DydAlbum getAllPictures(String srcUrl) {
        DydAlbum album = new DydAlbum();
        String temp = WebLinksCatcher.getResponseFromHttpUrl(loadLouZhuUrl(preLoadUrl(srcUrl)), "utf-8");
        album.setAuthor(getAuthor(temp));
        album.setTags(getTags(temp));
        album.setTitle(getTitle(temp));
        album.setDescription(getDesc(temp));
        String pageCount = getAllPageCount(temp);
        if (pageCount.equals("")) {
            pageCount = "1";
        }
        String realUrl = loadLouZhuUrl(preLoadUrl(srcUrl).substring(0,preLoadUrl(srcUrl).lastIndexOf("/")) + "/" + pageCount);
        System.out.println("RealUrl->" + realUrl);
        String src = WebLinksCatcher.getResponseFromHttpUrl(realUrl, "utf-8");
        List<DydPicture> picList = new ArrayList<>();
        picList = getRealImgUrl(src);
        if (picList.size() == 0) {
            picList = getDydPictureList(getPictureJSONStr(src));
        }
        System.out.println("相册共有图片数量共：" + picList.size() + "张");
        album.setPicList(picList);
        return album;
    }

}
