package com.zrq.webvideo.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import com.bumptech.glide.Glide
import com.google.android.material.tabs.TabLayoutMediator
import com.zrq.webvideo.adapter.DetailAdapter
import com.zrq.webvideo.databinding.ActivityPlayerBinding
import org.jsoup.Jsoup
import xyz.doikki.videocontroller.StandardVideoController
import java.util.regex.Pattern

class PlayerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityPlayerBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        initData()
        initEvent()
    }

    private lateinit var mBinding: ActivityPlayerBinding
    private lateinit var detailAdapter: DetailAdapter

    private var title = ""
    private var path = ""
    private var cover = ""
    private var high = ""
    private var low = ""
    private var hls = ""
    private var isDestroy = false

    private fun initData() {
        title = intent.getStringExtra("title") ?: ""
        path = intent.getStringExtra("path") ?: ""
        cover = intent.getStringExtra("cover") ?: ""
        cover = intent.getStringExtra("cover") ?: ""
        val transition = intent.getStringExtra("transition") ?: ""
        detailAdapter = DetailAdapter(this)

        mBinding.apply {
            Glide.with(this@PlayerActivity)
                .load(cover)
                .into(ivCover)
            ivCover.transitionName = transition
            viewPager.offscreenPageLimit = 2
            viewPager.adapter = detailAdapter
            TabLayoutMediator(tabLayout, viewPager, true) { tab, position ->
                tab.text = if (position == 0) "简介" else "评论"
            }.attach()
        }
        loadVideo()
    }

    private fun initEvent() {
    }

    private fun loadVideo() {
        Thread {
            val doc = Jsoup.connect("https://xvideos.com$path").get()
            val element = doc.getElementsByTag("script")
            element.forEach {
                if (it.toString().contains(".mp4", true)) {
                    val pattern = Pattern.compile("setVideoUrlHigh.*\'.*mp4.*\'")
                    val pattern2 = Pattern.compile("setVideoUrlLow.*\'.*mp4.*\'")
                    val pattern3 = Pattern.compile("setVideoHLS.*\'.*m3u8.*\'")
                    val matcher = pattern.matcher(it.toString())
                    val matcher2 = pattern2.matcher(it.toString())
                    val matcher3 = pattern3.matcher(it.toString())
                    while (matcher.find()) {
                        high = matcher.group().replaceBefore("http", "").replace("'", "")
                        Log.d(TAG, "High: $high")

                    }
                    while (matcher2.find()) {
                        low = matcher2.group().replaceBefore("http", "").replace("'", "")
                        Log.d(TAG, "Low: $low")
                    }
                    while (matcher3.find()) {
                        hls = matcher3.group().replaceBefore("http", "").replace("'", "")
                        Log.d(TAG, "hls: $hls")
                    }
                    setVideoPath()
                }
            }
        }.start()
    }

    private fun setVideoPath() {
        if (isDestroy) {
            Log.d(TAG, "isDestroy: ")
            return
        }
        Handler(Looper.getMainLooper()).post {
            mBinding.apply {
                ivCover.visibility = View.GONE
                videoView.visibility = View.VISIBLE
                videoView.setUrl(hls)
                val controller = StandardVideoController(this@PlayerActivity)
                controller.addDefaultControlComponent(title, false)
                videoView.setVideoController(controller)
                videoView.start()
            }
        }
    }

    override fun onBackPressed() {
        val back = !mBinding.videoView.onBackPressed()
        if (back) {
            super.onBackPressed()
        }
    }

    override fun onResume() {
        super.onResume()
        isDestroy = false
        mBinding.videoView.resume()
    }

    override fun onPause() {
        super.onPause()
        mBinding.videoView.pause()
    }

    override fun onDestroy() {
        super.onDestroy()
        isDestroy = true
        mBinding.videoView.release()
    }

    companion object {
        const val TAG = "PlayerActivity"
    }
}