package com.mtdagar.marvelcharacters.data.local.typeconvertors

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.mtdagar.marvelcharacters.data.model.Events

class EventsConverter {

    @TypeConverter
    fun fromEventsToJson(events: Events): String {
        return Gson().toJson(events)
    }

    @TypeConverter
    fun fromJsonToEvents(json: String): Events {
        val type = object : TypeToken<Events>() {}.type
        return Gson().fromJson(json, type)
    }

}