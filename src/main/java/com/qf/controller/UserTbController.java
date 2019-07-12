package com.qf.controller;


import cn.com.webxml.MobileCodeWSSoap;
import com.qf.bean.Menu;
import com.qf.bean.SysPermission;
import com.qf.bean.SysUser;
import com.qf.bean.UserTb;
import com.qf.service.MenuMapperService;
import com.qf.service.UserTbMapperService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Watchable;
import java.util.List;


@Controller
public class UserTbController {

    @Resource
    private UserTbMapperService userTbMapperService;
    @Resource
    private MenuMapperService menuMapperService;
   // @Resource
   // private MobileCodeWSSoap soap;

    @RequestMapping("/user/updateuser")
    public void updateuser(UserTb userTb, HttpSession session, HttpServletResponse response) {

        UserTb u2 = userTbMapperService.updateuser(userTb);

        try {
            response.setContentType("text/html;charset=utf-8");
            PrintWriter writer = response.getWriter();

            if (u2 != null) {
                session.setAttribute("user", u2);
                writer.print("<script>alert('修改成功');top.location.href='/index.jsp'</script>");
            } else {
                writer.print("<script>alert('修改失败');location.href='/MyUser.jsp'</script>");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 真正用户名不能改为别人的
     *
     * @param uname
     */
    @RequestMapping("/user/checkname")
    public void checkname(String uname, HttpServletResponse response) {
        boolean checkname = userTbMapperService.checkname(uname);
        try {
            response.setContentType("text/html;charset=utf-8");
            PrintWriter writer = response.getWriter();

            if (checkname) {
                writer.print("用户名已存在,不能改为它");
            } else {
                writer.print("用户名可用");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    /**
     * @param request
     * @param respones
     */
    @RequestMapping("/tologin")
    public void login(HttpServletRequest request, HttpServletResponse respones) {

        System.out.println(request.getRequestURI() + "===>");
        String shiroLoginFailure = (String) request.getAttribute("shiroLoginFailure");
        try {
            respones.setContentType("text/html;charset=utf-8");
            PrintWriter writer = respones.getWriter();

            if (shiroLoginFailure != null) {

                if (shiroLoginFailure.equals(UnknownAccountException.class.getName())) {
                    writer.print("<script>alert('用户名不正确');location.href='login.jsp'</script>");
                } else if (shiroLoginFailure.equals(IncorrectCredentialsException.class.getName())) {
                    writer.print("<script>alert('密码不正确');location.href='login.jsp'</script>");
                } else {
                    writer.print("<script>alert('其他不正确');location.href='login.jsp'</script>");
                }

            }
            writer.print("<script>alert('用户名或密码不正确');location.href='login.jsp'</script>");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @RequestMapping("/loginsuccess")
    public String loginsuccess(HttpSession session) {
        //保存session信息
        Subject subject = SecurityUtils.getSubject();

        UserTb user = (UserTb) subject.getPrincipal();
        List<Menu> menuList = menuMapperService.findbyroleid(user.getRoleId());
        user.setMenus(menuList);
        session.setAttribute("user", user);
        return "redirect:/index.jsp";


    }

    @RequestMapping("/getphoneaddress")
    @ResponseBody
    public void getaddress(String phone, HttpServletResponse response) {
        try {
            ApplicationContext applicationContext=
                    new ClassPathXmlApplicationContext("spring-cxf.xml");
         MobileCodeWSSoap soap=(MobileCodeWSSoap)   applicationContext.getBean("abc");


            String info = soap.getMobileCodeInfo(phone, "");
            response.setContentType("text/html;charset=utf-8");
            String[] s = info.split(" ");
            response.getWriter().print(s[1]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


