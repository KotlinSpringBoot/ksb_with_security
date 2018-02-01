package com.ksb.ksb_with_security.controller

import com.ksb.ksb_with_security.result.Result
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.servlet.ModelAndView


@Controller
class LoginController {
    @GetMapping("/login/success")
    @ResponseBody
    fun success(): Result<String> {
        return Result("0", "login success")
    }

    @GetMapping("/login/failure")
    @ResponseBody
    fun failure(): Result<String> {
        return Result("1", "login failure: username or password incorrect!")
    }

    @GetMapping(value = "/login")
    fun login(
            @RequestParam(value = "error", required = false) error: String?,
            @RequestParam(value = "logout", required = false) logout: String?): ModelAndView {
        val model = ModelAndView()
        if (error != null) {
            model.addObject("error", "不正确的用户名和密码")
        }
        if (logout != null) {
            model.addObject("msg", "你已经成功退出")
        }
        model.viewName = "login" // login.ftl
        return model
    }

}
