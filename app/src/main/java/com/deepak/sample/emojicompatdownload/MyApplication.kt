package com.deepak.sample.emojicompatdownload

import android.app.Application
import android.graphics.Color
import android.support.text.emoji.EmojiCompat
import android.support.text.emoji.FontRequestEmojiCompatConfig
import android.support.v4.provider.FontRequest

/**
 * Created by root on 5/11/17.
 */
class MyApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        val fontRequest = FontRequest(
                "com.google.android.gms.fonts",
                "com.google.android.gms",
                "Noto Color Emoji Compat", R.array.com_google_android_gms_fonts_certs)
        val config = FontRequestEmojiCompatConfig(this, fontRequest)
        config.setEmojiSpanIndicatorEnabled(true)
        config.setEmojiSpanIndicatorColor(Color.YELLOW)
        // other config settings......
        EmojiCompat.init(config)
    }
}