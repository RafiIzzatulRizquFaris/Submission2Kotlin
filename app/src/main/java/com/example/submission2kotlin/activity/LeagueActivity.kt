package com.example.submission2kotlin.activity

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.submission2kotlin.LeagueActivityUI
import com.example.submission2kotlin.R
import com.example.submission2kotlin.adapter.AdapterItem
import com.example.submission2kotlin.model.Item
import org.jetbrains.anko.setContentView
import org.jetbrains.anko.startActivity

class LeagueActivity : AppCompatActivity() {

    private lateinit var leagueActivityUI: LeagueActivityUI
    private val items: MutableList<Item> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        leagueActivityUI = LeagueActivityUI()
        leagueActivityUI.setContentView(this)
        getData()
        leagueActivityUI.recyclerView!!.layoutManager = LinearLayoutManager(this)
        leagueActivityUI.recyclerView!!.adapter = AdapterItem(this, items) {
            startActivity<DetailLeagueActivity>("detail" to it)
        }
    }

    private fun getData() {
        val id = resources.getStringArray(R.array.league_id)
        val name = resources.getStringArray(R.array.league_name)
        val desc = resources.getStringArray(R.array.league_desc)
        val img = resources.obtainTypedArray(R.array.league_image)

        for (i in id.indices) {
            items.add(Item(id[i], name[i], desc[i], img.getResourceId(i, 0)))
        }
        img.recycle()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val searchView = menu!!.findItem(R.id.search).actionView as SearchView
        searchView.setSearchableInfo(searchManager.getSearchableInfo(componentName))
        searchView.queryHint = resources.getString(R.string.query_hint)
        searchView.setOnQueryTextListener(object :
            SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                val intent = Intent(this@LeagueActivity, SearchEventActivity::class.java)
                intent.putExtra("query_league", query)
                startActivity(intent)
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean = false
        })
        return true
    }
}
