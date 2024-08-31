package com.saraalves.rickandmorty.domain.model.response.commom

data class Info(
    val count: Int,
    val pages: Int,
    val next: String? = null,
    val prev: String? = null
)
