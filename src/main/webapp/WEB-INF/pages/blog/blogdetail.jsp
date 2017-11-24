<%--
  Created by IntelliJ IDEA.
  User: lizhongren1
  Date: 2017/5/18
  Time: 上午8:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>${blog.title}</title>
    <link rel="stylesheet" href="../../../resources/bs/css/bootstrap.css">
    <script src="../../../resources/js/jquery-3.2.1.min.js"></script>
    <script src="../../../resources/bs/js/bootstrap.js"></script>

    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>

<div class="container">
<div class="panel panel-default">
    <!-- Default panel contents -->
    <div class="panel-heading">博客详情</div>
    <div class="panel-body text-center">
        <h2>${blog.title}</h2>
    </div>

    <!-- List group -->
    <ul class="list-group">
        <li class="list-group-item text-center"><p>${blog.content}</p></li>
        <li class="list-group-item">
            <button id="edit" class="btn btn-primary">编辑</button>
            <button id="back" class="btn btn-default">返回</button>
        </li>
    </ul>
</div>
</div>

</body>
<script src="../../../resources/js/jquery-3.2.1.min.js"></script>
<script src="../../../resources/js/jquery.cookie.js"></script>
<script>

    $("#edit").click(function () {
        location.href = "/updateblog/"+${blog.id}
    });


    $("#back").click(function () {
        location.href = "/blogpage/"+${applicationScope.loginUser.id}
    })
</script>
</html>
