package com.bearman.pokedex.data.service

import com.bearman.pokedex.data.entity.PokemonEntity
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface PokeApi {

    @GET("pokemon?limit=10")
    fun getPokemonList(@Query("offset") offset: String): Single<PokemonEntity>
}