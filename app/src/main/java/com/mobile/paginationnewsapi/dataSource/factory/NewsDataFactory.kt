package com.mobile.paginationnewsapi.dataSource.factory

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.mobile.paginationnewsapi.dataSource.NewsDataSource
import com.mobile.paginationnewsapi.model.ArticlesItem

class NewsDataFactory : DataSource.Factory<Long, ArticlesItem>() {

    var mutableLiveData : MutableLiveData<NewsDataSource>
    var newsDataSource : NewsDataSource

    init {
        mutableLiveData = MutableLiveData()
        newsDataSource = NewsDataSource()
    }

    override fun create(): DataSource<Long, ArticlesItem> {
        mutableLiveData.postValue(newsDataSource)
        return newsDataSource
    }

    @JvmName("getMutableLiveData1")
    fun getMutableLiveData(): MutableLiveData<NewsDataSource>{
        return mutableLiveData
    }
}