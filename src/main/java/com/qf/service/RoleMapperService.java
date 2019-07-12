package com.qf.service;

import com.github.pagehelper.PageInfo;
import com.qf.bean.Role;
import com.qf.bean.UserTb;

import java.util.Map;

public interface RoleMapperService {

    public Role findbyrid(int roleid);

    //修改
    public int update(Role role,int []menuid);
    public int deletemid(Role role);

    //修改禁用启用选项
    public  int change(int roleid,int rolestate);

    public PageInfo<Role> findall(int index, int size);
//添加中间表
    public int insertmiddle(Role role,int []menuid);

    int deleteByPrimaryKey(Integer roleid);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer roleid);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
}