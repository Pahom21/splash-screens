package com.example.splashscreen

import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import com.example.splashscreen.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        // Click Listeners for buttons to navigate between activities
        findViewById<Button>(R.id.button_to_second).setOnClickListener{
            startActivity(Intent(this, SecondActivity::class.java))
        }
        findViewById<Button>(R.id.button_to_third).setOnClickListener{
            startActivity(Intent(this,ThirdActivity::class.java))
        }

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_first_fragment -> {
                findNavController(R.id.nav_host_fragment_content_main).navigate(R.id.FirstFragment)
                true
            }
            R.id.action_second_fragment -> {
                findNavController(R.id.nav_host_fragment_content_main).navigate(R.id.SecondFragment)
                true
            }
            R.id.action_third_fragment -> {
                findNavController(R.id.nav_host_fragment_content_main).navigate(R.id.ThirdFragment)
                true
            }
            R.id.action_forth_fragment -> {
                findNavController(R.id.nav_host_fragment_content_main).navigate(R.id.ForthFragment)
                true
            }
            R.id.action_fifth_fragment -> {
                findNavController(R.id.nav_host_fragment_content_main).navigate(R.id.FifthFragment)
                true
            }
            R.id.action_sixth_fragment -> {
                findNavController(R.id.nav_host_fragment_content_main).navigate(R.id.SixthFragment)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}