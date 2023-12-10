package com.example.carbonfootprintcalculator.viewModel

import androidx.lifecycle.ViewModel

class CalculatorViewModel : ViewModel() {
    fun calculateFootPrint(
        energyConsumption: String = "0",
        transportation: String = "0",
        wastGeneration: String = "0",
        waterUsage: String = "0",
        telecommunication: String = "0",
        numberOfPeople: String = "1"
    ): String {
        var energyConsumptionFactor = 1
        var telecommunicationFactor = 1
        var waterUsageFactor = 1
        var wastGenerationFactor = 1
        var transportationFactor = 1
        return (numberOfPeople.toInt() * (energyConsumptionFactor * energyConsumption.toDouble() + transportation.toDouble() * transportationFactor + wastGeneration.toDouble() * wastGenerationFactor +waterUsage.toDouble()*waterUsageFactor+telecommunication.toDouble()*telecommunicationFactor)).toString()
    }
}