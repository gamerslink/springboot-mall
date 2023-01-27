package com.jackyliao.springbootmall.service;

import com.jackyliao.springbootmall.dto.UserRegisterRequest;
import com.jackyliao.springbootmall.model.User;

public interface UserService {

    User getUserById(Integer userId);


    Integer register(UserRegisterRequest userRegisterRequest);
}
