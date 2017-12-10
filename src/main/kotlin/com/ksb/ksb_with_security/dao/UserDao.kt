package com.ksb.ksb_with_security.dao

import com.ksb.ksb_with_security.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface UserDao : JpaRepository<User, Long> {

    @Query("""
         select a from #{#entityName} a where a.username = :username
    """)
    fun findByUsername(@Param("username") username: String): User?
}
