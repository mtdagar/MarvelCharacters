package com.mtdagar.marvelcharacters.data.local.typeconvertors

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.mtdagar.marvelcharacters.data.model.Series

class SeriesConverter {

    @TypeConverter
    fun fromSeriesToJson(series: Series): String {
        return Gson().toJson(series)
    }

    @TypeConverter
    fun fromJsonToSeries(json: String): Series {
        val type = object : TypeToken<Series>() {}.type
        return Gson().fromJson(json, type)
    }

}