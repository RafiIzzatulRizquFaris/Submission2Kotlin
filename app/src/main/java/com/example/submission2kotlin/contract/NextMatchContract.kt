package com.example.submission2kotlin.contract

import com.example.submission2kotlin.model.Event

interface NextMatchContract {
    interface View {
        fun setNextMatch(matchList: List<Event>)
    }

    interface Presenter {
        fun getNextMatch(league: String?)
    }
}