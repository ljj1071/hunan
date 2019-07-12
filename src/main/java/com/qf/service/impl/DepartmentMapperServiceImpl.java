package com.qf.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.bean.Department;
import com.qf.bean.Student;
import com.qf.dao.DepartmentMapper;
import com.qf.dao.StudentMapper;
import com.qf.service.DepartmentMapperService;
import com.qf.service.StudentMapperService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class DepartmentMapperServiceImpl implements DepartmentMapperService {


    @Resource
    private DepartmentMapper departmentMapper;


    @Override
    public List<Department> findall() {

        return departmentMapper.findall();
    }

    @Override
    public int deleteByPrimaryKey(Integer departid) {
        return 0;
    }

    @Override
    public int insert(Department record) {
        return 0;
    }

    @Override
    public int insertSelective(Department record) {
        return 0;
    }

    @Override
    public Department selectByPrimaryKey(Integer departid) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Department record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Department record) {
        return 0;
    }
}
