package com.saraalves.rickandmorty.data.remote.datasource.episodes

import com.saraalves.rickandmorty.data.extensions.parseHttpError
import com.saraalves.rickandmorty.data.mapper.episodes.AllEpisodeResponseToModelMapper
import com.saraalves.rickandmorty.data.remote.api.GetAllEpisodesService
import com.saraalves.rickandmorty.domain.model.response.episodes.AllEpisodes
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class EpisodesRemoteDataSourceImpl(
    private val episodesService: GetAllEpisodesService,
    private val allEpisodesMapper: AllEpisodeResponseToModelMapper,
) : EpisodesRemoteDataSource {
    override fun getAllEpisodes(page: Int): Flow<AllEpisodes> {
        return flow {
            emit(allEpisodesMapper.map(episodesService.getAllEpisode(page)))
        }.parseHttpError()
    }
}