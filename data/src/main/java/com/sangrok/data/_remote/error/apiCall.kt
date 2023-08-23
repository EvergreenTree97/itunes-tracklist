package com.sangrok.data._remote.error

internal suspend fun <T> apiCallWithThrow(
    call: suspend () -> T,
): T {
    return try {
        call()
    } catch (throwable: Throwable) {
        throw throwError(throwable)
    }
}