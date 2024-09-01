package com.saraalves.rickandmorty.data.repository.location

import com.saraalves.rickandmorty.data.remote.datasource.location.LocationRemoteDataSource
import com.saraalves.rickandmorty.domain.model.response.location.AllLocation
import com.saraalves.rickandmorty.domain.model.response.location.SingleLocation
import com.saraalves.rickandmorty.domain.repository.location.LocationRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class LocationRepositoryImpl(private val locationRemoteDataSource: LocationRemoteDataSource) :
    LocationRepository {
    override fun getAllLocation(page: Int): Flow<AllLocation> = flow {
        getAllLocationData(page).collect{ remoteList ->
            emit(remoteList)
        }
    }

    override fun getAllLocationData(page: Int): Flow<AllLocation> =
        locationRemoteDataSource.getAllLocations(page)
}