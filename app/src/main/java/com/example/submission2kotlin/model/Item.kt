package com.example.submission2kotlin.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Item (
    val id: String?,
    val name: String?,
    val desc: String?,
    val image: Int?
) : Parcelable