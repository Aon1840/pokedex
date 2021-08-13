package com.bearman.pokedex.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.bearman.pokedex.R
import com.bearman.pokedex.viewmodel.ListPokemonViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: ListPokemonViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(ListPokemonViewModel::class.java)
        viewModel.callService("10")

    }
}