package org.deslre.convert;

import org.deslre.entity.po.Words;
import org.deslre.entity.vo.WordsVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * ClassName: WordConvert
 * Description: TODO
 * Author: Deslrey
 * Date: 2024-12-26 10:56
 * Version: 1.0
 */
@Mapper(componentModel = "spring")
public interface WordConvert {
    WordConvert INSTANCE = Mappers.getMapper(WordConvert.class);

    Words convert(WordsVO vo);

    WordsVO convert(Words entity);

    List<WordsVO> convertList(List<Words> list);

}
