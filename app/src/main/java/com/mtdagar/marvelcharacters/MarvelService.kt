package com.mtdagar.marvelcharacters

import com.mtdagar.marvelcharacters.data.model.MarvelCharactersResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MarvelService {

//    @Headers("apiKey: " + "1b353f979d2861d08eeb67a2fbbd5368")
    @GET("characters")
    fun getCharacters(
        @Query("ts") ts: String,
        @Query("apikey") apiKey: String,
        @Query("hash") hash: String
    ): Call<MarvelCharactersResponse>

}