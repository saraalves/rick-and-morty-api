package com.saraalves.rickandmorty.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.saraalves.rickandmorty.domain.model.response.character.AllCharacters

@Dao
interface CharacterDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveCharacters(characters: AllCharacters)
    
}