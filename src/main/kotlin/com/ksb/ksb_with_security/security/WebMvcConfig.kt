package com.ksb.ksb_with_security.security

import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport

@Configuration
class WebMvcConfig : WebMvcConfigurationSupport() {
    val log = LoggerFactory.getLogger(WebMvcConfig::class.java)

    /**
     * 重写 addCorsMappings方法:
    addMapping：配置可以被跨域的路径。
    allowedMethods：允许访问该跨域资源服务器的请求方法，如：POST、GET、PUT、DELETE等。
    allowedOrigins：允许访问的跨域资源的请求域名。
    allowedHeaders：允许请求 header 的访问，如："X-TOKEN"。
     */
    override fun addCorsMappings(registry: CorsRegistry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("*")
                .allowedHeaders("*")
        super.addCorsMappings(registry)
    }
}