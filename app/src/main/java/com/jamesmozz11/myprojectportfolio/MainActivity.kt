package com.jamesmozz11.myprojectportfolio

import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        Log.i(getString(R.string.log_main), getString(R.string.log_created))
    }

    override fun onStart() {
        super.onStart()
        Log.i(getString(R.string.log_main), getString(R.string.log_started))
    }
    override fun onResume() {
        super.onResume()
        Log.i(getString(R.string.log_main), getString(R.string.log_resume))
    }

    override fun onPause() {
        super.onPause()
        Log.i(getString(R.string.log_main), getString(R.string.log_pause))
    }

    override fun onStop() {
        super.onStop()
        Log.i(getString(R.string.log_main), getString(R.string.log_stop))
    }

    override  fun onDestroy() {
        super.onDestroy()
        Log.i(getString(R.string.log_main), getString(R.string.log_destroy))
    }

    override fun onRestart() {
        super.onRestart()
        Log.i(getString(R.string.log_main), getString(R.string.log_restart))
    }

    fun goToCalculator(view: View) {
        val intent = Intent(this, CalculatorActivity::class.java)
        startActivity(intent)
    }

    fun goToTapGame(view: View) {
        val intent = Intent(this, TapGameActivity::class.java)
        startActivity(intent)
    }
}