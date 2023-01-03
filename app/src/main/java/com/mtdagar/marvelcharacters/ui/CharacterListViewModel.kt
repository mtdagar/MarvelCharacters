package com.mtdagar.marvelcharacters.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.mtdagar.marvelcharacters.data.CharacterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterListViewModel @Inject constructor(
    private val repository: CharacterRepository
) : ViewModel() {

    val characters = repository.getCharacters().asLiveData()

    fun incrementItemViewCount(id: Int) {
        viewModelScope.launch {
            repository.incrementViewCount(id)
        }
    }

}