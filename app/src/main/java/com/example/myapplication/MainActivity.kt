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
        //Creates a binding object for the activity_main.xml layout.
        //Inflates the layout into a view hierarchy.
        //Assigns the inflated view hierarchy to the binding variable.
        binding = ActivityMainBinding.inflate(layoutInflater)
        //This refers to the root view of the layout that was inflated using view binding. In other words, it's the top-level view that contains all other views in the layout.
        setContentView(binding.root)
        Log.i(TAG, "onCreate")

        // Setting up a listener to handle how your app's layout adapts to system insets (like status bar, navigation bar, or display cutout) in Android. Here's a breakdown:
        //
        //ViewCompat.setOnApplyWindowInsetsListener:
        //
        //This method (from the androidx.core.view library) allows you to attach a listener to a specific view (findViewById(R.id.main) in this case).
        //This listener will be triggered whenever the system insets change around the view.
        //findViewById(R.id.main):
        //
        //This part finds the view in your layout with the ID R.id.main. This view will be the one listening for inset changes.
        //{ v, insets -> ... }:
        //
        //This is the code block that will be executed whenever the listener is triggered (i.e., when system insets change).
        //The block receives two arguments:
        //v: This refers to the view that the listener is attached to (the one found with findViewById(R.id.main)).
        //insets: This is a WindowInsetsCompat object that contains information about the current system insets around the view.
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
            // Inside the code block, you can access the insets object to get details about the system insets and adjust your view's layout accordingly. Here are some common examples:
            //
            //Get specific inset values: You can use methods like insets.getSystemWindowInsetTop(), insets.getSystemWindowInsetBottom(), etc., to retrieve the size of specific insets (top, bottom, left, right).
            //Update view padding: Based on the insets, you might want to update the view's padding to avoid content being obscured by the status bar or navigation bar.
            //Adjust content placement: You could use the insets information to adjust the positioning of child views within the main view to ensure proper layout within the available space.
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