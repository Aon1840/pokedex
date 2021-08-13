package com.bearman.pokedex.model

import com.google.gson.annotations.SerializedName

data class Pokemon(
    @SerializedName("next")
    private val next: String?,

    @SerializedName("previous")
    private val previous: String?,

    @SerializedName("results")
    private val result: List<PokemonLink>?
)