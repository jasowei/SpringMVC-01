<%--
  Created by IntelliJ IDEA.
  User: lizhongren1
  Date: 2017/5/17
  Time: 上午11:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>修改博客</title>
    <link rel="stylesheet" href="../../../resources/bs/css/bootstrap.css">
    <script src="../../../resources/js/jquery-3.2.1.min.js"></script>
    <script src="../../../resources/bs/js/bootstrap.js"></script>

    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>

<div class="container">
    <h1>
        更新博客
    </h1>
    <table class="table">
        <tr>
            <td>标题</td>
            <td><input value="${blog.title}" class="form-control" type="text" id="add_title" required></td>
        </tr>
        <tr>
            <td>描述</td>
            <td><textarea class="form-control" id="add_des" placeholder="请简要描述一下博客内容" required>${blog.des}</textarea>
            </td>
        </tr>
        <tr>
            <td>内容</td>
            <td><textarea class="form-control" rows="10" id="add_content" placeholder="请输入内容"
                          required>${blog.content}</textarea></td>
        </tr>
    </table>
</div>
<div class="text-center">
    <button id="subtn" class="btn btn-primary">提交</button>
    <button id="back" class="btn btn-default">返回</button>
</div>
</body>

<script src="../../../resources/js/jquery-3.2.1.min.js"></script>
<script src="../../../resources/js/jquery.cookie.js"></script>
<script>

    $("#subtn").click(function () {

        if ($("#add_title").val() == "" ||
                $("#add_des").val() == "" ||
                $("#add_content").val() == ""
        ) {
            alert("请填写完整信息!(均为必填项)")
            return false;
        } else {

            $.post("/newBlog", {
                "id":${blog.id},
                "title": $("#add_title").val(),
                "des": $("#add_des").val(),
                "content": $("#add_content").val(),
                "userId": ${applicationScope.loginUser.id}
            }, function (result) {
                if (result.errorCode == 0) {
                    location.href = "/blogpage/" +
                    ${applicationScope.loginUser.id}
                }
            })
        }
    })

    $("#back").click(function () {
        location.href = "/blogpage/" +
        ${applicationScope.loginUser.id}
    })
</script>

</html>
