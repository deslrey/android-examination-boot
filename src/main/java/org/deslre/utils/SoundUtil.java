package org.deslre.utils;

import lombok.extern.slf4j.Slf4j;

/**
 * ClassName: soundUtil
 * Description: TODO
 * Author: Deslrey
 * Date: 2024-12-19 10:38
 * Version: 1.0
 */
@Slf4j
public class SoundUtil {


    private static final String URL = "https://dict.youdao.com/dictvoice?audio=";

    public static final String BRITISH_PRONUNCIATION = "";


    public static String getAmericanPronunciation(String word) {
        if (StringUtil.isEmpty(word)) {
            log.warn("查询的美式发音的单词不能为空");
            return null;
        }
        return URL + word + "&type=" + 0;
    }

    public static String getBritishPronunciation(String word) {
        if (StringUtil.isEmpty(word)) {
            log.warn("查询的英式发音的单词不能为空");
            return null;
        }
        return URL + word + "&type=" + 1;
    }


}
