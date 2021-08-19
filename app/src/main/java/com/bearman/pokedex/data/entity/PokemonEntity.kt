package com.bearman.pokedex.data.entity

import com.google.gson.annotations.SerializedName

data class PokemonEntity(
    @SerializedName("next")
    private val next: String?,

    @SerializedName("previous")
    private val previous: String?,

    @SerializedName("results")
    private val result: List<PokemonLinkEntity>?
)