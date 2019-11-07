package com.example.submission2kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.submission2kotlin.model.Item

class LeagueActivity : AppCompatActivity() {

    private val items: MutableList<Item> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)
        getData()
    }

    private fun getData(){
        val id = resources.getStringArray(R.array.league_id)
        val name = resources.getStringArray(R.array.league_name)
        val desc = resources.getStringArray(R.array.league_desc)
        val img = resources.obtainTypedArray(R.array.league_image)

        for (i in id.indices){
            items.add(Item(id[i], name[i], desc[i], img.getResourceId(i, 0)))
        }

        img.recycle()
    }
}
