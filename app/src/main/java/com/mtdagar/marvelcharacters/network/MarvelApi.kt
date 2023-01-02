package com.mtdagar.marvelcharacters.network

import com.mtdagar.marvelcharacters.data.model.MarvelCharactersResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MarvelApi {

    companion object {
        const val BASE_URL = "https://gateway.marvel.com:443/v1/public/"
    }

    @GET("characters")
    suspend fun getCharacters(
        @Query("ts") ts: String,
        @Query("apikey") apiKey: String,
        @Query("hash") hash: String
    ): MarvelCharactersResponse

    @GET("characters/{characterId}")
    suspend fun getCharacterById(
        @Path("characterId") id: Int,
        @Query("ts") ts: String,
        @Query("apikey") apiKey: String,
        @Query("hash") hash: String
    ): Call<MarvelCharactersResponse>

}