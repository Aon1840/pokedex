package com.bearman.pokedex.model

import com.google.gson.annotations.SerializedName

data class PokemonLink(
    @SerializedName("name")
    private val name: String?,

    @SerializedName("url")
    private val url: String,
)