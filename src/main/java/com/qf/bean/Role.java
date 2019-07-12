package com.qf.bean;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    private Integer roleid;

    private String rolename;

    private Integer rolestate;

    private List<Menu> menus;

}