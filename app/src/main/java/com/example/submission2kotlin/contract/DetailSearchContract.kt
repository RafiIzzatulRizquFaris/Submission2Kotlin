package com.example.submission2kotlin.contract

import com.example.submission2kotlin.model.Event
import com.example.submission2kotlin.model.Team

interface DetailSearchContract {
    interface View{
        fun setDetailSearch(listEvent: List<Event>)
        fun setDetailTeamHome(listTeam: List<Team>)
        fun setDetailTeamAway(listTeam: List<Team>)
    }
    interface Presenter{
        fun getDetailSearch(id: String)
        fun getDetailTeamHome(id: String)
        fun getDetailTeamAway(id: String)
    }
}