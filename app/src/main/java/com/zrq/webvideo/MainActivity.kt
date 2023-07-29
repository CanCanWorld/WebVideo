package com.zrq.webvideo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import org.jsoup.Jsoup
import org.jsoup.select.Elements
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        Thread {
//            val doc = Jsoup.connect("https://xvideos.com").get()
//            val elements = doc.getElementsByClass("thumb-under")
//            elements.forEach {
//                val titleTag = it.getElementsByClass("title")[0].getElementsByClass("title")[0].getElementsByTag("a")[0]
//                val title = titleTag.attr("title")
//                val path = titleTag.attr("href")
//                Log.d(TAG, "title: $title")
//                Log.d(TAG, "path: $path")
//            }
//        }.start()

        Thread {
            val doc = Jsoup.connect("https://xvideos.com/video77645253/31292067/0/pervert_uncle_stays_alone_with_a_family_member_-_after8teen").get()
            val element = doc.getElementsByTag("script")
            element.forEach {
                if (it.toString().contains(".mp4", true)) {
                    val pattern = Pattern.compile("setVideoUrlHigh.*\'.*mp4.*\'")
                    val pattern2 = Pattern.compile("setVideoUrlLow.*\'.*mp4.*\'")
                    val matcher = pattern.matcher(it.toString())
                    val matcher2 = pattern2.matcher(it.toString())
                    while (matcher.find()) {
                        val high = matcher.group().replaceBefore("http", "").replace("'", "")
                        Log.d(TAG, "High: $high")

                    }
                    while (matcher2.find()) {
                        val low = matcher2.group().replaceBefore("http", "").replace("'", "")
                        Log.d(TAG, "Low: $low")
                    }
                }
            }
        }.start()
    }

    companion object {
        const val TAG = "MainActivity"
    }
}