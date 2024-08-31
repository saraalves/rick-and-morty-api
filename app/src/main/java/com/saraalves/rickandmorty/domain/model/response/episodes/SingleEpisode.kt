package com.saraalves.rickandmorty.domain.model.response.episodes

// enxugar os atributos que não são usados
data class SingleEpisode(
    val id: Int? = null,
    val name: String? = null,
    val airDate: String? = null,
    val episode: String? = null,
    val characters: List<String> = listOf(),
    val url: String? = null,
    val created: String? = null


)
