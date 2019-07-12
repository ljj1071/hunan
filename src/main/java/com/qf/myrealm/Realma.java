package com.qf.myrealm;

import com.qf.bean.UserTb;
import com.qf.service.RoleMapperService;
import com.qf.service.UserTbMapperService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;

public class Realma extends AuthorizingRealm {
    @Resource
    private UserTbMapperService userTbMapperService;


    @Override
    //授权
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        return null;
    }

    @Override
    //认证
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = (String) authenticationToken.getPrincipal();
        UserTb user = userTbMapperService.login(username);
        System.out.println("user="+user);
        if (user == null) {
            return null;
        }
        SimpleAuthenticationInfo info=new SimpleAuthenticationInfo(user,user.getUserPs(),"realma");

        return info;

    }

}
