package com.saraalves.rickandmorty.data.remote.model.response.commom

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class InfoResponse(
    @SerialName("count") val count: Int? = null,
    @SerialName("pages") val pages: Int? = null,
    @SerialName("next") val next: String? = null,
    @SerialName("prev") val prev: String? = null,
)