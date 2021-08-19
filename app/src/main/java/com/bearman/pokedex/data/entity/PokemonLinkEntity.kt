package com.bearman.pokedex.data.entity

import com.google.gson.annotations.SerializedName

data class PokemonLinkEntity(
    @SerializedName("name")
    private val name: String?,

    @SerializedName("url")
    private val url: String,
)