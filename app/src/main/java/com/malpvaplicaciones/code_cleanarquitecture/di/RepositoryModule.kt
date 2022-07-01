package com.malpvaplicaciones.code_cleanarquitecture.di

import com.malpvaplicaciones.code_cleanarquitecture.data.database.dao.CharacterDao
import com.malpvaplicaciones.code_cleanarquitecture.data.database.mapper.CharacterDatabaseMapper
import com.malpvaplicaciones.code_cleanarquitecture.data.network.mapper.CharacterNetworkMapper
import com.malpvaplicaciones.code_cleanarquitecture.data.network.service.CharacterService
import com.malpvaplicaciones.code_cleanarquitecture.repository.MainRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideMainRepository(
        characterDao: CharacterDao,
        characterService: CharacterService,
        characterDatabaseMapper: CharacterDatabaseMapper,
        characterNetworkMapper: CharacterNetworkMapper
    ): MainRepository {
        return MainRepository(
            characterDao,
            characterService,
            characterDatabaseMapper,
            characterNetworkMapper
        )
    }
}