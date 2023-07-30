package com.zrq.webvideo.entity

data class VideoItem(
    val title: String,
    val path: String,
    val cover: String,
    val preview: String,
    val up: String,
    val duration: String,
    var isPlayer : Boolean = false
)