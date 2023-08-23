package com.sangrok.presentation.common.kotlin

import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList

inline fun <T> ImmutableList<T>.copy(mutator: MutableList<T>.() -> Unit): ImmutableList<T> {
    return toMutableList().apply(mutator).toImmutableList()
}
