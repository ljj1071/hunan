package com.qf.service;

import com.github.pagehelper.PageInfo;
import com.qf.bean.Student;
import com.qf.bean.UserTb;

import java.util.List;

public interface StudentMapperService {

   public PageInfo<Student> findall(int index, int size,String name, String stuno,int sex);

    int deleteByPrimaryKey(Integer studentid);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer studentid);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);


}