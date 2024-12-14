package org.deslre;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.deslre.entity.po.Books;
import org.deslre.entity.po.MiddleLink;
import org.deslre.entity.po.Words;
import org.deslre.service.BooksService;
import org.deslre.service.MiddleLinkService;
import org.deslre.service.WordsService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * ClassName: addWordTest
 * Description: TODO
 * Author: Deslrey
 * Date: 2024-12-13 14:40
 * Version: 1.0
 */

@SpringBootTest
public class addWordTest {

    @Resource
    private BooksService booksService;
    @Resource
    private WordsService wordsService;
    @Resource
    private MiddleLinkService middleLinkService;

    @Test
    void insert() {
        String bookName = "2024考研英语红宝书(下)";
        String jsonPath = "D:\\dem\\qwerty-learner\\public\\dicts\\2024HongBao_T2.json";

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            List<Map<String, Object>> data = objectMapper.readValue(
                    new File(jsonPath),
                    new TypeReference<List<Map<String, Object>>>() {
                    }
            );


            Words words;
            MiddleLink middleLink;

            int sum = 0;
            Books books = Books.builder().wordSum(sum).bookName(bookName).description("2024考研英语红宝书(下)").exist(true).build();
            booksService.save(books);

            StringBuilder sb = new StringBuilder();

            LambdaQueryWrapper<Words> eq;
            String name;
            Words wordsServiceOne;
            List<String> trans;
            String usPhone;
            String ukPhone;
            int count = 0;
            for (Map<String, Object> entry : data) {
                count++;
                name = (String) entry.get("name");
                eq = new LambdaQueryWrapper<Words>().eq(Words::getWord, name);
                wordsServiceOne = wordsService.getOne(eq);
                if (wordsServiceOne != null) {
                    System.err.println("当前词已存在 ======> " + name);
                    middleLink = MiddleLink.builder().bookId(books.getId()).wordId(wordsServiceOne.getId()).exist(true).build();
                    middleLinkService.save(middleLink);
                    sb = new StringBuilder();
                    continue;
                }
                trans = (List<String>) entry.get("trans");
                usPhone = (String) entry.get("usphone");
                ukPhone = (String) entry.get("ukphone");

                System.out.println("单词 : " + name);
                System.out.println("释义 : ");
                for (String tran : trans) {
                    tran = tran.replaceAll("，", ",").replaceAll("（", "(").replaceAll("）", ")").replaceAll("；", ";");
                    System.out.println(" --- " + tran);
                    sb.append(tran).append("<deslre>");
                }
                System.out.println("美式发音 : " + usPhone);
                System.out.println("英式发音 : " + ukPhone);
                System.out.println(" -------------------------------------------------- ");

                words = Words.builder().word(name).trans(sb.toString()).amerPronoun(usPhone).britishPronoun(ukPhone).exist(true).build();

                wordsService.save(words);

                middleLink = MiddleLink.builder().bookId(books.getId()).wordId(words.getId()).exist(true).build();
                middleLinkService.save(middleLink);
                sb = new StringBuilder();
            }

            books.setWordSum(count);
            booksService.updateById(books);
            System.out.println("插入完成");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}























