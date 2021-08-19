package com.bearman.pokedex.domain.repository

import com.bearman.pokedex.model.Pokemon
import com.bearman.pokedex.model.PokemonService
import io.reactivex.Single
import javax.inject.Inject

class PokemonRepository @Inject constructor(
    private val pokemonService: PokemonService
) : PokemonRepositoryContractor {

    override fun getPokemonList(offset: String): Single<Pokemon> {
        return pokemonService.getListPokemon(offset)
    }
}