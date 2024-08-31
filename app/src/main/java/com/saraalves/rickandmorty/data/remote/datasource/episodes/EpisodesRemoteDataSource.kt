package com.saraalves.rickandmorty.data.remote.datasource.episodes

import com.saraalves.rickandmorty.domain.model.response.episodes.AllEpisodes
import kotlinx.coroutines.flow.Flow

interface EpisodesRemoteDataSource {

    fun getAllEpisodes(page: Int): Flow<AllEpisodes>

}