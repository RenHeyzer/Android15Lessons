package com.geeks.pokeapiandroid15.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.geeks.pokeapiandroid15.databinding.ItemPokemonBinding
import com.geeks.pokeapiandroid15.presentation.models.PokemonUI

class PokemonAdapter :
    PagingDataAdapter<PokemonUI, PokemonAdapter.ViewHolder>(diffUtil) {

    inner class ViewHolder(private val binding: ItemPokemonBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(pokemon: PokemonUI) = with(binding) {
            Glide.with(ivPokemonImage.context)
                .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/${pokemon.id}.png")
                .into(ivPokemonImage)
            tvPokemonName.text = pokemon.name.replaceFirstChar { it.uppercase() }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemPokemonBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position)?.let { holder.onBind(it) }
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<PokemonUI>() {

            override fun areItemsTheSame(oldItem: PokemonUI, newItem: PokemonUI): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: PokemonUI, newItem: PokemonUI): Boolean {
                return oldItem == newItem
            }
        }
    }
}