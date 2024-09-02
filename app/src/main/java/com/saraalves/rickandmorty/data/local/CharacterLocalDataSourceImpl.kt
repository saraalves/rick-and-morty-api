package com.saraalves.rickandmorty.data.local

import com.saraalves.rickandmorty.data.mapper.character.AllCharacterResponseToModelMapper
import com.saraalves.rickandmorty.domain.model.response.character.AllCharacters

class CharacterLocalDataSourceImpl(
    private val characterDao: CharacterDao,
    private val mapper: AllCharacterResponseToModelMapper
) : CharacterLocalDataSource {
    override suspend fun saveCharacter(character: AllCharacters) {
        TODO("Not yet implemented")
    }

    override fun getCharacter(): AllCharacters {
        TODO("Not yet implemented")
    }

    override fun deleteCharacter(id: String) {
        TODO("Not yet implemented")
    }

    override fun deleteCharacter() {
        TODO("Not yet implemented")
    }

}