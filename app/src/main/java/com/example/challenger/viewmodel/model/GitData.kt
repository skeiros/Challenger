/*
 * *
 * Created by Daniel Sequeiros on 5/6/22 19:44
 * Copyright (c) 2022. All rights reserved
 * Last modified 5/6/22 19:44
 * /
 */

package com.example.challenger.viewmodel.model

data class GitData(
    val incomplete_results: Boolean,
    val items: List<Item>,
    val total_count: Int
)