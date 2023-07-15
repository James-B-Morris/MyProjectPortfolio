package com.jamesmozz11.myprojectportfolio

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import org.w3c.dom.Text

class TapGameActivity : AppCompatActivity() {
    private var score = 0
    private var tapModifier = 1
    private var autoModifier = 0
    private var tapCost = 10.0
    private var autoCost = 10.0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_tap_game)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        Log.i(getString(R.string.log_tap_game), getString(R.string.log_created))

        initToolbar()
        initGame()


    }

    private fun initGame() {
        val txtScore = findViewById<TextView>(R.id.txtViewPoints)
        val btnTap = findViewById<Button>(R.id.btnTap)

        val btnUpgradeTap = findViewById<Button>(R.id.btnUpgTap)
        val btnUpgradeAuto = findViewById<Button>(R.id.btnUpgAuto)
        val txtTapCost = findViewById<TextView>(R.id.txtTapCost)
        val txtAutoCost = findViewById<TextView>(R.id.txtAutoCost)

        txtScore.text = score.toString()
        txtTapCost.text = tapCost.toInt().toString()
        txtAutoCost.text = autoCost.toInt().toString()

        // increase score by tap modifier each time the button is pressed.
        btnTap.setOnClickListener {
            score += tapModifier
            txtScore.text = score.toString()
        }

        btnUpgradeTap.setOnClickListener {
            if (score >= tapCost) {
                tapModifier *= 2
                Log.i(getString(R.string.log_tap_game), tapModifier.toString())

                score -= tapCost.toInt()
                Log.i(getString(R.string.log_tap_game), score.toString())

                tapCost *= 2.5
                Log.i(getString(R.string.log_tap_game), tapCost.toString())

                txtScore.text = score.toString()
                txtTapCost.text = tapCost.toInt().toString()
            }
        }

        btnUpgradeAuto.setOnClickListener {
            if (score >= autoCost) {
                autoModifier *= 2
                Log.i(getString(R.string.log_tap_game), autoModifier.toString())

                score -= autoCost.toInt()
                Log.i(getString(R.string.log_tap_game), score.toString())

                autoCost *= 2
                Log.i(getString(R.string.log_tap_game), autoCost.toString())

                txtScore.text = score.toString()
                txtAutoCost.text = autoCost.toInt().toString()
            }
        }
    }

    ///// TOOLBAR STUFF /////
    /**
     * Initialise the Toolbar
     */
    private fun initToolbar() {
        val toolbar = findViewById<Toolbar>(R.id.tapgameToolbar)
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