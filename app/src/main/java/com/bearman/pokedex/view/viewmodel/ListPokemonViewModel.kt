package com.bearman.pokedex.view.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bearman.pokedex.data.entity.PokemonEntity
import com.bearman.pokedex.domain.usecase.ListPokemonUseCase
import io.reactivex.disposables.CompositeDisposable
import timber.log.Timber
import javax.inject.Inject

class ListPokemonViewModel
@Inject constructor(
    private var listPokemonUseCase: ListPokemonUseCase
) : ViewModel() {

    var pokemonList = MutableLiveData<PokemonEntity>()
    var isLoading = MutableLiveData<Boolean>()
    var isError = MutableLiveData<Boolean>()

    fun callService(offset: String) {
        fetchPokemon(offset)
    }

    private fun fetchPokemon(offset: String) {
        isLoading.value = true
        listPokemonUseCase.execute({
            pokemonList.value = it
            Timber.d("success: $it")
        }, {
            isError.value = true
            Timber.d("error: $it")
        },
            params = offset
        )

    }
}