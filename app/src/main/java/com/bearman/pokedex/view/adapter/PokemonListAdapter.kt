package com.bearman.pokedex.view.adapter

import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
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

    class CountryViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        fun bind(pokemon: PokemonDetailEntity) {
            itemView.rootView.apply {
                relativeLayoutBackground.background.colorFilter =
                    PorterDuffColorFilter(
                        ContextCompat.getColor(view.context, R.color.black),
                        PorterDuff.Mode.SRC_ATOP
                    )
                textViewName.text = pokemon.name
                textViewID.text = pokemon.id
                Glide.with(this)
                    .load(pokemon.imageUrl)
                    .into(imageView)
            }
        }

        @ColorInt
        private fun getPokemonColor(type: String?): Int {
            val color = when (type?.toLowerCase()) {
                "grass", "bug" -> R.color.lightTeal
                "fire" -> R.color.lightRed
                "water", "fighting", "normal" -> R.color.lightBlue
                "electric", "psychic" -> R.color.lightYellow
                "poison", "ghost" -> R.color.lightPurple
                "ground", "rock" -> R.color.lightBrown
                "dark" -> R.color.black
                else -> R.color.lightBlue
            }
            return convertColor(color)
        }

        @ColorInt
        fun convertColor(@ColorRes color: Int): Int {
            return ContextCompat.getColor(view.context, color)
        }
    }
}