package com.malpvaplicaciones.code_cleanarquitecture.network.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CharacterNetworkEntity(

    @SerializedName("id")
    @Expose
    var id: Int,

    @SerializedName("name")
    @Expose
    var name: String,

    @SerializedName("status")
    @Expose
    var status: String,

    @SerializedName("species")
    @Expose
    var species: String,

    @SerializedName("gender")
    @Expose
    var gender: String,

    @SerializedName("image")
    @Expose
    var image: String
)