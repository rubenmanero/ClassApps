package com.ruben.classapps

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ReplyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_reply)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left,systemBars.top,systemBars.right,systemBars.bottom)
            insets
        }

        var btnSend2 = findViewById<Button>(R.id.btnSend2)
        var tvMessage = findViewById<TextView>(R.id.tvMessage)
        var tvTitle2 = findViewById<TextView>(R.id.tvTitle2)
        var etReply = findViewById<EditText>(R.id.etReply)

        var message = intent.extras?.getString("extra_message").orEmpty()

        tvTitle2.text = "Message received!"
        tvMessage.text = message

        btnSend2.setOnClickListener {
            var message = etReply.text.toString()
            if(message.isNotEmpty()) {
                var intent = Intent(this,MessageActivity::class.java)
                intent.putExtra("extra_message",message)
                startActivity(intent)
            }
        }
    }
}