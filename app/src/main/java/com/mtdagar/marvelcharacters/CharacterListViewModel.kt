package com.mtdagar.marvelcharacters

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.mtdagar.marvelcharacters.data.CharacterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CharacterListViewModel @Inject constructor(
    repository: CharacterRepository
) : ViewModel() {

    val characters = repository.getCharacters().asLiveData()

}