package com.saraalves.rickandmorty.data.remote.api

import com.saraalves.rickandmorty.data.remote.model.response.location.LocationResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface GetAllLocationService {

    @GET("location")
    suspend fun getAllLocation(@Query("page") page: Int): LocationResponse
}