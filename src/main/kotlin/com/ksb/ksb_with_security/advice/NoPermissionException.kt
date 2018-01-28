package com.ksb.ksb_with_security.advice

class NoPermissionException : Exception {
    internal var msg: String
    internal var t: Throwable? = null

    constructor(msg: String) {
        this.msg = msg
    }


    constructor(msg: String, t: Throwable) {
        this.msg = msg
        this.t = t
    }

    constructor(message: String, msg: String, t: Throwable) : super(message) {
        this.msg = msg
        this.t = t
    }

    constructor(message: String, cause: Throwable, msg: String, t: Throwable) : super(message, cause) {
        this.msg = msg
        this.t = t
    }

    constructor(cause: Throwable, msg: String, t: Throwable) : super(cause) {
        this.msg = msg
        this.t = t
    }

    constructor(message: String, cause: Throwable, enableSuppression: Boolean, writableStackTrace: Boolean, msg: String, t: Throwable) : super(message, cause, enableSuppression, writableStackTrace) {
        this.msg = msg
        this.t = t
    }
}
