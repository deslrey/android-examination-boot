package org.deslre.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.deslre.entity.po.UserInfo;
import org.deslre.entity.vo.UserInfoVO;
import org.deslre.result.Results;

/**
 * ClassName: UserInfoService
 * Description: TODO
 * Author: Deslrey
 * Date: 2024-11-29 11:21
 * Version: 1.0
 */

public interface UserInfoService extends IService<UserInfo> {
    Results<UserInfoVO> login(String userName, String passWord);

    Results<UserInfoVO> emailRegister(String email, String passWord);

    Results<UserInfoVO> phoneRegister(String phone, String passWord);
}
