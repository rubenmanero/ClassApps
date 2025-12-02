package com.ruben.classapps.SuperheroApp

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.ruben.classapps.databinding.ItemSuperheroBinding
import com.squareup.picasso.Picasso

class SuperheroViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemSuperheroBinding.bind(view)
    fun bind(superheroItemResponse: SuperheroItemResponse) {
        binding.tvSuperheroName.text = superheroItemResponse.name
        Log.i("urls", superheroItemResponse.superheroImage.url)
        Picasso.get().load("https://cdn.jsdelivr.net/gh/akabab/superhero-api@0.3.0/api/images/md/"
                + superheroItemResponse.superheroId
                + "-" + superheroItemResponse.name.lowercase().replace(" ","-")
                +".jpg").into(binding.ivSuperhero);
    }
}