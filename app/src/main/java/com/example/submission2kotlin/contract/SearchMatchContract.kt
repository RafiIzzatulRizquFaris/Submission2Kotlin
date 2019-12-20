package com.example.submission2kotlin.contract

import com.example.submission2kotlin.model.Event

interface SearchMatchContract {
    interface View {
        fun setSearchMatch(matchList: List<Event>)
    }

    interface Presenter {
        fun getSearchMatch(strQuery: String?)
    }
}