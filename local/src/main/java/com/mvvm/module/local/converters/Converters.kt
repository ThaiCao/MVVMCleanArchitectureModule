package com.mvvm.module.local.converters

import androidx.room.TypeConverter
import java.util.*

class Converters {
    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return value?.let { Date(it) }
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time
    }

  /*  @TypeConverter
    fun restoreList(listOfString: String?): List<String?>? {
        return Gson().fromJson(listOfString, object : TypeToken<List<String?>?>() {}.getType())
    }

    @TypeConverter
    fun saveList(listOfString: List<String?>?): String? {
        return Gson().toJson(listOfString)
    }*/
}