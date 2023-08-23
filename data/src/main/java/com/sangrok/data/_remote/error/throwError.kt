package com.sangrok.data._remote.error

import com.sangrok.common.ErrorData
import retrofit2.HttpException
import java.net.UnknownHostException

internal fun throwError(throwable: Throwable): ErrorData {
    throw when (throwable) {
        is UnknownHostException,
        -> ErrorData.Network

        is HttpException -> ErrorData.Api(
            message = throwable.response()?.message(),
        )

        else -> ErrorData.Unknown(message = "${throwable.message}")
    }
}