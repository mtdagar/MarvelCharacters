package com.mtdagar.marvelcharacters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mtdagar.marvelcharacters.data.model.MarvelCharactersResponse
import com.mtdagar.marvelcharacters.data.model.Result
import com.mtdagar.marvelcharacters.databinding.CharacterItemBinding

class CharacterAdapter(var charactersResponse: MarvelCharactersResponse) : RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    inner class CharacterViewHolder (private val binding: CharacterItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(character: Result) {
            binding.apply {
                characterName.text = character.name
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val binding = CharacterItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CharacterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val currentItem = charactersResponse.data.results[position]
        if (currentItem != null) {
            holder.bind(currentItem)
        }
    }

    override fun getItemCount(): Int {
        return charactersResponse.data.results.size
    }

    public fun setData(data: MarvelCharactersResponse) {
        charactersResponse = data
        notifyDataSetChanged()
    }

}