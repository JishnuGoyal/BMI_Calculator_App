package com.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bmicalculator.databinding.ActivityMainBinding
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    //

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initialiseBinding()

        binding.btnCalculate.setOnClickListener {
            calculateBMI()
        }

        binding.btnClear.setOnClickListener {
            clearAll()
        }


    }

    private fun clearAll() {
        binding.apply {
            bmiTextView.text = null
            height.text?.clear()
            weight.text?.clear()
        }
    }

    private fun calculateBMI() {
        val heightString = binding.height.text.toString()
        val weightString = binding.weight.text.toString()

        val heightInCM = heightString.toFloat()
        val heightInMeter = heightInCM / 100
        val heightInMeterSquare = heightInMeter.pow(2)
        val weightInKg = weightString.toFloat()

        val bmi = weightInKg / heightInMeterSquare
        val resultToDisplay = bmi.toString()
        binding.bmiTextView.text = resultToDisplay

    }

    private fun initialiseBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }


}