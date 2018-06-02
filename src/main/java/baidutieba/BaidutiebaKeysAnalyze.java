package baidutieba;

import baidutieba.beans.TiebaPicture;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ZhongLeiDev at 2018/5/24
 */
public class BaidutiebaKeysAnalyze {

    public static List<TiebaPicture> getRealTiebaImgUrl(String src) {
        List<TiebaPicture> result = new ArrayList<>();
        Pattern pattern= Pattern.compile("https://imgsa.baidu.com/.{3,7}/.{5,9}/sign=.{30,34}/.{38,42}(.jpg|jpeg|png|bmp).*?>");
        Matcher matcher = pattern.matcher(src);
        String str = "";
        while(matcher.find()) {
            str = matcher.group();
            String[] param = str.split("\"");
            String url = "https://imgsa.baidu.com/forum/pic/item" + param[0].substring(param[0].lastIndexOf("/"), param[0].length());
            result.add(new TiebaPicture(url ,Integer.parseInt(param[4]),Integer.parseInt(param[6])));
        }
        return result;
    }

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

}
