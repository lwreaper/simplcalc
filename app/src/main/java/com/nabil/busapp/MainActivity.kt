package com.nabil.busapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPreferences = this.getSharedPreferences("com.nabil.busapp", Context.MODE_PRIVATE)

        displayResult.setText(sharedPreferences.getInt("result", 0).toString())
        init_clickListeners()



    }

    fun init_clickListeners(){
        plusButton.setOnClickListener{
            displayText(plus(firstNumber.text.toString().toInt(), secondNumber.text.toString().toInt()))
        }

        minusButton.setOnClickListener{
            displayText(minus(firstNumber.text.toString().toInt(), secondNumber.text.toString().toInt()))
        }

        timesButton.setOnClickListener{
            displayText(times(firstNumber.text.toString().toInt(), secondNumber.text.toString().toInt()))
        }

        divideButton.setOnClickListener{
            displayText(divide(firstNumber.text.toString().toInt(), secondNumber.text.toString().toInt()))
        }

        resultToFirst.setOnClickListener {
            firstNumber.setText(displayResult.text)
            secondNumber.setText("")
        }
    }

    fun displayText(result: Int){
        val sharedPreferences = this.getSharedPreferences("com.nabil.busapp", Context.MODE_PRIVATE)
        sharedPreferences.edit().putInt("result", result).apply()

        displayResult.text = result.toString()
    }

    fun plus(num1: Int, num2: Int):Int{
        return num1 + num2
    }

    fun minus(num1: Int, num2: Int):Int{
        return num1 - num2
    }

    fun times(num1: Int, num2: Int):Int{
        return num1 * num2
    }

    fun divide(num1: Int, num2: Int):Int{
        return num1 / num2
    }

}
