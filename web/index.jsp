<%--
  Created by IntelliJ IDEA.
  User: suifeng
  Date: 2017/10/23
  Time: 22:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
  <head>
    <title>总集篇</title>
  </head>
  <body>
  <h1>这里是所有链接的集合</h1>
  <a href="hello.html">hello</a>
  <br/>
  <%
    out.print("Your ID address is " + request.getRemoteAddr());
  %>
  </body>
</html>
