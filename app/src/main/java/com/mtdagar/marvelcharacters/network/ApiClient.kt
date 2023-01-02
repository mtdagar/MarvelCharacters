package com.mtdagar.marvelcharacters.network

import com.mtdagar.marvelcharacters.MarvelService
import retrofit2.Response

class ApiClient(
    private val marvelService: MarvelService
) {

//    suspend fun getCharacters(pageIndex: Int): SimpleResponse<MarvelCharactersResponse> {
//        //todo pass query parameters through interceptor
//        return safeApiCall { marvelService.getCharacters() }
//    }


    private inline fun <T> safeApiCall(apiCall: () -> Response<T>): SimpleResponse<T> {
        return try {
            SimpleResponse.success(apiCall.invoke())
        } catch (e: Exception) {
            SimpleResponse.failure(e)
        }
    }

}