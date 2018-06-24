package dyd;

import common.linkshandle.WebLinksCatcher;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ZhongLeiDev at 2018/5/30
 */
public class DydKeysAnalyzeTest {

    private static final String DYDURL = "http://www.diyidan.com/main/post/6294359091003588274/detail/1";
    private static final String URL = "https://www.diyidan.com/main/post/6294630120669109839/detail/1";
    private static final String LXLURL = "https://www.diyidan.com/main/post/6294630120664505040/detail/1#anchor_comment_floor";
    private static final String DYDURL1 = "http://www.diyidan.com/main/post/6294630120662342678/detail/1";
    private static final String LMURL = "https://www.diyidan.com/main/post/6294359091003347458/detail/1";
    private static final String COMICURL = "https://www.diyidan.com/main/post/6294630120667616960/detail/1";
    private static final String COMICURLLOUZHU = "https://www.diyidan.com/main/post/6294630120667616960/detail/1?louzhu=true";
    private static final String LOUZHU = "https://www.diyidan.com/main/post/6294630120659899673/detail/1";

    @Test
    public void getRealImgUrl() {
//        String src = WebLinksCatcher.getResponseFromHttpUrl(DYDURL1, "utf-8");
//        System.out.println(src);
//        System.out.println(DydKeysAnalyze.getRealImgUrl(src));
//        System.out.println(DydKeysAnalyze.getDydPictureList(DydKeysAnalyze.getPictureJSONStr(src)));
//        System.out.println(DydKeysAnalyze.getTags(src));
//        System.out.println(DydKeysAnalyze.getAllPageCount(src));
//        System.out.println(DydKeysAnalyze.getAuthor(src));
//        System.out.println(DydKeysAnalyze.getTitle(src));
//        System.out.println(DydKeysAnalyze.getDesc(src));

        System.out.println(DydKeysAnalyze.getAllPictures(DYDURL));
        System.out.println(DydKeysAnalyze.getAllPictures(URL));
        System.out.println(DydKeysAnalyze.getAllPictures(LXLURL));
        System.out.println(DydKeysAnalyze.getAllPictures(DYDURL1));
        System.out.println(DydKeysAnalyze.getAllPictures(LMURL));
        System.out.println(DydKeysAnalyze.getAllPictures(COMICURL));
        System.out.println(DydKeysAnalyze.getAllPictures(LOUZHU));


    }
}