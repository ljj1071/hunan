package com.qf.controller;


import com.github.pagehelper.PageInfo;
import com.qf.StudentInter;
import com.qf.bean.Books;
import com.qf.bean.Menu;
import com.qf.bean.Role;
import com.qf.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;


@Controller
public class BookController {
    @Resource
    private ClassesMapperService classesMapperService;
    @Resource
    private MajorMapperService majorMapperService;
    @Resource
    private DepartmentMapperService departmentMapperService;
    @Resource
    private RoleMapperService roleMapperService;
    @Resource
    private MenuMapperService menuMapperService;
    @Resource
    private BooksMapperService booksMapperService;

    @RequestMapping("/book/selectall")
    public String findall(@RequestParam(defaultValue = "1") int index, ModelMap map) {

        PageInfo<Books> findall = booksMapperService.findall(index, StudentInter.PAGESIZE);
        map.addAttribute("pi", findall);
        return "/book/list";
    }


    @RequestMapping("/book/add")
    public String addbook(Books books) {
        books.setIssuedcount(1);
        books.setIssueddate(new Date());
        int i = booksMapperService.insertSelective(books);


        return "redirect:/book/selectall";

    }

    @RequestMapping("/book/edit")
    public String findbook(int bookid, ModelMap map) {
        Books books = booksMapperService.findbybookid(bookid);
        map.addAttribute("books", books);
        return "/book/edit";
    }

    @RequestMapping("/book/update")
    public String update(Books books) {

        books.setIssuedcount(1);
        books.setIssueddate(new Date());
        int i = booksMapperService.updateByPrimaryKeySelective(books);
        if (i > 0) {
            return "redirect:/book/selectall";
        }
        return "redirect:/book/edit";
    }

    @RequestMapping("/book/info")
    public String info(int bookid, ModelMap map) {

        Books books = booksMapperService.findbybookid(bookid);

        map.addAttribute(books);
        return "/book/info";
    }
    @RequestMapping("/book/delete")
    public String delete(int bookid){

        int i = booksMapperService.deleteByPrimaryKey(bookid);

        return  "redirect:/book/selectall";
    }
    @RequestMapping("/book/changestate/{bookid}/{bookstate}")
    public void checkstate(@PathVariable(name="bookid") int bookid,
                             @PathVariable(name="bookstate") int bookstate,
                             HttpServletResponse response){


        try {
            response.setContentType("text/html;charset=utf-8");
            int i = booksMapperService.changebybookid(bookid, bookstate);
            System.out.println("i="+i);
            if(i>0){
                response.getWriter().print("true");
            }else{
                response.getWriter().print("false");

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/book/deleteall")
    public String deleteall(String[] strings){

        int i = booksMapperService.deleteall(strings);
        return "redirect:/book/selectall";
    }





}


