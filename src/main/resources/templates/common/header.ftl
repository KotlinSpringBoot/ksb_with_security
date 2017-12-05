<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>KSB with Shiro</title>

    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" rel="stylesheet">

    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>

<nav class="navbar navbar-inverse" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="/">Kotlin + Spring Boot</a>
        </div>
        <div>
            <ul class="nav navbar-nav">
                <li class="active"><a href="/">首页</a></li>
                <li><a href="/admin">系统管理</a></li>
                <li><a href="/user"> 用户列表</a></li>
                <li><a href="/main">系统主页</a></li>

                <li class="divider"></li>

                <li><a href="/login">登陆</a></li>
                <li><a href="/logout">退出</a></li>

                <li class="divider"></li>

                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                    ${(Session["user"].username)!} <b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="#"> Kotlin </a></li>
                        <li><a href="#"> Spring Boot </a></li>
                        <li><a href="#"> Java </a></li>
                        <li class="divider"></li>
                        <li><a href="#"> Scala </a></li>
                        <li class="divider"></li>
                        <li><a href="#"> React </a></li>
                    </ul>
                </li>


            </ul>
        </div>
    </div>
</nav>
