package com.qf.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Books {
    private Integer bookid;

    private String bookname;

    private Integer issuedcount;

    private Date issueddate;

    private Integer bookstate;

    private String bookremark;


}