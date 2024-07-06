package com.example.myapplication.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.myapplication.R
import com.example.myapplication.db.RunDAO
import com.example.myapplication.utils.Constants
import com.example.myapplication.utils.Constants.ACTION_SHOW_TRACKING_FRAGMENT
import com.google.android.material.bottomnavigation.BottomNavigationView

import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navigateToTrackingFragmentIfNeeded(intent)
        setSupportActionBar(findViewById(R.id.toolbar))
       var navHost:Fragment? = supportFragmentManager.findFragmentById(R.id.navHostFragment)
        if(navHost != null) {
            findViewById<BottomNavigationView>(R.id.bottomNavigationView).setupWithNavController(navHost.findNavController())
            navHost.findNavController().addOnDestinationChangedListener { _, destination, _->
                when(destination.id) {
                    R.id.settingsFragment, R.id.runFragment, R.id.statisticsFragment ->
                        findViewById<View>(R.id.bottomNavigationView).visibility = View.VISIBLE
                    else ->
                        findViewById<View>(R.id.bottomNavigationView).visibility = View.GONE
                }
            }
        }
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        navigateToTrackingFragmentIfNeeded(intent)
    }

    private fun navigateToTrackingFragmentIfNeeded(intent: Intent?) {
        if(intent?.action == ACTION_SHOW_TRACKING_FRAGMENT) {
            if(intent?.action == Constants.ACTION_SHOW_TRACKING_FRAGMENT) {
                supportFragmentManager.findFragmentById(R.id.navHostFragment)?.findNavController()?.navigate(R.id.action_global_trackingFragment)
            }
        }
    }
}

