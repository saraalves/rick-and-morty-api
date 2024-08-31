package com.saraalves.rickandmorty

import androidx.recyclerview.widget.DiffUtil

class DefaultDiffCallback<T> : DiffUtil.ItemCallback<T>() {

    override fun areItemsTheSame(oldItem: T & Any, newItem: T & Any): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: T & Any, newItem: T & Any): Boolean {
        return areItemsTheSame(oldItem, newItem)
    }
}
