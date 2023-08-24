plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
}

android {
    namespace = "com.sangrok.data"
    compileSdk = Apps.compileSdk
    defaultConfig {
        minSdk = Apps.minSdk
        targetSdk = Apps.targetSdk
        buildConfigField("String", "ITUNES_URL", "\"https://itunes.apple.com\"")
    }
    buildFeatures{
        buildConfig = true
    }
    compileOptions {
        sourceCompatibility = Apps.sourceCompat
        targetCompatibility = Apps.targetCompat
    }
    kotlinOptions {
        jvmTarget = Apps.jvmTarget
    }
}

dependencies {
    kapt(Dependencies.Hilt.Kapt)
    kapt(Dependencies.Room.Compiler)
    implementation(project(Modules.Domain))
    implementation(Dependencies.Hilt.Android)
    implementation(Dependencies.Room.Core)
    implementation(Dependencies.Paging.Runtime)
    implementation(Dependencies.Kotlin.Coroutine)
    Dependencies.Network.forEach(::implementation)
}
