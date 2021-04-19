package com.mobile.paginationnewsapi.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.mobile.paginationnewsapi.dataSource.factory.NewsDataFactory
import com.mobile.paginationnewsapi.model.ArticlesItem
import java.util.concurrent.Executor
import java.util.concurrent.Executors

class NewsViewModel : ViewModel() {

    var executor : Executor
    var articleData : LiveData<PagedList<ArticlesItem>>

    init {
        executor = Executors.newFixedThreadPool(5)

        var newsFactory = NewsDataFactory()

        var pageListConfig = PagedList.Config.Builder()
            .setPageSize(20)
            .setInitialLoadSizeHint(10)
            .setEnablePlaceholders(false)
            .build()

        articleData = LivePagedListBuilder(newsFactory, pageListConfig)
                .setFetchExecutor(executor)
                .build()
    }

    fun getArticle() : LiveData<PagedList<ArticlesItem>> {
        return articleData
    }


}