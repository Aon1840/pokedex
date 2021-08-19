package com.bearman.pokedex.model

import io.reactivex.Single
import javax.inject.Inject

class PokemonService
@Inject constructor(var api: PokeApi) {

    fun getListPokemon(offset: String): Single<Pokemon> {
        return api.getPokemonList(offset)
    }
}