package huaban;

import huaban.beans.HuabanPicture;

import java.util.List;

/**
 * Created by ZhongLeiDev at 2018/5/24
 */
public class HuabanKeysAnalyze {

    /**
     * 根据boardUrl获取画板内的所有图片
     * @param boardUrl  画板链接
     * @return
     */
    public static List<HuabanPicture> getAllPicFromBoardUrl(String boardUrl) {
        return Snapper.getInstance().setBoardUrl(boardUrl).getAllPictures();
    }

}
