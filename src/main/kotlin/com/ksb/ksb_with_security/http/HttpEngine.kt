package com.ksb.ksb_with_security.http

import okhttp3.MediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody

object HttpEngine {
    private val okhttpClient = OkHttpClient.Builder()
            .build()

    fun get(url: String): String? {
        val request = Request.Builder()
                .url(url)
                .get()
                .build()
        val response = okhttpClient.newCall(request).execute()
        return response.body()?.string()
    }

    fun post(url: String, data: String?): String? {
        //设置媒体类型 application/json , 表示传递的是一个json格式的对象
        val mediaType = MediaType.parse("application/json")
        val requestBody = RequestBody.create(mediaType, data);
        val request = Request.Builder()
                .url(url)
                .post(requestBody)
                .build()
        val response = okhttpClient.newCall(request).execute()
        return response.body()?.string()

    }
}