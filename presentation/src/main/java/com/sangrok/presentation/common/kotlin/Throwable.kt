package com.sangrok.presentation.common.kotlin

import java.net.UnknownHostException

val Throwable.isNetworkError: Boolean
    get() = this is UnknownHostException