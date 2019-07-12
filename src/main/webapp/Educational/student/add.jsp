﻿<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head><meta http-equiv="Content-Type" content="text/html; charset=utf-8" /><title>
	学生信息管理平台
</title>
	<link href="../../Style/StudentStyle.css" rel="stylesheet" type="text/css" />
	<link href="../../Script/jBox/Skins/Blue/jbox.css" rel="stylesheet" type="text/css" />
	<link href="../../Style/ks.css" rel="stylesheet" type="text/css" />
	<link href="../../css/mine.css" type="text/css" rel="stylesheet">
    <script src="../../Script/jBox/jquery-1.4.2.min.js" type="text/javascript"></script>
    <script src="../../Script/jBox/jquery.jBox-2.3.min.js" type="text/javascript"></script>
    <script src="../../Script/jBox/i18n/jquery.jBox-zh-CN.js" type="text/javascript"></script>
    <script src="../../Script/Common.js" type="text/javascript"></script>
    <script src="../../Script/Data.js" type="text/javascript"></script>

    <script type="text/javascript">
        $(function(){
            //获得专业
            $("[name='deptid']").change(function(){
                var val = $(this).val();
                if(val==-1){
                    alert("请选择院系");
                }else{
                    $.getJSON("/Educational/student/findmajorbyid","deptid="+val,function(rs){
                        $("[name='majorid']")[0].length=0;
                        $("[name='majorid']")[0].add(new Option("--请选择--",-1));
                        for(var i=0;i<rs.length;i++){
                            $("[name='majorid']")[0].add(new Option(rs[i].majorname,rs[i].majorid));
                        }
                    })
                }
            });
            //获得班级
            $("[name='majorid']").change(function(){
                var val = $(this).val();
                // alert("val="+val);
                if(val==-1){
                    alert("请选择专业");
                }else{
                    $.getJSON("/Educational/student/findclassbyid","mid="+val,function(rs){
                        $("[name='classid']")[0].length=0;
                        for(var i=0;i<rs.length;i++){
                            $("[name='classid']")[0].add(new Option(rs[i].classname,rs[i].classid));
                        }
                    })
                }
            });



        });
    </script>



</head>
<body>

		<div class="div_head">
            <span>
                <span style="float:left">当前位置是：教务中心-》学生管理-》新增</span>
                <span style="float:right;margin-right: 8px;font-weight: bold"></span>
            </span>
        </div>
</div>
<div class="cztable">
    <form action="/Educational/student/addstudent" method="post">
	<table border="1" width="100%" class="table_a">
                <tr  width="120px;">
                    <td width="10%">学号：<span style="color:red">*</span>：</td>
                    <td>
						<input type="text"  name="studentno" value="" />
					</td>
                </tr>

                <tr  width="120px;">
                    <td>姓名<span style="color:red">*</span>：</td>
                    <td>
						<input type="text"  name="stuname" value="" />
					</td>
                </tr>
               <tr>
                    <td>学院<span style="color:red">*</span>：</td>
                    <td>
                        <select name="deptid">
                        	<option>---请选择---</option>

                            <c:forEach items="${dlist}" var="dept">
                                <option value="${dept.departid}">${dept.departname}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>专业<span style="color:red">*</span>：</td>
                    <td>
                        <select name="majorid">
                            <option>---请选择---</option>

                        </select>
                    </td>
                </tr>
                <tr>
                    <td>班级<span style="color:red">*</span>：</td>
                    <td>
                        <select name="classid">
                            <option value="-1">---请选择---</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>性别<span style="color:red">*</span>：</td>
                    <td>
                        <input type="radio" name="stusex" checked value="1" />男
                        <input type="radio" name="stusex" value="0"/>女
                    </td>
                </tr>


				<tr>
                    <td>EMAIL：</td>
                    <td>
                        <input type="text" name="email" value="1332@126.com" />
                    </td>                
                </tr>

				<tr>
                    <td>联系电话：</td>
                    <td>
                        <input type="text" name="phone" value="13333333333" />
                    </td>                
                </tr>

				<tr>
                    <td>户口所在地：</td>
                    <td>
                        <input type="text" name="registered" value="北京"  />
                    </td>                
                </tr>

				<tr>
                    <td>住址：</td>
                    <td>
                        <input type="text" name="address" value="朝阳" />
                    </td>                
                </tr>
				<tr>
                    <td>政治面貌：</td>
                    <td>
                        <input type="text" name="politics" value="党员" />
                    </td>                
                </tr>
				<tr>
                    <td>身份证号：</td>
                    <td>
                        <input type="text" name="cardid" value="110111111111111111111" />
                    </td>                
                </tr>
				

				<tr>
                    <td>简介<span style="color:red">*</span>：</td>
                    <td>
                        <textarea name="stucontent">一个新开辟领域的探讨，探讨摸索</textarea>
                    </td>
                </tr>
				<tr>
					<td colspan=2 align="center">
						<input type="submit" value="添加" /> 
					</td> 
				</tr>
			</table>
	</form>
</div>

            </div>
        </div>
    </div>
</body>
</html>
