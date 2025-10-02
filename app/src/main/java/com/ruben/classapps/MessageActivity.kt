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

class MessageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_message)

        var btnSend = findViewById<Button>(R.id.btnSend)
        var tvReply = findViewById<TextView>(R.id.tvReply)
        var tvTitle = findViewById<TextView>(R.id.tvTitle)
        var etMessage = findViewById<EditText>(R.id.etMessage)

        var reply = intent.extras?.getString("extra_message").orEmpty()

        if(reply.isNotEmpty()) {
            tvTitle.text = "Reply received!"
            tvReply.text = reply
        }

        btnSend.setOnClickListener {
            var message = etMessage.text.toString()
            if(message.isNotEmpty()) {
                var intent = Intent(this,ReplyActivity::class.java)
                intent.putExtra("extra_message",message)
                startActivity(intent)
            }
        }
    }
}