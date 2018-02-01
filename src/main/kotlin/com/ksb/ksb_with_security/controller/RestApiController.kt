package com.ksb.ksb_with_security.controller

import com.ksb.ksb_with_security.dao.UserDao
import com.ksb.ksb_with_security.entity.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpServletRequest

@RestController
@RequestMapping("/api")
class RestApiController {

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(value = ["/session"])
    fun hello(request: HttpServletRequest): Map<String, Any> {
        val session = request.session
        val attributes = mutableMapOf<String, Any>()
        session.attributeNames.iterator().forEach {
            attributes[it] = session.getAttribute(it)
        }
        return attributes
    }

    @Autowired lateinit var userDao: UserDao
    @GetMapping(value = ["/users"])
    @PreAuthorize("hasRole('ADMIN')")
    fun users(): List<User> {
        return userDao.findAll()
    }
}








