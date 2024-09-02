package com.saraalves.rickandmorty.data.local

import com.saraalves.rickandmorty.domain.model.response.character.AllCharacters

interface CharacterLocalDataSource {
    suspend fun saveCharacter(character: AllCharacters)
    fun getCharacter(): AllCharacters
    fun deleteCharacter(id: String)
    fun deleteCharacter()
}