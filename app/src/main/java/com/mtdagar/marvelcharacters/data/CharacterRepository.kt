package com.mtdagar.marvelcharacters.data

import androidx.room.withTransaction
import com.mtdagar.marvelcharacters.data.local.CharactersDatabase
import com.mtdagar.marvelcharacters.network.MarvelApi
import com.mtdagar.marvelcharacters.util.networkBoundResource
import kotlinx.coroutines.delay
import javax.inject.Inject

class CharacterRepository @Inject constructor(
    private val api: MarvelApi,
    private val db: CharactersDatabase
) {

    private val characterDao = db.characterDao()

    fun getCharacters() = networkBoundResource(
        query = {
            characterDao.getAllCharacters()
        },
        fetch = {
            delay(2000)
            api.getCharacters(
                "1",
                "1b353f979d2861d08eeb67a2fbbd5368",
                "44b43742dfb63d5b5265855f0ce0bddd"
            )
        },
        saveFetchResult = { characters ->
            db.withTransaction {
                characterDao.deleteAllCharacters()
                characters.data?.results?.let { characterDao.insertCharacters(it) }
                //todo find an alternate to this enque shit man
//                characters.enqueue(object : Callback<MarvelCharactersResponse> {
//                    override fun onResponse(
//                        call: Call<MarvelCharactersResponse>,
//                        response: Response<MarvelCharactersResponse>
//                    ) {
//                        Log.i("MainActivity", response.toString())
//                        response.body()?.data?.results?.let { characterDao.insertCharacters(it) }
//                    }
//
//                    override fun onFailure(call: Call<MarvelCharactersResponse>, t: Throwable) {
//                        Log.i("MainActivity", t.message ?: "null message")
//                    }
//                })

            }
        }
    )

}