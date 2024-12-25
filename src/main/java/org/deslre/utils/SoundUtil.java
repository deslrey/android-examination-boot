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

    private static final String English = "https://dict.youdao.com/dictvoice?audio=";
    private static final String Japanese = "https://dict.youdao.com/dictvoice?audio=";
    private static final String German = "https://dict.youdao.com/dictvoice?audio=";
    private static final String Kazakh = "https://dict.youdao.com/dictvoice?audio=";
    private static final String Indonesia = "https://dict.youdao.com/dictvoice?audio=";

    public static String getAmericanPronunciation(String word) {
        if (StringUtil.isEmpty(word)) {
            log.warn("查询的美式发音的单词不能为空");
            return null;
        }
        return English + word + "&type=" + 0;
    }

    public static String getBritishPronunciation(String word) {
        if (StringUtil.isEmpty(word)) {
            log.warn("查询的英式发音的单词不能为空");
            return null;
        }
        return English + word + "&type=" + 1;
    }

    public static String getJapan(String word) {
        if (StringUtil.isEmpty(word)) {
            log.warn("查询的日语发音的单词不能为空");
            return null;
        }
        return Japanese + word + "&le=jap";
    }

    public static String getGerman(String word) {
        if (StringUtil.isEmpty(word)) {
            log.warn("查询的德语发音的单词不能为空");
            return null;
        }
        return German + word + "&le=de";
    }

    public static String getKazakh(String word) {
        if (StringUtil.isEmpty(word)) {
            log.warn("查询的哈萨克语哈拼发音的单词不能为空");
            return null;
        }
        return Kazakh + word + "&le=ru";
    }

    public static String getIndonesia(String word) {
        if (StringUtil.isEmpty(word)) {
            log.warn("查询的哈萨克语哈拼发音的单词不能为空");
            return null;
        }
        return Indonesia + word + "&le=id";
    }


    public static void main(String[] args) {
        String string = getJapan("てまえ");
        System.out.println("string = " + string);
    }

}
