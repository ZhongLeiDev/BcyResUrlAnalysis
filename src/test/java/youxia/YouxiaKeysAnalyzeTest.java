package youxia;

import common.linkshandle.WebLinksCatcher;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ZhongLeiDev at 2018/5/30
 */
public class YouxiaKeysAnalyzeTest {

    private static final String YXURL = "http://pic.ali213.net/html/2016-03-21/61101_44.html";
//    private static final String YXURL = "http://pic.ali213.net/html/2016-03-21/61101.html";

    @Test
    public void getAllPageCount() {
        String src = WebLinksCatcher.getResponseFromHttpUrl(YXURL, "utf-8");
        System.out.println(YouxiaKeysAnalyze.getAllPageCount(src));
    }

    @Test
    public void getRealImgUrl() {
//        String src = WebLinksCatcher.getResponseFromHttpUrl(YXURL, "utf-8");
//        System.out.println(src);
//        System.out.println(YouxiaKeysAnalyze.getAlbumName(src));
        System.out.println(YouxiaKeysAnalyze.getAllPicturesFromAlbumUrl(YXURL));
    }
}