package com.mtdagar.marvelcharacters.di

import android.app.Application
import androidx.room.Room
import com.mtdagar.marvelcharacters.data.local.CharactersDatabase
import com.mtdagar.marvelcharacters.network.MarvelApi
import com.mtdagar.marvelcharacters.network.MarvelApi.Companion.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * AppModule class to provide API client and database instance as singletons
 */

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideMarvelApi(): MarvelApi {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(MarvelApi::class.java)
    }

    @Provides
    @Singleton
    fun provideDatabase(app: Application) : CharactersDatabase =
        Room.databaseBuilder(app, CharactersDatabase::class.java, "marvel_database")
            .build()
}