package com.saraalves.rickandmorty.domain.model.response.episodes

import com.saraalves.rickandmorty.domain.model.response.commom.Info

data class AllEpisodes(
    val info: Info,
    val results: List<SingleEpisode> = listOf()
)