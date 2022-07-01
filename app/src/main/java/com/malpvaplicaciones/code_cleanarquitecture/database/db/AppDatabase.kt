package com.malpvaplicaciones.code_cleanarquitecture.database.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.malpvaplicaciones.code_cleanarquitecture.database.dao.CharacterDao
import com.malpvaplicaciones.code_cleanarquitecture.database.entity.CharacterDatabaseEntity

@Database(
    entities = [CharacterDatabaseEntity::class],
    version = AppDatabase.DB_VERSION
)
abstract class AppDatabase: RoomDatabase() {

    abstract fun characterDao(): CharacterDao

    companion object{

        const val DB_NAME = "app_database"
        const val DB_VERSION = 1
    }
}