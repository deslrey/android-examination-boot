package org.deslre.convert;


import org.deslre.entity.po.Codes;
import org.deslre.entity.vo.CodeVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * ClassName: CodeConvert
 * Description: TODO
 * Author: Deslrey
 * Date: 2024-12-25 14:03
 * Version: 1.0
 */
@Mapper(componentModel = "spring")
public interface CodeConvert {

    CodeConvert INSTANCE = Mappers.getMapper(CodeConvert.class);

    Codes convert(CodeVO vo);

    CodeVO convert(Codes entity);

    List<CodeVO> convertList(List<Codes> list);

}
