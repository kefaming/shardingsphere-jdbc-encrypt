package com.example.demo.mapper;

import com.example.demo.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

//    @Insert("insert into t_user(user_id,user_name,pwd) values(#{userId},#{userName},#{pwd})")
    @Insert("insert into t_user(user_name,pwd) values(#{userName},#{pwd})")
    void insertUser(User userEntity);

    @Select("select * from t_user where user_name=#{userName} and pwd=#{pwd}")
    @Results({
            @Result(column = "user_id", property = "userId"),
            @Result(column = "user_name", property = "userName"),
            @Result(column = "pwd", property = "pwd"),
            @Result(column = "pwd_assisted", property = "pwdAssisted")
    })
    List<User> getUserInfo(@Param("userName") String userName, @Param("pwd") String pwd);
}
