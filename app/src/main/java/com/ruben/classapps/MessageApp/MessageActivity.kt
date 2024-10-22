package com.ruben.classapps.MessageApp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.ruben.classapps.R

class MessageActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_message)

        var tvMessage = findViewById<TextView>(R.id.tvMessage)
        var tvTitle = findViewById<TextView>(R.id.tvTitle)
        var message: String = intent.extras?.getString("extra_reply").orEmpty()
        if (message.isNotEmpty()) {
            tvMessage.text = "$message"
            tvTitle.text = "Reply received!"
        }

        var btnSend = findViewById<Button>(R.id.buttonSend)
        var userText = findViewById<EditText>(R.id.etMessage)

        btnSend.setOnClickListener {
            var text = userText.text.toString()
            if(text.isNotEmpty()) {
                var textIntent = Intent(this, ReplyActivity::class.java)
                textIntent.putExtra("extra_message", text)
                startActivity(textIntent)
            }
        }
    }
}