package com.bearman.pokedex.data.service

import com.bearman.pokedex.data.entity.PokemonDetailEntity
import com.bearman.pokedex.data.entity.PokemonEntity
import io.reactivex.Single
import javax.inject.Inject

class PokemonService
@Inject constructor(var api: PokeApi) {

    fun getListPokemon(offset: String): Single<PokemonEntity> {
        return api.getPokemonList(offset)
    }

    fun getListPokemonDetail(): Single<List<PokemonDetailEntity>> {
        return api.getPokemon()
    }
}