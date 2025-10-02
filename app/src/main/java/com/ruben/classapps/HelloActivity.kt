package com.ruben.classapps

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class HelloActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hello)

        var textoHola = findViewById<TextView>(R.id.helloText)
        var name: String = intent.extras?.getString("extra_name").orEmpty()
        textoHola.text = "Hola $name"
    }
}