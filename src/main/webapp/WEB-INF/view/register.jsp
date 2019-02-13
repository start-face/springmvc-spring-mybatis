<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2018/5/3
  Time: 10:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册用户界面</title>

    <style>
        .add {
            width: 20%;
        }
    </style>
</head>
<body>

<form action="/admin/insertUser" method="post">
    <br/><br/>
    帐号:<input type="text" class="add" name="userName" value="" id="userName"/><br/><br/>
    邮箱:<input type="text" class="add" name="mail" value="" id="mail"/><br/><br/>
    电话:<input type="text" class="add" name="phone" value="" id="phone"/><br/><br/>

    <input type="button" value="确认" id="btn"/>
</form>

<script>

    $("#userName").blur(function () {

        let userName = $("#userName").val();
        if (userName === "") {
            alert("账户名未填写");
            return false;
        }

        if (!checkName()) {
            alert("用户名已经存在");
            return false;
        }
    });

    $("#btn").click(function () {

        let userName = $("#userName").val();
        let mail = $("#mail").val();
        let phone = $("#phone").val();

        if (userName === "" && mail === "" && phone === "") {
            alert("未填写数据");
            return false;
        }

        if (userName !== "" && !checkName()) {
            alert("用户名已经存在");
            return false;
        }

        $.ajax({
            timeout: 20000,
            type: "POST",
            dataType: "JSON",
            url: "/admin/insertUser",
            async: false,
            data: {"userName": userName, "mail": mail, "phone": phone},
            success: function (data) {

                if (data === 2) {
                    alert("请先登录系统")
                }
                if (data === 1) {
                    alert("添加用户成功");
                    window.location.href = "/admin/getUserList";
                }
                if (data === 0) {
                    alert("添加用户失败");
                }
            }
        });
    });

    function checkName() {

        let userName = $("#userName").val();
        let flag = false;

        $.ajax({
            timeout: 20000,
            type: "POST",
            dataType: "JSON",
            url: "/admin/findUserByUserName",
            async: false,
            data: {"userName": userName},
            success: function (data) {
                if (data === 1) {
                    flag = true;
                }
            }
        });

        return flag;
    }
</script>
</body>
</html>
