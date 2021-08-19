package com.bearman.pokedex.di

import com.bearman.pokedex.domain.repository.PokemonRepository
import com.bearman.pokedex.domain.usecase.ListPokemonUseCase
import com.bearman.pokedex.model.PokeApi
import com.bearman.pokedex.model.PokemonService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class ApiModule {

    private val BASE_URL = "https://pokeapi.co/api/v2/"

    @Singleton
    @Provides
    fun provideCountriesApi(): PokeApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(PokeApi::class.java)
    }

    @Singleton
    @Provides
    fun providePokemonService(pokeApi: PokeApi): PokemonService {
        return PokemonService(pokeApi)
    }

    @Singleton
    @Provides
    fun providePokemonRepository(pokemonService: PokemonService): PokemonRepository {
        return PokemonRepository(pokemonService)
    }

    @Singleton
    @Provides
    fun provideListPokemonUseCase(repository: PokemonRepository): ListPokemonUseCase {
        return ListPokemonUseCase(repository)
    }
}