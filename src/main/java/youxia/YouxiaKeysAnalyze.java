package youxia;

import common.linkshandle.WebLinksCatcher;
import youxia.beans.YouxiaPicture;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ZhongLeiDev at 2018/5/24
 */
public class YouxiaKeysAnalyze {

    /**
     * 获取相册名称
     * @param src
     * @return
     */
    public static String getAlbumName(String src) {
        String title = "";
        Pattern pattern= Pattern.compile("<title>[\\s\\S]*?</title>");
        Matcher matcher = pattern.matcher(src);
        while(matcher.find()) {
            title = matcher.group().split(">")[1].split("<")[0].split("\\(")[0];
        }
        return title;
    }

    /**
     * 获取总页数
     * @param src
     * @return
     */
    public static int getAllPageCount(String src) {
        int pagecounts = 0;
        Pattern pattern= Pattern.compile("<div class=\"centers1\" >.{0,100}<span>(.{1,3}/.{1,3})</span></div>");
        Matcher matcher = pattern.matcher(src);
        while(matcher.find()) {
            //System.out.println(matcher.group());
            //字符串处理
            String[] para = matcher.group().split("/");
            pagecounts = Integer.parseInt(para[1].substring(0, para[1].indexOf(")")));
            System.out.println("总页数为：" + String.valueOf(pagecounts) + "页");

            break;	//保证只查找一次
        }
        return pagecounts;
    }

    /**
     * 解析链接源数据
     * @param src Urll链接数据源
     * @param albumname 相册名称
     * @return 解析后的YouXiaPicture对象
     */
    public static YouxiaPicture getRealImgUrl(String src, String albumname) {
        YouxiaPicture result = new YouxiaPicture(albumname,"", "");
        String temp;
        String part1,part2;
//        Pattern pattern= Pattern.compile("http://images.ali213.net/picfile/pic/.{3,5}/.{1,3}/.{1,3}/.{15,25}(.jpg|jpeg|png|bmp)");
        Pattern pattern= Pattern.compile("http://images.ali213.net/picfile/pic/[\\s\\S]*?(jpg|jpeg|png|bmp)");
        Matcher matcher = pattern.matcher(src);
        while(matcher.find()) {
            temp = matcher.group();
            System.out.println(temp);
            if (temp.contains("_")) {
                part1 = temp.split("_")[0];
                part2 = temp.split("_")[1];
                result.setUrl(temp);
                result.setOriginurl(part1.substring(0, part1.lastIndexOf("/")+1)+part2);
                break;
            }
        }
        return result;
    }

    /**
     * 根据相册链接分析相册内的图片信息并返回
     * @param srcurl 相册链接
     * @return
     */
    public static List<YouxiaPicture> getAllPicturesFromAlbumUrl(String srcurl) {
        List<YouxiaPicture> list = new ArrayList<>();
        String src = WebLinksCatcher.getResponseFromHttpUrl(srcurl, "utf-8");
        int counts = getAllPageCount(src);
        String albumname = getAlbumName(src);
        String tempurl = "";
        if (srcurl.contains("_")) { //如果相册链接不是首页
            for (int i = 0; i < counts; i++) {
                if (i > 0) {
                    tempurl = srcurl.substring(0, srcurl.indexOf("_") + 1) + String.valueOf(i + 1) + ".html";//链接解析
                } else {
                    tempurl = srcurl.substring(0, srcurl.indexOf("_")) + ".html";
                }
                list.add(getRealImgUrl(WebLinksCatcher.getResponseFromHttpUrl(tempurl, "utf-8"), albumname));
            }
        } else {    //如果相册链接是首页
            for (int i = 0; i < counts; i++) {
                if (i > 0) {
                    tempurl = srcurl.substring(0, srcurl.lastIndexOf(".") ) + "_" +String.valueOf(i + 1) + ".html";//链接解析
                } else {
                    tempurl = srcurl;
                }
                list.add(getRealImgUrl(WebLinksCatcher.getResponseFromHttpUrl(tempurl, "utf-8"), albumname));
            }
        }
        return list;
    }

}
