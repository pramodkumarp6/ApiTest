package com.pramod.apitest.api

import com.pramod.apitest.api.Constants.BASE_URL.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

  object RetrofitClient {
      fun getInstance(): ApiService {
              return Retrofit.Builder()
                  .baseUrl(BASE_URL)
                // .addCallAdapterFactory(CoroutineCallAdapterFactory())
                  .addConverterFactory(GsonConverterFactory.create())
                  .build()
                  .create(ApiService::class.java)

          }
      }

