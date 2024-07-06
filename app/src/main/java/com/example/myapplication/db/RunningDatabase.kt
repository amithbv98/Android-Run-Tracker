package com.example.myapplication.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters



@TypeConverters(Convertors::class)
@Database(entities = [Run::class], version = 1, exportSchema = false)
abstract class RunningDatabase:RoomDatabase() {
    abstract fun getRunDao() : RunDAO
}