package com.bearman.pokedex.di

import com.bearman.pokedex.model.PokemonService
import com.bearman.pokedex.viewmodel.ListPokemonViewModel
import dagger.Component

@Component(modules = [ApiModule::class])
interface ApiComponent {

    fun inject(service: PokemonService)

    fun inject(viewModel: ListPokemonViewModel)

}