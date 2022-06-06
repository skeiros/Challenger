package com.example.challenger.data


import com.example.challenger.interfaces.GitAppInterface


class GitDataSet(private val retrofitService: GitAppInterface) {
    val page=1
    val per_page=10
    val language="kotlin"
    //private var listData  = listOf<Item>();

    fun getAllGit() = retrofitService.getData(page,per_page,language)

}