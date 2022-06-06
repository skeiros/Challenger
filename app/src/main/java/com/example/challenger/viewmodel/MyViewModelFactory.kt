/*
 * *
 * Created by Daniel Sequeiros on 5/6/22 20:12
 * Copyright (c) 2022. All rights reserved
 * Last modified 5/6/22 20:12
 * /
 */

package com.example.challenger.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.challenger.data.GitDataSet


class MyViewModelFactory constructor(private val repository: GitDataSet): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            MainViewModel(this.repository) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}