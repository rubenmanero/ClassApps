package com.ruben.classapps

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ruben.classapps.BoardgamesApp.BoardgamesActivity
import com.ruben.classapps.ColorsApp.ColorsActivity
import com.ruben.classapps.HelloApp.MainActivity
import com.ruben.classapps.IMCapp.IMCActivity
import com.ruben.classapps.MessageApp.MessageActivity
import com.ruben.classapps.SuperheroApp.SuperheroListActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left+30, systemBars.top+30, systemBars.right+30, systemBars.bottom+30)
            insets
        }
        var btnHelloApp = findViewById<Button>(R.id.btnHelloApp)
        var btnMessageApp = findViewById<Button>(R.id.btnMessageApp)
        var btnImcApp = findViewById<Button>(R.id.btnImcApp)
        var btnBoardgamesApp = findViewById<Button>(R.id.btnBoardgamesApp)
        var btnColorsApp = findViewById<Button>(R.id.btnColorsApp)
        var btnSuperheroApp = findViewById<Button>(R.id.btnSuperheroApp)

        btnHelloApp.setOnClickListener{ navigateToHelloApp() }
        btnMessageApp.setOnClickListener{ navigateToMessageApp() }
        btnImcApp.setOnClickListener{ navigateToImcApp() }
        btnBoardgamesApp.setOnClickListener{ navigateToBoardgamesApp() }
        btnColorsApp.setOnClickListener{ navigateToColorsApp() }
        btnSuperheroApp.setOnClickListener{ navigateToSuperheroApp() }
    }

    private fun navigateToHelloApp() {
        var intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
    private fun navigateToMessageApp() {
        var intent = Intent(this, MessageActivity::class.java)
        startActivity(intent)
    }
    private fun navigateToImcApp() {
        var intent = Intent(this, IMCActivity::class.java)
        startActivity(intent)
    }
    private fun navigateToBoardgamesApp() {
        var intent = Intent(this, BoardgamesActivity::class.java)
        startActivity(intent)
    }
    private fun navigateToColorsApp() {
        var intent = Intent(this, ColorsActivity::class.java)
        startActivity(intent)
    }
    private fun navigateToSuperheroApp() {
        var intent = Intent(this, SuperheroListActivity::class.java)
        startActivity(intent)
    }
}

