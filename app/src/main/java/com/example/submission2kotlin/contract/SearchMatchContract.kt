package com.example.submission2kotlin.contract

import com.example.submission2kotlin.model.SearchEvent

interface SearchMatchContract {
    interface View {
        fun setSearchMatch(listMatch: List<SearchEvent>?)
    }

    interface Presenter {
        fun getSearchMatch(strQuery: String?)
    }
}