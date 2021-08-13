package com.bearman.pokedex.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bearman.pokedex.di.DaggerApiComponent
import com.bearman.pokedex.model.Pokemon
import com.bearman.pokedex.model.PokemonService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

class ListPokemonViewModel : ViewModel() {

    @Inject
    lateinit var pokemonService: PokemonService

    private val disposable = CompositeDisposable()
    val pokemonList = MutableLiveData<Pokemon>()
    val isLoading = MutableLiveData<Boolean>()
    var isError = MutableLiveData<Boolean>()

    init {
        DaggerApiComponent.create().inject(this)
    }

    fun callService(offset: String) {
        fetchPokemon(offset)
    }

    private fun fetchPokemon(offset: String) {
        isLoading.value = true
        disposable.add(
            pokemonService.getListPokemon(offset)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<Pokemon>() {
                    override fun onSuccess(value: Pokemon?) {
                        pokemonList.value = value
                        isLoading.value = false
                        Timber.d("success: $value")
                    }

                    override fun onError(e: Throwable?) {
                        isError.value = true
                        isLoading.value = false
                        Timber.d("error: $e")
                    }

                })
        )
    }
}