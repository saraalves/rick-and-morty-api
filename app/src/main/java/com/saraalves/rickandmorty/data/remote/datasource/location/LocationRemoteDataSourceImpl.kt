package com.saraalves.rickandmorty.data.remote.datasource.location

import com.saraalves.rickandmorty.data.extensions.parseHttpError
import com.saraalves.rickandmorty.data.mapper.location.AllLocationMapperResponseToModelMapper
import com.saraalves.rickandmorty.data.remote.api.GetAllLocationService
import com.saraalves.rickandmorty.domain.model.response.location.AllLocation
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class LocationRemoteDataSourceImpl(
    private val locationApi: GetAllLocationService,
    private val allLocationMapper: AllLocationMapperResponseToModelMapper,
) : LocationRemoteDataSource {
    override fun getAllLocations(page: Int): Flow<AllLocation> {
        return flow { emit(allLocationMapper.map(locationApi.getAllLocation(page))) }.parseHttpError()
    }
}