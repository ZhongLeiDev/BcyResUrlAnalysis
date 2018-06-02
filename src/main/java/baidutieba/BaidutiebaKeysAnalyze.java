package baidutieba;

import baidutieba.beans.TiebaPicture;
import common.linkshandle.WebLinksCatcher;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ZhongLeiDev at 2018/5/24
 */
public class BaidutiebaKeysAnalyze {

    /**
     * 获取图片链接
     * @param src
     * @return
     */
    public static List<TiebaPicture> getRealTiebaImgUrl(String src) {
        List<TiebaPicture> result = new ArrayList<>();
        Pattern pattern= Pattern.compile("https://imgsa.baidu.com/.{3,7}/.{5,9}/sign=.{30,34}/.{38,42}(.jpg|jpeg|png|bmp)");
        Matcher matcher = pattern.matcher(src);
        String str = "";
        while(matcher.find()) {
            str = matcher.group();
            String url = "https://imgsa.baidu.com/forum/pic/item" + str.substring(str.lastIndexOf("/"), str.length());
            result.add(new TiebaPicture(url));
        }
        return result;
    }

    /**
     * 获取该帖的总页数
     * @param src
     * @return
     */
    public static int getAllPageCounts(String src) {
        int pagecounts = 0;
        Pattern pattern= Pattern.compile("<a href=\"/p/.{8,12}?pn=.{1,5}\">尾页</a>");
        Matcher matcher = pattern.matcher(src);
        while(matcher.find()) {

            String[] para = matcher.group().split("\"");
            pagecounts = Integer.parseInt(para[1].split("=")[1]);
//            System.out.println("共" + String.valueOf(pagecounts) + "页");

            break;
        }
        return pagecounts;
    }

    /**
     * 根据给出的链接地址分析本帖的所有图片链接信息
     * @param url
     * @return
     */
    public static List<TiebaPicture> getAllImgUrls(String url) {

        List<TiebaPicture> list = new ArrayList<>();
        String baseUrl = "";
        if (url.contains("?")) {
            baseUrl = url.split("\\?")[0];
        } else {
            baseUrl = url;
        }
        String src = WebLinksCatcher.getResponseFromHttpsUrl(baseUrl,"utf-8");
        int pageCount = getAllPageCounts(src);
        list.addAll(getRealTiebaImgUrl(src));
        for (int i=2;i<pageCount;i++) {
            src = WebLinksCatcher.getResponseFromHttpsUrl(baseUrl + "?pn=" + String.valueOf(i), "utf-8");
            list.addAll(getRealTiebaImgUrl(src));
        }
        return list;

    }

}
