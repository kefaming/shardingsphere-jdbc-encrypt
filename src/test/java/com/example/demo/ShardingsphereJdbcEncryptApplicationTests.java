package com.example.demo;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;
import java.util.Random;

@Slf4j
@SpringBootTest
class ShardingsphereJdbcEncryptApplicationTests {

    @Resource
    private UserMapper userMapper;

    @Test
    void insertUser() {
        int i = new Random().nextInt(1000);
        User user = User.builder()
            .userId(i)
            .userName("test_mybatis_" + i)
            .pwd("pwd_mybatis_" + i)
//            .pwdCipher("pwd_mybatis_" + i)
            .build();
        System.out.println(user);
        userMapper.insertUser(user);
    }

//    @Test
    void getUserInfo() {
        List<User> list = userMapper.getUserInfo("test_mybatis_717", "pwd_mybatis_717");
        if(list != null && list.size() > 0){
            for (User user:list) {
                System.out.println(user);
            }
        }
    }

}
