package com.saraalves.rickandmorty.presentation.character.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.saraalves.rickandmorty.domain.model.response.character.SingleCharacter
import com.saraalves.rickandmorty.R
import com.saraalves.rickandmorty.databinding.ListItemCharacterBinding
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso

import java.lang.Exception

class AllCharactersViewHolder(
    itemView: View, private val onItemClick: (SingleCharacter) -> Unit
) : RecyclerView.ViewHolder(itemView) {

    private val binding = ListItemCharacterBinding.bind(itemView)

    // tirar o let do binding e colocar o with()
    fun bind(characters: SingleCharacter) {
        binding.let {
            it.root.setOnClickListener { onItemClick(characters) }
            it.characterName.text = characters.name ?: "ops sem nome"
            it.text.text = characters.status ?: "ops sem status"
            it.progressBar.isVisible = false
            Picasso.get()
                .load(characters.image)
                .error(R.drawable.ic_launcher_foreground)
                .into(it.picture, object : Callback {
                    override fun onSuccess() {
                        it.progressBar.isVisible = false
                    }

                    override fun onError(e: Exception?) {
                        it.progressBar.isVisible = false
                    }
                })
        }
    }

    companion object {
        fun build(parent: ViewGroup, onItemClick: (SingleCharacter) -> Unit): AllCharactersViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val view = layoutInflater.inflate(R.layout.list_item_character, parent, false)
            return AllCharactersViewHolder(view, onItemClick)
        }
    }
}