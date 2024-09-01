package com.saraalves.rickandmorty.presentation.character.fragment

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CharacterDetailArgs(
    val name: String,
    val status: String,
    val image: String
) : Parcelable
