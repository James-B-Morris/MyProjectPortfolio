package com.jamesmozz11.myprojectportfolio

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.Menu
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import org.w3c.dom.Text

class TapGameActivity : AppCompatActivity() {
    lateinit var autoTick: Handler

    private var score = 0
    private var tapModifier = 1
    private var autoModifier = 1
    private var tapCost = 10.0
    private var autoCost = 10.0

    private val updateAutoTick = object : Runnable {
        override fun run() {
            score += autoModifier
            updateScore()
            autoTick.postDelayed(this, 1000)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_tap_game)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        Log.i(getString(R.string.log_tap_game), getString(R.string.log_created))

        initToolbar()
        initGame()

        autoTick = Handler(Looper.getMainLooper())
    }

    override fun onPause() {
        super.onPause()
        autoTick.removeCallbacks(updateAutoTick)
    }

    override fun onResume() {
        super.onResume()
        autoTick.post(updateAutoTick)
    }

    /**
     * Increases the score every time the screen is tapped
     */
    fun screenTapped (view : View) {
        score += tapModifier
        updateScore()
    }

    /**
     * Initialises game values and sets the actions for the buttons
     */
    private fun initGame() {
        val btnUpgradeTap = findViewById<Button>(R.id.btnUpgTap)
        val btnUpgradeAuto = findViewById<Button>(R.id.btnUpgAuto)

        updateScore()
        updateTapCost()
        updateAutoCost()

        // increases the score gained per tap if the score is higher than the tapCost
        btnUpgradeTap.setOnClickListener {
            if (score >= tapCost) {
                tapModifier *= 2
                Log.i(getString(R.string.log_tap_game), tapModifier.toString())

                score -= tapCost.toInt()
                Log.i(getString(R.string.log_tap_game), score.toString())

                tapCost *= 2.5
                Log.i(getString(R.string.log_tap_game), tapCost.toString())

                updateScore()
                updateTapCost()
            }
        }

        // increases the score gained per second if the score is higher than the autoCost
        btnUpgradeAuto.setOnClickListener {
            if (score >= autoCost) {
                autoModifier *= 2
                Log.i(getString(R.string.log_tap_game), autoModifier.toString())

                score -= autoCost.toInt()
                Log.i(getString(R.string.log_tap_game), score.toString())

                autoCost *= 2.5
                Log.i(getString(R.string.log_tap_game), autoCost.toString())

                updateScore()
                updateAutoCost()
            }
        }
    }

    /**
     * Updates txtScore to the current score total.
     */
    private fun updateScore() {
        val txtScore = findViewById<TextView>(R.id.txtViewPoints)
        txtScore.text = score.toString()
    }

    /**
     * Updates txtTapCost to the current tap upgrade cost.
     */
    private fun updateTapCost() {
        val txtTapCost = findViewById<TextView>(R.id.txtTapCost)
        txtTapCost.text = tapCost.toInt().toString()
    }

    /**
     * Updates txtAutoCost to the current auto upgrade cost.
     */
    private fun updateAutoCost() {
        val txtAutoCost = findViewById<TextView>(R.id.txtAutoCost)
        txtAutoCost.text = autoCost.toInt().toString()
    }

    ///// TOOLBAR STUFF /////
    /**
     * Initialise the Toolbar.
     */
    private fun initToolbar() {
        val toolbar = findViewById<Toolbar>(R.id.tapgameToolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
        }
    }

    /**
     * handles the actions when an option is selected on the dropdown menu.
     */
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.layout_toolbar, menu)
        return super.onCreateOptionsMenu(menu)
    }

}