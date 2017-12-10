package com.ksb.ksb_with_security.controller

import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class ManageController {

    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("/main")
    fun main(): String {
        return "/main"
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(value = ["/admin"])
    fun admin(): String {
        return "/admin"
    }

    @GetMapping(value = ["/user"])
    fun user(): String {
        return "/user"
    }

}
