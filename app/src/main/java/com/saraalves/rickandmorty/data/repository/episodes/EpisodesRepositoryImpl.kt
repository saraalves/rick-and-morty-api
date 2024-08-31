package com.saraalves.rickandmorty.data.repository.episodes

import com.saraalves.rickandmorty.data.remote.datasource.episodes.EpisodesRemoteDataSource
import com.saraalves.rickandmorty.domain.model.response.episodes.AllEpisodes
import com.saraalves.rickandmorty.domain.repository.episodes.EpisodesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class EpisodesRepositoryImpl(private val episodeRemoteDataSource: EpisodesRemoteDataSource) : EpisodesRepository {
    override fun getAllEpisodes(page: Int): Flow<AllEpisodes> = flow {
        getAllEpisodesData(page).collect {remoteList ->
            emit(remoteList)
        }
    }

    override fun getAllEpisodesData(page: Int): Flow<AllEpisodes> = episodeRemoteDataSource.getAllEpisodes(page)
}