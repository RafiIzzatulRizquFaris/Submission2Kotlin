package com.example.submission2kotlin.activity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.submission2kotlin.R
import com.example.submission2kotlin.adapter.AdapterNextEvent
import com.example.submission2kotlin.contract.SearchMatchContract
import com.example.submission2kotlin.gone
import com.example.submission2kotlin.model.Event
import com.example.submission2kotlin.presenter.SearchMatchPresenter
import kotlinx.android.synthetic.main.activity_search_event.*
import org.jetbrains.anko.startActivity

class SearchEventActivity : AppCompatActivity(), SearchMatchContract.View {

    private lateinit var mPresenter: SearchMatchPresenter
    private var matchLists: MutableList<Event> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_event)
        mPresenter = SearchMatchPresenter(this)
        val strQuery = intent?.getStringExtra("query_event")
        supportActionBar!!.title = strQuery
        rv_search_match.layoutManager = LinearLayoutManager(this)
        rv_search_match.setHasFixedSize(true)
        rv_search_match.adapter = AdapterNextEvent(applicationContext!!, matchLists) {
            startActivity<DetailEventActivity>("Detail" to it)
        }
        mPresenter.getSearchMatch(strQuery!!)
        Toast.makeText(this, strQuery, Toast.LENGTH_LONG).show()
    }

    override fun setSearchMatch(matchList: List<Event>) {
        if (matchList.isNotEmpty()) {
            matchLists.clear()
            matchLists.addAll(matchList)
            rv_search_match.adapter!!.notifyDataSetChanged()
            pg_search_match.gone()
        } else Toast.makeText(applicationContext, "List is not Empty", Toast.LENGTH_LONG).show()
    }
}
