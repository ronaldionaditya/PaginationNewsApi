package com.mobile.paginationnewsapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.mobile.paginationnewsapi.Adapter.NewsListAdapter
import com.mobile.paginationnewsapi.viewModel.NewsViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var viewModel : NewsViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(NewsViewModel::class.java)

        viewModel?.getArticle()?.observe(this, Observer {
            val adapter = NewsListAdapter()
            adapter.submitList(it)
            listNews.adapter = adapter
        })

    }
}