package com.saraalves.rickandmorty

import android.app.Application
import com.saraalves.rickandmorty.di.characterUseCaseModule
import com.saraalves.rickandmorty.di.chracterViewModel
import com.saraalves.rickandmorty.di.dataSourceModule
import com.saraalves.rickandmorty.di.mapperModule
import com.saraalves.rickandmorty.di.networkModule
import com.saraalves.rickandmorty.di.repositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class RickAndMortyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        val allModules = listOf(
            networkModule,
            chracterViewModel,
            characterUseCaseModule,
            mapperModule,
            dataSourceModule,
            repositoryModule
        )

        startKoin{
            androidContext(this@RickAndMortyApplication)
            modules(allModules)
        }
    }
}