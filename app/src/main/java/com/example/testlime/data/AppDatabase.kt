package com.example.testlime.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    version = 1,
    entities = [
        TvDbEntity::class,
    ]
)

abstract class AppDatabase : RoomDatabase() {

    abstract fun getTvDao(): TvDao

}