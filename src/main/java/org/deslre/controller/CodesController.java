package org.deslre.controller;


import org.deslre.entity.vo.CodeVO;
import org.deslre.result.Results;
import org.deslre.service.CodesService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author author
 * @since 2024-12-19
 */
@RestController
@RequestMapping("/codes")
public class CodesController {

    @Resource
    private CodesService codesService;

    @GetMapping("getCodeData")
    public Results<List<CodeVO>> getCodeData(Integer id) {
        return codesService.getCodeData(id);
    }

}
