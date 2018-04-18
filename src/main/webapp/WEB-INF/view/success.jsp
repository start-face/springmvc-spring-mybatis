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
    <title>结果测试界面</title>
</head>
<body>
    <h1>收到的后台数据是</h1>

    <table cellspacing="0" cellpadding="0" border="1">
        <tr>
            <th>主键</th>
            <th>用户名</th>
            <th>密码</th>
        </tr>
        <c:forEach items="${user}" var="one">
            <tr>
                <td>${one.id}</td>
                <td>${one.userName}</td>
                <td>${one.passWord}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
