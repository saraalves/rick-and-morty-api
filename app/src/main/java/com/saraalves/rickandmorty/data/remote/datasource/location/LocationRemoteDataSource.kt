package com.saraalves.rickandmorty.data.remote.datasource.location

import com.saraalves.rickandmorty.domain.model.response.location.AllLocation
import com.saraalves.rickandmorty.domain.model.response.location.SingleLocation
import kotlinx.coroutines.flow.Flow

interface LocationRemoteDataSource {

    fun getAllLocations(page: Int): Flow<AllLocation>
}