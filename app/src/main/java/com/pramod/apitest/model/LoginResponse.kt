package com.pramod.apitest.model


import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("error")
    var error: Boolean?,
    @SerializedName("message")
    var message: String?,
    @SerializedName("user")
    var user: User?
)