package com.saraalves.rickandmorty.data.remote.model.response.commom

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResultsLocationResponse(
    @SerialName("id") val id: Int? = null,
    @SerialName("name") val locationName: String? = null,
    @SerialName("type") val type: String? = null,
    @SerialName("dimension") val dimension: String? = null,
    @SerialName("residents") val residents: List<String> = listOf(),
    @SerialName("url") val locationUrl: String? = null,
    @SerialName("created") val createdLocation: String? = null,
)