package com.malpvaplicaciones.code_cleanarquitecture.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.malpvaplicaciones.code_cleanarquitecture.data.database.entity.CharacterDatabaseEntity

@Dao
interface CharacterDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(entity: CharacterDatabaseEntity)

    @Query("SELECT * FROM characters")
    suspend fun getCharactersFromDatabase(): List<CharacterDatabaseEntity>

}