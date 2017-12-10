package com.ksb.ksb_with_security.dao

import com.ksb.ksb_with_security.entity.Role
import org.springframework.data.jpa.repository.JpaRepository

interface RoleDao : JpaRepository<Role, Long> {
}
