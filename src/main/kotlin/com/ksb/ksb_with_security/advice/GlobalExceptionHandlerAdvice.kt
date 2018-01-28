package com.ksb.ksb_with_security.advice

import org.springframework.ui.Model
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import javax.servlet.http.HttpServletRequest


@ControllerAdvice(basePackages = ["com.ksb.ksb_with_security.controller"])
class GlobalExceptionHandlerAdvice {

    @ExceptionHandler(value = NoPermissionException::class)
    fun exception(exception: Exception, req: HttpServletRequest, model: Model): String {
        model.addAttribute("errorMessage", exception.message)
        model.addAttribute("stackTrace", exception.stackTrace)
        model.addAttribute("url", req.requestURL)
        return "/error"
    }
}
