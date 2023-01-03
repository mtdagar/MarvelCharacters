package com.mtdagar.marvelcharacters.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.mtdagar.marvelcharacters.data.model.Result
import com.mtdagar.marvelcharacters.databinding.CharacterItemBinding


class CharacterAdapter(
    val characterListViewModel: CharacterListViewModel,
    var characters: List<Result>
    ) : RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    inner class CharacterViewHolder (private val binding: CharacterItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(character: Result) {
            binding.apply {
                val imageUrl = character.thumbnail.path + "." + character.thumbnail.extension
                Glide.with(binding.root.context)
                    .load(imageUrl)
                    .centerCrop()
                    .transition(DrawableTransitionOptions.withCrossFade(200))
                    .into(characterImage)

                characterName.text = character.name
                viewCount.text = character.viewCount.toString()

                itemView.setOnClickListener {
                    characterListViewModel.incrementItemViewCount(character.id)
                    val navController = Navigation.findNavController(itemView)
                    val action = CharacterListFragmentDirections.actionCharacterListFragmentToCharacterDetailFragment(
                        character.name,
                        imageUrl,
                        character.description
                    )
                    navController.navigate(action)
                    notifyItemChanged(characters.indexOf(character))
                }
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

    fun setData(data: List<Result>) {
        characters = data
        notifyDataSetChanged()
    }

    fun sortAZ() {
        characters = characters.sortedBy { it.name }
        notifyDataSetChanged()
    }

    fun sortZA() {
        characters = characters.sortedByDescending { it.name }
        notifyDataSetChanged()
    }


    fun sortViewsAsc() {
        characters = characters.sortedBy { it.viewCount }
        notifyDataSetChanged()
    }

    fun sortViewsDesc() {
        characters = characters.sortedByDescending { it.viewCount }
        notifyDataSetChanged()
    }

}