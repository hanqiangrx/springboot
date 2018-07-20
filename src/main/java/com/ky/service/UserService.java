package com.ky.service;

import com.github.pagehelper.PageInfo;
import com.ky.pojo.User;

import java.util.List;

public interface UserService {
    public List<User> selectAll();

    public PageInfo<User> page(int page,int rows);
}
