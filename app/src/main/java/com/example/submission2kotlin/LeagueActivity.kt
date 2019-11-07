package com.example.submission2kotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
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
}
