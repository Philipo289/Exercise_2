package com.example.exercise_2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.treebo.internetavailabilitychecker.InternetAvailabilityChecker

class MainActivity : AppCompatActivity() {

    /**
     * Our MainActivity is only responsible for setting the content view that contains the
     * Navigation Host.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        InternetAvailabilityChecker.init(this)
        setContentView(R.layout.activity_main)
    }
}
