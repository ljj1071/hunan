package com.qf.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.bean.Classes;
import com.qf.bean.Menu;
import com.qf.dao.ClassesMapper;
import com.qf.dao.MenuMapper;
import com.qf.service.ClassesMapperService;
import com.qf.service.MenuMapperService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class MenuMapperServiceImpl implements MenuMapperService {
    @Resource
    private MenuMapper menuMapper;

    @Override
    public List<Menu> findmenus() {
        List<Menu> menus = menuMapper.findmenus();
        List newmenus = new ArrayList();
        for (Menu menu : menus) {
            if (menu.getUpmenuid() ==-1) {
                List second = new ArrayList();
                for (Menu menu1 : menus) {
                    if (menu.getMenuid() == menu1.getUpmenuid()) {
                        second.add(menu1);
                    }
                }

                menu.setSecondmenus(second);
                newmenus.add(menu);
            }
        }


        return newmenus;
    }

    @Override
    public List<Menu> findbyroleid(int roleid) {

        List<Menu> menus = menuMapper.findbyroleid(roleid);
        List newmenus = new ArrayList();
        for (Menu menu : menus) {
            if (menu.getUpmenuid() ==-1) {
                List second = new ArrayList();
                for (Menu menu1 : menus) {
                    if (menu.getMenuid() == menu1.getUpmenuid()) {
                        second.add(menu1);
                    }
                }

                menu.setSecondmenus(second);
                newmenus.add(menu);
            }
        }


        return newmenus;
    }


    @Override
    public int insert(Menu record) {
        return 0;
    }

    @Override
    public int insertSelective(Menu record) {
        return 0;
    }

    @Override
    public Menu selectByPrimaryKey(Integer menuid) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Menu record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Menu record) {
        return 0;
    }


}
