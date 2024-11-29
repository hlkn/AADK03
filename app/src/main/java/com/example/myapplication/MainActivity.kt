package com.example.myapplication

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val viewModel by viewModels<MainViewModel>()
        binding.addQuantityButton.setOnClickListener {
            viewModel.increaseQuantity()
        }
        binding.removeQuantityButton.setOnClickListener {
            viewModel.decreaseQuantity()
        }
        binding.checkoutButton.setOnClickListener {
            viewModel.checkout()
        }

//        viewModel.quantity.observe(this) { TODO("Not yet implemented") }
//        viewModel.totalAmount.observe(this) { TODO("Not yet implemented") }

    }
}