package com.qf.service;

import com.qf.bean.Menu;
import com.qf.bean.UserTb;

import java.util.List;

public interface UserTbMapperService {
//登录
    UserTb login(String username);
//差名字更改是否重复

    boolean checkname(String name);
//增加对象
    UserTb updateuser(UserTb userTb);


    int deleteByPrimaryKey(Integer userId);

    int insert(UserTb record);

    int insertSelective(UserTb record);

    UserTb selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(UserTb record);

    int updateByPrimaryKey(UserTb record);
}