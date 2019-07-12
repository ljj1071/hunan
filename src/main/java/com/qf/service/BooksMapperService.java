package com.qf.service;

import com.github.pagehelper.PageInfo;
import com.qf.bean.Books;
import com.qf.bean.Role;

import java.util.List;
import java.util.Map;

public interface BooksMapperService {

    public PageInfo<Books> findall(int index, int size);

    public Books findbybookid(int bookid);

    public int updatestate(Books books);

    public int changebybookid(int bookid, int bookstate);

    public int changebybook(int bookid, int bookstate);

    int deleteByPrimaryKey(Integer bookid);

    int insert(Books record);

    int insertSelective(Books record);

    Books selectByPrimaryKey(Integer bookid);

    int updateByPrimaryKeySelective(Books record);

    int updateByPrimaryKey(Books record);

    int deleteall(String[] strings);
}