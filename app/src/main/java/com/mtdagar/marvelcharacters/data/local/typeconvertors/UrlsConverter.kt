package com.mtdagar.marvelcharacters.data.local.typeconvertors

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.mtdagar.marvelcharacters.data.model.Url

class UrlsConverter {

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