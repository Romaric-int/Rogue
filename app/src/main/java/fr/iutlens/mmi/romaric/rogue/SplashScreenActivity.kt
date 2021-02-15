package fr.iutlens.mmi.romaric.rogue

import android.content.Intent
import android.os.Bundle
import android.os.Handler

import androidx.appcompat.app.AppCompatActivity

class SplashScreenActivity : AppCompatActivity() {
    protected override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        val runnable = Runnable {
            val intent = Intent(getApplicationContext(), GameActivity::class.java)
            startActivity(intent)
            finish()
        }
        Handler().postDelayed(runnable, 3000)
    }
}