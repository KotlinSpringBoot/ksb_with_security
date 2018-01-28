package com.ksb.ksb_with_security.handler

import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.security.access.AccessDeniedException
import org.springframework.security.web.WebAttributes
import org.springframework.security.web.access.AccessDeniedHandler
import org.springframework.stereotype.Component
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class MyAccessDeniedHandler : AccessDeniedHandler {
    private val logger = LoggerFactory.getLogger(MyAccessDeniedHandler::class.java)

    override fun handle(request: HttpServletRequest, response: HttpServletResponse, accessDeniedException: AccessDeniedException) {
        val isAjax = ControllerTools.isAjaxRequest(request)

        if (!response.isCommitted) {
            if (isAjax) {
                val msg = accessDeniedException.message
                logger.info("accessDeniedException.message = $msg")
                val accessDenyMsg = """
                    {
                    "code":"403",
                    "msg": "没有权限"
                    }
                """.trimIndent()
                ControllerTools.print(response, accessDenyMsg)
            } else {
                // Put exception into request scope (perhaps of use to a view)
                request.setAttribute(WebAttributes.ACCESS_DENIED_403,
                        accessDeniedException)
                // Set the 403 status code.
                response.status = HttpStatus.FORBIDDEN.value()
                // forward to error page.
                val dispatcher = request.getRequestDispatcher("/403")
                dispatcher.forward(request, response)
            }
        }
    }
}


object ControllerTools {
    fun isAjaxRequest(request: HttpServletRequest): Boolean {
        return "XMLHttpRequest".equals(request.getHeader("X-Requested-With"), true)
    }

    fun print(response: HttpServletResponse, msg: String) {
        response.characterEncoding = "UTF-8"
        response.contentType = "application/json; charset=utf-8"
        val writer = response.writer
        writer.write(msg)
        writer.flush()
        writer.close()
    }
}