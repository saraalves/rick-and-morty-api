package com.saraalves.rickandmorty.domain.model.response.character

import com.saraalves.rickandmorty.domain.model.response.location.AllLocation
import com.saraalves.rickandmorty.domain.model.response.commom.Origin
// enxugar os atributos que não são usados
data class SingleCharacter(
    val id: Int? = null,
    val name: String? = null,
    val status: String? = null,
    val species: String? = null,
    val type: String? = null,
    val gender: String? = null,
    val origin: Origin? = null,
    val location: AllLocation? = null,
    val image: String? = null,
    val episode: List<String> = listOf(),
    val url: String? = null,
    val created: String? = null,
)