package com.saraalves.rickandmorty.domain.repository.location

import com.saraalves.rickandmorty.domain.model.response.location.AllLocation
import com.saraalves.rickandmorty.domain.model.response.location.SingleLocation
import kotlinx.coroutines.flow.Flow

interface LocationRepository {

    fun getAllLocation(page: Int): Flow<AllLocation>
    fun getAllLocationData(page: Int): Flow<AllLocation>
}