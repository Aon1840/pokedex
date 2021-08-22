package com.bearman.pokedex.view.activity

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.bearman.pokedex.R
import com.bearman.pokedex.view.viewmodel.ListPokemonViewModel
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit var viewModel: ListPokemonViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(ListPokemonViewModel::class.java)
        viewModel.callService("10")
        observer()
    }

    private fun observer() {
        viewModel.pokemonList.observe(this, {
            tvHello.text = it?.get(800)?.name
        })
    }
}