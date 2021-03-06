package com.qf.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.bean.Student;
import com.qf.bean.UserTb;
import com.qf.dao.StudentMapper;
import com.qf.dao.UserTbMapper;
import com.qf.service.StudentMapperService;
import com.qf.service.UserTbMapperService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class StudentServiceImpl implements StudentMapperService {


    @Resource
    private  StudentMapper studentMapper;

    @Override
    public PageInfo<Student> findall(int index, int size,String name, String stuno,int sex) {
        PageHelper.startPage(index,size);
        Map map=new HashMap();
        map.put("name",name);
        map.put("stuno",stuno);
        map.put("sex",sex);
        List<Student> students = studentMapper.findall(map);
        PageInfo<Student>pageInfo=new PageInfo<>(students);
        return pageInfo;
    }

    @Override
    public int deleteByPrimaryKey(Integer studentid) {
        return 0;
    }

    @Override
    public int insert(Student record) {
        return 0;
    }

    @Override
    @Transactional
    public int insertSelective(Student record) {
        return studentMapper.insertSelective(record);
    }

    @Override
    public Student selectByPrimaryKey(Integer studentid) {
        return null;
    }

    @Override
    @Transactional
    public int updateByPrimaryKeySelective(Student record) {
        return studentMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Student record) {
        return 0;
    }
}
