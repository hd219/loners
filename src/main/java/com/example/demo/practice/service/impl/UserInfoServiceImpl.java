package com.example.demo.practice.service.impl;

import com.example.demo.practice.dao.UserInfoDao;
import com.example.demo.practice.model.pojo.UserInfo;
import com.example.demo.practice.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author : coder
 * @create 2021/1/22 19:59
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoDao userInfoDao;

    @Override
    public String saveUser(int data) {
        if (data == 0) {
            return "fail";
        }
        UserInfo userInfo = new UserInfo();
        userInfo.setName("james");
        userInfo.setAge(1);
        userInfo.setAddress("安达");
        userInfo.setBirthday(new Date());
        userInfo.setSex("man");
        int i = userInfoDao.insertUser(userInfo);
        if (i > 0) {
            return "success";
        }
        return "success";
    }
}
