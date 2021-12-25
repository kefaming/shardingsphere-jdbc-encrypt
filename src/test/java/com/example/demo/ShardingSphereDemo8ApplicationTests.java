package com.example.demo;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@SpringBootTest
class ShardingSphereDemo8ApplicationTests {

    @Resource
    private UserMapper userMapper;

    @Test
    void insertUser() {
        int i = 21;
        User user = User.builder    ()
                .userId(i)
                .userName("user" + i)
                .pwd("pwd_mybatis_" + i)
//                .pwdCipher("pwd_mybatis_" + i)
                .build();

        userMapper.insertUser(user);
    }

    @Test
    void getUserInfo() {
        List<User> userEntityList = userMapper.getUserInfo("user19", "123456");
        log.info(userEntityList.toString());
    }

}
