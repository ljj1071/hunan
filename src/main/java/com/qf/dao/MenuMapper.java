package com.qf.dao;

import com.qf.bean.Menu;

import java.util.List;

public interface MenuMapper {

    public List<Menu> findmenus();

    public List<Menu> findbyroleid(int roleid);

    int deleteByPrimaryKey(Integer menuid);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(Integer menuid);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);
}