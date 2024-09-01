package com.saraalves.rickandmorty.data.api

import com.saraalves.rickandmorty.data.remote.api.GetAllCharactersService
import okhttp3.mockwebserver.MockWebServer
import org.junit.Before
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GetAllCharactersServiceTest {
    private lateinit var api: GetAllCharactersService
    private val mockWebServer = MockWebServer()

    @Before
    fun setup(){
        mockWebServer.start(3000)
        api = Retrofit.Builder()
            .baseUrl(mockWebServer.url(""))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GetAllCharactersService::class.java)
    }
}