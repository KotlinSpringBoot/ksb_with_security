package com.ksb.ksb_with_security.security

import com.ksb.ksb_with_security.handler.MyAccessDeniedHandler
import com.ksb.ksb_with_security.service.MyUserDetailService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder


/**
prePostEnabled :决定Spring Security的前注解是否可用 [@PreAuthorize,@PostAuthorize,..]
secureEnabled : 决定是否Spring Security的保障注解 [@Secured] 是否可用
jsr250Enabled ：决定 JSR-250 annotations 注解[@RolesAllowed..] 是否可用.
 */

@Configuration
@EnableWebSecurity
// 开启 Spring Security 方法级安全注解 @EnableGlobalMethodSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
class WebSecurityConfig : WebSecurityConfigurerAdapter() {
    @Autowired lateinit var myAccessDeniedHandler: MyAccessDeniedHandler
    @Autowired lateinit var userDetailsService: MyUserDetailService

//    @Bean
//    override fun userDetailsService(): UserDetailsService {
//        return MyUserDetailService()
//    }

    @Throws(Exception::class)
    override fun configure(web: WebSecurity) {
        web.ignoring().antMatchers(
                "/css/**",
                "/fonts/**",
                "/js/**",
                "/plugins/**",
                "/images/**" // 不拦截静态资源
        )
    }

    @Throws(Exception::class)
    override fun configure(http: HttpSecurity) {
//        http.csrf().disable()
        http.authorizeRequests()
                .antMatchers(
                        "/login/**"
                ).permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login") // @param loginPage the login page to redirect to if authentication is required。 url 请求路径，对应 LoginController 里面的 @GetMapping("/login")
                .loginProcessingUrl("/login") // POST, Specifies the URL to validate the credentials
                .usernameParameter("username")
                .passwordParameter("password")
                .defaultSuccessUrl("/main")//登陆成功路径
//                .defaultSuccessUrl("/login/success")//登陆成功路径
//                .failureUrl("/login/failure")//登陆失败路径
                .and()
                .exceptionHandling().accessDeniedHandler(myAccessDeniedHandler)
                //.exceptionHandling().accessDeniedPage("/403")
                .and()
                .logout()
                .logoutSuccessUrl("/login?logout")

        /**
         * The URL that triggers log out to occur (default is "/logout"). If CSRF protection
         * is enabled (default), then the request must also be a POST. This means that by
         * default POST "/logout" is required to trigger a log out. If CSRF protection is
         * disabled, then any HTTP method is allowed.
         */

    }

    @Throws(Exception::class)
    override fun configure(auth: AuthenticationManagerBuilder) {
        //AuthenticationManager 使用我们的 MyUserDetailService 来获取用户信息
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder())
    }

    /**
     * 密码加密算法
     *
     * @return
     */
    @Bean
    fun passwordEncoder(): BCryptPasswordEncoder {
        return BCryptPasswordEncoder();
    }
}
