package com.pramod.apitest.api

import com.pramod.apitest.model.LoginResponse
import com.pramod.apitest.model.RegisterResponse
import com.pramod.apitest.utils.User
import retrofit2.Response
import retrofit2.http.*

interface ApiService {

    @GET("allusers")
    @Headers("Content-type:application/json")
    suspend fun getUser(): Response<User>

    @FormUrlEncoded
    @POST("createuser")
    suspend fun createUser(
        @Field("email") email: String, @Field("password") password: String,
        @Field("name") name: String, @Field("school") school: String
    ): Response<LoginResponse>


    @FormUrlEncoded
    @POST("userlogin")
    suspend fun login(
        @Field("email") email: String, @Field("password") password: String

    ): Response<RegisterResponse>



}