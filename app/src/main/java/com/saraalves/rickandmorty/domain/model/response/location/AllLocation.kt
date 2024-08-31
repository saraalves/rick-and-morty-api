package com.saraalves.rickandmorty.domain.model.response.location

import com.saraalves.rickandmorty.domain.model.response.commom.Info


data class AllLocation(
    val infoLocation: Info? = null,
    val results: List<SingleLocation> = listOf(),
)
