package com.example.challenger.data

data class GitData(
    val incomplete_results: Boolean,
    val items: List<Item>,
    val total_count: Int
)