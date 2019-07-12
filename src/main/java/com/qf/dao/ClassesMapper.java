package com.qf.dao;

import com.qf.bean.Classes;
import com.qf.bean.Student;

import java.util.List;
import java.util.Map;


public interface ClassesMapper {


    public List<Classes> findall(Map map);
//模查班级审核
    public List<Classes> selectaudit(Map map);

    public List<String> findteacher(int mid);

    List<Classes> findclassbyid(int id);

    int deleteByPrimaryKey(Integer classid);

    int insert(Classes record);

    int insertSelective(Classes record);

    Classes selectByPrimaryKey(Integer classid);

    int updateByPrimaryKeySelective(Classes record);

    int updateByPrimaryKey(Classes record);
}