package com.qf.dao;

import com.qf.bean.Major;

import java.util.List;

public interface MajorMapper {

    List<Major>findbydeptid(int id);
    int deleteByPrimaryKey(Integer majorid);

    int insert(Major record);

    int insertSelective(Major record);

    Major selectByPrimaryKey(Integer majorid);

    int updateByPrimaryKeySelective(Major record);

    int updateByPrimaryKey(Major record);
}