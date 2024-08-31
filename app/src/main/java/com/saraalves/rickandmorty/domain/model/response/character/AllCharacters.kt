package com.saraalves.rickandmorty.domain.model.response.character

import com.saraalves.rickandmorty.domain.model.response.commom.Info

data class AllCharacters(
    val info: Info,
    val results: List<SingleCharacter> = listOf()
)

