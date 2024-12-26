package org.deslre.service;

import org.deslre.entity.po.Words;
import com.baomidou.mybatisplus.extension.service.IService;
import org.deslre.entity.vo.WordsVO;
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
public interface WordsService extends IService<Words> {

    Results<List<WordsVO>> getWordData(Integer bookId);
}
