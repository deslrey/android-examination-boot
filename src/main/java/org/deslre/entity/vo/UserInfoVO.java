package org.deslre.entity.vo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户信息表
 * </p>
 *
 * @author author
 * @since 2024-11-29
 */
@Data
@Builder
public class UserInfoVO {

    /**
     * 用户ID
     */

    private String userId;

    /**
     * 用户昵称
     */
    private String nickName;

    /**
     * 用户邮箱
     */
    private String email;

    /**
     * 用户手机号
     */
    private String phone;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 注册时间
     */
    private LocalDateTime joinTime;

    /**
     * 上次登录时间
     */
    private LocalDateTime lastLoginTime;

    /**
     * 用户状态(0禁用)
     */
    private Integer status;


}