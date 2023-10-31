package com.example.tasty_advisor.models


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

@Parcelize
data class AnalyzedInstruction(
    @SerializedName("steps")
    val steps: @RawValue List<Step>
): Parcelable