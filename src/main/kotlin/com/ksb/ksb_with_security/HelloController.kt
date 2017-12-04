package com.ksb.ksb_with_security

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpServletRequest

@RestController
class HelloController {

    @GetMapping("hello")
    fun hello(request: HttpServletRequest): Map<String, Any> {
        val sesion = request.session
        val attributes = mutableMapOf<String, Any>()
        sesion.attributeNames.iterator().forEach {
            attributes[it] = sesion.getAttribute(it)
        }
        return attributes
    }
}
