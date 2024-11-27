package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.databinding.ActivityMainBinding

const val TAG = "Life Cycle"

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    // onCreate is called once when the activity is first created and is used to initialize the activity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.i(TAG, "onCreate")
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    // onPause is called when the activity is no longer visible i.e. in the background
    override fun onPause() {
        super.onPause()
        Log.i(TAG, "onPause")
    }

    // onResume is called when the activity is visible again i.e. when the user returns to the activity to the foreground
    override fun onResume() {
        super.onResume()
        Log.i(TAG, "onResume")
    }

    // onStart is called when the activity is visible to the user
    override fun onStart() {
        super.onStart()
        Log.i(TAG, "onStart")
    }

    // onStop is called when the activity is no longer visible to the user
    override fun onStop() {
        super.onStop()
        Log.i(TAG, "onStop")
    }

    // onDestroy is called before the activity is destroyed
    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "onDestroy")
    }

}