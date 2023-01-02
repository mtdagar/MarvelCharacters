package com.mtdagar.marvelcharacters.data.local.typeconvertors

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.mtdagar.marvelcharacters.data.model.Thumbnail

class ThumbnailConverter {

    @TypeConverter
    fun fromThumbnailToJson(thumbnail: Thumbnail): String {
        return Gson().toJson(thumbnail)
    }

    @TypeConverter
    fun fromJsonToThumbnail(json: String): Thumbnail {
        val type = object : TypeToken<Thumbnail>() {}.type
        return Gson().fromJson(json, type)
    }

}