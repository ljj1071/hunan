package com.qf.controller;


import com.github.pagehelper.PageInfo;
import com.qf.StudentInter;
import com.qf.bean.*;
import com.qf.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.jms.Session;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


@Controller
public class RoleController {
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

    @RequestMapping("/power/role/list")
    public String findall(@RequestParam(defaultValue = "1") int index, ModelMap map) {

        PageInfo<Role> findall = roleMapperService.findall(index, StudentInter.PAGESIZE);
        map.addAttribute("pi", findall);

        return "/power/role/list";
    }

    //查询菜单{1级-->2级}
    @RequestMapping("/power/role/selectmenus")
    public String getmenus(ModelMap map) {
        List<Menu> menus = menuMapperService.findmenus();
        map.addAttribute("menus", menus);

        return "/power/role/add";
    }

    //添加角色表
    @RequestMapping("/power/role/add")
    public String add(Role role, int[] menuid) {
        int i = roleMapperService.insertmiddle(role, menuid);
        return "redirect:/power/role/list";
    }

    //修改1得到该觉得2级菜单
    @RequestMapping("/power/role/findbyrid")
    public String findbyrid(int roleid, ModelMap map) {
        Role role = roleMapperService.selectByPrimaryKey(roleid);

        List<Menu> menus = menuMapperService.findmenus();

        map.addAttribute("role", role);
        map.addAttribute("menus", menus);

        return "/power/role/edit";
    }


    //修改请求
    @RequestMapping("/power/role/update")
    public String update(Role role, int[] menuid) {
        int i = roleMapperService.update(role, menuid);

        return "redirect:/power/role/list";
    }
    //更改禁用启用选择项
    @RequestMapping("power/role/changestate/{roleid}/{rolestate}")
    public void change(@PathVariable(name="roleid") int roleid,
                       @PathVariable(name="rolestate") int rolestate,
                       HttpServletResponse response){

        try {
            response.setContentType("text/html;charset=utf-8");
            int i = roleMapperService.change(roleid, rolestate);
            if(i>0){
                response.getWriter().print("true");
            }else{
                response.getWriter().print("false");

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}


