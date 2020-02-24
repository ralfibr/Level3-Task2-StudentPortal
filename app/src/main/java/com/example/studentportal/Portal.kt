package com.example.studentportal
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Data clas for the Portal
 */
@Parcelize
data class Portal (
    var title: String,
    var url: String
) : Parcelable