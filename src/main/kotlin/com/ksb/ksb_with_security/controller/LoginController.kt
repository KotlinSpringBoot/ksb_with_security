package com.ksb.ksb_with_security.controller

import com.ksb.ksb_with_security.result.Result
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController


@RestController
class LoginController {

    @CrossOrigin(origins = ["http://127.0.0.1:3000"],
            maxAge = 3600,
            methods = [RequestMethod.GET, RequestMethod.POST])
    @GetMapping("/login/success")
    fun success(): Result<String> {
        return Result("1", "login success")
    }

    @CrossOrigin(origins = ["http://127.0.0.1:3000"],
            maxAge = 3600,
            methods = [RequestMethod.GET, RequestMethod.POST])
    @GetMapping("/login/failure")
    fun failure(): Result<String> {
        return Result("0", "login failure: username or password incorrect!")
    }

}
