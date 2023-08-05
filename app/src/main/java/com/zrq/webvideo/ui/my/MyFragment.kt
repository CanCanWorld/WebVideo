package com.zrq.webvideo.ui.my

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.zrq.webvideo.base.BaseVmFragment
import com.zrq.webvideo.databinding.FragmentMyBinding


class MyFragment : BaseVmFragment<FragmentMyBinding, MyViewModel>() {
    override fun providedViewBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentMyBinding {
        return FragmentMyBinding.inflate(layoutInflater)
    }

    override fun providedViewModel(): Class<MyViewModel> {
        return MyViewModel::class.java
    }

    override fun initViewModel(): Context {
        return requireActivity()
    }

    override fun initData() {

    }

    override fun initEvent() {

    }

}