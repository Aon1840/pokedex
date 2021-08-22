package com.bearman.pokedex.domain.repository

import com.bearman.pokedex.data.entity.PokemonDetailEntity
import com.bearman.pokedex.data.entity.PokemonEntity
import io.reactivex.Single

interface PokemonRepositoryContractor {
    fun getPokemonList(offset: String): Single<PokemonEntity>
    fun getPokemonListDetail(): Single<List<PokemonDetailEntity>>
}