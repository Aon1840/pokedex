package com.bearman.pokedex.view.activity

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.bearman.pokedex.R
import com.bearman.pokedex.view.adapter.PokemonListAdapter
import com.bearman.pokedex.view.viewmodel.ListPokemonViewModel
import com.ethanhua.skeleton.Skeleton
import com.ethanhua.skeleton.SkeletonScreen
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: ListPokemonViewModel

    private var pokemonListAdapter = PokemonListAdapter(arrayListOf())

    private var skeleton: SkeletonScreen? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(ListPokemonViewModel::class.java)
        viewModel.callService()
        rvPokemon.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = pokemonListAdapter
            skeleton = Skeleton.bind(this)
                .adapter(pokemonListAdapter)
                .shimmer(true)
                .angle(20)
                .frozen(false)
                .load(R.layout.item_pokemon_loading)
                .show()
        }

        observer()
    }

    private fun observer() {
        viewModel.pokemonList.observe(this, {
            rvPokemon.visibility = View.VISIBLE
            skeleton?.hide()
            pokemonListAdapter.updateCountries(it)
        })
    }
}