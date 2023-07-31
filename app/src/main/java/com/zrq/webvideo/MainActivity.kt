package com.zrq.webvideo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.zrq.webvideo.vm.MainModel
import org.jsoup.Jsoup
import org.jsoup.select.Elements
import xyz.doikki.videoplayer.exo.ExoMediaPlayerFactory
import xyz.doikki.videoplayer.player.VideoViewConfig
import xyz.doikki.videoplayer.player.VideoViewManager
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainModel = ViewModelProvider(this)[MainModel::class.java]
        VideoViewManager.setConfig(
            VideoViewConfig.newBuilder()
                .setPlayerFactory(ExoMediaPlayerFactory.create())
                .build()
        )
    }

    private lateinit var mainModel: MainModel

    override fun onBackPressed() {
        if (mainModel.onBackPress())
            super.onBackPressed()
    }

    companion object {
        const val TAG = "MainActivity"
    }
}