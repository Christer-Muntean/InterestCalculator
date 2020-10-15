package com.example.interestcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        calculate_button.setOnClickListener {
            result_textView.text = ""
            calculate()
        }
    }

    private fun calculate(){
        val startCapital = getIntValueFromET(start_capital_editText)
        val interestRate = interest_rate_percent_editText.text.toString().toDouble()
        val years = getIntValueFromET(years_editText)
        var yearlyResult : Double = startCapital.toDouble()

        for (year in 1..years){
            yearlyResult = yearlyResult * (1 + (interestRate/100))
            result_textView.append("\nYear ${year} result: ${yearlyResult}")
        }
    }

    private fun getIntValueFromET(editText: EditText) : Int{
        return editText.text.toString().toInt()
    }
}