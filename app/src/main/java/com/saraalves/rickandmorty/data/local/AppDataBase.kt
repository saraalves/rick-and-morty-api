package com.saraalves.rickandmorty.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.saraalves.rickandmorty.data.remote.model.response.allCharacters.AllCharacterResponse

@Database(entities = [AllCharacterResponse::class], version = 1, exportSchema = false)
@TypeConverters(ListConverters::class)
abstract class AppDatabase: RoomDatabase() {
    abstract fun characterDao(): CharacterDao
}