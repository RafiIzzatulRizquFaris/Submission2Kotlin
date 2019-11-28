package com.example.submission2kotlin.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DetailLeague(
    val idLeague: String?,
    val nameLeague: String?,
    val countryLeague: String?,
    val websiteLeague: String?,
    val facebookLeague: String?,
    val twitterLeague: String?,
    val youtubeLeague: String?,
    val descLeague: String?
) : Parcelable