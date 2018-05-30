package dyd;

import common.utils.ComUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ZhongLeiDev at 2018/5/24
 */
public class DydKeysAnalyze {

    /**
     * 获取图片链接
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

}
