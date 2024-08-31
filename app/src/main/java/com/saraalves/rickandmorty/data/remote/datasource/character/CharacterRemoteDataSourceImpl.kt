package com.saraalves.rickandmorty.data.remote.datasource.character

import com.saraalves.rickandmorty.data.extensions.parseHttpError
import com.saraalves.rickandmorty.data.mapper.character.AllCharacterResponseToModelMapper
import com.saraalves.rickandmorty.data.remote.api.GetAllCharactersService
import com.saraalves.rickandmorty.domain.model.response.character.AllCharacters
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class CharacterRemoteDataSourceImpl(
    private val characterApi: GetAllCharactersService,
    private val allCharacterMapper: AllCharacterResponseToModelMapper,
) : CharacterRemoteDataSource {
    override fun getAllCharacters(page: Int): Flow<AllCharacters> {
        return flow {
            emit(allCharacterMapper.map(characterApi.getAllCharacters(page)))
        }.parseHttpError()
    }
}