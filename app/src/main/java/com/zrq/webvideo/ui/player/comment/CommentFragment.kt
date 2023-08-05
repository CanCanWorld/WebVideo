package com.zrq.webvideo.ui.player.comment

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.zrq.webvideo.base.BaseVmFragment
import com.zrq.webvideo.databinding.FragmentCommentBinding

class CommentFragment : BaseVmFragment<FragmentCommentBinding, CommentViewModel>() {
    override fun providedViewBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentCommentBinding {
        return FragmentCommentBinding.inflate(inflater, container, false)
    }

    override fun providedViewModel(): Class<CommentViewModel> {
        return CommentViewModel::class.java
    }

    override fun initViewModel(): Context {
        return requireActivity()
    }


    override fun initData() {
        viewModel.loadComment()
    }

    override fun initEvent() {
    }


}
