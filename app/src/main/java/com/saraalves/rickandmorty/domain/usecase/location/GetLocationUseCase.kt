package com.saraalves.rickandmorty.domain.usecase.location

import com.saraalves.rickandmorty.domain.model.response.location.AllLocation
import com.saraalves.rickandmorty.domain.repository.location.LocationRepository
import kotlinx.coroutines.flow.Flow

class GetLocationUseCase(private val repository: LocationRepository) {
    operator fun invoke(page: Int): Flow<AllLocation> = repository.getAllLocation(page)
}