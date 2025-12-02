package com.ruben.classapps.RepasoApp

import android.app.Dialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ruben.classapps.BoardgamesApp.GameCategory
import com.ruben.classapps.R

class RepasoActivity : AppCompatActivity() {

    private lateinit var tv1: TextView
    private lateinit var tv2: TextView
    private lateinit var tv3: TextView
    private lateinit var tv4: TextView
    private lateinit var tv5: TextView
    private lateinit var tv6: TextView
    private lateinit var tv7: TextView
    private lateinit var tv8: TextView
    private lateinit var tv9: TextView
    private lateinit var tv10: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_repaso)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initComponents()
        initListeners()
    }

    private fun initComponents() {
        tv1 = findViewById(R.id.tv1)
        tv2 = findViewById(R.id.tv2)
        tv3 = findViewById(R.id.tv3)
        tv4 = findViewById(R.id.tv4)
        tv5 = findViewById(R.id.tv5)
        tv6 = findViewById(R.id.tv6)
        tv7 = findViewById(R.id.tv7)
        tv8 = findViewById(R.id.tv8)
        tv9 = findViewById(R.id.tv9)
        tv10 = findViewById(R.id.tv10)
    }

    private fun initListeners() {
        tv1.setOnClickListener { showDialog(tv1) }
        tv2.setOnClickListener { showDialog(tv2) }
        tv3.setOnClickListener { showDialog(tv3) }
        tv4.setOnClickListener { showDialog(tv4) }
        tv5.setOnClickListener { showDialog(tv5) }
        tv6.setOnClickListener { showDialog(tv6) }
        tv7.setOnClickListener { showDialog(tv7) }
        tv8.setOnClickListener { showDialog(tv8) }
        tv9.setOnClickListener { showDialog(tv9) }
        tv10.setOnClickListener { showDialog(tv10) }
    }

    private fun showDialog(id: TextView) {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.dialog_repaso)

        val cvApplyColor = dialog.findViewById<CardView>(R.id.cvApplyColor)
        val rgColors = dialog.findViewById<RadioGroup>(R.id.rgColors)

        cvApplyColor.setOnClickListener {
            val selectedRadioButton: RadioButton = rgColors.findViewById(rgColors.checkedRadioButtonId)
            when (selectedRadioButton.text.toString()) {
                getString(R.string.white) -> {
                    id.text = getString(R.string.white)
                    id.setTextColor(getColor(R.color.black))
                    id.setBackgroundColor(getColor(R.color.white))
                }
                getString(R.string.red) -> {
                    id.text = getString(R.string.red)
                    id.setTextColor(getColor(R.color.white))
                    id.setBackgroundColor(getColor(R.color.red))
                }
                getString(R.string.orange) -> {
                    id.text = getString(R.string.orange)
                    id.setTextColor(getColor(R.color.black))
                    id.setBackgroundColor(getColor(R.color.orange))
                }
                getString(R.string.yellow) -> {
                    id.text = getString(R.string.yellow)
                    id.setTextColor(getColor(R.color.black))
                    id.setBackgroundColor(getColor(R.color.yellow))
                }
                getString(R.string.green) -> {
                    id.text = getString(R.string.green)
                    id.setTextColor(getColor(R.color.black))
                    id.setBackgroundColor(getColor(R.color.green))
                }
                getString(R.string.cyan) -> {
                    id.text = getString(R.string.cyan)
                    id.setTextColor(getColor(R.color.black))
                    id.setBackgroundColor(getColor(R.color.cyan))
                }
                getString(R.string.blue) -> {
                    id.text = getString(R.string.blue)
                    id.setTextColor(getColor(R.color.white))
                    id.setBackgroundColor(getColor(R.color.blue))
                }
                getString(R.string.violet) -> {
                    id.text = getString(R.string.violet)
                    id.setTextColor(getColor(R.color.white))
                    id.setBackgroundColor(getColor(R.color.violet))
                }
                getString(R.string.green) -> {
                    id.text = getString(R.string.green)
                    id.setTextColor(getColor(R.color.white))
                    id.setBackgroundColor(getColor(R.color.green))
                }
                else -> {
                    id.text = getString(R.string.black)
                    id.setTextColor(getColor(R.color.white))
                    id.setBackgroundColor(getColor(R.color.black))
                }
            }
        }
        dialog.show()
    }
}