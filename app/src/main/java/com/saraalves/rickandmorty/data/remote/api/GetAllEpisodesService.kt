package com.saraalves.rickandmorty.data.remote.api

import com.saraalves.rickandmorty.data.remote.model.response.episodes.AllEpisodesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface GetAllEpisodesService {
    @GET("episode")
    suspend fun getAllEpisode(@Query("page") page: Int): AllEpisodesResponse
}