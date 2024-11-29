package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

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



        // We use viewModel.info.observe to display new value
        viewModel.info.observe(this) {
            displaySnackBar(it)
        }

        // Everytime we lick the fab we perform loadData ie
        // increment private info value
        binding.fab.setOnClickListener { view ->
            viewModel.loadData()
        }
//        binding.fab.setOnClickListener { view ->
//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).show()
//        }

    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    private fun handleShare(): Boolean {
        val intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT,
                "I just purchased ${viewModel.info.value} bottles of olive oil!")
            type = "text/plain"
        }
        startActivity(intent)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.action_share -> handleShare()
            else -> return super.onOptionsItemSelected(item)
        }
    }
    private fun displaySnackBar(count: Int) {
        Snackbar.make(
            binding.root,
            "Current value: $count",
            Snackbar.LENGTH_LONG
        ).show()
    }
}