package com.qf.controller;


import com.github.pagehelper.PageInfo;
import com.qf.StudentInter;
import com.qf.bean.*;
import com.qf.service.ClassesMapperService;
import com.qf.service.DepartmentMapperService;
import com.qf.service.MajorMapperService;
import com.qf.service.StudentMapperService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;


@Controller
public class ClassesController {
    @Resource
    private ClassesMapperService classesMapperService;
    @Resource
    private MajorMapperService majorMapperService;
    @Resource
    private DepartmentMapperService departmentMapperService;

    /**
     * 班级表模查分页
     *
     * @param map
     * @param index
     * @param name
     * @return
     */
    @RequestMapping("/Educational/class/selectall")
    public String getclss(ModelMap map, @RequestParam(defaultValue = "1") int index, String name) {

        PageInfo<Classes> pageInfo = classesMapperService.findall(index, StudentInter.PAGESIZE, name);
        map.addAttribute("pi", pageInfo);
        map.addAttribute("name", name);
        return "/Educational/class/list";
    }


    /**
     * json
     * 查询所有的学院信息
     */
    @RequestMapping("/Educational/class/selectadd")
    public String getdepartment(ModelMap map) {
        List<Department> findall = departmentMapperService.findall();
        map.addAttribute("dlist", findall);
        return "/Educational/class/add";
    }

    /**
     * json
     * 查询所有的学院信息中的老师
     */
    @RequestMapping("/Educational/class/findclassbyid")
    @ResponseBody
    public List getteacher(int mid) {
        List<String> findteacher = classesMapperService.findteacher(mid);

        return findteacher;

    }

    //add页面form表单添加
    //班主任添加班级信息
    @RequestMapping("/Educational/class/add")
    public String addclass(Classes classes) {
        classes.setClassstate("未审核");
        classes.setAuditcount(0);
        int i = classesMapperService.insertSelective(classes);
        return "redirect:/Educational/class/selectall";
    }


    //教务总监班级审核全查
    @RequestMapping("/Educational/Auditing")
    public String Auditing(@RequestParam(defaultValue = "1") int index, String classno, String classname, ModelMap map, HttpSession session) {

        UserTb userTb = (UserTb) session.getAttribute("user");
        PageInfo<Classes> selectaudit = classesMapperService.selectaudit(index, StudentInter.PAGESIZE, classno, classname, userTb.getUserId());
        map.addAttribute("pi", selectaudit);
        map.addAttribute("classno", classno);
        map.addAttribute("classname", classname);
        return "/Educational/Auditing";
    }

    //班主任提交班级审核-->1修改审核状态-->审核中
    //                    2找到审核人id修改
    @RequestMapping("/Educational/class/submitaudit")
    public String submitaudit(Classes classes, HttpSession session ){
        classes.setClassstate("审核中");
        //得到(sql)where //1.缺少审核人的id-->用户表中有-->通过登录session中get到
        UserTb user =(UserTb) session.getAttribute("user");

        classes.setAuditid(user.getManagerid());
        // 2.缺少审核次数的值//为嘛走查询-->classes.getAuditcount()

        Classes classes1 = classesMapperService.selectByPrimaryKey(classes.getClassid());

        classes.setAuditcount(classes1.getAuditcount()+1);
        classesMapperService.updateByPrimaryKeySelective(classes);
        return "redirect:/Educational/class/selectall";
    }

    //教务总监驳回通过请求
    @RequestMapping("/Educational/updatestate/{a1}/{b1}")
    public String audit(@PathVariable(name = "a1") int classid, @PathVariable(name = "b1")int state){
        Classes classes =new Classes();
        classes.setClassid(classid);
        switch (state){
            case  1:
                classes.setClassstate("审核通过");
                break;
            case 0:
                classes.setClassstate("审核未通过");
                break;
        }
        classesMapperService.updateByPrimaryKeySelective(classes);
        return "redirect:/Educational/Auditing";

    }







}


