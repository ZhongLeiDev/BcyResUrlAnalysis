package dyd;

import common.linkshandle.WebLinksCatcher;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ZhongLeiDev at 2018/5/30
 */
public class DydKeysAnalyzeTest {

    private static final String DYDURL = "http://www.diyidan.com/main/post/6294359091003588274/detail/1";

    @Test
    public void getRealImgUrl() {
        String src = WebLinksCatcher.getResponseFromHttpUrl(DYDURL, "utf-8");
        System.out.println(src);
    }
}