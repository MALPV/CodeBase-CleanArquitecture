package com.malpvaplicaciones.code_cleanarquitecture.network.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ResultCharacters(

    @SerializedName("results")
    @Expose
    var characters: List<CharacterNetworkEntity>
)
