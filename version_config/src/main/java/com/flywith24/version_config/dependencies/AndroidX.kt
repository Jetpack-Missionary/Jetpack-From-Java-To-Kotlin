package com.flywith24.version_config.dependencies

/**
 * @author Flywith24
 * @date   2020/1/13
 * time   14:09
 * description
 */
@Suppress("SpellCheckingInspection")
object AndroidX {
    const val appcompat = "androidx.appcompat:appcompat:1.3.0-alpha01"
    const val recyclerView = "androidx.recyclerview:recyclerview:1.2.0-alpha03"
    const val coreKtx = "androidx.core:core-ktx:1.2.0"
    const val activityKtx = "androidx.activity:activity-ktx:1.2.0-alpha04"
    const val constraintlayout = "androidx.constraintlayout:constraintlayout:1.1.3"
    const val cardview = "androidx.cardview:cardview:1.0.0"
    const val multidex = "androidx.multidex:multidex:2.0.0"
    const val legacy = "androidx.legacy:legacy-support-v4:1.0.0"
    const val paging = "androidx.paging:paging-runtime-ktx:2.1.2"
    const val viewpager = "androidx.viewpager:viewpager:1.0.0"


    object Fragment {
        private const val fragment_version = "1.3.0-alpha05"
        const val fragment = "androidx.fragment:fragment:$fragment_version"
        const val fragmentKtx = "androidx.fragment:fragment-ktx:$fragment_version"
        const val fragmentTesting = "androidx.fragment:fragment-testing:$fragment_version"
    }


    object Lifecycle {
        private const val lifecycle_version = "2.2.0"
        const val liveDataKtx = "androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version"
        const val viewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version"
        const val viewModelSavedState = "androidx.lifecycle:lifecycle-viewmodel-savedstate:$lifecycle_version"
        const val commonJava8 = "androidx.lifecycle:lifecycle-common-java8:$lifecycle_version"
        const val service = "androidx.lifecycle:lifecycle-service:$lifecycle_version"
    }
    

    object Navigation {
        private const val navigation_version = "2.1.0"
        const val fragmentKtx = "androidx.navigation:navigation-fragment-ktx:$navigation_version"
        const val uiKtx = "androidx.navigation:navigation-ui-ktx:$navigation_version"
    }


    object Room {
        private const val room_version = "2.2.5"
        const val roomRuntime = "androidx.room:room-runtime:$room_version"
        const val roomCompiler = "androidx.room:room-compiler:$room_version"
        const val roomKtx = "androidx.room:room-ktx:$room_version"
    }
}