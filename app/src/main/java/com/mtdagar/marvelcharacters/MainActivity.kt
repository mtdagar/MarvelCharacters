package com.mtdagar.marvelcharacters

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.mtdagar.marvelcharacters.databinding.ActivityMainBinding
import com.mtdagar.marvelcharacters.util.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        var characterAdapter: CharacterAdapter?

        viewModel.characters.observe(this@MainActivity) { result ->
            characterAdapter = result.data?.let { characters -> CharacterAdapter(characters) }

            binding.apply {
                characterRecyclerView.apply {
                    adapter = characterAdapter
                    layoutManager = LinearLayoutManager(this@MainActivity)
                }
            }

            binding.progressBar.isVisible = result is Resource.Loading && result.data.isNullOrEmpty()
            binding.textViewError.isVisible = result is Resource.Error && result.data.isNullOrEmpty()
            binding.textViewError.text = result.error?.localizedMessage

        }

    }
}
