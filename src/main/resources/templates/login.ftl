<#include 'common/header.ftl'>

<div class="container text-info text-center">
    <div class="jumbotron">
        <h3 class=""> LightSword </h3>

        <form class="form-horizontal form-login" role="form" method="post" action="/login">
            <div class="form-group">
                <div class="col-sm-3">
                ${error!}
                ${msg!}
                </div>
            </div>
            <div class="form-group">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <label class="col-sm-1 control-label">
                    <span class="glyphicon glyphicon-user" aria-hidden="true"></span>
                </label>
                <div class="col-sm-3">
                    <input type="text" class="form-control" name="username" placeholder="请输入用户名">
                </div>
            </div>

            <div class="form-group">
                <label class="col-sm-1 control-label">
                    <span class="glyphicon glyphicon-lock" aria-hidden="true"></span>
                </label>
                <div class="col-sm-3">
                    <input type="password" class="form-control" name="password" placeholder="请输入密码">
                </div>
            </div>

            <div class="form-group">
                <div class="col-sm-offset-1 col-sm-3">
                    <button type="submit" class="btn btn-primary">登录</button>
                </div>
            </div>
        </form>
    </div>
</div>

<#--<div class="container text-info text-center">-->
<#--<div class="jumbotron">-->
<#--<h3 class=""> LightSword </h3>-->

<#--<div class="login-form">-->
<#--<table>-->
<#--<tr>-->
<#--<td>-->
<#--<label class="form-label">用户名:</label>-->
<#--</td>-->
<#--<td>-->
<#--<input type='text' name='username' value='user' class="form-input">-->
<#--</td>-->
<#--</tr>-->
<#--<tr>-->
<#--<td>-->
<#--<label class="form-label">密 码:</label>-->
<#--</td>-->
<#--<td>-->
<#--<input type='password' name='password' value='user' class="form-input"/>-->
<#--</td>-->
<#--</tr>-->
<#--<tr>-->
<#--<td colspan='2'>-->
<#--<input onclick="doLogin();"-->
<#--name="submit"-->
<#--type="button"-->
<#--value="登陆"-->
<#--class="btn btn-primary form-submit-btn"-->
<#--/>-->
<#--</td>-->
<#--</tr>-->
<#--</table>-->
<#--<div id="results" class="text-danger"></div>-->
<#--</div>-->
<#--</div>-->
<#--</div>-->
<#--<script>-->
<#--function doLogin() {-->
<#--var username = $("input[name='username']").val();-->
<#--var password = $("input[name='password']").val();-->
<#--$.ajax({-->
<#--url: "login",-->
<#--type: "POST",-->
<#--data: "username=" + username + "&password=" + password,-->
<#--success: function (data) {-->
<#--var dataJson = JSON.stringify(data)-->
<#--if (data.code == 0) {-->
<#--alert("登陆成功:" + dataJson)-->
<#--location.href = '/main'-->
<#--} else {-->
<#--$("#results").html("登陆失败：" + dataJson)-->
<#--}-->
<#--}-->
<#--});-->
<#--}-->
<#--</script>-->
<#include 'common/footer.ftl'>
