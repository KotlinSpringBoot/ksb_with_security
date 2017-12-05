package com.ksb.ksb_with_security.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import javax.servlet.http.HttpServletRequest

@Controller
class LoginController {

    @RequestMapping("/login")
    fun login(request: HttpServletRequest): String {
        return "login"
    }

    @RequestMapping("/logout")
    fun logout(request: HttpServletRequest): String {
        return "redirect:/login"
    }

}
