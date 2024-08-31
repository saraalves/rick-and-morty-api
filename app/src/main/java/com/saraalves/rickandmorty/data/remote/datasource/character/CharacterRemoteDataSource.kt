package com.saraalves.rickandmorty.data.remote.datasource.character

import com.saraalves.rickandmorty.domain.model.response.character.AllCharacters
import com.saraalves.rickandmorty.domain.model.response.character.SingleCharacter
import kotlinx.coroutines.flow.Flow

interface CharacterRemoteDataSource {

    fun getAllCharacters(page: Int): Flow<AllCharacters>
}