package com.example.tasty_advisor.models


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Step(
    @SerializedName("number")
    val number: Int,
    @SerializedName("step")
    val step: String
): Parcelable