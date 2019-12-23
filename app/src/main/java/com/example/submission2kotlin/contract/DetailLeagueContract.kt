package com.example.submission2kotlin.contract

import com.example.submission2kotlin.model.League

interface DetailLeagueContract {
    interface View{
        fun setDetailLeague(listLeague: List<League>)
    }

    interface Presenter {
        fun getDetailLeague(id: String)
    }
}