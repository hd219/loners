package com.example.demo.practice.dao.impl;

import com.example.demo.practice.dao.UserInfoDao;
import com.example.demo.practice.model.mapper.UserInfoMapper;
import com.example.demo.practice.model.pojo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author : coder
 * @create 2021/1/22 20:08
 */
@Repository
public class UserInfoDaoImpl implements UserInfoDao {

    @Autowired
    private UserInfoMapper mapper;

    @Override
    public int insertUser(UserInfo userInfo) {
        return mapper.insertSelective(userInfo);
    }
}
