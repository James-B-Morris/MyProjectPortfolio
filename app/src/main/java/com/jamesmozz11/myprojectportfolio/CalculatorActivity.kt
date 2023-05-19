package com.jamesmozz11.myprojectportfolio

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.util.Log
import android.view.Menu
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

        val btnOne = findViewById<Button>(R.id.btn0)
        btnOne.setOnClickListener {
            inputNum(0)
        }
    }

    ///// ANSWER CALCULATIONS /////
    fun inputNum(number: Int) {
        val txtAnswer = findViewById<TextView>(R.id.txtAns)
        var txt = txtAnswer.text as String

        if (txt == "0") {
            return
        }
        else if (txt.length >= 10) {
            // set the last char to the new input
        }
        else {
            txtAnswer.text = "$txt$number"
            Log.i(getString(R.string.log_calculator), txtAnswer.text as String)
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