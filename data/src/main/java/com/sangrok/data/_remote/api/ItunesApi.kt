package com.sangrok.data._remote.api

import com.sangrok.data.search.dto.SearchResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ItunesApi {
    @GET("/search")
    suspend fun getSearchResults(
        @Query("term") term: String,
        @Query("entity") entity: String,
        @Query("offset") offset: Int,
        @Query("limit") limit: Int,
    ): SearchResponse
}