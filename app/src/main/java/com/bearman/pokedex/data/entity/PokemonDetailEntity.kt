package com.bearman.pokedex.data.entity

import com.google.gson.annotations.SerializedName

data class PokemonDetailEntity(
    @SerializedName("name")
    val name: String? = null,

    @SerializedName("id")
    val id: String? = null,

    @SerializedName("imageurl")
    val imageUrl: String? = null,

    @SerializedName("xdescription")
    val description: String? = null,

    @SerializedName("height")
    val height: String? = null,

    @SerializedName("category")
    val category: String? = null,

    @SerializedName("weight")
    val weight: String? = null,

    @SerializedName("typeofpokemon")
    val type: List<String>? = null,

    @SerializedName("weaknesses")
    val weaknesses: List<String>? = null,

    @SerializedName("evolutions")
    val evolutions: List<String>? = null,

    @SerializedName("abilities")
    val abilities: List<String>? = null,

    @SerializedName("hp")
    val hp: Int? = null,

    @SerializedName("attack")
    val attack: Int? = null,

    @SerializedName("defense")
    val defense: Int? = null,

    @SerializedName("speed")
    val speed: Int? = null,

    @SerializedName("total")
    val total: Int? = null
)
