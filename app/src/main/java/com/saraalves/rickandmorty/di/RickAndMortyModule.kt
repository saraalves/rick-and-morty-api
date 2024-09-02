package com.saraalves.rickandmorty.di

import androidx.room.Room
import com.saraalves.rickandmorty.data.mapper.character.AllCharacterResponseToModelMapper
import com.saraalves.rickandmorty.data.remote.datasource.character.CharacterRemoteDataSource
import com.saraalves.rickandmorty.data.remote.datasource.character.CharacterRemoteDataSourceImpl
import com.google.gson.GsonBuilder
import com.saraalves.rickandmorty.data.local.AppDatabase
import com.saraalves.rickandmorty.data.local.CharacterLocalDataSource
import com.saraalves.rickandmorty.data.local.CharacterLocalDataSourceImpl
import com.saraalves.rickandmorty.data.mapper.episodes.AllEpisodeResponseToModelMapper
import com.saraalves.rickandmorty.data.mapper.location.AllLocationMapperResponseToModelMapper
import com.saraalves.rickandmorty.data.remote.api.GetAllCharactersService
import com.saraalves.rickandmorty.data.remote.api.GetAllEpisodesService
import com.saraalves.rickandmorty.data.remote.api.GetAllLocationService
import com.saraalves.rickandmorty.data.remote.datasource.episodes.EpisodesRemoteDataSource
import com.saraalves.rickandmorty.data.remote.datasource.episodes.EpisodesRemoteDataSourceImpl
import com.saraalves.rickandmorty.data.remote.datasource.location.LocationRemoteDataSource
import com.saraalves.rickandmorty.data.remote.datasource.location.LocationRemoteDataSourceImpl
import com.saraalves.rickandmorty.data.repository.character.CharacterRepositoryImpl
import com.saraalves.rickandmorty.data.repository.episodes.EpisodesRepositoryImpl
import com.saraalves.rickandmorty.data.repository.location.LocationRepositoryImpl
import com.saraalves.rickandmorty.domain.repository.character.CharacterRepository
import com.saraalves.rickandmorty.domain.repository.episodes.EpisodesRepository
import com.saraalves.rickandmorty.domain.repository.location.LocationRepository
import com.saraalves.rickandmorty.domain.usecase.character.GetAllCharacterUseCase
import com.saraalves.rickandmorty.domain.usecase.episodes.GetAllEpisodesUseCase
import com.saraalves.rickandmorty.domain.usecase.location.GetLocationUseCase
import com.saraalves.rickandmorty.presentation.character.viewmodel.CharacterViewModel
import com.saraalves.rickandmorty.presentation.episodes.EpisodesViewModel
import com.saraalves.rickandmorty.presentation.location.LocationViewModel
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// alterar os nomes pra ficar generico
//remover os get() e colocar os nomes das dependencias

val dataBaseModule = module {
    single { Room.databaseBuilder(get(), AppDatabase::class.java, "database").build() }
    single { get<AppDatabase>().characterDao() }
}

val chracterViewModel = module {
    viewModel { CharacterViewModel(get()) }
    viewModel { EpisodesViewModel(get()) }
    viewModel { LocationViewModel(get()) }
}

val characterUseCaseModule = module {
    single { GetAllCharacterUseCase(get()) }
    single { GetAllEpisodesUseCase(get()) }
    single { GetLocationUseCase(get()) }
}

val mapperModule = module {
    single { AllCharacterResponseToModelMapper() }
    single { AllEpisodeResponseToModelMapper() }
    single { AllLocationMapperResponseToModelMapper() }
}

val dataSourceModule = module {
    single<CharacterRemoteDataSource> {
        CharacterRemoteDataSourceImpl(
            characterService = get(),
            allCharacterMapper = get()
        )
    }
    single<EpisodesRemoteDataSource> {
        EpisodesRemoteDataSourceImpl(
            episodesService = get(),
            allEpisodesMapper = get(),
        )
    }
    single<LocationRemoteDataSource> {
        LocationRemoteDataSourceImpl(
            locationApi = get(),
            allLocationMapper = get(),
        )
    }
    single<CharacterLocalDataSource> { CharacterLocalDataSourceImpl(get(), get()) }
}

val repositoryModule = module {
    single<CharacterRepository> { CharacterRepositoryImpl(get()) }
    single<EpisodesRepository> { EpisodesRepositoryImpl(get()) }
    single<LocationRepository> { LocationRepositoryImpl(get()) }
}
val networkModule = module {
    factory { createRetrofit().create(GetAllCharactersService::class.java) }
    factory { createRetrofit().create(GetAllEpisodesService::class.java) }
    factory { createRetrofit().create(GetAllLocationService::class.java) }
}
private fun createRetrofit(): Retrofit {
    val url = "https://rickandmortyapi.com/api/"
    val okHttp = OkHttpClient.Builder().build()
    val gson = GsonBuilder().create()
    return Retrofit.Builder()
        .baseUrl(url)
        .client(okHttp)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()
}