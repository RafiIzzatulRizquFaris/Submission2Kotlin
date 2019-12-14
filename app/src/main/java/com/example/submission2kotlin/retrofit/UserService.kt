package com.example.submission2kotlin.retrofit

import com.example.submission2kotlin.model.Events
import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface UserService {
    @GET("lookupleague.php")
    fun responseDetailLeague(
        @Query("id") id: Int
    ): Call<ResponseBody?>?

    @GET("eventspastleague.php")
    fun responsePastLeague(
        @Query("id") id: String
    ): Observable<Events>

    @GET("eventsnextleague.php")
    fun responseNextLeague(
        @Query("id") id: String
    ): Observable<Events>
}
