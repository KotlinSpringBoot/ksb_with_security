package com.ksb.ksb_with_security.controller

import com.ksb.ksb_with_security.result.Result
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class LoginController {
    @GetMapping("/login/success")
    fun success(): Result<String> {
        return Result("1", "login success")
    }

    @GetMapping("/login/failure")
    fun failure(): Result<String> {
        return Result("0", "login failure: username or password incorrect!")
    }
    @GetMapping("/logout/ok")
    fun logout(): Result<String> {
        return Result("2", "logout ok!")
    }
}
