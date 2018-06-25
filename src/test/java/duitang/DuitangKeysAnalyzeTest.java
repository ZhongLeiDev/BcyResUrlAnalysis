package duitang;

import common.linkshandle.WebLinksCatcher;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ZhongLeiDev at 2018/6/25
 */
public class DuitangKeysAnalyzeTest {

    private static final String MAINURL = "https://www.duitang.com/topics/";
    private static final String HOTURL = "https://www.duitang.com/napi/index/hot/?include_fields=top_comments,is_root,source_link,item,buyable,root_id,status,like_count,sender,album&limit=24&start=48&_=1529905585063";
    private static final String SIMPLEHOTURL = "https://www.duitang.com/napi/index/hot/?limit=24&start=0";     //热门分类
    private static final String SEARCHURL = "https://www.duitang.com/napi/blog/list/by_search/?kw=cos&type=feed&include_fields=top_comments,is_root,source_link,item,buyable,root_id,status,like_count,sender,album&_type=&start=24&_=1529907030145";
    private static final String GUFENGURL = "https://www.duitang.com/napi/blog/list/by_filter_id/?include_fields=top_comments,is_root,source_link,item,buyable,root_id,status,like_count,sender,album&filter_id=古风&start=24&_=1529907609991";   //古风分类
    private static final String SHEJIURL = "https://www.duitang.com/napi/blog/list/by_filter_id/?include_fields=top_comments,is_root,source_link,item,buyable,root_id,status,like_count,sender,album&filter_id=设计&start=24&_=1529907380214"; //设计分类
    private static final String[] FILTER_ID_SET = {

            "家居生活",
            "美食菜谱",
            "手工DIY",
            "时尚搭配",
            "美妆造型",
            "婚纱婚礼",
            "设计",
            "古风",
            "插画绘画",
            "壁纸",
            "头像",
            "文字句子",
            "旅行",
            "摄影",
            "人文艺术",
            "影音书",
            "人物明星",
            "动画漫画",
            "植物多肉",
            "生活百科",
            "搞笑萌宠"

    };

    @Test
    public void getAllPictures() {
        String src = WebLinksCatcher.getResponseFromHttpsUrl(MAINURL,"utf-8");
        System.out.println(src);
    }
}