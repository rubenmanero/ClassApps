package com.ruben.classapps.HelloApp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import android.widget.TextView
import androidx.core.view.WindowInsetsCompat
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import com.ruben.classapps.R

class HelloActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_hello)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left,systemBars.top,systemBars.right,systemBars.bottom)
            insets
        }


        var textoHola = findViewById<TextView>(R.id.helloText)
        var name: String = intent.extras?.getString("extra_name").orEmpty()
        textoHola.text = "Hola $name"



    }
}