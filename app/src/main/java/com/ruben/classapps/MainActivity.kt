package com.ruben.classapps

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btnSend = findViewById<Button>(R.id.btnSend)
        var userText = findViewById<EditText>(R.id.etName)

        btnSend.setOnClickListener {
            Log.i("Rubén","Sending")
            var name = userText.text.toString()
            if(name.isNotEmpty()) {
                var textIntent = Intent(this, HelloActivity::class.java)
                textIntent.putExtra("extra_name", name)
                startActivity(textIntent)
            }
        }

    }
}