package com.saraalves.rickandmorty.data.mapper

interface Mapper<S, T> {
    fun map(source: S): T
}