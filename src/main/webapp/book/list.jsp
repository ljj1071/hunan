<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head><meta http-equiv="Content-Type" content="text/html; charset=utf-8" /><title>
	学生信息管理平台
</title>
	<link href="../Style/StudentStyle.css" rel="stylesheet" type="text/css" />
	<link href="../Script/jBox/Skins/Blue/jbox.css" rel="stylesheet" type="text/css" />
	<link href="../Style/ks.css" rel="stylesheet" type="text/css" />
	<link href="../css/mine.css" type="text/css" rel="stylesheet">
    <script src="../Script/jBox/jquery-1.4.2.min.js" type="text/javascript"></script>
    <script src="../Script/jBox/jquery.jBox-2.3.min.js" type="text/javascript"></script>
    <script src="../Script/jBox/i18n/jquery.jBox-zh-CN.js" type="text/javascript"></script>
    <script src="../Script/Common.js" type="text/javascript"></script>
    <script src="../Script/Data.js" type="text/javascript"></script>
    <script>
	function del(bookid){
		var rs=confirm("确认删除？");
		if(rs==true){
            location.href="/book/delete?bookid="+bookid;

        }
	}

    function delAll(){
        var alls=document.getElementsByName("check");
        var ids=new Array();
        for(var i=0;i<alls.length;i++){
            if(alls[i].checked){
                ids.push(alls[i].value);
            }
        }
        alert(ids);
        if(ids.length>0){
            if(confirm("确认删除?")){
                //alert("删除成功!");
                window.location.href="/book/deleteall?strings="+ids;
            }
        }else{
            alert("请选中要删除的项");
        }
    }

</script>
</head>
<body>

   

<div class="div_head" style="width: 100%;text-align:center;">
		<span> <span style="float:left">当前位置是：书籍管理-》书籍管理</span> <span
			style="float:right;margin-right: 8px;font-weight: bold">
            <a style="text-decoration: none;" href="javascript:alert('操作成功！');">【导出excel】</a>&nbsp;&nbsp;&nbsp;&nbsp;
            <a style="text-decoration: none;"  onclick="delAll()">【批量删除】</a>&nbsp;&nbsp;&nbsp;&nbsp;
			<a style="text-decoration: none;" href="addBook.jsp">【新增书籍】</a>&nbsp;&nbsp;&nbsp;&nbsp;
		</span>
		</span>
	</div>

<div class="morebt">
 
</div>





 <div class="cztable">
        
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tbody>
                <tr style="height: 25px" align="center">
                	<th><input type="checkbox"/></th>
                    <th scope="col">
                        编号
                    </th>
                    
                    <th scope="col">
                        书籍名称
                    </th>
                    <th scope="col">
                        状态
                    </th>
                    <th scope="col">
                        操作
                    </th>
                </tr>


                <c:forEach items="${pi.list}" var="b" varStatus="sta">

                <tr align="center">
                    <th><input name="check" type="checkbox" value="${b.bookid}"/></th>
                    <td>
                        ${sta.count}
                    </td>
                    <td>
                       ${b.bookname}
                    </td>

                    <script>
                        function cc(rid,rownum){
                            //发送ajax请求
                            var bookstate=document.getElementById("bookstate"+rownum).value;
                            var url="/book/changestate/"+rid+"/"+bookstate;
                            $.post(url,null,function(rs){
                                if(rs=='true'){
                                    var  str="state"+rownum;
                                    //修改状态列
                                    var state=$("[name='"+str+"']").html();
                                    if(state=='禁用'){
                                        $("[name='"+str+"']").html("启用");
                                    }else{
                                        $("[name='"+str+"']").html("禁用");
                                    }
                                    //修改操作列
                                    var str2="change"+rownum;
                                    var state2=$("[name='"+str2+"']").html();
                                    if(state2=='禁用'){
                                        $("[name='"+str2+"']").html("启用");
                                        document.getElementById("bookstate"+rownum).value=0;
                                    }else{
                                        $("[name='"+str2+"']").html("禁用");
                                        document.getElementById("bookstate"+rownum).value=1;
                                    }
                                }
                            });
                        }
                    </script>

                    <td>&nbsp;
                     <span name="state${sta.count}">${b.bookstate==1?'启用':'禁用'}</span>
                    </td>

                    <td>&nbsp;
                        <input type="hidden" id="bookstate${sta.count}" value="${b.bookstate}">
                        <span style="color: #00bbff;" name="change${sta.count}"
                              onclick="cc(${b.bookid},${sta.count})">${b.bookstate==1?'禁用':'启用'}</span>




                        <a href="info?bookid=${b.bookid}">详情</a>
                        <a href="edit?bookid=${b.bookid}">修改</a>
						<a href="javascript:void(0)"
                           onclick="del(${b.bookid});return false"
                           class="tablelink"> 删除</a>
                    </td>
                </tr>


                </c:forEach>


            </tbody>
        </table>
        
          <div class='MainStyle'><div class=''>
              <a href='http://sm.zk0731.com/OnlineTeaching/StudentMaterial.aspx?page=1' target='_self'>首页</a>
          </div>
              <div class=''><a href='javascript:void(0)' target='_self'>上一页</a>
              </div><div class='NowItemStyle'><a href='javascript:void(0)' target='_self'>1</a></div><div class=''><a href='http://sm.zk0731.com/OnlineTeaching/StudentMaterial.aspx?page=2' target='_self'>2</a></div><div class=''><a href='http://sm.zk0731.com/OnlineTeaching/StudentMaterial.aspx?page=3' target='_self'>3</a></div><div class=''><a href='http://sm.zk0731.com/OnlineTeaching/StudentMaterial.aspx?page=2' target='_self'>下一页</a></div><div class=''><a href='http://sm.zk0731.com/OnlineTeaching/StudentMaterial.aspx?page=3' target='_self'>尾页</a></div><div class=''>总共<b>44</b>条数据</div><div class=''>每页<b>20</b>条数据</div><div class=''><b>1</b>/3</div><div class='SearchStyle'><input type='text' id='john_Page_Search' onkeydown="if(event.keyCode == 13){page_searchIndex();}"/></div><div class=''><input type='button' value='Go' onclick="page_searchIndex()"/></div></div><script>    function page_searchIndex(){        var searchText = document.getElementById('john_Page_Search');        var searchIndex = searchText != null && searchText.value != '' ? parseInt(searchText.value) : 0;        if(searchIndex > 0 && searchIndex <= 3) {             window.location='StudentMaterial.aspx?page=' + searchIndex;        }        else        {            alert('需要跳转的页码不能超出范围！');        }    }</script>
        </div>
    </div>

    </div>
</body>
</html>