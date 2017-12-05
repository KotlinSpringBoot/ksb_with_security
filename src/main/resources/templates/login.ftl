<#include 'common/header.ftl'>

<div class="container text-info text-center">
    <div class="jumbotron">
        <h3 class="">登陆界面</h3>
        <form class="form-horizontal" role="form" method="post" action="/doLogin">

            <div class="form-group">
                <label class="col-sm-3 control-label">用户名</label>
                <div class="col-sm-7">
                    <input type="text" class="form-control" name="username" placeholder="请输入用户名">
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label">密 码</label>
                <div class="col-sm-7">
                    <input type="text" class="form-control" name="password" placeholder="请输入姓">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-3 col-sm-7">
                    <div class="checkbox">
                        <label>
                            <input type="checkbox" name="rememberMe">请记住我
                        </label>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-3 col-sm-7">
                    <button type="submit" class="btn btn-default">登录</button>
                </div>
            </div>
        </form>


    </div>
</div>




<#include 'common/footer.ftl'>
