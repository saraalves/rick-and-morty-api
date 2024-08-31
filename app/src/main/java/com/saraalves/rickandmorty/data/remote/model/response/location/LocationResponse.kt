package com.saraalves.rickandmorty.data.remote.model.response.location

import com.saraalves.rickandmorty.data.remote.model.response.commom.InfoResponse
import com.saraalves.rickandmorty.data.remote.model.response.commom.ResultsLocationResponse
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LocationResponse(
    @SerialName("info") val infoLocation: InfoResponse? = null,
    @SerialName("results") val results: List<ResultsLocationResponse> = listOf(),
)