package com.qf.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.qf.bean.Role;
import com.qf.dao.MenuMapper;
import com.qf.dao.RoleMapper;
import com.qf.service.RoleMapperService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class RoleMapperServiceImpl implements RoleMapperService {
    @Resource
    private RoleMapper roleMapper;


    //修改1得到该觉得2级菜单
    @Override
    public Role findbyrid(int roleid) {
        Role role = roleMapper.findbyrid(roleid);
        return role;
    }

    @Override
    public int update(Role role, int[] menuid) {
        //先修改角色
        int i = roleMapper.updateByPrimaryKeySelective(role);
        System.out.println(role);
        //改中间表-->先删后改
        roleMapper.deletemid(role);
        int roleid = role.getRoleid();
        Map map = new HashMap();
        map.put("roleid", roleid);
        map.put("menuids", menuid);
        int insertmiddle = roleMapper.insertmiddle(map);
        return insertmiddle;
    }

    @Override
    public int deletemid(Role role) {
        int deletemid = roleMapper.deletemid(role);
        return deletemid;
    }

    @Override
    public int change(int roleid, int rolestate) {
        Map map=new HashMap();
        map.put("roleid",roleid);
        map.put("rolestate",rolestate);

        int i = roleMapper.change(map);
        return i;
    }

    @Override
    public PageInfo<Role> findall(int index, int size) {
        PageHelper.startPage(index, size);
        List<Role> findall = roleMapper.findall();
        PageInfo<Role> pageInfo = new PageInfo<>(findall);
        return pageInfo;
    }

    @Override
    @Transactional
    public int insertmiddle(Role r, int[] menuid) {
        //1添加角色表
        roleMapper.insertSelective(r);

        //2.添加中间表
        int roleid = r.getRoleid();
        Map map = new HashMap();
        map.put("roleid", roleid);
        map.put("menuids", menuid);
        int insertmiddle = roleMapper.insertmiddle(map);

        return insertmiddle;
    }

    @Override
    public int deleteByPrimaryKey(Integer roleid) {
        return 0;
    }

    @Override
    public int insert(Role record) {
        return 0;
    }

    @Override
    public int insertSelective(Role record) {

        return 0;
    }

    @Override
    public Role selectByPrimaryKey(Integer roleid) {
        return roleMapper.selectByPrimaryKey(roleid);
    }

    @Override
    public int updateByPrimaryKeySelective(Role record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Role record) {
        return 0;
    }
}
