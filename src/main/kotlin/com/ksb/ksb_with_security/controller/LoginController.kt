package com.ksb.ksb_with_security.controller

import com.ksb.ksb_with_security.result.Result
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody


@Controller
class LoginController {
    @GetMapping("/login")
    fun login(): String {
        return "login" // login.ftl
    }

    @RequestMapping("/login/success")
    @ResponseBody
    fun success(): Result<String> {
        return Result("0", "login success")
    }

    @RequestMapping("/login/failure")
    @ResponseBody
    fun failure(): Result<String> {
        return Result("1", "login failure: username or password incorrect!")
    }

}
