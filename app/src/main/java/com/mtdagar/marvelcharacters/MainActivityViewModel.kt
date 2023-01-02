package com.mtdagar.marvelcharacters

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mtdagar.marvelcharacters.data.model.MarvelCharactersResponse
import com.mtdagar.marvelcharacters.network.MarvelApi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    api: MarvelApi
) : ViewModel() {

    private val charactersLiveData = MutableLiveData<MarvelCharactersResponse>()
    val characters: LiveData<MarvelCharactersResponse> = charactersLiveData

    init {
        viewModelScope.launch {
            val charactersResponse = api.getCharacters(
                "1",
                "1b353f979d2861d08eeb67a2fbbd5368",
                "44b43742dfb63d5b5265855f0ce0bddd"
            )

            delay(1000)

            Log.i("MainActivity", charactersResponse.data.results[0].name)
            charactersLiveData.value = charactersResponse

//            charactersResponse.enqueue(object : Callback<MarvelCharactersResponse> {
//                override fun onResponse(
//                    call: Call<MarvelCharactersResponse>,
//                    response: Response<MarvelCharactersResponse>
//                ) {
//                    Log.i("MainActivity", response.toString())
//                    charactersLiveData.value = response.body()
//                }
//
//                override fun onFailure(call: Call<MarvelCharactersResponse>, t: Throwable) {
//                    Log.i("MainActivity", t.message ?: "null message")
//                }
//
//            })


        }
    }

}