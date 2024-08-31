package com.saraalves.rickandmorty.data.remote.model.response.commom

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class OriginResponse(
    @SerialName("name") val originName: String? = null,
    @SerialName("url") val originUrl: String? = null
)