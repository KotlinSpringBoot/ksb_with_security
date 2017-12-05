package com.ksb.ksb_with_security.advice

import org.springframework.ui.Model
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler


@ControllerAdvice(basePackages = arrayOf("com.ksb.ksb_with_shiro"))
class GlobalExceptionHandlerAdvice {

    /**表示捕捉到 Exception的异常，我们可以在这里自定义异常进行捕获处理*/
    @ExceptionHandler(value = Exception::class)
    fun exception(exception: Exception, model: Model): String {
        model.addAttribute("errorMessage", exception.message)
        model.addAttribute("stackTrace", exception.stackTrace)
        return "/error"
    }
}

/* 另一种方式：HandlerExceptionResolver */
//@Service
//class MyExceptionResolver : HandlerExceptionResolver {
//
//    override fun resolveException(request: HttpServletRequest, response: HttpServletResponse, handler: Any?, ex: Exception): ModelAndView? {
//
//        val model = ConcurrentHashMap<String, Any>()
//        model.put("ex", ex)
//        return ModelAndView("error", model)
//    }
//
//}
