package com.ksb.ksb_with_security

import com.ksb.ksb_with_security.dao.RoleDao
import com.ksb.ksb_with_security.dao.UserDao
import com.ksb.ksb_with_security.entity.Role
import com.ksb.ksb_with_security.entity.User
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.context.support.beans
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.web.servlet.config.annotation.EnableWebMvc

@SpringBootApplication
@EnableAutoConfiguration(exclude = [ErrorMvcAutoConfiguration::class])
class KsbWithSecurityApplication

fun main(args: Array<String>) {
    SpringApplicationBuilder().initializers(
            beans {
                bean {
                    ApplicationRunner {
                        try {
                            val roleDao = ref<RoleDao>()
                            // 普通用户角色
                            val roleUser = Role()
                            roleUser.role = "ROLE_USER"
                            val r1 = roleDao.save(roleUser)

                            // 超级管理员角色
                            val roleAdmin = Role()
                            roleAdmin.role = "ROLE_ADMIN"
                            val r2 = roleDao.save(roleAdmin)

                            val userDao = ref<UserDao>()
                            // 普通用户
                            val user = User()
                            user.username = "user"
                            user.password = BCryptPasswordEncoder().encode("user")
                            val userRoles = setOf(r1)
                            user.roles = userRoles
                            userDao.save(user)

                            // 超级管理员用户
                            val admin = User()
                            admin.username = "admin"
                            admin.password = BCryptPasswordEncoder().encode("admin")
                            val adminRoles = setOf(r1, r2)
                            admin.roles = adminRoles
                            userDao.save(admin)

                        } catch (e: Exception) {
                        }
                    }
                }
            }
    ).sources(KsbWithSecurityApplication::class.java).run(*args)
}
