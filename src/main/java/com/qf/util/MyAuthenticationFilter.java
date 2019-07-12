package com.qf.util;

import com.qf.bean.UserTb;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MyAuthenticationFilter extends FormAuthenticationFilter {

    private static Logger logger = LoggerFactory.getLogger(MyAuthenticationFilter.class);



    @Override
    protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request,
                                     ServletResponse response) throws Exception {

      HttpServletResponse response1=(HttpServletResponse)response;
response1.sendRedirect("/loginsuccess");

        return false;
    }


}
