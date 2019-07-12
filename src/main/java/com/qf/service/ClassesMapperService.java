package com.qf.service;

import com.github.pagehelper.PageInfo;
import com.qf.bean.Classes;
import com.qf.bean.Department;
import com.qf.bean.Student;

import java.util.List;
import java.util.Map;

public interface ClassesMapperService {


 public PageInfo<Classes> findall(int index, int size,String classname);
 //模查班级审核
 public PageInfo<Classes> selectaudit(int index, int size,String classno,String classname,int userid);

 public List<String> findteacher(int mid);

 public  List<Classes>findclassbyid(int majorid);
 int deleteByPrimaryKey(Integer classid);

 int insert(Classes record);

 int insertSelective(Classes record);

 Classes selectByPrimaryKey(Integer classid);

 int updateByPrimaryKeySelective(Classes record);

 int updateByPrimaryKey(Classes record);


}