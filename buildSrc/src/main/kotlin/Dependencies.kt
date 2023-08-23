object Dependencies {

    object Kotlin {
        const val Coroutine = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.Kotlin.Coroutines}"
        const val ImmutableCollections = "org.jetbrains.kotlinx:kotlinx-collections-immutable:${Versions.Kotlin.ImmutableCollections}"
    }

    object Hilt {
        const val Core = "com.google.dagger:hilt-core:${Versions.Jetpack.Hilt}"
        const val Android = "com.google.dagger:hilt-android:${Versions.Jetpack.Hilt}"
        const val Kapt = "com.google.dagger:hilt-android-compiler:${Versions.Jetpack.Hilt}"
    }

    object Javax {
        const val Inject = "javax.inject:javax.inject:${Versions.Di.Inject}"
    }

    object Room {
        const val Core = "androidx.room:room-ktx:${Versions.Jetpack.Room}"
        const val Compiler = "androidx.room:room-compiler:${Versions.Jetpack.Room}"
    }

    val Network = listOf(
        "com.squareup.retrofit2:retrofit:${Versions.Network.Retrofit}",
        "com.squareup.okhttp3:logging-interceptor:${Versions.Network.OkHttp}",
        "com.squareup.okhttp3:okhttp:${Versions.Network.OkHttp}",
    )

    object Paging {
        const val Runtime = "androidx.paging:paging-runtime:${Versions.Jetpack.Paging}"
        const val Common = "androidx.paging:paging-common:${Versions.Jetpack.Paging}"
    }

    object Compose {
        val core = listOf(
            "androidx.compose.ui:ui:${Versions.Compose.Main}",
            "androidx.compose.runtime:runtime:${Versions.Compose.Main}",
            "androidx.compose.foundation:foundation:${Versions.Compose.Main}",
            "androidx.compose.material:material:${Versions.Compose.Material}",
            "androidx.paging:paging-compose:${Versions.Compose.Paging}",
        )
        val sub = listOf(
            "androidx.activity:activity-compose:${Versions.Compose.Activity}",
            "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.Compose.Lifecycle}",
            "androidx.lifecycle:lifecycle-runtime-compose:${Versions.Compose.Lifecycle}",
            "io.coil-kt:coil-compose:${Versions.Compose.Coil}",
        )
    }

    val Test = listOf(
        "junit:junit:${Versions.Test.JUnit}",
    )
}
