package com.mtdagar.marvelcharacters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mtdagar.marvelcharacters.data.model.Result
import com.mtdagar.marvelcharacters.databinding.CharacterItemBinding


class CharacterAdapter(var characters: List<Result>) : RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    inner class CharacterViewHolder (private val binding: CharacterItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(character: Result) {
            binding.apply {
                Glide.with(binding.root.context)
                    .load(character.thumbnail.path + "." + character.thumbnail.extension)
                    .into(characterImage)

                characterName.text = character.name
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val binding = CharacterItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CharacterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val currentItem = characters[position]
        if (currentItem != null) {
            holder.bind(currentItem)
        }
    }

    override fun getItemCount(): Int {
        return characters.size
    }

    public fun setData(data: List<Result>) {
        characters = data
        notifyDataSetChanged()
    }

}