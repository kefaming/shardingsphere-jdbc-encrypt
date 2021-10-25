package com.example.demo.service.impl;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;


    @Override
    public void insertUser(User userEntity) {
        userMapper.insertUser(userEntity);
    }

    @Override
    public List<User> getUserInfo(String userName, String pwd) {
        return userMapper.getUserInfo(userName, pwd);
    }
}
