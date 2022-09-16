package com.pramod.apitest.utils


import com.google.gson.annotations.SerializedName

data class UserX(
    @SerializedName("email")
    var email: String?,
    @SerializedName("id")
    var id: Int?,
    @SerializedName("name")
    var name: String?,
    @SerializedName("school")
    var school: String?
)