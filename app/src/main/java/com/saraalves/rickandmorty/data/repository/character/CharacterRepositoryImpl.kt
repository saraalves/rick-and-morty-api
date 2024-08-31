package com.saraalves.rickandmorty.data.repository.character

import com.saraalves.rickandmorty.data.remote.datasource.character.CharacterRemoteDataSource
import com.saraalves.rickandmorty.domain.model.response.character.AllCharacters
import com.saraalves.rickandmorty.domain.model.response.character.SingleCharacter
import com.saraalves.rickandmorty.domain.repository.character.CharacterRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class CharacterRepositoryImpl(private val characterRemoteDataSource: CharacterRemoteDataSource) :
    CharacterRepository {
    override fun getAllCharacters(page: Int): Flow<AllCharacters> = flow {
        getAllCharactersData(page).collect { remoteList ->
            emit(remoteList)
        }
    }


    override fun getAllCharactersData(page: Int): Flow<AllCharacters> =
        characterRemoteDataSource.getAllCharacters(page)
}