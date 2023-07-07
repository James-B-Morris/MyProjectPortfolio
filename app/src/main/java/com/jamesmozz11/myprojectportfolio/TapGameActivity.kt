package com.jamesmozz11.myprojectportfolio

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.util.Log
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class TapGameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_tap_game)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        Log.i(getString(R.string.log_tap_game), getString(R.string.log_created))

        initToolbar()
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