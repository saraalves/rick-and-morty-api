package com.saraalves.rickandmorty.domain.usecase.character

import com.saraalves.rickandmorty.domain.model.response.character.AllCharacters
import com.saraalves.rickandmorty.domain.repository.character.CharacterRepository
import kotlinx.coroutines.flow.Flow

class GetAllCharacterUseCase(private val repository: CharacterRepository) {
    operator fun invoke(page: Int): Flow<AllCharacters> = repository.getAllCharacters(page)
}