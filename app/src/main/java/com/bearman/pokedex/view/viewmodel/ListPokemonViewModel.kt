package com.bearman.pokedex.view.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bearman.pokedex.data.entity.PokemonDetailEntity
import com.bearman.pokedex.domain.usecase.ListPokemonDetail
import timber.log.Timber
import javax.inject.Inject

class ListPokemonViewModel
@Inject constructor(
    private var listPokemonDetailUseCase: ListPokemonDetail
) : ViewModel() {

    var pokemonList = MutableLiveData<List<PokemonDetailEntity>>()
    var isLoading = MutableLiveData<Boolean>()
    var isError = MutableLiveData<Boolean>()
    var isChangeView = MutableLiveData(false)

    fun callService() {
        fetchPokemon()
    }

    fun changeView() {
        isChangeView.value?.let {
            isChangeView.value = !it
        }
    }

    private fun fetchPokemon() {
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