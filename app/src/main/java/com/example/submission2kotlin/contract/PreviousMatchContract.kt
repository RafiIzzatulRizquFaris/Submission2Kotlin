package com.example.submission2kotlin.contract

import com.example.submission2kotlin.model.Event

interface PreviousMatchContract {
    interface View {
        fun setPreviousMatch(matchList: List<Event>)
    }

    interface Presenter {
        fun getPreviousMatch(league: String?)
    }
}