package com.bearman.pokedex.model

import com.bearman.pokedex.di.DaggerApiComponent
import io.reactivex.Single
import javax.inject.Inject

class PokemonService {

    @Inject
    lateinit var api: PokeApi

    init {
        DaggerApiComponent.create().inject(this)
    }

    fun getListPokemon(offset: String): Single<Pokemon> {
        return api.getPokemonList(offset)
    }
}