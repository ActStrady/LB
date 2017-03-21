<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
     
    <title>系统管理</title>
  </head>
  
  <body>
  <center>
   <h1>欢迎你，管理员</h1> 
   <h2><a href="addBook.jsp">添加图书资源</a></h2>
    <hr>  
   <h3>图书资源信息表</h3>
  
   <table border="1" width="480">
   <tr>
     <th>图书ID</th>
     <th>书名</th>
     <th>出版日期</th>
     <th>单价</th>
     <th>是否删除</th>
     <th>是否修改</th>
   
   </tr>
   <s:iterator value="#request.bookList" id="bt"> 
   <tr>
     <td align="center"><s:property value="#bt.resid"/></td>
     <td align="center"><s:property value="#bt.bname"/></td>
     <td align="center"><s:property value="#bt.bdate"/></td>
     <td align="center"><s:property value="#bt.price"/></td>
     <td align="center"><a href="bookdelete.action?id=<s:property value='#bt.resid'/>">删除</a></td>
     <td align="center"><a href="toupdate?id=<s:property value='#bt.resid'/>">修改</a></td>
   </tr>
   </s:iterator>
   </table>
  </center>
  </body>
</html>
