package com.example.demo.practice.controller;

import com.example.demo.practice.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : coder
 * @create 2021/1/22 19:55
 */
@RestController
@RequestMapping("/user")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @GetMapping("/insert")
    public String insert(@RequestParam(required = false, defaultValue = "1") int data) {
        return userInfoService.saveUser(data);
    }

}
