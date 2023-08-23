package com.sangrok.presentation

import com.sangrok.presentation.common.kotlin.copy
import kotlinx.collections.immutable.persistentListOf
import org.junit.Assert.assertSame
import org.junit.Test

class ImmutableListTest {
    @Test
    fun `should change when you change the element`() {

        val actual = persistentListOf(1).copy { this[0] = 0 }
        val expected = persistentListOf(0)
        assertSame(actual.first(), expected.first())
    }

    @Test
    fun `should not change when you change the element`() {
        val actual = persistentListOf(1).copy { this[0] = 0 }
        val expected = persistentListOf(1)
        assertSame(actual.first(), expected.first())
    }

}