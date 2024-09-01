package com.saraalves.rickandmorty.presentation.episodes.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.saraalves.rickandmorty.R
import com.saraalves.rickandmorty.databinding.ListItemEpisodesBinding
import com.saraalves.rickandmorty.domain.model.response.episodes.SingleEpisode


class AllEpisodesViewHolder(itemView: View, private val onItemClick: (SingleEpisode) -> Unit) :
    RecyclerView.ViewHolder(itemView) {

    private val binding = ListItemEpisodesBinding.bind(itemView)

    fun bind(episode: SingleEpisode) {
        binding.let {
            it.root.setOnClickListener { onItemClick(episode) }
            it.nameEpisode.text = episode.name ?: "ops sem nome"
            it.episodesAirDate.text = episode.airDate
            it.episodesAirDate.visibility =
                if (episode.airDate.isNullOrEmpty()) View.GONE else View.VISIBLE
            it.episodes.text = episode.episode ?: "ops sem status"
            it.progressBar.isVisible = false
        }
    }

    companion object {
        fun build(parent: ViewGroup, onItemClick: (SingleEpisode) -> Unit): AllEpisodesViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val view = layoutInflater.inflate(R.layout.list_item_episodes, parent, false)
            return AllEpisodesViewHolder(view, onItemClick)
        }
    }
}