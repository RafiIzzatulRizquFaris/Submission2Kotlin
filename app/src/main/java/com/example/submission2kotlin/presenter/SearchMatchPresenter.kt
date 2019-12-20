package com.example.submission2kotlin.presenter

import android.util.Log
import com.example.submission2kotlin.contract.SearchMatchContract
import com.example.submission2kotlin.retrofit.RetrofitClient
import com.example.submission2kotlin.retrofit.UserService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class SearchMatchPresenter(val view: SearchMatchContract.View) : SearchMatchContract.Presenter {
    override fun getSearchMatch(strQuery: String?) {
        Log.e("TAG", strQuery)
        val retrofit = RetrofitClient.getClient()
            .create(UserService::class.java)
        CompositeDisposable().add(
            retrofit.responseSearch(strQuery)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(
                    {
                        view.setSearchMatch(it.events)
                    }, { error -> Log.e("Error", error.message) }
                )
        )
    }
}