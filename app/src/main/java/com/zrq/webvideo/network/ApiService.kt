package com.zrq.webvideo.network

import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

/**
 * @Description:
 * @author zhangruiqian
 * @date 2023/8/4 18:09
 */
interface ApiService {

    @FormUrlEncoded
    @POST("/video-comments/get-posts/top/75552647/0/0")
    fun loadComment(
        @FieldMap map: Map<String, @JvmSuppressWildcards Any?>
    ): String
}