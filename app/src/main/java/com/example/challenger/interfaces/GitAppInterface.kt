package com.example.challenger.interfaces

import com.example.challenger.data.GitData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GitAppInterface {
    @GET(value = "repositories")
  fun getData(
        @Query(value="page",encoded = true)page:Int,
        @Query(value="per_page",encoded = true)per_page:Int,
        @Query(value="q",encoded = true)q:String
    ): Call<GitData>
 }