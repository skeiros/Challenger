package com.example.challenger.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.challenger.data.GitData
import com.example.challenger.data.Item
import com.example.challenger.data.Owner
import com.example.challenger.interfaces.GitAppInterface
import com.example.challenger.ui.BASE_URL
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainViewModel:ViewModel() {

    private val page:Int=1
    private val per_page:Int=30
    private val language:String="kotlin"

    // TODO: Implement the ViewModel
     private val listData = MutableLiveData<List<Item>>()
    init {
        getGitData()
    }
    fun setListData(listaItem:List<Item>){
        listData.value=listaItem;
    }

    fun getListItemLiveData():LiveData<List<Item>>{
        return listData;
    }
    fun getDetail(position:Int):String{
        var detailItem: Item? =listData.value?.get(position)
        val myStringBuilder=StringBuilder()

        myStringBuilder.append("Name: "+detailItem?.name+"\n")
        myStringBuilder.append("Id: "+detailItem?.id+"\n")
        myStringBuilder.append("Url: "+detailItem?.url+"\n")
        myStringBuilder.append("license: "+detailItem?.license+"\n")
        myStringBuilder.append("Owner: "+detailItem?.owner?.login+"\n")
        myStringBuilder.append("language: "+detailItem?.language+"\n")
        myStringBuilder.append("Size: "+detailItem?.size+"\n")
        myStringBuilder.append("Score: "+detailItem?.score+"\n")

        return myStringBuilder.toString();
    }
    private fun getGitData() {
        val retrofitBuilder= Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(GitAppInterface::class.java)
        val retrofitData=retrofitBuilder.getData(page,per_page,language)
        with(retrofitData) {
            enqueue(object : Callback<GitData> {
                override fun onResponse(
                    call: Call<GitData>,
                    response: Response<GitData>
                ) {
                    val responseBody=response.body() !!
                    val myStringBuilder=StringBuilder()
                    myStringBuilder.append(responseBody.total_count.toString())
                    setListData(responseBody.items)
                }

                override fun onFailure(call: Call<GitData?>, t: Throwable) {
                    Log.d("msg",t.message.toString())
                }

            })
        }
    }



}