package com.ksb.ksb_with_security.schedule

import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import java.text.SimpleDateFormat
import java.util.*


@Component
@EnableScheduling
class DemoSchedule {

    @Scheduled(cron = "0/10 * * * * *")
    fun job1() {
        println("${SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Date())} 执行任务 job1 ")
    }

    @Scheduled(fixedRate = 3000)
    fun job2() {
        println("${SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Date())} 执行任务 job2 ")
    }

}
