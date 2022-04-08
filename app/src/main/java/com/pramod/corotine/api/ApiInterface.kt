package com.pramod.corotine.api

import com.pramod.corotine.model.RegisterResponse
import com.pramod.corotine.model.User
import retrofit2.Response
import retrofit2.http.*

interface ApiInterface {

    @GET("/posts")
    @Headers("Content-type:application/json")
     suspend fun getUser():Response<User>
     @FormUrlEncoded

     @POST("simple/public/createuser")
     suspend fun createUser(@Field("email")email: String, @Field("password")password: String,
                            @Field("name")name: String, @Field("school")school: String):Response<RegisterResponse>
}