package org.deslre;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.apache.bcel.classfile.Code;
import org.deslre.entity.po.*;
import org.deslre.result.CategoryResult;
import org.deslre.service.*;
import org.deslre.utils.DictListExample;
import org.deslre.utils.SoundUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.awt.print.Book;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * ClassName: addWordTest
 * Description: TODO
 * Author: Deslrey
 * Date: 2024-12-13 14:40
 * Version: 1.0
 */

@Slf4j
@SpringBootTest
public class addWordTest {

    @Resource
    private BooksService booksService;
    @Resource
    private WordsService wordsService;
    @Resource
    private MiddleLinkService middleLinkService;
    @Resource
    private CodesService codesService;

    String jsonPath = "D:\\dem\\qwerty-learner\\public\\";

    @Test
    void insertWordData() throws Exception {

        String path = "E:\\de\\2.json";

        List<DictionaryItem> dictionaryItems = DictionaryLoader.loadDictionaryData(path);

        int sum = 0;
        for (DictionaryItem item : dictionaryItems) {
            System.out.println("item = " + item);
//            String all = jsonPath + item.getUrl().replaceAll("/", "\\\\");
//            item.setUrl(all);
//            readJson(item);
//            log.info("当前第 {} 本书插入完成 ======> {}", ++sum, item.getName());
//            break;
        }

    }


    private void readJson(DictionaryItem item) {
        String jsonPath = item.getUrl();
        String americanPronunciation;
        String britishPronunciation;
        String transStr;
        String usphone;
        String ukphone;

        List<String> trans;

        Books books;
        Words words;
        MiddleLink middleLink;

        LambdaQueryWrapper<Words> wq;

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            List<Map<String, Object>> data = objectMapper.readValue(new File(jsonPath), new TypeReference<List<Map<String, Object>>>() {
            });
            List<String> stringList = item.getTags();
            String tags = String.join("&", stringList);

            books = Books.builder().bookName(item.getName()).category(item.getCategory()).description(item.getDescription()).tags(tags)
                    .wordSum(item.getLength()).language(item.getLanguage()).languageCategory(item.getLanguageCategory()).exist(true).build();

            booksService.save(books);


            for (Map<String, Object> entry : data) {
                String name = (String) entry.get("name");

                wq = new LambdaQueryWrapper<Words>().eq(Words::getWord, name);
                Words wordsServiceOne = wordsService.getOne(wq);
                if (wordsServiceOne != null) {
                    middleLink = MiddleLink.builder().bookId(books.getId()).wordId(wordsServiceOne.getId()).exist(true).build();
                    middleLinkService.save(middleLink);
                    continue;
                }

                trans = (List<String>) entry.get("trans");
                usphone = (String) entry.get("usphone");
                ukphone = (String) entry.get("ukphone");

                transStr = String.join("<deslre>", trans);

                transStr = transStr.replaceAll("，", ",").replaceAll("（", "(").replaceAll("）", ")").replaceAll("；", ";");
                System.out.println("单词 : " + name);
                System.out.println("释义 : " + transStr);
                System.out.println(" -------------------------------------------------- ");

                americanPronunciation = SoundUtil.getAmericanPronunciation(name);
                britishPronunciation = SoundUtil.getBritishPronunciation(name);

                words = Words.builder().word(name).trans(transStr).amer(usphone).amerPronoun(americanPronunciation).british(ukphone).britishPronoun(britishPronunciation).exist(true).build();
                wordsService.save(words);
                middleLink = MiddleLink.builder().bookId(books.getId()).wordId(words.getId()).exist(true).build();
                middleLinkService.save(middleLink);
            }

        } catch (Exception e) {
            log.error("出现异常,异常的书籍是  ======> {}", item);
            e.printStackTrace();
        }
    }

    @Test
    void readJSON() throws IOException {
        String path = "E:\\de\\2.json";

        List<DictionaryItem> dictList = DictionaryLoader.loadDictionaryData(path);

        for (DictionaryItem item : dictList) {
            System.out.println("item = " + item);
            String all = jsonPath + item.getUrl().replaceAll("/", "\\\\");
            item.setUrl(all);
        }

        String jsonPath;

        List<String> trans;
        List<String> stringList;
        String join;

        Codes codes;
        Books books;

        String americanPronunciation;
        String britishPronunciation;

        String transStr;

        for (DictionaryItem dict : dictList) {

            stringList = dict.getTags();
            join = String.join("&", stringList);
            jsonPath = dict.getUrl();
            books = Books.builder().wordSum(dict.getLength()).bookName(dict.getName()).description(dict.getDescription()).category(dict.getCategory()).language(dict.getLanguage())
                    .languageCategory(dict.getLanguageCategory()).tags(join).exist(true).build();
            booksService.save(books);

            ObjectMapper objectMapper = new ObjectMapper();
            try {
                List<Map<String, Object>> data = objectMapper.readValue(new File(dict.getUrl()), new TypeReference<List<Map<String, Object>>>() {
                });


                for (Map<String, Object> entry : data) {
                    String name = (String) entry.get("name");
                    trans = (List<String>) entry.get("trans");

                    transStr = String.join("<deslre>", trans);

                    transStr = transStr.replaceAll("，", ",").replaceAll("（", "(").replaceAll("）", ")").replaceAll("；", ";");
                    System.out.println("单词 : " + name);
                    System.out.println("释义 : " + transStr);
                    System.out.println(" -------------------------------------------------- ");

                    americanPronunciation = SoundUtil.getAmericanPronunciation(name);
                    britishPronunciation = SoundUtil.getBritishPronunciation(name);

                    codes = Codes.builder().bookId(books.getId()).word(name).trans(transStr).amerPronoun(americanPronunciation).britishPronoun(britishPronunciation).exist(true).build();
                    codesService.save(codes);
                }

                System.out.println("插入完成 ======> " + dict.getName());

            } catch (Exception e) {
                log.error("读取JSON文件出现异常 ======> {}", dict);
                e.printStackTrace();
            }
        }
    }
}























