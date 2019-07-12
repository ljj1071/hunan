package com.qf.service;

import com.qf.bean.Menu;
import com.qf.bean.UserTb;

import java.util.List;

public interface MenuMapperService {

    public List<Menu> findmenus();

    public List<Menu> findbyroleid(int roleid);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(Integer menuid);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);
}