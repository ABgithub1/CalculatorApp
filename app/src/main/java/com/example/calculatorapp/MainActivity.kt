package com.example.calculatorapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.calculatorapp.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        with(binding) {
            fun setTextFields(str: String) {
                mathOp.append(str)
            }
            buttonAllClean.setOnClickListener {
                mathOp.text = ""
                mathRes.text = ""
            }
            buttonBracketOpen.setOnClickListener { setTextFields("(") }
            buttonBracketClose.setOnClickListener { setTextFields(")") }
            buttonDivide.setOnClickListener { setTextFields("/") }
            buttonRoot.setOnClickListener { setTextFields("sqrt") }
            buttonPercent.setOnClickListener { setTextFields("%") }
            buttonMultiply.setOnClickListener { setTextFields("*") }
            buttonMinus.setOnClickListener { setTextFields("-") }
            buttonPlus.setOnClickListener { setTextFields("+") }
            buttonDot.setOnClickListener { setTextFields(".") }

            buttonBack.setOnClickListener {
                val str = mathOp.text.toString()
                if (str.isNotEmpty()) {
                    mathOp.text = str.substring(0, str.length - 1)
                }
                mathRes.text = ""
            }

            buttonZero.setOnClickListener { setTextFields("0") }
            button1.setOnClickListener { setTextFields("1") }
            button2.setOnClickListener { setTextFields("2") }
            button3.setOnClickListener { setTextFields("3") }
            button4.setOnClickListener { setTextFields("4") }
            button5.setOnClickListener { setTextFields("5") }
            button6.setOnClickListener { setTextFields("6") }
            button7.setOnClickListener { setTextFields("7") }
            button8.setOnClickListener { setTextFields("8") }
            button9.setOnClickListener { setTextFields("9") }

            buttonEquals.setOnClickListener {
                try {
                    val ex = ExpressionBuilder(mathOp.text.toString()).build()
                    val res = ex.evaluate()

                    val longRes = res.toLong()
                    if (res == longRes.toDouble())
                        mathRes.text = longRes.toString()
                    else
                        mathRes.text = res.toString()

                } catch (e: Exception) {
                    Log.d("Ошибка", "Сообщение:${e.message}")
                }
            }
        }

    }
}
