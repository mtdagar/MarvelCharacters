package com.mtdagar.marvelcharacters

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.mtdagar.marvelcharacters.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    private val viewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        var characterAdapter:CharacterAdapter? = null

        viewModel.characters.observe(this@MainActivity) {
            characterAdapter = CharacterAdapter(it)

            binding.apply {
                characterRecyclerView.apply {
                    adapter = characterAdapter
                    layoutManager = LinearLayoutManager(this@MainActivity)
                }

            }
        }

    }
}
