package org.deslre.controller;


import org.deslre.entity.vo.BooksVO;
import org.deslre.result.Results;
import org.deslre.service.BooksService;
import org.springframework.web.bind.annotation.GetMapping;
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
@RequestMapping("/books")
public class BooksController {

    @Resource
    private BooksService booksService;

    @GetMapping("getAllBooks")
    public Results<List<BooksVO>> getAllBooks() {
        return booksService.getAllBooks();
    }

    @PostMapping("getCategory")
    public Results<List<BooksVO>> getCategory(String category) {
        return booksService.getCategory(category);
    }

    @PostMapping("getLanguage")
    public Results<List<BooksVO>> getLanguage(String language) {
        return booksService.getLanguage(language);
    }

    @PostMapping("getLanguageCategory")
    public Results<List<BooksVO>> getLanguageCategory(String languageCategory) {
        return booksService.getLanguageCategory(languageCategory);
    }

    @GetMapping("getAllWordBooks")
    public Results<List<BooksVO>> getAllWordBooks() {
        return booksService.getAllWordBooks();
    }

}
