package com.deepak.sample.emojicompatdownload

import android.os.Bundle
import android.support.text.emoji.EmojiCompat
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import org.apache.commons.lang3.StringEscapeUtils


class MainActivity : AppCompatActivity() {

    // [U+1F469] (WOMAN) + [U+200D] (ZERO WIDTH JOINER) + [U+1F4BB] (PERSONAL COMPUTER)
    private val WOMAN_TECHNOLOGIST = "\uD83D\uDC69\u200D\uD83D\uDCBB"
    // [U+1F469] (WOMAN) + [U+200D] (ZERO WIDTH JOINER) + [U+1F3A4] (MICROPHONE)
    private val WOMAN_SINGER = "\uD83D\uDC69\u200D\uD83C\uDFA4"

    private val emojiContent: String = WOMAN_TECHNOLOGIST + " " + WOMAN_SINGER

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView2.text = StringEscapeUtils.unescapeJava(emojiContent)

        EmojiCompat.get().registerInitCallback(object : EmojiCompat.InitCallback() {
            override fun onInitialized() {
                super.onInitialized()
                println("EmojiCompat initialized successfully")
                val processed = EmojiCompat.get().process(emojiContent)
                textView4.text = processed
            }

            override fun onFailed(throwable: Throwable?) {
                super.onFailed(throwable)
                Toast.makeText(this@MainActivity, throwable?.message ?: "", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
