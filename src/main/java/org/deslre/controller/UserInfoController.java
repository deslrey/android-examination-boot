package org.deslre.controller;


import org.deslre.entity.po.UserInfo;
import org.deslre.entity.vo.UserInfoVO;
import org.deslre.result.Results;
import org.deslre.service.UserInfoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 用户信息表 前端控制器
 * </p>
 *
 * @author author
 * @since 2024-11-29
 */
@RestController
@RequestMapping("/userInfo")
public class UserInfoController {

    @Resource
    private UserInfoService userInfoService;

    /**
     * 用户登录
     *
     * @param userName 用户名
     * @param passWord 用户密码
     */
    @PostMapping("login")
    public Results<UserInfoVO> login(String userName, String passWord) {
        System.out.println("userName = " + userName);
        System.out.println("passWord = " + passWord);
        return userInfoService.login(userName, passWord);
    }

    /**
     * 用户使用邮箱注册
     *
     * @param email    邮箱账号
     * @param passWord 密码
     */
    @PostMapping("emailRegister")
    public Results<UserInfoVO> emailRegister(String email, String passWord) {
        System.out.println("email = " + email);
        System.out.println("password = " + passWord);
        return userInfoService.emailRegister(email, passWord);
    }

    /**
     * 用户使用手机号注册
     *
     * @param phone    手机号
     * @param passWord 密码
     */
    @PostMapping("phoneRegister")
    public Results<UserInfoVO> phoneRegister(String phone, String passWord) {
        System.out.println("phone = " + phone);
        System.out.println("password = " + passWord);
        return userInfoService.phoneRegister(phone, passWord);
    }

}
