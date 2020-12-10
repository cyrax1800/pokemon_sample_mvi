object ApplicationId {
    const val id = "com.michael.pokemon.mvi.flow"
}

object Releases {
    const val versionCode = 1
    const val versionName = "1.0"

    const val buildToolsVersion = "29.0.3"
    const val compileSdkVersion = 29
    const val targetSdkVersion = 29
    const val minSdkVersion = 21
}

object Version {
    //common
    const val kotlin = "1.4.10"
    const val gradle = "4.1.1"
    const val material = "1.2.1"
    const val multiDex = "2.0.1"

    //androidx
    const val constraintLayout = "2.0.4"
    const val appCompat = "1.0.0"
    const val recyclerView = "1.0.0"
    const val swipeRefreshLayout = "1.1.0"

    //network
    const val retrofit = "2.6.0"
    const val rxretrofit = "2.4.0"
    const val okhttpLogging = "3.11.0"
    const val mockWebServer = "3.11.0"

    //thread
    const val coroutines = "1.4.2"
    const val coroutinesAdapter = "0.9.2"

    //media
    const val glide = "4.8.0"

    //data
    const val gson = "2.8.5"

    //jetpack
    const val archLifecycle = "2.0.0"
    const val ktx = "1.3.2"
    const val lifecycleKtx = "2.2.0"

    //di
    const val dagger = "2.21"

    //misc
    const val deeplink = "4.1.0"
    const val fastAdapter = "4.1.0"
    const val facebookShimmer = "0.5.0"
    const val gradleDependencyGraph = "0.6.0-SNAPSHOT"

    //testing
    const val jUnit = "4.12"
    const val testRunner = "1.1.0-alpha4"
    const val espresso = "3.1.1"
    const val mockito = "3.0.0"
    const val mockk = "1.9.3"
    const val mockTestRunner = "0.3.1"
    const val rules = "1.1.0"
    const val ext = "1.0.0"
    const val jacoco = "0.8.4"

    //debugging
    const val stetho = "1.5.1"
    const val fbFlipper = "0.32.2"
    const val soLoader = "0.8.2"
    const val leakCanary = "1.6.1"
}

object Android {
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Version.constraintLayout}"
    const val appCompat = "androidx.appcompat:appcompat:${Version.appCompat}"
    const val cardView = "androidx.cardview:cardview:${Version.appCompat}"
    const val recyclerView = "androidx.recyclerview:recyclerview:${Version.recyclerView}"
    const val swipeRefreshLayout = "androidx.swiperefreshlayout:swiperefreshlayout:${Version.swipeRefreshLayout}"
    const val gson = "com.google.code.gson:gson:${Version.gson}"
    const val design = "com.google.android.material:material:${Version.material}"
    const val multiDex = "androidx.multidex:multidex:${Version.multiDex}"
}

object Jetpack {
    const val lifecycle = "androidx.lifecycle:lifecycle-extensions:${Version.archLifecycle}"
    const val lifecycleCompiler = "androidx.lifecycle:lifecycle-compiler:${Version.archLifecycle}"
    val Ktx = KtxDeps

    object KtxDeps {
        const val core = "androidx.core:core-ktx:${Version.ktx}"
        const val lifecycle = "androidx.lifecycle:lifecycle-runtime-ktx:${Version.lifecycleKtx}"
    }
}

object Dependencies {
    const val kotlinGradle = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Version.kotlin}"
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Version.kotlin}"
    const val gradle = "com.android.tools.build:gradle:${Version.gradle}"
}

object Retrofit {
    const val mockWebServer = "com.squareup.okhttp3:mockwebserver:${Version.mockWebServer}"
    const val retrofit = "com.squareup.retrofit2:retrofit:${Version.retrofit}"
    const val gsonConverter = "com.squareup.retrofit2:converter-gson:${Version.retrofit}"
    const val scalarConverter = "com.squareup.retrofit2:converter-scalars:${Version.retrofit}"
    const val rxAdapter = "com.squareup.retrofit2:adapter-rxjava2:${Version.rxretrofit}"
    const val okHttpLogging = "com.squareup.okhttp3:logging-interceptor:${Version.okhttpLogging}"
    const val coroutinesAdapter =
        "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:${Version.coroutinesAdapter}"
    const val mock = "com.squareup.retrofit2:retrofit-mock:${Version.retrofit}"
}

