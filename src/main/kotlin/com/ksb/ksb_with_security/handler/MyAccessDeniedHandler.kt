//package com.ksb.ksb_with_security.handler
//
//import org.springframework.security.access.AccessDeniedException
//import org.springframework.security.web.WebAttributes
//import org.springframework.security.web.access.AccessDeniedHandler
//import org.springframework.stereotype.Service
//import javax.servlet.http.HttpServletRequest
//import javax.servlet.http.HttpServletResponse
//
//
//@Service
//class MyAccessDeniedHandler : AccessDeniedHandler {
//    var errorPage = "/403"
//
//    override fun handle(request: HttpServletRequest, response: HttpServletResponse, accessDeniedException: AccessDeniedException) {
//        val isAjax = ControllerTools.isAjaxRequest(request)
//        if (isAjax) {
//            val msg: String = accessDeniedException.message.toString()
//            ControllerTools.print(response, msg)
//        } else if (!response.isCommitted()) {
//            // Put exception into request scope (perhaps of use to a view)
//            request.setAttribute(WebAttributes.ACCESS_DENIED_403, accessDeniedException)
//            // Set the 403 status code.
//            response.setStatus(HttpServletResponse.SC_FORBIDDEN)
//            // forward to error page.
//            val dispatcher = request.getRequestDispatcher(errorPage)
//            dispatcher.forward(request, response)
//        }
//    }
//}
//
//object ControllerTools {
//    fun isAjaxRequest(request: HttpServletRequest): Boolean {
//        return "XMLHttpRequest".equals(request.getHeader("X-Requested-With"), true)
//    }
//
//    fun print(response: HttpServletResponse, msg: String) {
//        response.characterEncoding = "UTF-8"
//        response.contentType = "application/json; charset=utf-8"
//        val out = response.writer
//        out.append(msg)
//    }
//}
