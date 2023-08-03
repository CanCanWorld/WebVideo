package com.zrq.webvideo.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import com.zrq.webvideo.base.BaseFragment
import com.zrq.webvideo.databinding.FragmentCommentBinding

class CommentFragment : BaseFragment<FragmentCommentBinding>() {
    override fun providedViewBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentCommentBinding {
        return FragmentCommentBinding.inflate(inflater, container, false)
    }


    override fun initData() {
    }

    override fun initEvent() {
    }


}
