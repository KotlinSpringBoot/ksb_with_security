package com.ksb.ksb_with_security.dto

import org.springframework.data.domain.Page

class PageDtoUxCore<T> {
    var content: PageContent<T>? = null
}

data class PageContent<T>(var data: List<T>, var currentPage: Int, var totalCount: Long)

class PageConverter<T> {
    fun convert(page: Page<T>, pageDtoUxCore: PageDtoUxCore<T>) {
        pageDtoUxCore.content = PageContent(
                data = page.content,
                currentPage = page.number + 1, // 后端 JPA 的分页，起始页为 0
                totalCount = page.totalElements
        )
    }
}


/**
{
"content":{
"data":[
{
"id":'1'
"grade":"grade1",
"email":"email1",
"firstName":"firstName1",
"lastName":"lastName1",
"birthDate":"birthDate1",
"country":"country1",
"city":"city1"
}
...

],
"currentPage":1,
"totalCount":30
},
"success": true,
"errorCode": "",
"errorMsg": ""
}
 */