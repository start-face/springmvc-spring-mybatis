<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2018/1/28
  Time: 19:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>展示用户界面</title>
</head>
<body>

    <table cellspacing="0" cellpadding="0" border="1">
        <tr>
            <th>主键</th>
            <th>用户名</th>
            <th>密码</th>
            <th>邮箱</th>
            <th>电话</th>
            <th>权限</th>
        </tr>
        <c:forEach items="${userList}" var="one">
            <tr>
                <td>${one.id}</td>
                <td>${one.userName}</td>
                <td>${one.passWord}</td>
                <td>${one.mail}</td>
                <td>${one.phone}</td>
                <td>${one.auth}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
