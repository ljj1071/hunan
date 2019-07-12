package com.qf.service;

import com.github.pagehelper.PageInfo;
import com.qf.bean.Department;
import com.qf.bean.Student;

import java.util.List;

public interface DepartmentMapperService {
 public  List<Department>findall();

 int deleteByPrimaryKey(Integer departid);

 int insert(Department record);

 int insertSelective(Department record);

 Department selectByPrimaryKey(Integer departid);

 int updateByPrimaryKeySelective(Department record);

 int updateByPrimaryKey(Department record);


}