<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="_csrf.token" content="${_csrf.token}"/>
    <meta name="_csrf.parameterName" content="${_csrf.parameterName}"/>
    <title>LightSword</title>

    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" rel="stylesheet">

    <link rel="stylesheet" href="/css/app.css">

    <script src="/js/jquery-3.1.1.min.js"></script>
    <script src="/plugins/bootstrap/js/bootstrap.min.js"></script>

    <script src="https://cdn.bootcss.com/react/15.4.2/react.min.js"></script>
    <script src="https://cdn.bootcss.com/react/15.4.2/react-dom.min.js"></script>
    <script src="https://cdn.bootcss.com/babel-standalone/6.22.1/babel.min.js"></script>

    <link rel="stylesheet" href="/plugins/bootstrap-table/bootstrap-table.min.css">
    <script src="/plugins/bootstrap-table/bootstrap-table.min.js"></script>
    <script src="/plugins/bootstrap-table/bootstrap-table-locale-all.min.js"></script>

</head>
<body>
<div id="NavPage">
    <nav class="navbar navbar-default" role="navigation">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="/"> LightSword </a>
            </div>
            <div>
                <ul class="nav navbar-nav">
                    <li datatype="nav-item">
                        <a href="/">首页</a>
                    </li>
                    <li datatype="nav-item">
                        <a href="/main">HTTP 接口测试</a>
                    </li>
                    <li datatype="nav-item">
                        <a href="/admin">管理员页面</a>
                    </li>

                    <li class="divider"></li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <span class="glyphicon glyphicon-user" aria-hidden="true"></span>
                        ${(Session["SPRING_SECURITY_CONTEXT"].authentication.principal.username)!}
                            <b class="caret"></b>
                        </a>

                        <ul class="dropdown-menu">
                            <li><a href="#"> Kotlin </a></li>
                            <li><a href="#"> Spring Boot </a></li>
                            <li><a href="#"> Java </a></li>
                            <li><a href="#"> Scala </a></li>
                            <li><a href="#"> React </a></li>
                            <li class="divider"></li>
                            <li>
                                <form action="/logout" method="post">
                                    <input type="hidden" name="${_csrf.parameterName!}" value="${_csrf.token!}"/>
                                    <button type="submit" class="logout-btn">退出</button>
                                </form>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</div>

<script type="text/javascript">
    $(function () {
        var href = location.href;

        var items = $('[datatype="nav-item"]')

        items.each(function () {
            var url = this.children[0].href
            if (href === url) {
                items.removeClass('active')
                $(this).addClass('active')
            }
        })
    })
</script>
