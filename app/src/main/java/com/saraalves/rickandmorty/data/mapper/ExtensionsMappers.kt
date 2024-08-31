package com.saraalves.rickandmorty.data.mapper

import com.saraalves.rickandmorty.data.remote.model.response.commom.InfoResponse
import com.saraalves.rickandmorty.data.remote.model.response.commom.OriginResponse
import com.saraalves.rickandmorty.data.remote.model.response.commom.ResultsLocationResponse
import com.saraalves.rickandmorty.data.remote.model.response.character.CharacterResponse
import com.saraalves.rickandmorty.data.remote.model.response.location.LocationResponse
import com.saraalves.rickandmorty.domain.model.response.commom.Info
import com.saraalves.rickandmorty.domain.model.response.location.AllLocation
import com.saraalves.rickandmorty.domain.model.response.commom.Origin
import com.saraalves.rickandmorty.domain.model.response.character.SingleCharacter
import com.saraalves.rickandmorty.domain.model.response.location.SingleLocation

fun OriginResponse.mapToOrigin(): Origin {
    return Origin(
        name = this.originName,
        url = this.originUrl
    )
}

fun LocationResponse.mapToLocation(): AllLocation {
    return AllLocation(
        infoLocation = infoLocation?.mapToInfo() ?: Info(0,0),
        results = results.mapToResults()
    )
}

fun InfoResponse.mapToInfo(): Info {
    return Info(
        count = this.count ?: 0,
        pages = this.pages ?: 0,
        next = this.next,
        prev = this.prev.orEmpty()
    )
}

private fun List<ResultsLocationResponse>.mapToResults(): List<SingleLocation> = map {
    SingleLocation(
        id = it.id,
        locationName = it.locationName,
        type = it.type,
        dimension = it.dimension,
        residents = it.residents,
        locationUrl = it.locationUrl,
        createdLocation = it.createdLocation
    )
}

fun List<CharacterResponse>.mapToListResults(): List<SingleCharacter> = map {
    SingleCharacter(
        id = it.id,
        name = it.name,
        status = it.status,
        species = it.species,
        type = it.type,
        gender = it.gender,
        origin = it.origin?.mapToOrigin(),
        location = it.location?.mapToLocation(),
        image = it.image,
        episode = it.episode,
        url = it.url,
        created = it.created
    )
}