package com.example.submission2kotlin

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

interface UserService {
    @FormUrlEncoded
    @POST("api/login")
    fun login(
        @Field("email") email: String?,
        @Field("password") password: String?
    ): Call<ResponseBody?>?

    @GET("api/matapelajaran")
    fun responBadan(): Call<ResponseBody?>?

    @GET("api/matapelajaran/detail")
    fun responseMapel(
        @Query("id") id: Int
    ): Call<ResponseBody?>?

    @GET("")
    fun responseDetailLeague(
        @Query("id") id: Int
    ): Call<ResponseBody?>?
}
