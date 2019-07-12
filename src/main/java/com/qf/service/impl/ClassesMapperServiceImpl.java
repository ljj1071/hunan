package com.qf.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.bean.Classes;
import com.qf.dao.ClassesMapper;
import com.qf.service.ClassesMapperService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class ClassesMapperServiceImpl implements ClassesMapperService {
@Resource
private ClassesMapper classesMapper;

    @Override
    public PageInfo<Classes> findall(int index, int size,String classname) {
        PageHelper.startPage(index,size);
        Map map=new HashMap();
        map.put("classname",classname);
        List<Classes> findall = classesMapper.findall(map);

        PageInfo<Classes> pageInfo=new PageInfo<>(findall);
        return pageInfo;
    }

    //班级审核 全查
    @Override
    public PageInfo<Classes> selectaudit(int index, int size, String classno, String classname,int userid) {
        PageHelper.startPage(index,size);
        Map map=new HashMap();
        map.put("userid",userid);
        map.put("classno",classno);
        map.put("classname",classname);
        List<Classes> selectaudit = classesMapper.selectaudit(map);

        PageInfo<Classes> pageInfo=new PageInfo<>(selectaudit);

        return pageInfo;
    }

    //查询老师下拉框
    @Override
    public List<String> findteacher(int mid) {

        return classesMapper.findteacher(mid);
    }

    @Override
    public List<Classes> findclassbyid(int majorid) {
        return classesMapper.findclassbyid(majorid);
    }

    @Override
    public int deleteByPrimaryKey(Integer classid) {
        return 0;
    }

    @Override
    public int insert(Classes record) {
        return 0;
    }

    @Override
    @Transactional
    public int insertSelective(Classes record) {
        return classesMapper.insertSelective(record);
    }

    @Override
    public Classes selectByPrimaryKey(Integer classid) {
        return classesMapper.selectByPrimaryKey(classid);
    }

    @Override
    @Transactional
    public int updateByPrimaryKeySelective(Classes record) {
        return classesMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Classes record) {
        return 0;
    }
}
