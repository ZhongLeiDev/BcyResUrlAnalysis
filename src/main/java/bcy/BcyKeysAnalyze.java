package bcy;

import bcy.beans.AlbumCoverAndUrl;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ZhongLeiDev at 2018/5/24
 */
public class BcyKeysAnalyze {

    /**
     * 获取相册封面和链接
     * @param src
     * @return
     */
    public static List<AlbumCoverAndUrl> getAlbumCoverAndUrl(String src) {
        List<AlbumCoverAndUrl> list = new ArrayList<>();
        Pattern pattern= Pattern.compile("href=\"/item/detail/[\\s\\S]*?/>");
        Matcher matcher = pattern.matcher(src);
        String str = "";
        while(matcher.find()) {
            str = matcher.group();
//	    	System.out.println("AlbumCoverAndUrl:" + str);
            list.add(new AlbumCoverAndUrl(str.split("\"")[11],"https://bcy.net" + str.split("\"")[1]));
        }
        return list;
    }

    /**
     * 获取作品总页数
     * @param src
     * @param pageSize	每页容量
     * @return
     */
    public static int getPageNum(String src, Double pageSize) {
        int pageNum = 0;
        Pattern pattern= Pattern.compile("共.*篇");
        Matcher matcher = pattern.matcher(src);
        while(matcher.find()) {
            double number = Double.parseDouble(matcher.group().replace("共", "").replace("篇", ""));
            System.out.println("共有" + number + "个相册");
            pageNum = (int)Math.ceil(number/pageSize);//向上取整
        }
        return pageNum;
    }

}
