package org.deslre.service.impl;

import org.deslre.entity.po.Words;
import org.deslre.mapper.WordsMapper;
import org.deslre.service.IWordsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author author
 * @since 2024-12-13
 */
@Service
public class WordsServiceImpl extends ServiceImpl<WordsMapper, Words> implements IWordsService {

}
