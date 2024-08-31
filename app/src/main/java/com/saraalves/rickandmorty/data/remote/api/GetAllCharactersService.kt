package com.saraalves.rickandmorty.data.remote.api

import com.saraalves.rickandmorty.data.remote.model.response.allCharacters.AllCharacterResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface GetAllCharactersService {
    @GET("character")
    suspend fun getAllCharacters(@Query("page") page: Int): AllCharacterResponse


}