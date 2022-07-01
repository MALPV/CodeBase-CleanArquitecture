package com.malpvaplicaciones.code_cleanarquitecture.di

import android.content.Context
import androidx.room.Room
import com.malpvaplicaciones.code_cleanarquitecture.database.dao.CharacterDao
import com.malpvaplicaciones.code_cleanarquitecture.database.db.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase{
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            AppDatabase.DB_NAME
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideCharacterDao(appDatabase: AppDatabase): CharacterDao{
        return appDatabase.characterDao()
    }
}