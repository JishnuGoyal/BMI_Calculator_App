package com.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bmicalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


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

    private fun initialiseBinding(){
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    private fun calculateBMI(){
        val heightString = binding.heightInput.text.toString()
        val weightString = binding.weightInput.text.toString()

        val heightInCM = heightString.toFloat()
        val weightInKg = weightString.toFloat()

        val heightInMeter = heightInCM / 100
        val heightInMeterSquare = heightInMeter * heightInMeter

        val bmi = weightInKg / heightInMeterSquare
        val bmiString = bmi.toString()

        binding.bmiDisplayTextView.text = bmiString

    }

    private fun clearAll(){
        binding.bmiDisplayTextView.text = null
        binding.heightInput.text?.clear()
        binding.weightInput.text?.clear()
    }




}