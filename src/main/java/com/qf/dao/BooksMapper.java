package com.qf.dao;

import com.qf.bean.Books;
import java.util.List;
import java.util.Map;

public interface BooksMapper {

    public List<Books> findall();

    public Books findbybookid(int bookid);
    public  int changebybookid(Map map);
    public  int changebybook(int bookid,int  bookstate);
    public int updatestate(Books books);

    int deleteByPrimaryKey(Integer bookid);


    int insert(Books record);

    int insertSelective(Books record);

    Books selectByPrimaryKey(Integer bookid);

    int updateByPrimaryKeySelective(Books record);

    int updateByPrimaryKey(Books record);
    int deleteall(Map map);
}