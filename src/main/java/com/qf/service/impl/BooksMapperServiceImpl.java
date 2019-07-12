package com.qf.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.bean.Books;
import com.qf.bean.Classes;
import com.qf.dao.BooksMapper;
import com.qf.dao.ClassesMapper;
import com.qf.service.BooksMapperService;
import com.qf.service.ClassesMapperService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class BooksMapperServiceImpl implements BooksMapperService {
    @Resource
    private BooksMapper booksMapper;


    @Override
    public PageInfo<Books> findall(int index,int size) {
        PageHelper.startPage(index,size);
        List<Books> findall = booksMapper.findall();
        PageInfo<Books>pageInfo=new PageInfo<>(findall);



        return pageInfo;
    }

    @Override
    public Books findbybookid(int bookid) {


        return booksMapper.findbybookid(bookid);
    }

    @Override
    public int updatestate(Books books) {
        return booksMapper.updatestate(books);
    }


    @Override
    public int changebybookid(int bookid, int bookstate) {
        Map map = new HashMap();
        map.put("bookid",bookid);
        map.put("bookstate",bookstate);
        return booksMapper.changebybookid(map);
    }

    @Override
    public int changebybook(int bookid, int bookstate) {
        return booksMapper.changebybook(bookid,bookstate);
    }

    @Override
    @Transactional
    public int deleteByPrimaryKey(Integer bookid) {
        return booksMapper.deleteByPrimaryKey(bookid);
    }

    @Override
    @Transactional
    public int insert(Books record) {
        return 0;
    }

    @Override
    public int insertSelective(Books record) {
        return booksMapper.insertSelective(record);
    }

    @Override
    public Books selectByPrimaryKey(Integer bookid) {
        return null;
    }

    @Override
    @Transactional
    public int updateByPrimaryKeySelective(Books record) {
        return booksMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Books record) {
        return 0;
    }

    @Override
    public int deleteall(String[] strings) {
        Map map = new HashMap();
        map.put("strings",strings);
        return booksMapper.deleteall(map);
    }
}
