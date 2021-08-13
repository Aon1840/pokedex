package com.bearman.pokedex.di

import com.bearman.pokedex.model.PokeApi
import com.bearman.pokedex.model.PokemonService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
class ApiModule {

    private val BASE_URL = "https://pokeapi.co/api/v2/"

    @Provides
    fun provideCountriesApi(): PokeApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(PokeApi::class.java)
    }

    @Provides
    fun providePokemonService(): PokemonService {
        return PokemonService()
    }
}