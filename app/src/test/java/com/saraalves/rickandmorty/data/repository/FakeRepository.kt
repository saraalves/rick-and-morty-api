package com.saraalves.rickandmorty.data.repository

import com.saraalves.rickandmorty.data.mapper.character.AllCharacterResponseToModelMapper
import com.saraalves.rickandmorty.domain.model.response.character.AllCharacters
import com.saraalves.rickandmorty.domain.repository.character.CharacterRepository
import kotlinx.coroutines.flow.Flow

class FakeRepository(
    private val characterMapper: AllCharacterResponseToModelMapper
) : CharacterRepository {

    override fun getAllCharacters(page: Int): Flow<AllCharacters> {
        TODO("Not yet implemented")
    }

    override fun getAllCharactersData(page: Int): Flow<AllCharacters> {
        TODO("Not yet implemented")
    }
}