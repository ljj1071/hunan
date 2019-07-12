package com.qf.dao;

import com.github.pagehelper.PageInfo;
import com.qf.bean.Role;

import java.util.List;
import java.util.Map;

public interface RoleMapper {

    List<Role> findall();

    public Role findbyrid(int roleid);

    public int deletemid(Role role);
    //修改禁用启用选项
    public  int change(Map map);

    public int insertmiddle(Map map);

    int deleteByPrimaryKey(Integer roleid);

    int insert(Role record);

    int insertSelective(Role role);

    Role selectByPrimaryKey(Integer roleid);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
}