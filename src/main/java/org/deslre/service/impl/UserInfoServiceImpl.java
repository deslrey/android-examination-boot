package org.deslre.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.deslre.convert.UserInfoConvert;
import org.deslre.entity.enums.UserStatusEnum;
import org.deslre.entity.vo.UserInfoVO;
import org.deslre.exception.DeslreException;
import org.deslre.mapper.UserInfoMapper;
import org.deslre.result.Constants;
import org.deslre.result.Results;
import org.deslre.entity.po.UserInfo;
import org.deslre.service.UserInfoService;
import org.deslre.utils.RegexUtils;
import org.deslre.utils.SHA256Util;
import org.deslre.utils.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Date;

import static org.deslre.result.Constants.NICKNAME_DESLRE;

/**
 * ClassName: UserInfoServiceImpl
 * Description: TODO
 * Author: Deslrey
 * Date: 2024-11-29 11:21
 * Version: 1.0
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {

    @Resource
    private UserInfoConvert userInfoConvert;

    @Override
    public Results<UserInfoVO> login(String userName, String passWord) {
        if (StringUtil.isEmpty(userName) || StringUtil.isEmpty(passWord)) {
            throw new DeslreException("账户或者密码不能为空");
        }

        String encrypt = SHA256Util.encrypt(passWord);

        if (RegexUtils.checkEmail(userName)) {
            return loginEmail(userName, encrypt);
        } else if (RegexUtils.checkMobile(userName)) {
            return loginMobile(userName, encrypt);
        }
        return Results.fail("登录失败,请输入正确的用户名进行登录");
    }

    /**
     * 用户使用邮箱进行注册
     *
     * @param email    邮箱
     * @param passWord 密码
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Results<UserInfoVO> emailRegister(String email, String passWord) {
        if (StringUtil.isEmpty(email) || StringUtil.isEmpty(passWord)) {
            throw new DeslreException("邮箱账号或者密码不能为空");
        }

        if (!RegexUtils.checkEmail(email)) {
            return Results.fail("清输入正确的邮箱号");
        }

        LambdaQueryWrapper<UserInfo> queryWrapper = new LambdaQueryWrapper<UserInfo>().eq(UserInfo::getEmail, email);
        UserInfo userInfo = getOne(queryWrapper);
        if (userInfo != null) {
            return Results.fail("注册失败,该邮箱已被使用");
        }
        String encrypt = SHA256Util.encrypt(passWord);
        String userId = StringUtil.getRandomNumber(Constants.LENGTH_10);
        UserInfo saveUserInfo = UserInfo.builder().userId(userId).nickName(NICKNAME_DESLRE + userId).email(email).password(encrypt).joinTime(LocalDateTime.now()).status(UserStatusEnum.ENABLE.getStatus()).build();
        boolean save = this.save(saveUserInfo);
        UserInfoVO convertUser = userInfoConvert.convert(saveUserInfo);
        if (save)
            return Results.ok(convertUser, "注册成功");
        return Results.fail("注册失败");
    }

    /**
     * 用户使用手机号进行注册
     *
     * @param phone    手机号
     * @param passWord 密码
     */
    @Override
    public Results<UserInfoVO> phoneRegister(String phone, String passWord) {
        if (StringUtil.isEmpty(phone) || StringUtil.isEmpty(passWord)) {
            throw new DeslreException("手机号或者密码不能为空");
        }

        if (!RegexUtils.checkMobile(phone)) {
            return Results.fail("清输入正确的手机号");
        }

        LambdaQueryWrapper<UserInfo> queryWrapper = new LambdaQueryWrapper<UserInfo>().select(UserInfo::getPhone).eq(UserInfo::getPhone, phone);
        UserInfo userInfo = getOne(queryWrapper);
        if (userInfo != null) {
            return Results.fail("注册失败,该手机号已被使用");
        }
        String encrypt = SHA256Util.encrypt(passWord);
        String userId = StringUtil.getRandomNumber(Constants.LENGTH_10);

        UserInfo saveUserInfo = UserInfo.builder().userId(userId).nickName(NICKNAME_DESLRE + userId).phone(phone).password(encrypt).joinTime(LocalDateTime.now()).status(UserStatusEnum.ENABLE.getStatus()).build();
        boolean save = this.save(saveUserInfo);
        UserInfoVO convertUser = userInfoConvert.convert(saveUserInfo);
        if (save)
            return Results.ok(convertUser, "注册成功");
        return Results.fail("注册失败");
    }


    private Results<UserInfoVO> loginEmail(String email, String passWord) {
        UserInfo userInfo = getUserEmail(email, passWord);
        if (userInfo == null)
            return Results.fail("登录失败,用户不存在");
        if (userInfo.getStatus() == 0)
            return Results.fail("登录失败,用户状态异常");
        UserInfoVO convert = userInfoConvert.convert(userInfo);
        return Results.ok(convert, "登录成功");
    }

    private Results<UserInfoVO> loginMobile(String phone, String passWord) {
        UserInfo userInfo = getUserPhone(phone, passWord);
        if (userInfo == null)
            return Results.fail("登录失败,用户不存在");
        if (userInfo.getStatus() == 0)
            return Results.fail("登录失败,用户状态异常");
        UserInfoVO convert = userInfoConvert.convert(userInfo);
        return Results.ok(convert, "登录成功");
    }


    /**
     * 根据邮箱查询用户
     *
     * @param email    邮箱账号
     * @param passWord 密码
     */
    private UserInfo getUserEmail(String email, String passWord) {
        LambdaQueryWrapper<UserInfo> queryWrapper = new LambdaQueryWrapper<UserInfo>().eq(UserInfo::getEmail, email).eq(UserInfo::getPassword, SHA256Util.encrypt(passWord));
        return getOne(queryWrapper);
    }

    /**
     * 根据手机号查询用户
     *
     * @param phone    手机号
     * @param passWord 密码
     */
    private UserInfo getUserPhone(String phone, String passWord) {
        LambdaQueryWrapper<UserInfo> queryWrapper = new LambdaQueryWrapper<UserInfo>().eq(UserInfo::getPhone, phone).eq(UserInfo::getPassword, SHA256Util.encrypt(passWord));
        return getOne(queryWrapper);
    }
}
