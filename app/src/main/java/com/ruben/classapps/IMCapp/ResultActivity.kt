package com.ruben.classapps.IMCapp

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ruben.classapps.R

class ResultActivity : AppCompatActivity() {

    private lateinit var tvResult: TextView
    private lateinit var tvIMC: TextView
    private lateinit var tvDescription: TextView
    private lateinit var btnRecalculate: CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var result: Double = intent.extras?.getDouble("IMC")?:-1.0
        initComponents()
        initListeners()
    }

    private fun initComponents() {
        tvResult = findViewById<TextView>(R.id.tvResult)
        tvIMC = findViewById<TextView>(R.id.tvIMC)
        tvDescription = findViewById<TextView>(R.id.tvDescription)
        btnRecalculate = findViewById<CardView>(R.id.btnRecalculate)
    }
    private fun initListeners() {
        btnRecalculate.setOnClickListener { onBackPressedDispatcher.onBackPressed() }
    }

}