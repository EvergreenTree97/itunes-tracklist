package com.sangrok.presentation.common.android

import androidx.paging.CombinedLoadStates
import androidx.paging.LoadState
import com.sangrok.presentation.common.kotlin.isNetworkError

internal val CombinedLoadStates.isRefreshLoading: Boolean
    get() = refresh is LoadState.Loading

internal val CombinedLoadStates.isAppendLoading: Boolean
    get() = append is LoadState.Loading

internal val CombinedLoadStates.isNetworkError: Boolean
    get() {
        return listOf(refresh, prepend, append)
            .filterIsInstance(LoadState.Error::class.java)
            .any { it.error.isNetworkError }
    }