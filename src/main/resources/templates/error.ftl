<#include 'common/header.ftl'>

<div class="container">

    <h1>系统异常统一处理页面</h1>
    <h3>请求 URL: ${url!}</h3>
    <h3>异常消息: <code>${errorMessage!'异常消息'}</code></h3>
    <h3>异常堆栈信息： </h3>

    <article>
        <code>
        <#list stackTrace! as line >
            <p>${line}</p>
        </#list>
        </code>
    </article>

</div>


<#include 'common/footer.ftl'>
