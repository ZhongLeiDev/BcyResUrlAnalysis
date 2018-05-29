package yande;

import common.linkshandle.WebLinksCatcher;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ZhongLeiDev at 2018/5/29
 */
public class YandeKeysAnalyzeTest {

//    private static final String YANDEURL = "https://yande.re/post?tags=love_live%21+&commit=Search";
    private static final String YANDEURL = "https://yande.re/post?tags=love_live!&commit=Search";
    private static final String BASEURL = "https://yande.re/post";

    @Test
    public void getPicturesWithTag() {
        String src = WebLinksCatcher.getResponseFromHttpsUrl(BASEURL, "utf-8");
        System.out.println(YandeKeysAnalyze.getPicturesWithTag(src));
        System.out.println(YandeKeysAnalyze.getAllPageCount(src));
    }
}