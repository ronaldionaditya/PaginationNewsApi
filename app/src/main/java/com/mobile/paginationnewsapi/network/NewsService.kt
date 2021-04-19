package com.mobile.paginationnewsapi.network

import com.mobile.paginationnewsapi.model.ResponseServer
import io.reactivex.rxjava3.core.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {

    @GET("everything")
    fun getNews(@Query("q") keyword: String,
                @Query("apiKey") api: String,
                @Query("page") page: Long,
                @Query("pageSize") pageSize: Int) : Flowable<ResponseServer>
}