package com.jackyliao.springbootmall.service.impl;

import com.jackyliao.springbootmall.dao.UserDao;
import com.jackyliao.springbootmall.dto.UserRegisterRequest;
import com.jackyliao.springbootmall.model.User;
import com.jackyliao.springbootmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public Integer register(UserRegisterRequest userRegisterRequest) {
        return userDao.createUser(userRegisterRequest);
    }

    @Override
    public User getUserById(Integer userId) {
        return userDao.getUserById(userId);
    }
}
