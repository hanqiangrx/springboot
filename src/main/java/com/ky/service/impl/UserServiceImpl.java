package com.ky.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ky.dao.UserMapper;
import com.ky.pojo.User;
import com.ky.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> selectAll() {

        return userMapper.selectAllUser();
    }




    @Override
    public PageInfo<User> page(int page, int rows) {
        PageHelper.startPage(page,rows);
        List<User> list  = userMapper.selectAllUser();
        PageInfo<User> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}
