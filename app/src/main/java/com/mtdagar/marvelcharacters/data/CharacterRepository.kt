package com.mtdagar.marvelcharacters.data

import androidx.room.withTransaction
import com.mtdagar.marvelcharacters.data.local.CharactersDatabase
import com.mtdagar.marvelcharacters.network.MarvelApi
import com.mtdagar.marvelcharacters.util.networkBoundResource
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
            }
        },
        shouldFetch = { data ->
            data.isEmpty()
        }
    )

    suspend fun incrementViewCount(id: Int) {
        characterDao.incrementViewCount(id)
    }

}