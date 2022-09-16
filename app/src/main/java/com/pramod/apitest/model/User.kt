package com.pramod.apitest.model


import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("email")
    var email: String?,
    @SerializedName("id")
    var id: Int?,
    @SerializedName("name")
    var name: String?,
    @SerializedName("school")
    var school: String?
)