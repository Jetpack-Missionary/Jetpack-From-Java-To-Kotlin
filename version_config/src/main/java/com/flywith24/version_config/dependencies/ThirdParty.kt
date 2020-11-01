@file:Suppress("SpellCheckingInspection")

package com.flywith24.version_config.dependencies

/**
 * @author Flywith24
 * @date   2020/5/28
 * time   9:43
 * description
 * third party dependencies
 */
object ThirdParty {
    const val materialiconlib = "net.steamcrafted:materialiconlib:1.1.5"
    const val permission = "com.yanzhenjie.permission:x:2.0.1"

    object Glide {
        private const val glide_version = "4.11.0"
        const val glide = "com.github.bumptech.glide:glide:$glide_version"
        const val compiler = "com.github.bumptech.glide:compiler:$glide_version"
    }

    object Archi {
        const val unPeekLiveData = "com.kunminx.archi:unpeek-livedata:4.4.1-beta1"
    }

    const val roundedImageView = "com.makeramen:roundedimageview:2.3.0"

}