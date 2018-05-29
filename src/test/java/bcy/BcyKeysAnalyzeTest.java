package bcy;

import common.linkshandle.WebLinksCatcher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class BcyKeysAnalyzeTest {

    private static final String URL = "https://bcy.net/u/3118497/post";
    private static final String MURL = "https://bcy.net/u/1038928/post";

    @Test
    public void getAlbumCoverAndUrl() {

        String src = WebLinksCatcher.getResponseFromHttpsUrl(MURL, "utf-8");

        System.out.println(BcyKeysAnalyze.getAlbumCoverAndUrl(src));

        System.out.println(BcyKeysAnalyze.getPageNum(src, 35.00));

    }
}
