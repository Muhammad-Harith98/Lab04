package com.harith.lab01

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var editText1: EditText
    private lateinit var editText2: EditText
    private lateinit var resultTextView: TextView
    private lateinit var buttonPlus: Button
    private lateinit var buttonMinus: Button
    private lateinit var buttonProduct: Button
    private lateinit var buttonDivide: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Linking views
        editText1 = findViewById(R.id.edittext1)
        editText2 = findViewById(R.id.edittext2)
        resultTextView = findViewById(R.id.resultTextView)
        buttonPlus = findViewById(R.id.button_plus)
        buttonMinus = findViewById(R.id.button_minus)
        buttonProduct = findViewById(R.id.button_product)
        buttonDivide = findViewById(R.id.button_divide)

        // Button click listeners
        buttonPlus.setOnClickListener { calculate('+') }
        buttonMinus.setOnClickListener { calculate('-') }
        buttonProduct.setOnClickListener { calculate('*') }
        buttonDivide.setOnClickListener { calculate('/') }
    }

    private fun calculate(operation: Char) {
        val num1Str = editText1.text.toString()
        val num2Str = editText2.text.toString()

        // Check if inputs are empty
        if (num1Str.isEmpty() || num2Str.isEmpty()) {
            Toast.makeText(this, "Please enter both numbers", Toast.LENGTH_SHORT).show()
            return
        }

        // Parse numbers
        val num1: Double
        val num2: Double
        try {
            num1 = num1Str.toDouble()
            num2 = num2Str.toDouble()
        } catch (e: NumberFormatException) {
            Toast.makeText(this, "Invalid input! Please enter valid numbers", Toast.LENGTH_SHORT).show()
            return
        }

        // Perform calculation
        val result = when (operation) {
            '+' -> num1 + num2
            '-' -> num1 - num2
            '*' -> num1 * num2
            '/' -> {
                if (num2 == 0.0) {
                    Toast.makeText(this, "Cannot divide by zero!", Toast.LENGTH_SHORT).show()
                    return
                }
                num1 / num2
            }
            else -> 0.0
        }

        // Display result
        resultTextView.text = "Result: %.2f".format(result)
    }
}
Key Differences in Kotlin:
