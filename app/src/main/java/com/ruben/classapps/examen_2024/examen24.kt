package com.ruben.classapps.examen_2024

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.setPadding
import com.ruben.classapps.R

class examen24 : AppCompatActivity() {

    private var turno = 1

    private lateinit var tvPlayer: TextView
    private lateinit var iv1: ImageView
    private lateinit var iv2: ImageView
    private lateinit var iv3: ImageView
    private lateinit var iv4: ImageView
    private lateinit var iv5: ImageView
    private lateinit var iv6: ImageView
    private lateinit var iv7: ImageView
    private lateinit var iv8: ImageView
    private lateinit var iv9: ImageView

    private var casillas = mutableListOf(0,0,0,0,0,0,0,0,0)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_examen24)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initComponents()
        initListeners()
        initUI()
    }

    private fun initUI() {
        turno = 1
        casillas.forEach { casillas[it] = 0 }


        iv1.setImageDrawable(null)
        iv2.setImageDrawable(null)
        iv3.setImageDrawable(null)
        iv4.setImageDrawable(null)
        iv5.setImageDrawable(null)
        iv6.setImageDrawable(null)
        iv7.setImageDrawable(null)
        iv8.setImageDrawable(null)
        iv9.setImageDrawable(null)

        iv1.setBackgroundColor(getColor(R.color.examtitle))
        iv2.setBackgroundColor(getColor(R.color.examtitle))
        iv3.setBackgroundColor(getColor(R.color.examtitle))
        iv4.setBackgroundColor(getColor(R.color.examtitle))
        iv5.setBackgroundColor(getColor(R.color.examtitle))
        iv6.setBackgroundColor(getColor(R.color.examtitle))
        iv7.setBackgroundColor(getColor(R.color.examtitle))
        iv8.setBackgroundColor(getColor(R.color.examtitle))
        iv9.setBackgroundColor(getColor(R.color.examtitle))
    }

    private fun initComponents() {
        tvPlayer = findViewById(R.id.tvPlayer)
        iv1 = findViewById(R.id.iv1)
        iv2 = findViewById(R.id.iv2)
        iv3 = findViewById(R.id.iv3)
        iv4 = findViewById(R.id.iv4)
        iv5 = findViewById(R.id.iv5)
        iv6 = findViewById(R.id.iv6)
        iv7 = findViewById(R.id.iv7)
        iv8 = findViewById(R.id.iv8)
        iv9 = findViewById(R.id.iv9)
    }

    private fun initListeners() {
        iv1.setOnClickListener { turnos(iv1, 0) }
        iv2.setOnClickListener { turnos(iv2, 1) }
        iv3.setOnClickListener { turnos(iv3, 2) }
        iv4.setOnClickListener { turnos(iv4, 3) }
        iv5.setOnClickListener { turnos(iv5, 4) }
        iv6.setOnClickListener { turnos(iv6, 5) }
        iv7.setOnClickListener { turnos(iv7, 6) }
        iv8.setOnClickListener { turnos(iv8, 7) }
        iv9.setOnClickListener { turnos(iv9, 8) }

    }

    private fun turnos(iv: ImageView, index: Int) {
        if(turno%2==1) {
            casillas[index] = 1
            iv.setBackgroundColor(getColor(R.color.player1))
            iv.setPadding(0)
            iv.isClickable = false
            iv.setImageDrawable(AppCompatResources.getDrawable(this,R.drawable.ic_launcher_foreground))
            checkWinCondition()
        }else{
            casillas[index] = 2
            iv.setBackgroundColor(getColor(R.color.player2))
            iv.setPadding(18)
            iv.isClickable = false
            iv.setImageDrawable(AppCompatResources.getDrawable(this,R.drawable.baseline_whatsapp_24))
            checkWinCondition()
        }
        turno+=1
        if(turno==10){
            tvPlayer.text = "It's a tie!"
            tvPlayer.setTextColor(getColor(R.color.black))
            Handler(Looper.getMainLooper()).postDelayed({ initUI() }, 2000)
        }
    }

    private fun checkWinCondition() {
        if(casillas[0]==casillas[1] && casillas[1]==casillas[2]) playerWin(casillas[0])
        if(casillas[3]==casillas[4] && casillas[4]==casillas[5]) playerWin(casillas[3])
        if(casillas[6]==casillas[7] && casillas[7]==casillas[8]) playerWin(casillas[6])
        if(casillas[0]==casillas[3] && casillas[3]==casillas[6]) playerWin(casillas[0])
        if(casillas[1]==casillas[4] && casillas[4]==casillas[7]) playerWin(casillas[1])
        if(casillas[2]==casillas[5] && casillas[5]==casillas[8]) playerWin(casillas[2])
        if(casillas[0]==casillas[4] && casillas[4]==casillas[8]) playerWin(casillas[0])
        if(casillas[2]==casillas[4] && casillas[4]==casillas[6]) playerWin(casillas[2])
    }

    private fun playerWin(i: Int) {
        if(i==1){
            tvPlayer.text = "Player 1 win!"
            tvPlayer.setTextColor(getColor(R.color.player1))
            Handler(Looper.getMainLooper()).postDelayed({ initUI() }, 2000)
        } else if (i==2) {
            tvPlayer.text = "Player 2 win!"
            tvPlayer.setTextColor(getColor(R.color.player2))
            Handler(Looper.getMainLooper()).postDelayed({ initUI() }, 2000)
        }
    }
}