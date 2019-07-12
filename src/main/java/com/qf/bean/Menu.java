package com.qf.bean;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Menu {
    private Integer menuid;

    private String menuname;

    private Integer upmenuid;

    private String menupath;

    private Integer menustate;

    private String menuremark;
    private Menu menu;
    private List<Menu>secondmenus;//创建子集合


}