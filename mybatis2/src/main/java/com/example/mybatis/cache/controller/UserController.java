package com.example.mybatis.cache.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/web/ums")
public class UserController {

    @GetMapping("/getUserInfo")
    public String getUserInfo(String userNo){
        return "";
    }

}
