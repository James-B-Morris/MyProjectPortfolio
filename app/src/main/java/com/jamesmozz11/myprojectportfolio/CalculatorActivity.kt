package com.jamesmozz11.myprojectportfolio

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class CalculatorActivity : AppCompatActivity() {
    private var answer = 0
    private var calc = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_calculator)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        initToolbar()
    }

    override fun onResume() {
        super.onResume()

        val txtAns = findViewById<TextView>(R.id.txtAns)

        val btn0 = findViewById<Button>(R.id.btn0)
        val btn1 = findViewById<Button>(R.id.btn1)
        val btn2 = findViewById<Button>(R.id.btn2)
        val btn3 = findViewById<Button>(R.id.btn3)
        val btn4 = findViewById<Button>(R.id.btn4)
        val btn5 = findViewById<Button>(R.id.btn5)
        val btn6 = findViewById<Button>(R.id.btn6)
        val btn7 = findViewById<Button>(R.id.btn7)
        val btn8 = findViewById<Button>(R.id.btn8)
        val btn9 = findViewById<Button>(R.id.btn9)

        val btnDecimal = findViewById<Button>(R.id.btnDecimal)
        val btnNegative = findViewById<Button>(R.id.btnNegative)

        val btnAdd = findViewById<Button>(R.id.btnAdd)
        val btnSubtract = findViewById<Button>(R.id.btnSubtract)
        val btnMultiply = findViewById<Button>(R.id.btnMultiply)
        val btnEquals = findViewById<Button>(R.id.btnEquals)
        val btnBracket = findViewById<Button>(R.id.btnBracket)
        val btnPercent = findViewById<Button>(R.id.btnPercent)
        val btnClear = findViewById<Button>(R.id.btnClear)


        btn0.setOnClickListener {
            inputNum(0)
        }
        btn1.setOnClickListener {
            inputNum(1)
        }
        btn2.setOnClickListener {
            inputNum(2)
        }
        btn3.setOnClickListener {
            inputNum(3)
        }
        btn4.setOnClickListener {
            inputNum(4)
        }
        btn5.setOnClickListener {
            inputNum(5)
        }
        btn6.setOnClickListener {
            inputNum(6)
        }
        btn7.setOnClickListener {
            inputNum(7)
        }
        btn8.setOnClickListener {
            inputNum(8)
        }
        btn9.setOnClickListener {
            inputNum(9)
        }

        // reset the calculator to default
        btnClear.setOnClickListener {
            txtAns.text = "0"
            answer = 0
            calc = 0
        }
    }

    ///// ANSWER CALCULATIONS /////
    fun inputNum(number: Int) {
        val txtAnswer = findViewById<TextView>(R.id.txtAns)
        var txt = txtAnswer.text as String

        if ((txt == "0") && (number == 0)) {
            return
        }
        else if (txt.length >= 12) {
            // set the last char to the new input
        }
        else {
            if (txt == "0") {
                txtAnswer.text = "$number"
            }
            else {
                // add commas to seperate numbers?
                //if (3.mod(txtAnswer.length()) == 0) {
                //    txtAnswer.text = "$txt$number"
                //}
                txtAnswer.text = "$txt$number"
                Log.i(getString(R.string.log_calculator), txtAnswer.text as String)
            }
        }
    }

    ///// TOOLBAR STUFF /////
    /**
     * Initialise the Toolbar
     */
    private fun initToolbar() {
        val toolbar = findViewById<Toolbar>(R.id.calculatorToolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
        }
    }

    /**
     * handles the actions when an option is selected on the dropdown menu
     */
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.layout_toolbar, menu)
        return super.onCreateOptionsMenu(menu)
    }
}