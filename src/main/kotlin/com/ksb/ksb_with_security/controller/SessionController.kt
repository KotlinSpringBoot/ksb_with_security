package com.ksb.ksb_with_security.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpServletRequest

@RestController
class SessionController {

    @GetMapping(value = ["session"])
    fun hello(request: HttpServletRequest): Map<String, Any> {
        val session = request.session
        val attributes = mutableMapOf<String, Any>()
        session.attributeNames.iterator().forEach {
            attributes[it] = session.getAttribute(it)
        }
        return attributes
    }
}








