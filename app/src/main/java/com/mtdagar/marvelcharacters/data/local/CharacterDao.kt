package com.mtdagar.marvelcharacters.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface CharacterDao {

    @Query("SELECT * FROM marvel_characters")
    fun getAllCharacters(): Flow<List<com.mtdagar.marvelcharacters.data.model.Result>>

    @Query("SELECT COUNT(*) FROM marvel_characters")
    suspend fun getItemCount(): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCharacters(characters: List<com.mtdagar.marvelcharacters.data.model.Result>)

    @Query("DELETE FROM marvel_characters")
    suspend fun deleteAllCharacters()

    @Query("UPDATE marvel_characters SET viewCount = viewCount + 1 WHERE id = :id")
    suspend fun incrementViewCount(id: Int)

}