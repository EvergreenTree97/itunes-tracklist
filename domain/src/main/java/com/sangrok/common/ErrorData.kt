package com.sangrok.common

sealed class ErrorData(
    override val message: String? = null,
) : Throwable() {
    object Network : ErrorData()
    class Api(message: String?) : ErrorData(message = message)
    class Unknown(message: String?) : ErrorData(message = message)
}
