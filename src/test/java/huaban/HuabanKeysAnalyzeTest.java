package huaban;

import org.junit.Test;

/**
 * Created by ZhongLeiDev at 2018/5/30
 */
public class HuabanKeysAnalyzeTest {

    private static final String HBURL = "http://huaban.com/boards/35709698/";

    @Test
    public void getAllPicFromBoardUrl() {
        System.out.println(HuabanKeysAnalyze.getAllPicFromBoardUrl(HBURL).size());
    }
}