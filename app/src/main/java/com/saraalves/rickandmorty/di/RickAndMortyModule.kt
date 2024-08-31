package com.saraalves.rickandmorty.di

import com.saraalves.rickandmorty.data.mapper.character.AllCharacterResponseToModelMapper
import com.saraalves.rickandmorty.data.remote.datasource.character.CharacterRemoteDataSource
import com.saraalves.rickandmorty.data.remote.datasource.character.CharacterRemoteDataSourceImpl
import com.google.gson.GsonBuilder
import com.saraalves.rickandmorty.data.remote.api.GetAllCharactersService
import com.saraalves.rickandmorty.data.repository.CharacterRepositoryImpl
import com.saraalves.rickandmorty.domain.repository.character.CharacterRepository
import com.saraalves.rickandmorty.domain.usecase.character.GetAllCharacterUseCase
import com.saraalves.rickandmorty.presentation.character.viewmodel.CharacterViewModel
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// alterar os nomes pra ficar generico
//remover os get() e colocar os nomes das dependencias

val chracterViewModel = module {
    viewModel { CharacterViewModel(get()) }
}

val characterUseCaseModule = module {
    single { GetAllCharacterUseCase(get()) }
}

val mapperModule = module {
    single { AllCharacterResponseToModelMapper() }
}

val dataSourceModule = module {
    single<CharacterRemoteDataSource> {
        CharacterRemoteDataSourceImpl(
            characterApi = get(),
            allCharacterMapper = get()
        )
    }
}
val repositoryModule = module {
    single<CharacterRepository> { CharacterRepositoryImpl(get()) }
}
val networkModule = module {
    factory { createRetrofit().create(GetAllCharactersService::class.java) }
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