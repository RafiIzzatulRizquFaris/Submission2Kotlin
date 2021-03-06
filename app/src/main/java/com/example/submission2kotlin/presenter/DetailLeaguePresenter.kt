package com.example.submission2kotlin.presenter

import android.util.Log
import com.example.submission2kotlin.contract.DetailLeagueContract
import com.example.submission2kotlin.retrofit.RetrofitClient
import com.example.submission2kotlin.retrofit.UserService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class DetailLeaguePresenter(val view: DetailLeagueContract.View): DetailLeagueContract.Presenter {
    override fun getDetailLeague(id: String) {
        val retrofit = RetrofitClient.getClient()
            .create(UserService::class.java)
        CompositeDisposable().add(
            retrofit.responseDetailLeague(id.toInt())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(
                    {
                        view.setDetailLeague(it.leagues)
                    }, { error -> Log.e("Error", error.message) }
                )
        )
    }
}