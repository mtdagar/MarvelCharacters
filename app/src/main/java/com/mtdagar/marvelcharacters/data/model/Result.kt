package com.mtdagar.marvelcharacters.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.mtdagar.marvelcharacters.data.local.typeconvertors.*

@Entity(tableName = "marvel_characters")
data class Result(
    @TypeConverters(ResultsConverter::class)
    val comics: Comics,
    val description: String,
    @TypeConverters(ResultsConverter::class)
    val events: Events,
    @PrimaryKey
    val id: Int,
    val modified: String,
    val name: String,
    val resourceURI: String,
    @TypeConverters(ResultsConverter::class)
    val series: Series,
    @TypeConverters(ResultsConverter::class)
    val stories: Stories,
    @TypeConverters(ResultsConverter::class)
    val thumbnail: Thumbnail,
    @TypeConverters(ResultsConverter::class)
    val urls: List<Url>
)