package com.ruben.classapps.SuperheroApp

import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.ruben.classapps.SuperheroApp.SuperheroListActivity.Companion.EXTRA_ID
import com.ruben.classapps.databinding.ActivitySuperheroDetailBinding
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.math.roundToInt

class SuperheroDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySuperheroDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySuperheroDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val id: String = intent.getStringExtra(EXTRA_ID).orEmpty()
        getSuperheroInformation(id)

    }

    private fun getSuperheroInformation(id: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val superheroDetail = getRetrofit().create(ApiService::class.java).getSuperheroDetail(id)
            if(superheroDetail.body()!=null) {
                Log.i("respuestaAPI", "OK")
                runOnUiThread {
                    createUI(superheroDetail.body()!!)
                }
            } else {
                Log.i("respuestaAPI", "No se ha recibido respuesta")
            }
        }
    }

    private fun createUI(superhero: SuperheroDetailResponse) {
        Picasso.get().load(superhero.image.url).into(binding.ivSuperhero)
        binding.tvSuperheroName.text = superhero.name
        binding.tvSuperheroRealName.text = superhero.biography.fullName
        binding.tvPublisher.text = superhero.biography.publisher
        prepareStats(superhero.powerstats)
    }

    private fun prepareStats(powerstats: PowerStatsResponse) {
        updateHeight(binding.viewIntellingence, powerstats.intelligence)
        updateHeight(binding.viewStrength, powerstats.strength)
        updateHeight(binding.viewSpeed, powerstats.speed)
        updateHeight(binding.viewDurability, powerstats.durability)
        updateHeight(binding.viewPower, powerstats.power)
        updateHeight(binding.viewCombat, powerstats.combat)
    }

    private fun updateHeight(view: View, stat: String) {
        val params = view.layoutParams
        if(stat!="null") {
            params.height = pxToDp(stat.toFloat())
        } else {
            params.height = pxToDp(0.toFloat())
        }
        view.layoutParams = params
    }

    private fun pxToDp(px: Float): Int {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, px, resources.displayMetrics).roundToInt()
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl("https://www.superheroapi.com/api/cf7418614ae06050036a16ba11287d07/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}