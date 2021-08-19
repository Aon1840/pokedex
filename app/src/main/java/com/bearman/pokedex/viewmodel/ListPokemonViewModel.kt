package com.bearman.pokedex.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bearman.pokedex.domain.usecase.ListPokemonUseCase
import com.bearman.pokedex.model.Pokemon
import io.reactivex.disposables.CompositeDisposable
import timber.log.Timber
import javax.inject.Inject

class ListPokemonViewModel
@Inject constructor(
    private var listPokemonUseCase: ListPokemonUseCase
) : ViewModel() {

    private val disposable = CompositeDisposable()
    var pokemonList = MutableLiveData<Pokemon>()
    var isLoading = MutableLiveData<Boolean>()
    var isError = MutableLiveData<Boolean>()

    fun callService(offset: String) {
        fetchPokemon(offset)
    }

    private fun fetchPokemon(offset: String) {
        isLoading.value = true
        disposable.add(listPokemonUseCase.getPokemonList(offset).subscribe({
            pokemonList.value = it
            isLoading.value = false
            Timber.d("success: $it")
        }, {
            isError.value = true
            isLoading.value = false
            Timber.d("error: $it")
        }))

    }
}