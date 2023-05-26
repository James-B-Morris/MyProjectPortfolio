package com.jamesmozz11.myprojectportfolio

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.View
import android.widget.Button
import android.widget.Switch
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import org.w3c.dom.Text

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
        val txtCalc = findViewById<TextView>(R.id.txtCalc)

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
        val btndivide = findViewById<Button>(R.id.btnDivide)
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
        btnDecimal.setOnClickListener {
            inputDecimal()
        }
        btnNegative.setOnClickListener {
            negateAnswer()
        }

        btnAdd.setOnClickListener {
            operate(getString(R.string.add))
        }
        btnSubtract.setOnClickListener {
            operate(getString((R.string.subtract)))
        }
        btnMultiply.setOnClickListener {
            operate(getString(R.string.multiply))
        }
        btndivide.setOnClickListener {
            operate(getString(R.string.divide))
        }

        btnEquals.setOnClickListener {
            equals()
        }


        // reset the calculator to default
        btnClear.setOnClickListener {
            txtAns.text = "0"
            txtCalc.text = ""
            answer = 0
            calc = 0
            Log.i(getString(R.string.log_calculator), txtAns.text as String)
        }
    }

    ///// ANSWER CALCULATIONS /////

    /**
     * input's a number into the calculator
     * @param number the number being input into the calculator
     */
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
            if ((txt == "0") || (txt == "-0")) {
                txtAnswer.text = "$number"
            }
            else {
                txtAnswer.text = "$txt$number"
                Log.i(getString(R.string.log_calculator), txtAnswer.text as String)
            }
        }
    }

    /**
     * input's a decimal place into the claculator
     */
    fun inputDecimal(){
        val txtAns = findViewById<TextView>(R.id.txtAns)
        val txt = txtAns.text as String
        if (!txt.contains('.')) {
            txtAns.text = "$txt."
        }
    }

    /**
     * turns the current number in the calculator negative/positive
     */
    fun negateAnswer() {
        val txtAns = findViewById<TextView>(R.id.txtAns)
        val txt = txtAns.text as String

        if (txt[0].isDigit()) {
            txtAns.text = "-$txt"
        }
        else {
            txtAns.text.drop(0)
        }
    }

    /**
     * moves the current inputted number to the calculation TextView,
     * if a number is already in the calculation TextView, complete the equation
     */
    private fun operate(operator : String) {
        val txtCalc = findViewById<TextView>(R.id.txtCalc)
        var txt : String

        //check to see if an operator has been used before
        //if yes then complete the sum
        when (txtCalc.text.isNotEmpty()){
            txtCalc.text.contains(getString(R.string.add)) -> equals()
            txtCalc.text.contains(getString(R.string.subtract)) -> equals()
            txtCalc.text.contains(getString(R.string.multiply)) -> equals()
            txtCalc.text.contains(getString(R.string.divide)) -> equals()
        }
        storeAnswer()
        txt = calc.toString()
        txtCalc.text = "$txt $operator"
    }


    private fun equals(){
        val txtViewAns = findViewById<TextView>(R.id.txtAns)
        val txtViewCalc = findViewById<TextView>(R.id.txtCalc)

        val txtAns = txtViewAns.text.toString()
        val txtCalc = txtViewCalc.text.toString()

        if (txtAns.contains(getString(R.string.decimal_point))){

        }
        else if (txtAns.contains(getString(R.string.subtract))){

        }
        else if (txtAns.isNotEmpty()){
            // calculate answer
            answer = txtAns.toInt()
            when(txtCalc.isNotEmpty()){
                txtCalc.contains(getString(R.string.add)) -> answer += calc
                txtCalc.contains(getString((R.string.subtract))) -> answer -= calc
                txtCalc.contains(getString(R.string.multiply)) -> answer *= calc
                txtCalc.contains(getString(R.string.divide)) -> calc /= answer
            }

            // display answer
            txtViewAns.text = answer.toString()
            txtViewCalc.text = ""
            calc = 0
            Log.i(getString(R.string.log_calculator), answer.toString())
        }
        else{

        }
    }

    /**
     * Stores the current number in the calculator and makes room for a new input
     */
    private fun storeAnswer() {
        val txtAns = findViewById<TextView>(R.id.txtAns)
        val txtCalc = findViewById<TextView>(R.id.txtCalc)

        if (txtAns.text.contains(getString(R.string.decimal_point))) {
            //calc = txtAns.text as Float
        }
        else if (txtAns.text.contains(getString(R.string.subtract))) {

        }
        else{
            calc = txtAns.text.toString().toInt()
            txtCalc.text = txtAns.text
            txtAns.text = "0"
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