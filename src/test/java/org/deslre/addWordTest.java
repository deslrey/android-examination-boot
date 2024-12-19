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
    @Resource
    private CategoryService categoryService;

    @Test
    void readJSON() {
        List<Dict> dictList = DictListExample.getDictList();

        String jsonPath;

        List<String> trans;
        List<String> stringList;
        String join;

        Codes codes;
        Books books;
        Category category;

        String americanPronunciation;
        String britishPronunciation;

        String transStr;

        for (Dict dict : dictList) {

            stringList = dict.getTags();
            join = String.join("&", stringList);

            category = Category.builder().parentCategory(CategoryResult.CODE).categoryName(join).build();

            categoryService.save(category);


            jsonPath = dict.getUrl();
            books = Books.builder().categoryId(category.getId()).wordSum(dict.getLength()).bookName(dict.getName()).description(dict.getDescription()).exist(true).build();

            booksService.save(books);

            ObjectMapper objectMapper = new ObjectMapper();
            try {
                List<Map<String, Object>> data = objectMapper.readValue(new File(jsonPath), new TypeReference<List<Map<String, Object>>>() {
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























