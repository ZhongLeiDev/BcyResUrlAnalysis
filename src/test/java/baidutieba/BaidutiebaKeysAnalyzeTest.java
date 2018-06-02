package baidutieba;

import common.linkshandle.WebLinksCatcher;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ZhongLeiDev at 2018/6/2
 */
public class BaidutiebaKeysAnalyzeTest {

    private static final String BTURL = "https://tieba.baidu.com/p/2393081938";
    private static final String BTURL1 = "https://tieba.baidu.com/p/2393081938?red_tag=0423286885";
    private static final String BTURL2 = "https://tieba.baidu.com/p/2393081938?pn=3";

    @Test
    public void getRealTiebaImgUrl() {

        String src = WebLinksCatcher.getResponseFromHttpsUrl(BTURL, "utf-8");
        System.out.println(BaidutiebaKeysAnalyze.getRealTiebaImgUrl(src));

    }

    @Test
    public void getAllPageCounts() {

        String src = WebLinksCatcher.getResponseFromHttpsUrl(BTURL, "utf-8");
        System.out.println("总页数：" + BaidutiebaKeysAnalyze.getAllPageCounts(src));

    }

    @Test
    public void getAllImgUrls() {
        System.out.println(BaidutiebaKeysAnalyze.getAllImgUrls(BTURL));
    }


}