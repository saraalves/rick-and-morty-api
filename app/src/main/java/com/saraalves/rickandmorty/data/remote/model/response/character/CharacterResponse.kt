package com.saraalves.rickandmorty.data.remote.model.response.character

import com.saraalves.rickandmorty.data.remote.model.response.commom.OriginResponse
import com.saraalves.rickandmorty.data.remote.model.response.location.LocationResponse
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CharacterResponse(
    @SerialName("id") val id: Int? = null,
    @SerialName("name") val name: String? = null,
    @SerialName("status") val status: String? = null,
    @SerialName("species") val species: String? = null,
    @SerialName("type") val type: String? = null,
    @SerialName("gender") val gender: String? = null,
    @SerialName("origin") val origin: OriginResponse? = null,
    @SerialName("location") val location: LocationResponse? = null,
    @SerialName("image") val image: String? = null,
    @SerialName("episode") val episode: List<String> = listOf(),
    @SerialName("url") val url: String? = null,
    @SerialName("created") val created: String? = null,
)