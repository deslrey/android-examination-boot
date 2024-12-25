package org.deslre.service;

import org.deslre.entity.po.Codes;
import com.baomidou.mybatisplus.extension.service.IService;
import org.deslre.entity.vo.CodeVO;
import org.deslre.result.Results;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author author
 * @since 2024-12-19
 */
public interface CodesService extends IService<Codes> {

    Results<List<CodeVO>> getCodeData(Integer id);
}
