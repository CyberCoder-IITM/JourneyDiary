package com.example.journeydiary

import android.Manifest
import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.view.animation.AccelerateInterpolator
import android.widget.ImageView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat

@SuppressLint("MissingPermission") // Temporarily for demonstration, request permissions at runtime
class SplashActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splashscreen)

        // Request location permission if not already granted
        if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), LOCATION_PERMISSION_REQUEST_CODE)
        } else {
            startAppAfterAnimation()
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == LOCATION_PERMISSION_REQUEST_CODE && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            startAppAfterAnimation()
        } else {
            // Handle permission denied scenario gracefully (e.g., inform user, disable location-based features)
        }
    }

    private fun startAppAfterAnimation() {
        // Find image views by ID
        val imageView1 = findViewById<ImageView>(R.id.image_view_1)
        val imageView2 = findViewById<ImageView>(R.id.image_view_2) // Assuming you have another image view

        // Ensure imageView1 is visible and imageView2 is invisible
        imageView1.alpha = 1f
        imageView2.alpha = 0f

        // Animate the transition
        imageView2.animate()
            .alpha(1f)
            .setDuration(1000) // Adjust duration as needed
            .setInterpolator(AccelerateInterpolator())
            .setListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator) {
                    startActivity(Intent(this@SplashActivity, MainActivity::class.java))
                    finish()
                }
            })
            .start()

        // Optionally, add additional animations or logic here
    }

    companion object {
        private const val LOCATION_PERMISSION_REQUEST_CODE = 101
    }
}