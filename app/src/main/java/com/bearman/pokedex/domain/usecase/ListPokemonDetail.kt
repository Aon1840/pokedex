package com.bearman.pokedex.domain.usecase

import com.bearman.pokedex.data.entity.PokemonDetailEntity
import com.bearman.pokedex.domain.executor.PostExecutionThread
import com.bearman.pokedex.domain.executor.ThreadExecutor
import com.bearman.pokedex.domain.repository.PokemonRepository
import io.reactivex.Single
import javax.inject.Inject

class ListPokemonDetail
@Inject constructor(
    threadExecutor: ThreadExecutor,
    postExecutionThread: PostExecutionThread,
    private val repository: PokemonRepository
) : BaseSingleUseCase<List<PokemonDetailEntity>, Void>(threadExecutor, postExecutionThread) {

//    override fun buildUseCaseSingle(): Single<PokemonEntity> {
//        return repository.getPokemonList(params!!)
//    }

    override fun buildUseCaseSingle(params: Void?): Single<List<PokemonDetailEntity>> {
        return repository.getPokemonListDetail()
    }

}