package com.mtdagar.marvelcharacters

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.mtdagar.marvelcharacters.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var homeFragment: CharacterListFragment? = null

    private val characterListViewModel: CharacterListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment

        homeFragment = navHostFragment.childFragmentManager.fragments[0] as CharacterListFragment

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.sorting_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.menu_a_to_z -> homeFragment?.sortAZ()
            R.id.menu_z_to_a -> homeFragment?.sortZA()
            R.id.menu_views_asc -> homeFragment?.sortViewAsc()
            R.id.menu_views_desc -> homeFragment?.sortViewDesc()
        }

        return super.onOptionsItemSelected(item)
    }
}
