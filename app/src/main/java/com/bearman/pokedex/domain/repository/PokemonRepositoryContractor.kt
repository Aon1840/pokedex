package com.bearman.pokedex.domain.repository

import com.bearman.pokedex.model.Pokemon
import io.reactivex.Single

interface PokemonRepositoryContractor {
    fun getPokemonList(offset: String): Single<Pokemon>
}