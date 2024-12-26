package org.deslre;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.deslre.entity.po.UserInfo;
import org.deslre.entity.po.Words;
import org.deslre.service.UserInfoService;
import org.deslre.service.WordsService;
import org.deslre.utils.SHA256Util;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class DeslreShopBootApplicationTests {

    @Resource
    private UserInfoService userInfoService;
    @Resource
    private WordsService wordsService;

    @Test
    void contextLoads() {
        LambdaQueryWrapper<UserInfo> queryWrapper = new LambdaQueryWrapper<UserInfo>().select(UserInfo::getEmail, UserInfo::getPassword).eq(UserInfo::getEmail, "1").eq(UserInfo::getPassword, "1");
        UserInfo userInfo = userInfoService.getOne(queryWrapper);
        System.out.println("userInfo = " + userInfo);

    }


    @Test
    void name() {
        Words words = wordsService.getById(1);
        System.out.println("words = " + words);

    }
}
