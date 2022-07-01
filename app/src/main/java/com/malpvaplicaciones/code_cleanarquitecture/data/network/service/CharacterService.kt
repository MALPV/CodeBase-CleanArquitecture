package com.malpvaplicaciones.code_cleanarquitecture.data.network.service

import com.malpvaplicaciones.code_cleanarquitecture.data.network.response.ResultCharacters
import retrofit2.http.GET

interface CharacterService {

    @GET("character/?page=1")
    suspend fun getCharactersFromNetwork(): ResultCharacters
}