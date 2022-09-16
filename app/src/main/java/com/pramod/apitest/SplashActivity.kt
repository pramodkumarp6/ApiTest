package com.pramod.apitest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.*

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        title ="SplashActivity"

        GlobalScope.launch(Dispatchers.Main) {
            delay(2000)
            startActivity(Intent(this@SplashActivity, LoginActivity::class.java))
        }
    }
}