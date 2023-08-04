package com.zrq.webvideo.network

import retrofit2.Retrofit

/**
 * @Description:
 * @author zhangruiqian
 * @date 2023/8/4 18:13
 */
object RetrofitProvider {

    val retrofit : Retrofit by lazy {
        Retrofit.Builder()
            .build()
    }

}