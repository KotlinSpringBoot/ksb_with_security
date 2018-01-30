package com.ksb.ksb_with_security.result

data class Result<T>(var code: String, var data: T)
