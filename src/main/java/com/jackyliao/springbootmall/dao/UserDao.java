package com.jackyliao.springbootmall.dao;

import com.jackyliao.springbootmall.dto.UserRegisterRequest;
import com.jackyliao.springbootmall.model.User;

public interface UserDao {

    User getUserById(Integer userId);

    Integer createUser(UserRegisterRequest userRegisterRequest);
}
