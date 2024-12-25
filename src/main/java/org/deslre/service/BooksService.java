package org.deslre.service;

import org.deslre.entity.po.Books;
import com.baomidou.mybatisplus.extension.service.IService;
import org.deslre.entity.vo.BooksVO;
import org.deslre.result.Results;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author author
 * @since 2024-12-13
 */
public interface BooksService extends IService<Books> {

    Results<List<BooksVO>> getAllBooks();

    Results<List<BooksVO>> getCategory(String category);

    Results<List<BooksVO>> getLanguage(String language);

    Results<List<BooksVO>> getLanguageCategory(String languageCategory);
}
