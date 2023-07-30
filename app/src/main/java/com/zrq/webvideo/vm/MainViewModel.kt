package com.zrq.webvideo.vm

import androidx.lifecycle.ViewModel
import com.zrq.webvideo.entity.VideoItem

class MainModel : ViewModel() {
    var onBackPress: () -> Boolean = { true }
}