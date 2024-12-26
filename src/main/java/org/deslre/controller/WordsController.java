package org.deslre.controller;


import org.deslre.entity.vo.WordsVO;
import org.deslre.result.Results;
import org.deslre.service.WordsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author author
 * @since 2024-12-13
 */
@RestController
@RequestMapping("/words")
public class WordsController {

    @Resource
    private WordsService wordsService;

    @PostMapping("getWordData")
    public Results<List<WordsVO>> getWordData(Integer bookId) {
        return wordsService.getWordData(bookId);
    }

}
