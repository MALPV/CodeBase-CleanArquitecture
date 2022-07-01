package com.malpvaplicaciones.code_cleanarquitecture.repository

import com.malpvaplicaciones.code_cleanarquitecture.core.util.ResultState
import com.malpvaplicaciones.code_cleanarquitecture.data.database.dao.CharacterDao
import com.malpvaplicaciones.code_cleanarquitecture.data.database.mapper.CharacterDatabaseMapper
import com.malpvaplicaciones.code_cleanarquitecture.domain.Character
import com.malpvaplicaciones.code_cleanarquitecture.data.network.mapper.CharacterNetworkMapper
import com.malpvaplicaciones.code_cleanarquitecture.data.network.service.CharacterService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import java.net.SocketTimeoutException
import java.net.UnknownHostException

class MainRepository
constructor(
    private val characterDao: CharacterDao,
    private val characterService: CharacterService,
    private val characterDatabaseMapper: CharacterDatabaseMapper,
    private val characterNetworkMapper: CharacterNetworkMapper
) {

    fun getCharacters(): Flow<ResultState<List<Character>>> = flow {
        emit(ResultState.Loading)
        delay(1000)

        val charactersFromDb = characterDao.getCharactersFromDatabase()
        if (charactersFromDb.isEmpty()) {
            val characterFromNetwork = characterService.getCharactersFromNetwork()
            val characters =
                characterNetworkMapper.mapFromEntityList(characterFromNetwork.characters)
            for (character in characters) {
                characterDao.insert(characterDatabaseMapper.mapToEntity(character))
            }
            emit(ResultState.Success(characters))
        } else {
            emit(ResultState.Success(characterDatabaseMapper.mapFromEntityList(charactersFromDb)))
        }
/*    }.onStart {
        delay(1000)*/
    }.catch { e ->
        when (e as Exception) {
            is UnknownHostException ->
                emit(ResultState.Error("Sin conexión a internet, verifique e intente nuevamente."))
            is SocketTimeoutException ->
                emit(ResultState.Error("Verifique la conexión a internet e intente nuevamente."))
            else ->
                emit(ResultState.Error("Error inesperado, contacte al administrador."))
        }
    }.flowOn(Dispatchers.IO)
}