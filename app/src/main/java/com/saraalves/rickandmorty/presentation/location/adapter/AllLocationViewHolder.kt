package com.saraalves.rickandmorty.presentation.location.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.saraalves.rickandmorty.R
import com.saraalves.rickandmorty.databinding.ListItemLocationBinding
import com.saraalves.rickandmorty.domain.model.response.location.SingleLocation

class AllLocationViewHolder(itemView: View, private val onItemClick: (SingleLocation) -> Unit) :
    RecyclerView.ViewHolder(itemView) {

    private val binding = ListItemLocationBinding.bind(itemView)

    fun bind(location: SingleLocation) {
        binding.let {
            it.root.setOnClickListener { onItemClick(location) }
            it.nameLocation.text = location.locationName
            it.nameLocation.visibility =
                if (location.locationName.isNullOrEmpty()) View.GONE else View.VISIBLE
            it.typeLocation.text = location.type ?: "ops sem nome"
            it.dimension.text = location.dimension ?: "ops sem type"
            it.progressBar.isVisible = false
        }
    }

    companion object {
        fun build(parent: ViewGroup, onItemClick: (SingleLocation) -> Unit): AllLocationViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val view = layoutInflater.inflate(R.layout.list_item_location, parent, false)
            return AllLocationViewHolder(view, onItemClick)
        }
    }
}