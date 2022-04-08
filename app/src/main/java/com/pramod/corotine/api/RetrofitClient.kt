package com.pramod.corotine.api

import com.pramod.corotine.api.Url.BASE_URL.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

  object  RetrofitClient {
     // companion object {


          fun getInstance(): Retrofit {
              return Retrofit.Builder()
                  .baseUrl(BASE_URL)
                  .addConverterFactory(GsonConverterFactory.create())
                  .build()

          }
      }
 // }
