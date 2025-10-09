package com.ruben.classapps.HelloApp

import android.content.Intent
import androidx.activity.enableEdgeToEdge
import android.widget.TextView
import androidx.core.view.WindowInsetsCompat
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import com.ruben.classapps.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left,systemBars.top,systemBars.right,systemBars.bottom)
            insets
        }

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