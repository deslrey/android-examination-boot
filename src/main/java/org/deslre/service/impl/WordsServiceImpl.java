package org.deslre.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.deslre.convert.WordConvert;
import org.deslre.entity.po.Words;
import org.deslre.entity.vo.WordsVO;
import org.deslre.mapper.WordsMapper;
import org.deslre.result.Results;
import org.deslre.service.WordsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.deslre.utils.StaticUtil;
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
public class WordsServiceImpl extends ServiceImpl<WordsMapper, Words> implements WordsService {

    @Override
    public Results<List<WordsVO>> getWordData(Integer bookId) {
        if (bookId == null) {
            return Results.fail("查询参数异常");
        }

        LambdaQueryWrapper<Words> queryWrapper = new LambdaQueryWrapper<Words>().eq(Words::getBookId, bookId).eq(Words::getExist, StaticUtil.TRUE);
        List<Words> wordsList = list(queryWrapper);
        if (wordsList == null || wordsList.isEmpty()) {
            return Results.fail("当前单词书暂无数据");
        }
        List<WordsVO> convertedList = WordConvert.INSTANCE.convertList(wordsList);
        return Results.ok(convertedList);
    }
}
