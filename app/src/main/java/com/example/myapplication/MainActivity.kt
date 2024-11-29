package com.example.myapplication

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        binding.toolbarLayout.title = getString(R.string.app_name)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // Verbose implementation of the click listener
//        binding.fab.setOnClickListener(object: View.OnClickListener {
//            override fun onClick(view: View?) {
//                Snackbar.make(view!!, "Replace with your own action", Snackbar.LENGTH_LONG).show()
//            }
//        })

        // Short implementation of the click listener
        binding.fab.setOnClickListener { view ->
            Snackbar.make(
                view!!,
                "Replace with your own action",
                Snackbar.LENGTH_LONG
            ).show()
        }

//        binding.fab.setOnClickListener { view ->
//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).show()
//        }
    }
}