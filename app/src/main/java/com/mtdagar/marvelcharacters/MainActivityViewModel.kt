package com.mtdagar.marvelcharacters

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.mtdagar.marvelcharacters.data.CharacterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    repository: CharacterRepository
) : ViewModel() {

    val characters = repository.getCharacters().asLiveData()

//    private val charactersLiveData = MutableLiveData<MarvelCharactersResponse>()
//    val characters: LiveData<MarvelCharactersResponse> = charactersLiveData
//
//    init {
//        viewModelScope.launch {
//            val charactersResponse = api.getCharacters(
//                "1",
//                "1b353f979d2861d08eeb67a2fbbd5368",
//                "44b43742dfb63d5b5265855f0ce0bddd"
//            )
//
//            delay(1000)
//
//            Log.i("MainActivity", charactersResponse.data.results[0].name)
//            charactersLiveData.value = charactersResponse
//
//        }
//    }

}