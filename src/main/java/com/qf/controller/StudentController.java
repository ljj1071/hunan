package com.qf.controller;


import com.github.pagehelper.PageInfo;
import com.qf.StudentInter;
import com.qf.bean.*;
import com.qf.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;


@Controller
public class StudentController {

    @Resource
    private StudentMapperService studentMapperService;
    @Resource
    private DepartmentMapperService departmentMapperService;
    @Resource
    private MajorMapperService majorMapperService;
    @Resource
    private ClassesMapperService classesMapperService;

    /**
     * 模查分页
     *
     * @param map
     * @param index
     * @param name
     * @param stuno
     * @param sex
     * @return
     */
    @RequestMapping("Educational/student/selectall")
    public String getstudents(ModelMap map, @RequestParam(defaultValue = "1") int index, String name, String stuno,
                              @RequestParam(defaultValue = "-1") int sex) {
        PageInfo<Student> pageInfo = studentMapperService.findall(index, StudentInter.PAGESIZE, name, stuno, sex);
        map.addAttribute("pi", pageInfo);
        map.addAttribute("name", name);
        map.addAttribute("stuno", stuno);
        map.addAttribute("sex", sex);


        return "Educational/student/list";
    }

    /**
     * 总查
     *
     * @param map
     * @return
     */
    @RequestMapping("/Educational/student/selectdepts")
    public String getdepts(ModelMap map) {
        List<Department> departmentList = departmentMapperService.findall();
        map.addAttribute("dlist", departmentList);

        return "/Educational/student/add";
    }

    /**
     * 查询专业
     *
     * @param deptid
     * @return
     */
    @RequestMapping("Educational/student/findmajorbyid")
    @ResponseBody
    public List getmajor(int deptid) {

        List<Major> findbydeptid = majorMapperService.findbydeptid(deptid);

        return findbydeptid;
    }

    /**
     * 查询班级json
     *
     * @param mid
     * @return
     */
    @RequestMapping("Educational/student/findclassbyid")
    @ResponseBody
    public List getclasses(int mid) {
        List<Classes> findclassbyid = classesMapperService.findclassbyid(mid);
        return findclassbyid;
    }

    /**
     * 新增
     * @param student
     * @return
     */
    @RequestMapping("/Educational/student/addstudent")
    public String addstudent (Student student){

        student.setRegdate(new Date());
        student.setStustate("正常");
        int i = studentMapperService.insertSelective(student);

        if(i>0){
            return "redirect:/Educational/student/selectall";
        }
        return "redirect:/Educational/student/selectdepts";
    }


    @RequestMapping("/Educational/student/updatestate")
    public String updateState(Student student){
        student.setStustate("退学");
        int i = studentMapperService.updateByPrimaryKeySelective(student);


        return "redirect:/Educational/student/selectall";

    }


}


