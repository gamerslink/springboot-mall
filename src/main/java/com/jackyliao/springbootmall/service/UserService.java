package com.jackyliao.springbootmall.service;

import com.jackyliao.springbootmall.dto.UserLoginRequest;
import com.jackyliao.springbootmall.dto.UserRegisterRequest;
import com.jackyliao.springbootmall.model.User;

public interface UserService {

    User getUserById(Integer userId);

    User login(UserLoginRequest userLoginRequest);

    Integer register(UserRegisterRequest userRegisterRequest);
}
