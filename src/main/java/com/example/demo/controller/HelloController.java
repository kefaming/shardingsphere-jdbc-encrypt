package com.example.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;

@Slf4j
@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String get(HashMap<String, Object> map) {
        return "hello";
    }

}
