package com.example.challenger.interfaces

import com.example.challenger.viewmodel.model.GitData
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
const val BASE_URL="https://api.github.com/search/";//URL API REST

interface GitAppInterface {
    @GET(value = "repositories")
  fun getData(
        @Query(value="page",encoded = true)page:Int,
        @Query(value="per_page",encoded = true)per_page:Int,
        @Query(value="q",encoded = true)q:String
    ): Call<GitData>
    companion object {
        var retrofitService: GitAppInterface? = null

        fun getInstance() : GitAppInterface {
            if (retrofitService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService = retrofit.create(GitAppInterface::class.java)
            }
            return retrofitService!!
        }
    }


 }