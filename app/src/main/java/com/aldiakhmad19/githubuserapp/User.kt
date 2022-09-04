package com.aldiakhmad19.githubuserapp

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    var avatar:Int,
    var name:String,
    var username:String,
    var repository:String,
    var followers:String,
    var following: String,
    var bio:String,
    var company:String,
    var location:String,
):Parcelable
