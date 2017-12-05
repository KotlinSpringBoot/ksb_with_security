package com.ksb.ksb_with_security.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class ManageController {

    @GetMapping("/main")
    fun main(): String {
        return "/main"
    }

    @GetMapping(value = ["/admin"])
    fun admin(): String {
        return "/admin"
    }

    @GetMapping(value = ["/user"])
    fun user(): String {
        return "/user"
    }

    @GetMapping(value = ["/403"])
    fun error403(): String {
        return "/403"
    }
}
