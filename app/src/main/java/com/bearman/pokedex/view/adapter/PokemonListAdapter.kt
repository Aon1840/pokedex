package com.bearman.pokedex.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bearman.pokedex.R
import com.bearman.pokedex.data.entity.PokemonDetailEntity
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_pokemon.view.*

class PokemonListAdapter(
    var countries: ArrayList<PokemonDetailEntity>
) : RecyclerView.Adapter<PokemonListAdapter.CountryViewHolder>() {

    fun updateCountries(newCountries: List<PokemonDetailEntity>) {
        countries.clear()
        countries.addAll(newCountries)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        return CountryViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_pokemon, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return countries.size
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.bind(countries[position])
    }

    class CountryViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(pokemon: PokemonDetailEntity) {
            itemView.rootView.apply {
                tvName.text = pokemon.name
                Glide.with(this)
                    .load(pokemon.imageUrl)
                    .into(ivCharacter)
            }
        }
    }
}