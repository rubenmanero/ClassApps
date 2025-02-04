package com.ruben.classapps

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.ruben.classapps.BoardgamesApp.BoardgamesActivity
import com.ruben.classapps.HelloApp.MainActivity
import com.ruben.classapps.IMCapp.IMCactivity
import com.ruben.classapps.MessageApp.MessageActivity
import com.ruben.classapps.Settings.SettingsActivity
import com.ruben.classapps.SuperheroApp.SuperheroListActivity

class MenuActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        var btnHelloApp = findViewById<Button>(R.id.btnHelloApp)
        var btnMessageApp = findViewById<Button>(R.id.btnMessageApp)
        var btnIMCApp = findViewById<Button>(R.id.btnIMCApp)
        var btnBoardgamesApp = findViewById<Button>(R.id.btnBoardgamesApp)
        var btnSuperheroApp = findViewById<Button>(R.id.btnSuperheroApp)
        var btnSettings = findViewById<Button>(R.id.btnSettings)

        btnHelloApp.setOnClickListener { navigateToHelloApp() }
        btnMessageApp.setOnClickListener { navigateToMessageApp() }
        btnIMCApp.setOnClickListener { navigateToIMCApp() }
        btnBoardgamesApp.setOnClickListener { navigateToBoardgamesApp() }
        btnSuperheroApp.setOnClickListener { navigateToSuperheroApp() }
        btnSettings.setOnClickListener { navigateToSettings() }
    }

    private fun navigateToHelloApp() {
        var intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToMessageApp() {
        var intent = Intent(this, MessageActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToIMCApp() {
        var intent = Intent(this, IMCactivity::class.java)
        startActivity(intent)
    }

    private fun navigateToBoardgamesApp() {
        var intent = Intent(this, BoardgamesActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToSuperheroApp() {
        var intent = Intent(this, SuperheroListActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToSettings() {
        var intent = Intent(this, SettingsActivity::class.java)
        startActivity(intent)
    }
}