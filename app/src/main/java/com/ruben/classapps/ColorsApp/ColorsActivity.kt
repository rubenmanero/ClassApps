package com.ruben.classapps.ColorsApp

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.os.Bundle
import android.util.Log
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ruben.classapps.R

class ColorsActivity : AppCompatActivity() {

    private val verticalBars = mutableListOf(
        VerticalBar(871890688, "V1 (20%)"),
        VerticalBar(1509921024, "V2 (35%)"),
        VerticalBar(-2131230976, "V3 (50%)"),
        VerticalBar(-1509883935, "V4 (65%)"),
        VerticalBar(-858717953, "V5 (80%)")
    )

    private lateinit var rvHorizontal: RecyclerView
    private lateinit var horizontalAdapter: HorizontalAdapter

    private lateinit var cvH1: CardView
    private lateinit var cvH2: CardView
    private lateinit var cvH3: CardView
    private lateinit var btnChangeColor: CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_colors)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initComponents()
        initUI()
        initListeners()
    }

    private fun initComponents() {
        rvHorizontal = findViewById<RecyclerView>(R.id.rvHorizontal)
        cvH1 = findViewById(R.id.cvH1)
        cvH2 = findViewById(R.id.cvH2)
        cvH3 = findViewById(R.id.cvH3)
        btnChangeColor = findViewById<CardView>(R.id.btnChangeColor)
    }

    private fun initUI() {
        horizontalAdapter = HorizontalAdapter(verticalBars)
        rvHorizontal.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvHorizontal.adapter = horizontalAdapter
    }

    private fun initListeners() {
        btnChangeColor.setOnClickListener { showDialog() }
    }

    private fun showDialog() {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.dialog_color)

        val cvApplyColor: CardView = dialog.findViewById(R.id.cvApplyColor)
        val rgBars: RadioGroup = dialog.findViewById(R.id.rgBars)
        val rgColors: RadioGroup = dialog.findViewById(R.id.rgColors)

        cvApplyColor.setOnClickListener {
            var selectedBar = rgBars.checkedRadioButtonId
            var selectedColor = rgColors.checkedRadioButtonId

            var selectedRadioButtonBar: RadioButton = rgBars.findViewById(selectedBar)
            var selectedRadioButtonColor: RadioButton = rgColors.findViewById(selectedColor)

            when (selectedRadioButtonBar.text) {
                getString(R.string.tvH1) -> {
                    var changeColor: Int = setColorSelectedH1(selectedRadioButtonColor)
                    cvH1.setCardBackgroundColor(changeColor)
                    Log.i("Color H1", "$changeColor")
                }

                getString(R.string.tvH2) -> {
                    var changeColor: Int = setColorSelectedH2(selectedRadioButtonColor)
                    cvH2.setCardBackgroundColor(changeColor)
                    Log.i("Color H2", "$changeColor")
                }

                getString(R.string.tvH3) -> {
                    var changeColor: Int = setColorSelectedH3(selectedRadioButtonColor)
                    cvH3.setCardBackgroundColor(changeColor)
                    Log.i("Color H3", "$changeColor")
                }

                getString(R.string.tvV1) -> {
                    verticalBars[0].colorSelected = setColorSelectedV1(selectedRadioButtonColor)
                    Log.i("Bar V1", "${verticalBars[0].colorSelected}")
                }

                getString(R.string.tvV2) -> {
                    verticalBars[1].colorSelected = setColorSelectedV2(selectedRadioButtonColor)
                    Log.i("Bar V2", "${verticalBars[1].colorSelected}")
                }

                getString(R.string.tvV3) -> {
                    verticalBars[2].colorSelected = setColorSelectedV3(selectedRadioButtonColor)
                    Log.i("Bar V3", "${verticalBars[2].colorSelected}")
                }

                getString(R.string.tvV4) -> {
                    verticalBars[3].colorSelected = setColorSelectedV4(selectedRadioButtonColor)
                    Log.i("Bar V4", "${verticalBars[3].colorSelected}")
                }

                else -> {
                    verticalBars[4].colorSelected = setColorSelectedV5(selectedRadioButtonColor)
                    Log.i("Bar V5", "${verticalBars[4].colorSelected}")
                }
            }
            horizontalAdapter.notifyDataSetChanged()
            dialog.hide()
        }
        dialog.show()
    }

    private fun setColorSelectedH1(selectedRadioButtonColor: RadioButton): Int {
        val currentColor: Int = when (selectedRadioButtonColor.text) {
            getString(R.string.white) -> getColor(R.color.white20)
            getString(R.string.red) -> getColor(R.color.red20)
            getString(R.string.orange) -> getColor(R.color.orange20)
            getString(R.string.yellow) -> getColor(R.color.yellow20)
            getString(R.string.green) -> getColor(R.color.green20)
            getString(R.string.cyan) -> getColor(R.color.cyan20)
            getString(R.string.blue) -> getColor(R.color.blue20)
            getString(R.string.violet) -> getColor(R.color.violet20)
            else -> getColor(R.color.black20)
        }
        //    val colorHex = currentColor.toString(16).uppercase()
        //    Log.i("Color seleccionado", colorHex)
        return currentColor
    }

    private fun setColorSelectedH2(selectedRadioButtonColor: RadioButton): Int {
        val currentColor: Int = when (selectedRadioButtonColor.text) {
            getString(R.string.white) -> getColor(R.color.white50)
            getString(R.string.red) -> getColor(R.color.red50)
            getString(R.string.orange) -> getColor(R.color.orange50)
            getString(R.string.yellow) -> getColor(R.color.yellow50)
            getString(R.string.green) -> getColor(R.color.green50)
            getString(R.string.cyan) -> getColor(R.color.cyan50)
            getString(R.string.blue) -> getColor(R.color.blue50)
            getString(R.string.violet) -> getColor(R.color.violet50)
            else -> getColor(R.color.black50)
        }
        return currentColor
    }

    private fun setColorSelectedH3(selectedRadioButtonColor: RadioButton): Int {
        val currentColor: Int = when (selectedRadioButtonColor.text) {
            getString(R.string.white) -> getColor(R.color.white80)
            getString(R.string.red) -> getColor(R.color.red80)
            getString(R.string.orange) -> getColor(R.color.orange80)
            getString(R.string.yellow) -> getColor(R.color.yellow80)
            getString(R.string.green) -> getColor(R.color.green80)
            getString(R.string.cyan) -> getColor(R.color.cyan80)
            getString(R.string.blue) -> getColor(R.color.blue80)
            getString(R.string.violet) -> getColor(R.color.violet80)
            else -> getColor(R.color.black80)
        }
        return currentColor
    }

    private fun setColorSelectedV1(selectedRadioButtonColor: RadioButton): Int {
        val currentColor: Int = when (selectedRadioButtonColor.text) {
            getString(R.string.white) -> getColor(R.color.white20)
            getString(R.string.red) -> getColor(R.color.red20)
            getString(R.string.orange) -> getColor(R.color.orange20)
            getString(R.string.yellow) -> getColor(R.color.yellow20)
            getString(R.string.green) -> getColor(R.color.green20)
            getString(R.string.cyan) -> getColor(R.color.cyan20)
            getString(R.string.blue) -> getColor(R.color.blue20)
            getString(R.string.violet) -> getColor(R.color.violet20)
            else -> getColor(R.color.black20)
        }
        return currentColor
    }

    private fun setColorSelectedV2(selectedRadioButtonColor: RadioButton): Int {
        val currentColor: Int = when (selectedRadioButtonColor.text) {
            getString(R.string.white) -> getColor(R.color.white35)
            getString(R.string.red) -> getColor(R.color.red35)
            getString(R.string.orange) -> getColor(R.color.orange35)
            getString(R.string.yellow) -> getColor(R.color.yellow35)
            getString(R.string.green) -> getColor(R.color.green35)
            getString(R.string.cyan) -> getColor(R.color.cyan35)
            getString(R.string.blue) -> getColor(R.color.blue35)
            getString(R.string.violet) -> getColor(R.color.violet35)
            else -> getColor(R.color.black35)
        }
        return currentColor
    }

    private fun setColorSelectedV3(selectedRadioButtonColor: RadioButton): Int {
        val currentColor: Int = when (selectedRadioButtonColor.text) {
            getString(R.string.white) -> getColor(R.color.white50)
            getString(R.string.red) -> getColor(R.color.red50)
            getString(R.string.orange) -> getColor(R.color.orange50)
            getString(R.string.yellow) -> getColor(R.color.yellow50)
            getString(R.string.green) -> getColor(R.color.green50)
            getString(R.string.cyan) -> getColor(R.color.cyan50)
            getString(R.string.blue) -> getColor(R.color.blue50)
            getString(R.string.violet) -> getColor(R.color.violet50)
            else -> getColor(R.color.black50)
        }
        return currentColor
    }

    private fun setColorSelectedV4(selectedRadioButtonColor: RadioButton): Int {
        val currentColor: Int = when (selectedRadioButtonColor.text) {
            getString(R.string.white) -> getColor(R.color.white65)
            getString(R.string.red) -> getColor(R.color.red65)
            getString(R.string.orange) -> getColor(R.color.orange65)
            getString(R.string.yellow) -> getColor(R.color.yellow65)
            getString(R.string.green) -> getColor(R.color.green65)
            getString(R.string.cyan) -> getColor(R.color.cyan65)
            getString(R.string.blue) -> getColor(R.color.blue65)
            getString(R.string.violet) -> getColor(R.color.violet65)
            else -> getColor(R.color.black65)
        }
        return currentColor
    }

    private fun setColorSelectedV5(selectedRadioButtonColor: RadioButton): Int {
        val currentColor: Int = when (selectedRadioButtonColor.text) {
            getString(R.string.white) -> getColor(R.color.white80)
            getString(R.string.red) -> getColor(R.color.red80)
            getString(R.string.orange) -> getColor(R.color.orange80)
            getString(R.string.yellow) -> getColor(R.color.yellow80)
            getString(R.string.green) -> getColor(R.color.green80)
            getString(R.string.cyan) -> getColor(R.color.cyan80)
            getString(R.string.blue) -> getColor(R.color.blue80)
            getString(R.string.violet) -> getColor(R.color.violet80)
            else -> getColor(R.color.black80)
        }
        return currentColor
    }
}