package com.ksb.ksb_with_security.entity

import com.fasterxml.jackson.annotation.JsonFormat
import java.util.*
import javax.persistence.*

/**
 * Created by Kor on 2018-01-30 02:26:01. author: 东海陈光剑
 */
@Entity
class HttpTestRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = -1
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    var gmtCreate = Date()
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    var gmtModify = Date()
    var isDeleted = 0

    var author: String = ""
    var url: String = ""
    @Column(length = 50)
    var method: String = ""
    var postData: String? = null
    @Lob
    var responseText: String? = null
}
