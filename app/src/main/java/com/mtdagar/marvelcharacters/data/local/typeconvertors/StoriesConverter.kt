package com.mtdagar.marvelcharacters.data.local.typeconvertors

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.mtdagar.marvelcharacters.data.model.Stories

class StoriesConverter {

    @TypeConverter
    fun fromStoriesToJson(stories: Stories): String {
        return Gson().toJson(stories)
    }

    @TypeConverter
    fun fromJsonToStories(json: String): Stories {
        val type = object : TypeToken<Stories>() {}.type
        return Gson().fromJson(json, type)
    }

}