package com.flywith24.version_config.dependencies

/**
 * @author Flywith24
 * @date   2020/1/13
 * time   14:09
 * description
 * AndroidX dependency
 * 不带 ktx 后缀的为 java 依赖，核心功能在此库
 * 带 ktx 后缀为 kotlin 依赖，提供很多方便的扩展函数, ktx 默认引入不带 ktx 的库
 *
 * 依赖关系参考 https://juejin.im/post/5e567ee1518825494466a938
 */
@Suppress("SpellCheckingInspection")
object AndroidX {
    const val appcompat = "androidx.appcompat:appcompat:1.3.0-alpha01"
    const val recyclerView = "androidx.recyclerview:recyclerview:1.2.0-alpha03"
    const val coreKtx = "androidx.core:core-ktx:1.2.0"
    const val activityKtx = "androidx.activity:activity-ktx:1.2.0-alpha04"
    const val constraintlayout = "androidx.constraintlayout:constraintlayout:2.0.0-beta6"
    const val cardview = "androidx.cardview:cardview:1.0.0"
    const val multidex = "androidx.multidex:multidex:2.0.0"
    const val legacy = "androidx.legacy:legacy-support-v4:1.0.0"
    const val viewpager = "androidx.viewpager:viewpager:1.0.0"
    const val viewpager2 = "androidx.viewpager2:viewpager2:1.0.0"


    object Fragment {
        private const val fragment_version = "1.3.0-alpha05"
        const val fragment = "androidx.fragment:fragment:$fragment_version"
        const val fragmentKtx = "androidx.fragment:fragment-ktx:$fragment_version"
        const val fragmentTesting = "androidx.fragment:fragment-testing:$fragment_version"
    }


    object Lifecycle {
        private const val lifecycle_version = "2.3.0-alpha07"
        const val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime:$lifecycle_version"

        const val viewModel = "androidx.lifecycle:lifecycle-viewmodel:$lifecycle_version"
        const val viewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version"

        const val liveData = "androidx.lifecycle:lifecycle-livedata:$lifecycle_version"
        const val liveDataKtx = "androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version"

        const val viewModelSavedState = "androidx.lifecycle:lifecycle-viewmodel-savedstate:$lifecycle_version"
        const val commonJava8 = "androidx.lifecycle:lifecycle-common-java8:$lifecycle_version"
        const val service = "androidx.lifecycle:lifecycle-service:$lifecycle_version"

        @Deprecated("lifecycle-extensions 已弃用,不要使用 ViewModelProviders.of 的方式")
        const val extensions = "androidx.lifecycle:lifecycle-extensions:2.2.0"
    }


    object Navigation {
        private const val nav_version = "2.3.0-rc01"

        // 无需直接引用
        const val runtime = "androidx.navigation:navigation-runtime:$nav_version"

        const val fragment = "androidx.navigation:navigation-fragment:$nav_version"
        const val fragmentKtx = "androidx.navigation:navigation-fragment-ktx:$nav_version"

        const val ui = "androidx.navigation:navigation-ui:$nav_version"
        const val uiKtx = "androidx.navigation:navigation-ui-ktx:$nav_version"

        // Dynamic Feature Module Support
        const val dynamic = "androidx.navigation:navigation-dynamic-features-fragment:$nav_version"

        // Testing Navigation
        const val testing = "androidx.navigation:navigation-testing:$nav_version"
    }


    object Room {
        private const val room_version = "2.2.5"
        const val roomRuntime = "androidx.room:room-runtime:$room_version"

        // for java use annotationProcessor , for kotlin use kapt
        const val roomCompiler = "androidx.room:room-compiler:$room_version"

        // optional - Kotlin Extensions and Coroutines support for Room
        const val roomKtx = "androidx.room:room-ktx:$room_version"

        // optional - RxJava support for Room
        const val roomrxjava2 = "androidx.room:room-rxjava2:$room_version"

        // optional - Guava support for Room, including Optional and ListenableFuture
        const val roomGuava = "androidx.room:room-guava:$room_version"

        // Test helpers
        const val roomTesting = "androidx.room:room-testing:$room_version"
    }

    object Paging {
        private const val paging_version = "2.1.2"
        const val pagingRuntime = "androidx.paging:paging-runtime:$paging_version"
        const val pagingRuntimeKtx = "androidx.paging:paging-runtime-ktx:$paging_version"

        // optional - RxJava support
        const val rxjava2 = "androidx.paging:paging-rxjava2:$paging_version"
        const val rxjava2Ktx = "androidx.paging:paging-rxjava2-ktx:$paging_version"

        // alternatively - without Android dependencies for testing
        const val testingCommon = "androidx.paging:paging-common:$paging_version"
        const val testingCommonKtx = "androidx.paging:paging-common-ktx:$paging_version"
    }
}