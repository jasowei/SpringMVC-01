<%--
  Created by IntelliJ IDEA.
  User: lizhongren1
  Date: 2017/5/4
  Time: 下午6:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>

    <%--<link rel="stylesheet" href="/resources/css/loginstyle.css">--%>

    <link rel="stylesheet" href="../../../resources/bs/css/bootstrap.css">
    <script src="../../../resources/js/jquery-3.2.1.min.js"></script>
    <script src="../../../resources/bs/js/bootstrap.js"></script>

    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>

<div class="container col-md-4 col-md-offset-4">
    <div class="panel panel-default">
        <div class="panel-heading">
            <h3 class="panel-title">
                登录
            </h3>
        </div>
        <div class="panel-body">
            <form>
                <div class="form-group">
                    <label for="u">用户名</label>
                    <input type="text" class="form-control" id="u" placeholder="请输入用户名">
                </div>
                <div class="form-group">
                    <label for="p">密码</label>
                    <input type="password" class="form-control" id="p" placeholder="请输入密码">
                </div>
                <div>
                    <label>
                        <input type="checkbox"> 自动登录
                    </label>
                </div>
                <button type="button" class="btn btn-default btn-primary" id="b"
                        data-toggle="collapse" data-target="#collapseExample"
                        aria-expanded="false" aria-controls="collapseExample">登录</button>
                <button type="button" class="btn btn-default" id="r">注册</button>

            </form>
        </div>
        <div class="collapse" id="collapseExample">
            <div class="well">
                <h3 style="color: red" id="loginresult"/>
            </div>
        </div>
    </div>

</div>

</body>
<script src="../../../resources/js/jquery.cookie.js"></script>
<script>

    $("#b").click(function () {
        $.ajax({
            type: "get",
            url: "/loginu",
            data: {
                "name": $("#u").val(),
                "password": $("#p").val()
            },
            success: function (result) {
                if (result.errorCode == 0) {
                    console.log(result)
//                    $.cookie("loginmsg", result.data.name, {expires: 1})
//                    $.cookie("userid", result.data.id, {expires: 1})
                    location.href = "/blogpage/" + result.data.id
                } else {
                    $("#loginresult").text(result.message)
                    console.log(result)
                }
            }
        })

    });

    $("#r").click(function () {
        location.href = "/register?uname="+$("#u").val()
    })

</script>
</html>
