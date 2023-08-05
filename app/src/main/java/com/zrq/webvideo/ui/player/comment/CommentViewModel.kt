package com.zrq.webvideo.ui.player.comment

import android.util.Log
import com.zrq.webvideo.base.BaseViewModel

class CommentViewModel : BaseViewModel() {

    fun loadComment() {
        launch(
            block = {
                Log.d(TAG, "loadComment: 1")
                val map = HashMap<String, Any?>()
                map["load_all"] = 1
                val loadComment = apiService.loadComment(map)
                Log.d(TAG, "loadComment: $loadComment")
            }
        )
    }

    companion object {
        const val TAG = "CommentViewModel"
    }

}