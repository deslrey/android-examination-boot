package org.deslre.convert;

import org.deslre.entity.po.Books;
import org.deslre.entity.po.Codes;
import org.deslre.entity.vo.BooksVO;
import org.deslre.entity.vo.CodeVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * ClassName: BookConvert
 * Description: TODO
 * Author: Deslrey
 * Date: 2024-12-25 15:39
 * Version: 1.0
 */
@Mapper(componentModel = "spring")
public interface BookConvert {
    BookConvert INSTANCE = Mappers.getMapper(BookConvert.class);

    Books convert(BooksVO vo);

    BooksVO convert(Books entity);

    List<BooksVO> convertList(List<Books> list);
}
