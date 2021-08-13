package com.bearman.pokedex.model

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface PokeApi {

    @GET("pokemon?limit=10")
    fun getPokemonList(@Query("offset") offset: String): Single<Pokemon>
}