package org.deslre.controller;


import org.deslre.entity.vo.BooksVO;
import org.deslre.result.Results;
import org.deslre.service.BooksService;
import org.springframework.web.bind.annotation.GetMapping;
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
    public Results<List<BooksVO>> getAllBooks(){
        return booksService.getAllBooks();
    }

}
