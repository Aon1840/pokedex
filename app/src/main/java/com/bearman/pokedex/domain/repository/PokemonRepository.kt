package com.bearman.pokedex.domain.repository

import com.bearman.pokedex.data.entity.PokemonEntity
import com.bearman.pokedex.data.service.PokemonService
import io.reactivex.Single
import javax.inject.Inject

class PokemonRepository @Inject constructor(
    private val pokemonService: PokemonService
) : PokemonRepositoryContractor {

    override fun getPokemonList(offset: String): Single<PokemonEntity> {
        return pokemonService.getListPokemon(offset)
    }
}