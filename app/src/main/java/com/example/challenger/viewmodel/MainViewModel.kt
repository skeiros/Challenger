package com.example.challenger.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.challenger.data.GitDataSet
import com.example.challenger.viewmodel.model.Item
import com.example.challenger.viewmodel.model.GitData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel constructor(private val repository: GitDataSet) :ViewModel() {

    val gitList = MutableLiveData<List<Item>>()
    val errorMessage = MutableLiveData<String>()

    fun getAllMovies() {
        val response = repository.getAllGit()
        response.enqueue(object : Callback<GitData> {
            override fun onFailure(call: Call<GitData>, t: Throwable) {
                errorMessage.postValue(t.message)
            }

            override fun onResponse(call: Call<GitData>, response: Response<GitData>) {
                gitList.postValue(response.body()?.items)
            }
        })
    }


}