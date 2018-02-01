package com.ksb.ksb_with_security.service

import com.ksb.ksb_with_security.dao.UserDao
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class MyUserDetailService : UserDetailsService {
    val logger = LoggerFactory.getLogger(MyUserDetailService::class.java)
    @Autowired lateinit var userDao: UserDao

    override fun loadUserByUsername(username: String): UserDetails {
        // 去数据库 User 表，根据 username 查询用户是否存在
        val user = userDao.findByUsername(username) ?: throw  UsernameNotFoundException(username + " not found")
        logger.info("user = {}", user)
        val roles = user.roles // 数据库中存的该用户的角色集合
        /**
         * SimpleGrantedAuthority: Basic concrete implementation of a GrantedAuthority
         */
        val authorities = mutableSetOf<SimpleGrantedAuthority>()
        roles.forEach {
            // 封装 org.springframework.security.core.userdetails.User 对象中的
            // Collection<? extends GrantedAuthority> authorities 参数
            authorities.add(SimpleGrantedAuthority(it.role))
        }
        return org.springframework.security.core.userdetails.User( // 此处为了区分我们本地系统中的 User 实体类，特意列出 Security 中的 User 类的全路径
                username,
                user.password,
                authorities
        )
    }
}
