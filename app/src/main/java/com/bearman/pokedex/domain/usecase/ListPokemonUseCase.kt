package com.bearman.pokedex.domain.usecase

import com.bearman.pokedex.domain.repository.PokemonRepository
import com.bearman.pokedex.model.Pokemon
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class ListPokemonUseCase @Inject constructor(
    private val repository: PokemonRepository
) {

    fun getPokemonList(
        offset: String
    ): Single<Pokemon> {
        return repository.getPokemonList(offset)
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
    }

}