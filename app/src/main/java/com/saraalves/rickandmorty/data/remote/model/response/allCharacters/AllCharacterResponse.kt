package com.saraalves.rickandmorty.data.remote.model.response.allCharacters

import com.saraalves.rickandmorty.data.remote.model.response.character.CharacterResponse
import com.saraalves.rickandmorty.data.remote.model.response.commom.InfoResponse
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AllCharacterResponse(
    @SerialName("info") val info: InfoResponse,
    @SerialName("results") val results: List<CharacterResponse>
)