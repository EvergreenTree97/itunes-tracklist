package com.sangrok.data.search.dto

data class SearchResponse(
    val resultCount: Int,
    val results: List<SearchResultData>,
)