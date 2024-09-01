package com.saraalves.rickandmorty.data.mapper.location

import com.saraalves.rickandmorty.data.mapper.Mapper
import com.saraalves.rickandmorty.data.mapper.mapToInfo
import com.saraalves.rickandmorty.data.remote.model.response.commom.ResultsLocationResponse
import com.saraalves.rickandmorty.data.remote.model.response.location.LocationResponse
import com.saraalves.rickandmorty.domain.model.response.location.AllLocation
import com.saraalves.rickandmorty.domain.model.response.location.SingleLocation

class AllLocationMapperResponseToModelMapper : Mapper<LocationResponse, AllLocation> {
    override fun map(source: LocationResponse): AllLocation {
        return AllLocation(
            infoLocation = source.infoLocation?.mapToInfo(),
            results = source.results.mapToListResults()
        )
    }

    private fun List<ResultsLocationResponse>.mapToListResults(): List<SingleLocation> = map {
        SingleLocation(
            id =  it.id,
            locationName = it.locationName,
            type = it.type,
            dimension = it.dimension,
            residents = it.residents,
            locationUrl = it.locationUrl,
            createdLocation = it.createdLocation
        )
    }
}


