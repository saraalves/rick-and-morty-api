package com.saraalves.rickandmorty.presentation.location.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.saraalves.rickandmorty.R
import com.saraalves.rickandmorty.databinding.ListItemCharacterBinding
import com.saraalves.rickandmorty.domain.model.response.character.SingleCharacter
import com.saraalves.rickandmorty.domain.model.response.location.SingleLocation
import com.saraalves.rickandmorty.presentation.character.adapter.AllCharactersViewHolder
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import java.lang.Exception

class AllLocationViewHolder(itemView: View, private val onItemClick: (SingleLocation) -> Unit) :
    RecyclerView.ViewHolder(itemView) {

    private val binding = ListItemCharacterBinding.bind(itemView)

    fun bind(location: SingleLocation) {
        binding.let {
            it.root.setOnClickListener { onItemClick(location) }
            it.characterName.text = location.locationName ?: "ops sem nome"
            it.textStatus.text = location.type ?: "ops sem type"
            it.progressBar.isVisible = false
        }
    }

    companion object {
        fun build(parent: ViewGroup, onItemClick: (SingleLocation) -> Unit): AllLocationViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val view = layoutInflater.inflate(R.layout.list_item_character, parent, false)
            return AllLocationViewHolder(view, onItemClick)
        }
    }
}