package com.mtdagar.marvelcharacters.data.local.typeconvertors

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.mtdagar.marvelcharacters.data.model.*

/**
 * This class converts custom POJO objects to json and vice-versa for Room to use during type
 * conversion.
 */

//todo figure out a way to make only 2 converters for all type to avoid code repetition

class ResultsConverter {

    @TypeConverter
    fun fromComicsToJson(comics: Comics): String {
        return Gson().toJson(comics)
    }

    @TypeConverter
    fun fromJsonToComics(json: String): Comics {
        val type = object : TypeToken<Comics>() {}.type
        return Gson().fromJson(json, type)
    }

    @TypeConverter
    fun fromEventsToJson(events: Events): String {
        return Gson().toJson(events)
    }

    @TypeConverter
    fun fromJsonToEvents(json: String): Events {
        val type = object : TypeToken<Events>() {}.type
        return Gson().fromJson(json, type)
    }

    @TypeConverter
    fun fromSeriesToJson(series: Series): String {
        return Gson().toJson(series)
    }

    @TypeConverter
    fun fromJsonToSeries(json: String): Series {
        val type = object : TypeToken<Series>() {}.type
        return Gson().fromJson(json, type)
    }

    @TypeConverter
    fun fromStoriesToJson(stories: Stories): String {
        return Gson().toJson(stories)
    }

    @TypeConverter
    fun fromJsonToStories(json: String): Stories {
        val type = object : TypeToken<Stories>() {}.type
        return Gson().fromJson(json, type)
    }

    @TypeConverter
    fun fromThumbnailToJson(thumbnail: Thumbnail): String {
        return Gson().toJson(thumbnail)
    }

    @TypeConverter
    fun fromJsonToThumbnail(json: String): Thumbnail {
        val type = object : TypeToken<Thumbnail>() {}.type
        return Gson().fromJson(json, type)
    }

    @TypeConverter
    fun fromUrlsToJson(urls: List<Url>): String {
        return Gson().toJson(urls)
    }

    @TypeConverter
    fun fromJsonToUrls(json: String): List<Url> {
        val type = object : TypeToken<List<Url>>() {}.type
        return Gson().fromJson(json, type)
    }

}