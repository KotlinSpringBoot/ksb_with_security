package com.ksb.ksb_with_security.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class IndexController {
    @GetMapping(value = ["", "/", "/index"])
    fun index(): String {
        return "/index"
    }

    @GetMapping(value = ["/403"])
    fun error403(): String {
        return "/403"
    }
}
