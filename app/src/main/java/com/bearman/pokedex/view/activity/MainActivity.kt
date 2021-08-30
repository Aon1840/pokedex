package com.bearman.pokedex.view.activity

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.bearman.pokedex.R
import com.bearman.pokedex.data.entity.PokemonDetailEntity
import com.bearman.pokedex.view.adapter.PokemonListAdapter
import com.bearman.pokedex.view.viewmodel.ListPokemonViewModel
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: ListPokemonViewModel

    private var pokemonListAdapter = PokemonListAdapter(arrayListOf())

    private var isChange = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(ListPokemonViewModel::class.java)
        viewModel.callService()
        rvPokemon.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = pokemonListAdapter
        }
//
//        btChange.setOnClickListener {
//            viewModel.changeView()
//        }

        observer()
    }

    private fun observer() {
        viewModel.pokemonList.observe(this, {
            rvPokemon.visibility = View.VISIBLE
            pokemonListAdapter.updateCountries(it)
        })

//        viewModel.isChangeView.observe(this, {
//            if (it) {
//                rvPokemon.layoutManager = LinearLayoutManager(this)
//            } else {
//                rvPokemon.layoutManager = GridLayoutManager(this, 2)
//            }
//        })
    }
}