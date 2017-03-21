<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>添加图书</title>   
  </head>
  <body>
    <center>
    <h2>添加图书</h2><hr>
     <form action="add.action" method="post">
       <table>
         <tr>
           <td>图书名称：</td>
           <td><input type="text" name="bname"></td>
           </tr>
           <tr>
           <td>出版日期：</td>
           <td><input type="date" name="bdate"></td>
           </tr>
          <tr>
           <td>单价：</td>
           <td><input type="text" name="price"></td>
           </tr>
           <tr>
             <td><input type="submit" value="提交"></td>
           </tr>
       </table>
     </form>
    </center>
  </body>
</html>
