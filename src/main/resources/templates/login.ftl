<#include 'common/header.ftl'>

<div class="container text-info text-center">
    <div class="jumbotron">
        <h3 class=""> WEKOOL </h3>

        <form class="form-horizontal" role="form" method="post" action="/login">

            <div class="form-group">
                <label class="col-sm-3 control-label">
                    <span class="glyphicon glyphicon-user" aria-hidden="true"></span>
                </label>
                <div class="col-sm-7">
                    <input type="text" class="form-control" name="username" placeholder="请输入用户名">
                </div>
            </div>

            <div class="form-group">
                <label class="col-sm-3 control-label">
                    <span class="glyphicon glyphicon-lock" aria-hidden="true"></span>
                </label>
                <div class="col-sm-7">
                    <input type="password" class="form-control" name="password" placeholder="请输入密码">
                </div>
            </div>

            <div class="form-group">
                <div class="col-sm-offset-3 col-sm-7">
                    <button type="submit" class="btn btn-primary">登录</button>
                </div>
            </div>

        </form>

    </div>
</div>

<#include 'common/footer.ftl'>
