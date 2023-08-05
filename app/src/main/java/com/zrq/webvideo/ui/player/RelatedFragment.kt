package com.zrq.webvideo.ui.player

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import com.zrq.webvideo.base.BaseFragment
import com.zrq.webvideo.databinding.FragmentRelatedBinding
import java.util.*

class RelatedFragment : BaseFragment<FragmentRelatedBinding>() {
    override fun providedViewBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentRelatedBinding {
        return FragmentRelatedBinding.inflate(inflater, container, false)
    }

    override fun initData() {


    }

    override fun initEvent() {
    }



    private fun initDetail() {
    }

    companion object {
        private const val TAG = "RelatedFragment"
    }
}
