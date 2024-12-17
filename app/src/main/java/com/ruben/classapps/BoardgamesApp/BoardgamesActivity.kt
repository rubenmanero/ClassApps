package com.ruben.classapps.BoardgamesApp

import android.app.Dialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.ruben.classapps.BoardgamesApp.GameCategory.*
import com.ruben.classapps.R

class BoardgamesActivity : AppCompatActivity() {

    private lateinit var rvCategories: RecyclerView
    private lateinit var rvGames: RecyclerView

    private lateinit var categoriesAdapter: CategoriesAdapter
    private lateinit var gamesAdapter: GamesAdapter

    private lateinit var fabAddGame: FloatingActionButton

    private var categoriesList = listOf(
        Cooperative,
        Deckbuilding,
        Euro,
        LCG,
        Legacy
    )

    private var gamesList = mutableListOf(
        Game("Frostpunk", Cooperative),
        Game("Hero Realm", Deckbuilding),
        Game("Agricola", Euro),
        Game("Arkham Horror", LCG),
        Game("Gloomhaven", Legacy),
        Game("Clank", Deckbuilding),
        Game("Marvel Champions", LCG),
        Game("Roots", Euro),
        Game("Feudalia", Deckbuilding),
        Game("Brass Birmingham", Euro),
        Game("This War of Mine", Cooperative),
        Game("Pandemic Legacy", Legacy)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_boardgames)

        initComponents()
        initListeners()
        initUI()
    }

    private fun initComponents() {
        rvCategories = findViewById(R.id.rvCategories)
        rvGames = findViewById(R.id.rvGames)
        fabAddGame = findViewById(R.id.fabAddGame)
    }

    private fun initListeners() {
        fabAddGame.setOnClickListener { showDialog() }
    }

    private fun initUI() {
        categoriesAdapter = CategoriesAdapter(categoriesList) { position -> onCategorySelected(position) }
        rvCategories.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        rvCategories.adapter = categoriesAdapter

        gamesAdapter = GamesAdapter(gamesList) { position -> onGameSelected(position) }
        rvGames.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        rvGames.adapter = gamesAdapter
    }

    private fun showDialog() {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.dialog_game)

        val etGame = dialog.findViewById<EditText>(R.id.etGame)
        val rgCategories = dialog.findViewById<RadioGroup>(R.id.rgCategories)
        val btnAddGame = dialog.findViewById<Button>(R.id.btnAddGame)

        dialog.show()

        btnAddGame.setOnClickListener {
            val currentGame = etGame.text.toString()
            if(currentGame.isNotEmpty()) {
                val selectedId = rgCategories.checkedRadioButtonId
                val selectedRadioButton: RadioButton = rgCategories.findViewById(selectedId)
                val currentCategory: GameCategory = when(selectedRadioButton.text) {
                    getString(R.string.bgapp_cooperative_category) -> Cooperative
                    getString(R.string.bgapp_deckbuilding_category) -> Deckbuilding
                    getString(R.string.bgapp_lcg_category) -> LCG
                    getString(R.string.bgapp_euro_category) -> Euro
                    else -> Legacy
                }
                gamesList.add(Game(currentGame,currentCategory))
                updateGames()
                dialog.hide()
            }
        }

    }

    private fun updateGames() {
        val selectedCategories: List<GameCategory> = categoriesList.filter { it.isSelected }
        val newGames: List<Game> = gamesList.filter { selectedCategories.contains(it.category)}
        gamesAdapter.games = newGames
        gamesAdapter.notifyDataSetChanged()
    }

    private fun onGameSelected(position: Int) {
        gamesList[position].isSelected = !gamesList[position].isSelected
        updateGames()
    }

    private fun onCategorySelected(position: Int) {
        categoriesList[position].isSelected = !categoriesList[position].isSelected
        categoriesAdapter.notifyItemChanged(position)
        updateGames()
    }
}