package com.zrq.webvideo.ui.home

import android.content.Context
import com.zrq.webvideo.base.BaseVmActivity
import com.zrq.webvideo.databinding.ActivityHomeBinding

class HomeActivity : BaseVmActivity<ActivityHomeBinding, HomeViewModel>() {

    override fun initData() {
    }

    override fun initEvent() {
    }

    override fun providedViewModel(): Class<HomeViewModel> {
        return HomeViewModel::class.java
    }

    override fun initViewModel(): Context {
        return this
    }

    override fun providedViewBinding(): ActivityHomeBinding {
        return ActivityHomeBinding.inflate(layoutInflater)
    }

    companion object {
        const val TAG = "MainActivity"
    }
}