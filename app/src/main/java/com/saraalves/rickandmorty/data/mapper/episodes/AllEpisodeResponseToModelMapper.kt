package com.saraalves.rickandmorty.data.mapper.episodes

import com.saraalves.rickandmorty.data.mapper.Mapper
import com.saraalves.rickandmorty.data.mapper.mapToInfo
import com.saraalves.rickandmorty.data.remote.model.response.episodes.AllEpisodesResponse
import com.saraalves.rickandmorty.data.remote.model.response.episodes.ResultsEpisodesResponse
import com.saraalves.rickandmorty.domain.model.response.episodes.AllEpisodes
import com.saraalves.rickandmorty.domain.model.response.episodes.SingleEpisode

class AllEpisodeResponseToModelMapper : Mapper<AllEpisodesResponse, AllEpisodes> {
    override fun map(source: AllEpisodesResponse): AllEpisodes {
        return AllEpisodes(
            info = source.info.mapToInfo(),
            results = source.results.mapToListResults()
        )
    }

    private fun List<ResultsEpisodesResponse>.mapToListResults(): List<SingleEpisode> = map {
        SingleEpisode(
            id = it.id,
            name = it.name,
            airDate = it.airDate,
            episode = it.episode,
            characters = it.characters ?: emptyList(),
            url = it.url,
            created = it.created
        )
    }
}