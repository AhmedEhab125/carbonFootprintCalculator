package com.example.carbonfootprintcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
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
       binding.seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                binding.tvNumOfPepole.text = p1.toString()
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
            }
        })
        binding.btnCalculate.setOnClickListener {
            binding.tvCarbonFoot.text = calculatorViewModel.calculateFootPrint(
                energyConsumption = binding.edEnerge.text.toString(),
                transportation = binding.etTransportation.text.toString(),
                wastGeneration = binding.etWastGeneration.text.toString(),
                waterUsage =  binding.etWaterUsage.text.toString(),
                telecommunication =  binding.etTelecomunication.text.toString(),
                numberOfPeople = binding.tvNumOfPepole.text.toString()
            )
        }
    }

}