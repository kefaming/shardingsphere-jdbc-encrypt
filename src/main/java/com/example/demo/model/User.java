package com.example.demo.model;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class User implements Serializable {

    private static final long serialVersionUID = 263434701950670170L;

    private int userId;

    private String userName;

    private String pwd;


//    @Override
//    public String toString() {
//        return String.format("user_id: %d, user_name: %s, pwd: %s", userId, userName, pwd);
//    }
}
