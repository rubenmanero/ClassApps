package com.ruben.classapps.BoardgamesApp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ruben.classapps.BoardgamesApp.GameCategory.*
import com.ruben.classapps.R

class BoardgamesActivity : AppCompatActivity() {

    private lateinit var rvCategories: RecyclerView
    private lateinit var rvGames: RecyclerView

    private lateinit var categoriesAdapter: CategoriesAdapter
    //private lateinit var gamesAdapter: GamesAdapter

    private var categoriesList = listOf(
        Deckbuilding,
        Cooperative,
        LCG,
        Euro,
        Legacy
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_boardgames)

        initComponents()
        initUI()
    }

    private fun initComponents() {
        rvCategories = findViewById(R.id.rvCategories)
        rvGames = findViewById(R.id.rvGames)
    }

    private fun initUI() {
        categoriesAdapter = CategoriesAdapter(categoriesList)
        rvCategories.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        rvCategories.adapter = categoriesAdapter

        //gamesAdapter = GamesAdapter(gamesList)
    }
}