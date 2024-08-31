package com.saraalves.rickandmorty.data.remote.model.response.episodes

import com.saraalves.rickandmorty.data.remote.model.response.commom.InfoResponse
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AllEpisodesResponse (
    @SerialName("info") val info: InfoResponse,
    @SerialName("results") val results: List<ResultsEpisodesResponse>
)