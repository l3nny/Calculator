package com.yulie.calculator


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_calculator_ui.*
import kotlinx.android.synthetic.main.display.*
import net.objecthunter.exp4j.ExpressionBuilder

class Calculator() : AppCompatActivity() {

    var newOperation: Boolean = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator_ui)
        supportActionBar?.hide()

        tvNumberZero.setOnClickListener {
            expressionAppend(
                getString(R.string.tv_number_zero),
                false
            )
        }
        tvNumberOne.setOnClickListener {
            expressionAppend(
                getString(R.string.tv_number_one),
                false
            )
        }
        tvNumberTwo.setOnClickListener {
            expressionAppend(
                getString(R.string.tv_number_two),
                false
            )
        }
        tvNumberThree.setOnClickListener {
            expressionAppend(
                getString(R.string.tv_number_three),
                false
            )
        }
        tvNumberFour.setOnClickListener {
            expressionAppend(
                getString(R.string.tv_number_four),
                false
            )
        }
        tvNumberFive.setOnClickListener {
            expressionAppend(
                getString(R.string.tv_number_five),
                false
            )
        }
        tvNumberSix.setOnClickListener {
            expressionAppend(
                getString(R.string.tv_number_six),
                false
            )
        }
        tvNumberSeven.setOnClickListener {
            expressionAppend(
                getString(R.string.tv_number_seven),
                false
            )
        }
        tvNumberEight.setOnClickListener {
            expressionAppend(
                getString(R.string.tv_number_eight),
                false
            )
        }
        tvNumberNine.setOnClickListener {
            expressionAppend(
                getString(R.string.tv_number_nine),
                false
            )
        }
        tvDot.setOnClickListener {
            expressionAppend(
                getString(R.string.tv_dot),
                true
            )
        }
        tvPlus.setOnClickListener {
            expressionAppend(
                getString(R.string.tv_plus),
                true
            )
        }
        tvMinus.setOnClickListener {
            expressionAppend(
                getString(R.string.tv_minus),
                true
            )
        }
        tvMultiplication.setOnClickListener {
            expressionAppend(
                "*",
                true
            )
        }
        tvDivide.setOnClickListener {
            expressionAppend(
                "/",
                true
            )
        }
        tvModulo.setOnClickListener {
            expressionAppend(
                getString(R.string.tv_modulo),
                true
            )
        }

        tvAllClear.setOnClickListener {
            tvResult.text = ""
            newOperation = false
        }

        tvEquals.setOnClickListener {
            newOperation = true;
            try {
                val expression = ExpressionBuilder(tvResult.text.toString()).build()
                val result = expression.evaluate()
                val longResult = result.toLong()
                if (result == longResult.toDouble())
                    tvResult.text = longResult.toString()
                else
                    tvResult.text = result.toString()
            } catch (e: Exception) {
                Log.d("Exception", " message : " + e.message)
            }
        }
    }

    fun expressionAppend(string: String, operator: Boolean) {

        if (newOperation && !operator) {
            tvResult.text = ""
        } else {
            newOperation = false
        }
        tvResult.append(string)

    }
}



