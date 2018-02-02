package com.ksb.ksb_with_security.dao

import com.ksb.ksb_with_security.entity.HttpTestRecord
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

/**
 * Created by Kor on 2018-01-30 02:26:01. author: 东海陈光剑
 */
interface HttpTestRecordDao : JpaRepository<HttpTestRecord, Long> {
    @Query(value = """
        select a from #{#entityName} a
        where concat(a.url, '|', a.method, '|', a.author)
        like %:searchText%
        """)
    fun findAll(@Param("searchText") searchText: String, pageable: Pageable): Page<HttpTestRecord>
}
