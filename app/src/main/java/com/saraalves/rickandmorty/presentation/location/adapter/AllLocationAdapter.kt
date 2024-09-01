package com.saraalves.rickandmorty.presentation.location.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.saraalves.rickandmorty.domain.model.response.character.SingleCharacter
import com.saraalves.rickandmorty.domain.model.response.location.SingleLocation
import com.saraalves.rickandmorty.presentation.DefaultDiffCallback
import com.saraalves.rickandmorty.presentation.character.adapter.AllCharactersViewHolder

class AllLocationAdapter(
    private val clickListener: (SingleLocation) -> Unit
) : ListAdapter<SingleLocation, AllLocationViewHolder>(DefaultDiffCallback<SingleLocation>()){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AllLocationViewHolder {
        return AllLocationViewHolder.build(parent, clickListener)
    }

    override fun onBindViewHolder(holder: AllLocationViewHolder, position: Int) {
        holder.bind(currentList[position] as SingleLocation)
    }
}