package com.mtdagar.marvelcharacters.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.mtdagar.marvelcharacters.data.local.typeconvertors.*

@Database(entities = [com.mtdagar.marvelcharacters.data.model.Result::class], version = 1)
@TypeConverters(ResultsConverter::class)
abstract class CharactersDatabase : RoomDatabase() {

    abstract fun characterDao(): CharacterDao

}