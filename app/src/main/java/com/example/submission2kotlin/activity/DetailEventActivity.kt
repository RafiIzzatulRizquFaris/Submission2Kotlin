package com.example.submission2kotlin.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.submission2kotlin.R
import com.example.submission2kotlin.model.Event

class DetailEventActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_event)
        val event: Event? = intent.getParcelableExtra("detail_event")
        supportActionBar?.title = event!!.strEvent
    }
}
