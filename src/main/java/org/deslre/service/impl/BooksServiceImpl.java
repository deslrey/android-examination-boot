package org.deslre.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.deslre.convert.BookConvert;
import org.deslre.entity.po.Books;
import org.deslre.entity.vo.BooksVO;
import org.deslre.mapper.BooksMapper;
import org.deslre.result.Results;
import org.deslre.service.BooksService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.deslre.utils.StaticUtil;
import org.deslre.utils.StringUtil;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author author
 * @since 2024-12-13
 */
@Service
public class BooksServiceImpl extends ServiceImpl<BooksMapper, Books> implements BooksService {

    @Override
    public Results<List<BooksVO>> getAllBooks() {
        LambdaQueryWrapper<Books> queryWrapper = new LambdaQueryWrapper<Books>().eq(Books::getExist, StaticUtil.TRUE);
        List<Books> booksList = list(queryWrapper);
        if (booksList == null || booksList.isEmpty()) {
            return Results.fail("获取全部单词书失败");
        }

        List<BooksVO> convertedList = BookConvert.INSTANCE.convertList(booksList);

        return Results.ok(convertedList);
    }

    @Override
    public Results<List<BooksVO>> getCategory(String category) {
        if (StringUtil.isEmpty(category)) {
            return Results.fail("查询参数不能为空");
        }
        LambdaQueryWrapper<Books> queryWrapper = new LambdaQueryWrapper<Books>().eq(Books::getCategory, category).eq(Books::getExist, StaticUtil.TRUE);
        List<Books> booksList = list(queryWrapper);
        if (booksList == null || booksList.isEmpty()) {
            return Results.fail("暂无该类单词书");
        }
        List<BooksVO> convertedList = BookConvert.INSTANCE.convertList(booksList);
        return Results.ok(convertedList);
    }

    @Override
    public Results<List<BooksVO>> getLanguage(String language) {
        if (StringUtil.isEmpty(language)) {
            return Results.fail("查询参数异常");
        }

        LambdaQueryWrapper<Books> queryWrapper = new LambdaQueryWrapper<Books>().eq(Books::getLanguage, language).eq(Books::getExist, StaticUtil.TRUE);
        List<Books> booksList = list(queryWrapper);
        if (booksList == null || booksList.isEmpty()) {
            return Results.fail("当前分类暂无书籍");
        }

        List<BooksVO> convertedList = BookConvert.INSTANCE.convertList(booksList);
        return Results.ok(convertedList);
    }

    @Override
    public Results<List<BooksVO>> getLanguageCategory(String languageCategory) {
        if (StringUtil.isEmpty(languageCategory)) {
            return Results.fail("查询参数异常");
        }
        LambdaQueryWrapper<Books> queryWrapper = new LambdaQueryWrapper<Books>().eq(Books::getLanguageCategory, languageCategory).eq(Books::getExist, StaticUtil.TRUE);
        List<Books> booksList = list(queryWrapper);
        if (booksList == null || booksList.isEmpty()) {
            return Results.fail("当前分类暂无书籍");
        }
        List<BooksVO> convertedList = BookConvert.INSTANCE.convertList(booksList);
        return Results.ok(convertedList);
    }
}























