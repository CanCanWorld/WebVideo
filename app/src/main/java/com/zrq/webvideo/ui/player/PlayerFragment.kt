package com.zrq.webvideo.ui.player

import android.view.LayoutInflater
import android.view.ViewGroup
import com.zrq.webvideo.base.BaseFragment
import com.zrq.webvideo.databinding.FragmentPlayerBinding

class PlayerFragment : BaseFragment<FragmentPlayerBinding>() {
    override fun providedViewBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentPlayerBinding {
        return FragmentPlayerBinding.inflate(layoutInflater, container, false)
    }

    override fun initData() {
    }



    override fun initEvent() {
    }

    companion object {
        const val TAG = "PlayerFragment"
    }

}