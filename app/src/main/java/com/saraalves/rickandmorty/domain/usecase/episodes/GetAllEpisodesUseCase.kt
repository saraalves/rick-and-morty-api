package com.saraalves.rickandmorty.domain.usecase.episodes

import com.saraalves.rickandmorty.domain.model.response.episodes.AllEpisodes
import com.saraalves.rickandmorty.domain.repository.episodes.EpisodesRepository
import kotlinx.coroutines.flow.Flow

class GetAllEpisodesUseCase(private val repository: EpisodesRepository) {

    operator fun invoke(page: Int): Flow<AllEpisodes> = repository.getAllEpisodes(page)
}