package com.ruben.classapps.BoardgamesApp

import android.content.res.ColorStateList
import android.graphics.Paint
import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.ruben.classapps.R

class GamesViewHolder (view: View) : RecyclerView.ViewHolder(view) {
    private val cbGame = view.findViewById<CheckBox>(R.id.cbGame)
    private val tvGame = view.findViewById<TextView>(R.id.tvGame)

    fun render (game: Game) {
        if(game.isSelected) {
            tvGame.paintFlags = tvGame.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        } else {
            tvGame.paintFlags = tvGame.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
        }
        cbGame.isChecked = game.isSelected

        tvGame.text = game.name
        val color = when(game.gameCategory) {
            GameCategory.Cooperative -> R.color.bgapp_cooperative_category
            GameCategory.Legacy -> R.color.bgapp_legacy_category
            GameCategory.LCG -> R.color.bgapp_lcg_category
            GameCategory.Deckbuilding -> R.color.bgapp_deckbuilding_category
            GameCategory.Euro -> R.color.bgapp_euro_category
        }
        cbGame.buttonTintList = ColorStateList.valueOf(ContextCompat.getColor(cbGame.context, color))
    }
}