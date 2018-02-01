package com.ksb.ksb_with_security.controller

import com.ksb.ksb_with_security.dao.HttpTestRecordDao
import com.ksb.ksb_with_security.entity.HttpTestRecord
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.*
import javax.servlet.http.HttpServletRequest

/**
 * Created by Kor on 2018-01-30 02:26:01. author: 东海陈光剑
 */
@RestController
@RequestMapping("/httptestrecord")
class HttpTestRecordController {
    @Autowired lateinit var HttpTestRecordDao: HttpTestRecordDao
    @GetMapping(value = ["/"])
    @PreAuthorize("hasRole('ADMIN')")
    fun httptestrecord(request: HttpServletRequest): List<HttpTestRecord> {
        return HttpTestRecordDao.findAll()
    }

    @GetMapping(value = ["/{id}"])
    @PreAuthorize("hasRole('ADMIN')")
    fun getOne(@PathVariable("id") id: Long): HttpTestRecord {
        return HttpTestRecordDao.getOne(id)
    }

    @GetMapping(value = ["/findAll"])
    @PreAuthorize("hasRole('ADMIN')")
    fun page(@RequestParam(value = "pageNo", defaultValue = "0") pageNo: Int,
             @RequestParam(value = "pageSize", defaultValue = "10") pageSize: Int,
             @RequestParam(value = "searchText", defaultValue = "") searchText: String
    ): Page<HttpTestRecord> {
        return HttpTestRecordDao.findAll(searchText, PageRequest.of(pageNo, pageSize))
    }
}
