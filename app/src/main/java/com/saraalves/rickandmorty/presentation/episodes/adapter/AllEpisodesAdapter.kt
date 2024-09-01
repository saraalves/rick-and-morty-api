package com.saraalves.rickandmorty.presentation.episodes.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.saraalves.rickandmorty.presentation.DefaultDiffCallback
import com.saraalves.rickandmorty.domain.model.response.episodes.SingleEpisode

class AllEpisodesAdapter(
    private val clickListener: (SingleEpisode) -> Unit
) : ListAdapter<SingleEpisode, AllEpisodesViewHolder>(DefaultDiffCallback<SingleEpisode>()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AllEpisodesViewHolder {
        return AllEpisodesViewHolder.build(parent, clickListener)
    }

    override fun onBindViewHolder(holder: AllEpisodesViewHolder, position: Int) {
        holder.bind(currentList[position] as SingleEpisode)
    }
}