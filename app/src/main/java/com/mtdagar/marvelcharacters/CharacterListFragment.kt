package com.mtdagar.marvelcharacters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.mtdagar.marvelcharacters.databinding.FragmentCharacterListBinding
import com.mtdagar.marvelcharacters.util.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharacterListFragment : Fragment() {

    private lateinit var binding: FragmentCharacterListBinding

    private val viewModel: CharacterListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCharacterListBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var characterAdapter: CharacterAdapter?

        viewModel.characters.observe(viewLifecycleOwner) { result ->
            characterAdapter = result.data?.let { characters -> CharacterAdapter(characters) }

            binding.apply {
                characterRecyclerView.apply {
                    adapter = characterAdapter
                    layoutManager = LinearLayoutManager(context)
                }
            }

            binding.progressBar.isVisible = result is Resource.Loading && result.data.isNullOrEmpty()
            binding.textViewError.isVisible = result is Resource.Error && result.data.isNullOrEmpty()
            binding.textViewError.text = result.error?.localizedMessage

        }

    }

}