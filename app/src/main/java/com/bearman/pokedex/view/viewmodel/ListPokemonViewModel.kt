package com.bearman.pokedex.view.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bearman.pokedex.data.entity.PokemonDetailEntity
import com.bearman.pokedex.domain.usecase.ListPokemonDetail
import com.bearman.pokedex.domain.usecase.ListPokemonUseCase
import timber.log.Timber
import javax.inject.Inject

class ListPokemonViewModel
@Inject constructor(
    private var listPokemonDetailUseCase: ListPokemonDetail
) : ViewModel() {

    var pokemonList = MutableLiveData<List<PokemonDetailEntity>>()
    var isLoading = MutableLiveData<Boolean>()
    var isError = MutableLiveData<Boolean>()

    fun callService(offset: String) {
        fetchPokemon(offset)
    }

    private fun fetchPokemon(offset: String) {
        isLoading.value = true
        listPokemonDetailUseCase.execute({
            Timber.d("success: $it")
            isLoading.value = false
            pokemonList.value = it
        }, {
            isLoading.value = false
            isError.value = true
            Timber.d("error: $it")
        })

    }
}