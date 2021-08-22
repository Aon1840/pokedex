package com.bearman.pokedex.domain.usecase

import com.bearman.pokedex.data.entity.PokemonEntity
import com.bearman.pokedex.domain.executor.PostExecutionThread
import com.bearman.pokedex.domain.executor.ThreadExecutor
import com.bearman.pokedex.domain.repository.PokemonRepository
import io.reactivex.Single
import javax.inject.Inject

class ListPokemonUseCase
@Inject constructor(
    threadExecutor: ThreadExecutor,
    postExecutionThread: PostExecutionThread,
    private val repository: PokemonRepository
) : BaseSingleUseCase<PokemonEntity, String>(threadExecutor, postExecutionThread) {

    override fun buildUseCaseSingle(params: String?): Single<PokemonEntity> {
        return repository.getPokemonList(params!!)
    }

}