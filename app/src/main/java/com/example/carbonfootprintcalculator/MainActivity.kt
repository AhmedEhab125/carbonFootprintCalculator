package com.example.carbonfootprintcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.carbonfootprintcalculator.databinding.ActivityMainBinding
import com.example.carbonfootprintcalculator.viewModel.CalculatorViewModel

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var calculatorViewModel: CalculatorViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        calculatorViewModel = ViewModelProvider(
            this
        ).get(CalculatorViewModel::class.java)
        binding.btnCalculate.setOnClickListener {
            binding.tvCarbonFoot.text = calculatorViewModel.calculateFootPrint(
                energyConsumption = binding.edEnerge.text.toString(),
                transportation = binding.etTransportation.text.toString(),
                wastGeneration = binding.etWastGeneration.text.toString(),
                waterUsage =  binding.etWaterUsage.text.toString(),
                telecommunication =  binding.etTelecomunication.text.toString()
            )
        }
    }

}