object Coroutines {
    const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Version.coroutines}"
    const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Version.coroutines}"
    const val test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Version.coroutines}"
}

object Glide {
    const val glide = "com.github.bumptech.glide:glide:${Version.glide}"
    const val compiler = "com.github.bumptech.glide:compiler:${Version.glide}"
}

object Dagger {
    const val dagger = "com.google.dagger:dagger:${Version.dagger}"
    const val android = "com.google.dagger:dagger-android:${Version.dagger}"
    const val androidSupport = "com.google.dagger:dagger-android-support:${Version.dagger}"
    const val compiler = "com.google.dagger:dagger-compiler:${Version.dagger}"
    const val processor = "com.google.dagger:dagger-android-processor:${Version.dagger}"
}

object Testing {
    const val jUnit = "junit:junit:${Version.jUnit}"
    const val testRunner = "androidx.test:runner:${Version.testRunner}"
    const val espresso = "androidx.test.espresso:espresso-core:${Version.espresso}"
    const val coreTesting = "androidx.arch.core:core-testing:${Version.archLifecycle}"
    const val espressoContrib = "androidx.test.espresso:espresso-contrib:${Version.espresso}"
    const val espressoIdleResources =
        "androidx.test.espresso:espresso-idling-resource:${Version.espresso}"
    const val espressoIntent = "androidx.test.espresso:espresso-intents:${Version.espresso}"
    const val mockito = "org.mockito:mockito-inline:${Version.mockito}"
    const val mockKtRunner = "de.jodamob.kotlin:kotlin-runner-junit4:${Version.mockTestRunner}"
    const val mockk = "io.mockk:mockk:${Version.mockk}"
    const val mockkInstrument = "io.mockk:mockk-android:${Version.mockk}"
    const val androidX = "androidx.arch.core:core-testing:${Version.archLifecycle}"
    const val runner = "androidx.test:runner:${Version.rules}"
    const val rules = "androidx.test:rules:${Version.rules}"
    const val core = "androidx.test:core:${Version.rules}"
    const val jacoco = "org.jacoco:org.jacoco.core:${Version.jacoco}"

    const val extJunit = "androidx.test.ext:junit:${Version.ext}"
    const val extTruth = "androidx.test.ext:truth:${Version.ext}"
}

object FastAdapter {
    const val core = "com.mikepenz:fastadapter:${Version.fastAdapter}"
    const val scroll = "com.mikepenz:fastadapter-extensions-scroll:${Version.fastAdapter}"
    const val ui = "com.mikepenz:fastadapter-extensions-ui:${Version.fastAdapter}"
    const val diff = "com.mikepenz:fastadapter-extensions-diff:${Version.fastAdapter}"
}

object Debugging {
    const val fbFlipper = "com.facebook.flipper:flipper:${Version.fbFlipper}"
    const val fbFlipperNoop = "com.facebook.flipper:flipper-noop:${Version.fbFlipper}"
    const val fbFlipperNetwork = "com.facebook.flipper:flipper-network-plugin:${Version.fbFlipper}"
    const val soLoader = "com.facebook.soloader:soloader:${Version.soLoader}"
    const val fbFlipperLeakCanary =
        "com.facebook.flipper:flipper-leakcanary-plugin:${Version.fbFlipper}"
    const val leakCanary = "com.squareup.leakcanary:leakcanary-android:${Version.leakCanary}"
    const val leakCanaryNoop =
        "com.squareup.leakcanary:leakcanary-android-no-op:${Version.leakCanary}"
    const val stetho = "com.facebook.stetho:stetho:${Version.stetho}"
    const val stethoOkHttp = "com.facebook.stetho:stetho-okhttp3:${Version.stetho}"
}

object Misc {
    const val deeplink = "com.airbnb:deeplinkdispatch:${Version.deeplink}"
    const val deeplinkProcessor = "com.airbnb:deeplinkdispatch-processor:${Version.deeplink}"
    const val shimmer = "com.facebook.shimmer:shimmer:${Version.facebookShimmer}"
    const val gradleDependencyGraph =
        "com.vanniktech:gradle-dependency-graph-generator-plugin:${Version.gradleDependencyGraph}"
}