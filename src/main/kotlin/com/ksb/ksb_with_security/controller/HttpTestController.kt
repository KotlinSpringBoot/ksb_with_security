package com.ksb.ksb_with_security.controller

import com.ksb.ksb_with_security.dao.HttpTestRecordDao
import com.ksb.ksb_with_security.entity.HttpTestRecord
import com.ksb.ksb_with_security.http.HttpEngine
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.Authentication
import org.springframework.security.core.userdetails.User
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.context.request.RequestContextHolder
import javax.servlet.http.HttpServletRequest
import javax.validation.Valid
import javax.validation.constraints.NotEmpty

@RestController
class HttpTestController {
    @Autowired lateinit var HttpTestRecordDao: HttpTestRecordDao

    @PostMapping("/httpTest")
    fun doTest(@Valid httpTestRequest: HttpTestRequest, bindingResult: BindingResult): HttpTestResult {
        val request = RequestContextHolder.getRequestAttributes() as HttpServletRequest
//        ${(Session["SPRING_SECURITY_CONTEXT"].authentication.principal.username)!}

        val authentication = request.session.getAttribute("SPRING_SECURITY_CONTEXT") as Authentication
        val username  = (authentication.principal as User).username

        if (bindingResult.hasErrors()) {
            var msg = ""
            bindingResult.fieldErrors.forEach {
                msg += it.defaultMessage
            }
            return HttpTestResult(
                    success = false,
                    msg = msg,
                    result = "执行失败：提交数据错误"
            )
        }
        if ("GET" == httpTestRequest.method) {
            var result = HttpEngine.get(httpTestRequest.url)

            val HttpTestRecord = HttpTestRecord()
            HttpTestRecord.author = username
            HttpTestRecord.method = "GET"
            HttpTestRecord.url = httpTestRequest.url
            HttpTestRecord.responseText = result
            HttpTestRecordDao.save(HttpTestRecord)

            return HttpTestResult(
                    success = true,
                    msg = "执行成功",
                    result = result
            )
        } else if ("POST" == httpTestRequest.method) {
            var result = HttpEngine.post(httpTestRequest.url, httpTestRequest.postData)
            val HttpTestRecord = HttpTestRecord()
            HttpTestRecord.author = username
            HttpTestRecord.method = "POST"
            HttpTestRecord.postData = httpTestRequest.postData
            HttpTestRecord.url = httpTestRequest.url
            HttpTestRecord.responseText = result
            HttpTestRecordDao.save(HttpTestRecord)

            return HttpTestResult(
                    success = true,
                    msg = "执行成功",
                    result = result
            )
        } else {
            return HttpTestResult(
                    success = false,
                    msg = "",
                    result = "执行失败：提交数据错误"
            )
        }


    }

}

data class HttpTestRequest(@NotEmpty(message = "请求方法不能为空")
                           var method: String,
                           @NotEmpty(message = "请求URL不能为空")
                           var url: String,
                           var postData: String?)

data class HttpTestResult(var success: Boolean,
                          var msg: String,
                          var result: String?)
