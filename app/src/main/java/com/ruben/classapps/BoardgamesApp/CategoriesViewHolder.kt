package com.ruben.classapps.BoardgamesApp

import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat.getColor
import androidx.recyclerview.widget.RecyclerView
import com.ruben.classapps.R

class CategoriesViewHolder (view: View) : RecyclerView.ViewHolder(view) {
    private val tvCategoryName: TextView = view.findViewById<TextView>(R.id.tvGameCategory)
    private val divider: View = view.findViewById<View>(R.id.divider)

    fun render (gameCategory: GameCategory) {
        when(gameCategory){
            GameCategory.Cooperative -> {
                tvCategoryName.text = "Cooperativos"
                divider.setBackgroundColor(getColor(divider.context, R.color.bgapp_cooperative_category))
            }
            GameCategory.Euro -> {
                tvCategoryName.text = "Eurogames"
                divider.setBackgroundColor(getColor(divider.context, R.color.bgapp_euro_category))
            }
            GameCategory.LCG -> {
                tvCategoryName.text = "LCG"
                divider.setBackgroundColor(getColor(divider.context, R.color.bgapp_lcg_category))
            }
            GameCategory.Legacy -> {
                tvCategoryName.text = "Legacy"
                divider.setBackgroundColor(getColor(divider.context, R.color.bgapp_legacy_category))
            }
            GameCategory.Deckbuilding -> {
                tvCategoryName.text = "Deckbuilding"
                divider.setBackgroundColor(getColor(divider.context, R.color.bgapp_deckbuilding_category))
            }
        }
    }
}