package com.mobile.paginationnewsapi.dataSource

import androidx.paging.PageKeyedDataSource
import com.mobile.paginationnewsapi.model.ArticlesItem
import com.mobile.paginationnewsapi.network.NewsService
import com.mobile.paginationnewsapi.network.RestApi
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class NewsDataSource : PageKeyedDataSource<Long, ArticlesItem>() {

    var api : NewsService

    init {
        api = RestApi.restApi()
    }

    override fun loadInitial(
        params: LoadInitialParams<Long>,
        callback: LoadInitialCallback<Long, ArticlesItem>
    ) {
        api.getNews("Movie", "e34d7f63faef420b861e83bda168ba83", 1, params.requestedLoadSize)
            .observeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                t ->
                t.articles?.let { callback.onResult(it,null,2L) }
            },{})
    }

    override fun loadBefore(params: LoadParams<Long>, callback: LoadCallback<Long, ArticlesItem>) {
        TODO("Not yet implemented")
    }

    override fun loadAfter(params: LoadParams<Long>, callback: LoadCallback<Long, ArticlesItem>) {
        api.getNews("Movie", "e34d7f63faef420b861e83bda168ba83", params.key, params.requestedLoadSize)
            .observeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                    t ->
                t.articles?.let { callback.onResult(it,params.key + 1) }
            },{})
    }

}