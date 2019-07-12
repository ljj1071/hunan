package com.qf.service.impl;

import com.qf.bean.Menu;
import com.qf.bean.Role;
import com.qf.bean.UserTb;
import com.qf.dao.MenuMapper;
import com.qf.dao.UserTbMapper;
import com.qf.service.UserTbMapperService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


@Service
public class UserTbServiceImpl implements UserTbMapperService {
    @Resource
    private UserTbMapper userTbMapper;
    @Resource
    private MenuMapper menuMapper;


    @Override
    public UserTb login(String username) {
        //根据用户名查询信息
        UserTb userTb = userTbMapper.login(username);
        //验证密码


            int count = userTb.getLogincount() + 1;
            userTb.setLogincount(count);
            userTbMapper.updateByPrimaryKeySelective(userTb);
            //根据用户id(session中)查询角色菜单


            System.out.println(userTb.getRoleId());
            List<Menu> menus = menuMapper.findbyroleid(userTb.getRoleId());

            List newmenus=new ArrayList();
            for (Menu menu:menus){
                if(menu.getUpmenuid()==-1){
                    List second=new ArrayList();
                    for(Menu menu1:menus){
                        if(menu.getMenuid()==menu1.getUpmenuid()){
                            second.add(menu1);
                        }
                    }

                    menu.setSecondmenus(second);
                    newmenus.add(menu);
                }
            }
            Role role =new Role();
            role.setMenus(newmenus);
            userTb.setRole(role);

                return userTb;



    }

    @Override
    public boolean checkname(String name) {
        String checkname = userTbMapper.checkname(name);
        if (checkname != null) {
            return true;
        }

        return false;
    }

    @Override
    public UserTb updateuser(UserTb userTb) {
        int i = userTbMapper.updateByPrimaryKeySelective(userTb);
        if (i > 0) {
            UserTb userTb1 = userTbMapper.login(userTb.getUserName());
            return userTb1;
        }

        return null;
    }


    @Override
    public int deleteByPrimaryKey(Integer userId) {
        return 0;
    }

    @Override
    public int insert(UserTb record) {
        return 0;
    }

    @Override
    public int insertSelective(UserTb record) {
        return 0;
    }

    @Override
    public UserTb selectByPrimaryKey(Integer userId) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(UserTb record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(UserTb record) {
        return 0;
    }
}
