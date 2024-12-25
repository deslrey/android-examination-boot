package org.deslre.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.deslre.convert.CodeConvert;
import org.deslre.entity.po.Codes;
import org.deslre.entity.vo.CodeVO;
import org.deslre.mapper.CodesMapper;
import org.deslre.result.Results;
import org.deslre.service.CodesService;
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
 * @since 2024-12-19
 */
@Service
public class CodesServiceImpl extends ServiceImpl<CodesMapper, Codes> implements CodesService {

    @Override
    public Results<List<CodeVO>> getCodeData(Integer id) {
        if (id == null || id <= 0) {
            return Results.fail("查询参数异常");
        }
        LambdaQueryWrapper<Codes> wrapper = new LambdaQueryWrapper<Codes>().eq(Codes::getBookId, id).eq(Codes::getExist, true);
        List<Codes> codesList = list(wrapper);
        if (codesList == null || codesList.isEmpty()) {
            return Results.fail("当前单词书暂无数据");
        }
        List<CodeVO> convertList = CodeConvert.INSTANCE.convertList(codesList);
        return Results.ok(convertList);
    }

    @Override
    public Results<List<CodeVO>> getPageData(Integer bookId, Integer page, Integer size) {
        if (bookId == null || page == null || size == null) {
            return Results.fail("查询参数异常");
        }
        LambdaQueryWrapper<Codes> queryWrapper = new LambdaQueryWrapper<Codes>().eq(Codes::getBookId, bookId).eq(Codes::getExist, StaticUtil.TRUE);
        Page<Codes> codesPage = baseMapper.selectPage(new Page<>(page, size), queryWrapper);
        List<Codes> records = codesPage.getRecords();
        if (records == null || records.isEmpty()) {
            return Results.fail("当前单词书暂无数据");
        }
        List<CodeVO> convertList = CodeConvert.INSTANCE.convertList(records);
        return Results.ok(convertList);
    }


}
