<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <style type="text/css">
    .body{text-align: center;}
    .div{border-radius:5px 5px 5px 5px;width: 600px;height: 270px;margin:0 auto;margin-top:20px;  background-color: #3AD2F9}
    </style>
    <title>用户登录</title>
  </head>

  <body>
  <div class="div">
   <center>
   <br>
   <h2>图书馆管理系统</h2>
   <h3>LibraryManager</h3><hr>
   <form action="login.action" method="post">
     <table style="text-align: center;">
     
     <tr>
      <td> 用户名：</td>
      <td><input type="text" name="username" style="width:200px" value="<s:property value="error1"/>"></td>
     </tr>
      <tr>
      <td>密码：</td>
      <td><input type="password" name="password" style="width:200px"></td>
     </tr>
       <tr>
       <td colspan="3"><input type="submit" value="登录" style="margin-top: 10px;width: 70px;height: 30px"></td>
       <td><a href="register.jsp">注册</a></td>
       </tr>
           
    </table>
   </form>
   </center>
   </div>
  </body>
</html>
