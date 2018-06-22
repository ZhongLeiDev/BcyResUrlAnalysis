package bcy;

import common.linkshandle.WebLinksCatcher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class BcyKeysAnalyzeTest {

    private static final String URL = "https://bcy.net/u/3118497/post";
    private static final String MURL = "https://bcy.net/u/1038928/post";        //鳗鱼
    private static final String ALBUMURL = "https://bcy.net/item/detail/6562396400015900932";

    @Test
    public void getAlbumCoverAndUrl() {

        String src = WebLinksCatcher.getResponseFromHttpsUrl(ALBUMURL, "utf-8");

        System.out.println(BcyKeysAnalyze.getAlbumTag(src));

        System.out.println(BcyKeysAnalyze.getAlbumDescription(src));

//        System.out.println(BcyKeysAnalyze.getAlbumCoverAndUrl(src));

//        System.out.println(BcyKeysAnalyze.getPageNum(src, 35.00));

    }
}
