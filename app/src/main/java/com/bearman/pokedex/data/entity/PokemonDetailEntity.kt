package com.bearman.pokedex.data.entity

import com.google.gson.annotations.SerializedName

data class PokemonDetailEntity(
    @SerializedName("name")
    val name: String?,

    @SerializedName("id")
    val id: String?,

    @SerializedName("imageurl")
    val imageUrl: String?,

    @SerializedName("xdescription")
    val description: String?,

    @SerializedName("height")
    val height: String?,

    @SerializedName("category")
    val category: String?,

    @SerializedName("weight")
    val weight: String?,

    @SerializedName("typeofpokemon")
    val type: List<String>?,

    @SerializedName("weaknesses")
    val weaknesses: List<String>?,

    @SerializedName("evolutions")
    val evolutions: List<String>?,

    @SerializedName("abilities")
    val abilities: List<String>?,

    @SerializedName("hp")
    val hp: Int?,

    @SerializedName("attack")
    val attack: Int?,

    @SerializedName("defense")
    val defense: Int?,

    @SerializedName("speed")
    val speed: Int?,

    @SerializedName("total")
    val total: Int?
)
